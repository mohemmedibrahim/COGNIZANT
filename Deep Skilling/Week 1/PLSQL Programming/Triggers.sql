/* ================================
   TABLES (Support Setup)
================================ */

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    Balance NUMBER
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionType VARCHAR2(20),
    Amount NUMBER,
    TransactionDate DATE
);

CREATE TABLE AuditLog (
    LogID NUMBER GENERATED ALWAYS AS IDENTITY,
    TransactionID NUMBER,
    Action VARCHAR2(100),
    LogDate DATE
);


/* =========================================
   1. TRIGGER: Update Last Modified Date
========================================= */

CREATE OR REPLACE TRIGGER TRG_UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/
 

/* =========================================
   2. TRIGGER: Audit Log for Transactions
========================================= */

CREATE OR REPLACE TRIGGER TRG_LogTransactionInsert
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, Action, LogDate)
    VALUES (:NEW.TransactionID, 'TRANSACTION INSERTED', SYSDATE);
END;
/
 

/* =========================================
   3. TRIGGER: Check Rules + Update Balance
========================================= */

CREATE OR REPLACE TRIGGER TRG_CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Get current balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    -- Deposit validation
    IF :NEW.TransactionType = 'DEPOSIT' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20001, 'Deposit must be greater than zero');
        END IF;

        UPDATE Accounts
        SET Balance = Balance + :NEW.Amount
        WHERE AccountID = :NEW.AccountID;
    END IF;

    -- Withdrawal validation
    IF :NEW.TransactionType = 'WITHDRAWAL' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Withdrawal must be greater than zero');
        ELSIF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20003, 'Insufficient balance');
        END IF;

        UPDATE Accounts
        SET Balance = Balance - :NEW.Amount
        WHERE AccountID = :NEW.AccountID;
    END IF;

END;
/