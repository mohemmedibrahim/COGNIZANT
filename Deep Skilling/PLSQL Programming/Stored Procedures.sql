
/* =========================
   1. DROP TABLES (SAFE RUN)
   ========================= */

BEGIN EXECUTE IMMEDIATE 'DROP TABLE Accounts'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Employees'; EXCEPTION WHEN OTHERS THEN NULL; END;
/

/* =========================
   2. CREATE TABLES
   ========================= */

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    AccountType VARCHAR2(20),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmpID NUMBER PRIMARY KEY,
    EmpName VARCHAR2(50),
    Department VARCHAR2(50),
    Salary NUMBER
);

/* =========================
   3. INSERT SAMPLE DATA
   ========================= */

INSERT INTO Accounts VALUES (1,'Ravi','SAVINGS',5000);
INSERT INTO Accounts VALUES (2,'Priya','SAVINGS',8000);
INSERT INTO Accounts VALUES (3,'Arun','CURRENT',10000);

INSERT INTO Employees VALUES (101,'Kumar','IT',40000);
INSERT INTO Employees VALUES (102,'Meena','IT',50000);
INSERT INTO Employees VALUES (103,'John','HR',45000);

COMMIT;

/* =====================================================
   SCENARIO 1
   Process Monthly Interest (1% for Savings Accounts)
   ===================================================== */

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'SAVINGS';

    COMMIT;
END;
/

/* =====================================================
   SCENARIO 2
   Employee Bonus by Department
   ===================================================== */

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_pct  IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE Department = p_department;

    COMMIT;
END;
/

/* =====================================================
   SCENARIO 3
   Transfer Funds Between Accounts
   ===================================================== */

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_acc IN NUMBER,
    p_to_acc   IN NUMBER,
    p_amount   IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    -- check balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_acc;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Balance');
    END IF;

    -- debit
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_acc;

    -- credit
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_acc;

    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Invalid Account ID');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer Failed');
END;
/

/* =========================
   4. TESTING PROCEDURES
   ========================= */

BEGIN
    ProcessMonthlyInterest;
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

BEGIN
    TransferFunds(1, 2, 2000);
END;
/

/* =========================
   5. CHECK OUTPUT
   ========================= */

SELECT * FROM Accounts;
SELECT * FROM Employees;