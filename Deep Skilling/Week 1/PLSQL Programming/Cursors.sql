
/* =========================
   1. DROP TABLES (SAFE RUN)
   ========================= */

BEGIN EXECUTE IMMEDIATE 'DROP TABLE Transactions'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Accounts'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Loans'; EXCEPTION WHEN OTHERS THEN NULL; END;
/

/* =========================
   2. CREATE TABLES
   ========================= */

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Balance NUMBER
);

CREATE TABLE Transactions (
    TransID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    Amount NUMBER,
    TransDate DATE
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    InterestRate NUMBER
);

/* =========================
   3. INSERT SAMPLE DATA
   ========================= */

INSERT INTO Accounts VALUES (1,'Ravi',5000);
INSERT INTO Accounts VALUES (2,'Priya',8000);
INSERT INTO Accounts VALUES (3,'Arun',12000);

INSERT INTO Transactions VALUES (101,1,1000,SYSDATE);
INSERT INTO Transactions VALUES (102,1,500,SYSDATE);
INSERT INTO Transactions VALUES (103,2,2000,SYSDATE);
INSERT INTO Transactions VALUES (104,3,1500,SYSDATE);

INSERT INTO Loans VALUES (201,'Ravi',8);
INSERT INTO Loans VALUES (202,'Priya',9);
INSERT INTO Loans VALUES (203,'Arun',7);

COMMIT;

SET SERVEROUTPUT ON;

/* =====================================================
   SCENARIO 1
   Generate Monthly Statements (Explicit Cursor)
   ===================================================== */

DECLARE
    CURSOR c_stmt IS
        SELECT AccountID, Amount, TransDate
        FROM Transactions
        WHERE TO_CHAR(TransDate,'MM-YYYY') = TO_CHAR(SYSDATE,'MM-YYYY');

    v_rec c_stmt%ROWTYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- MONTHLY STATEMENT ---');

    OPEN c_stmt;
    LOOP
        FETCH c_stmt INTO v_rec;
        EXIT WHEN c_stmt%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Account: ' || v_rec.AccountID ||
            ' | Amount: ' || v_rec.Amount ||
            ' | Date: ' || TO_CHAR(v_rec.TransDate,'DD-MON-YYYY')
        );
    END LOOP;
    CLOSE c_stmt;
END;
/

/* =====================================================
   SCENARIO 2
   Apply Annual Fee using Cursor
   ===================================================== */

DECLARE
    CURSOR c_fee IS
        SELECT AccountID, Balance FROM Accounts;

    v_acc c_fee%ROWTYPE;
    v_fee NUMBER := 500;
BEGIN
    OPEN c_fee;
    LOOP
        FETCH c_fee INTO v_acc;
        EXIT WHEN c_fee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = v_acc.AccountID;

        DBMS_OUTPUT.PUT_LINE('Fee applied to Account: ' || v_acc.AccountID);
    END LOOP;
    CLOSE c_fee;
END;
/

/* =====================================================
   SCENARIO 3
   Update Loan Interest Rates using Cursor
   New Policy: Increase interest by 1%
   ===================================================== */

DECLARE
    CURSOR c_loan IS
        SELECT LoanID, InterestRate FROM Loans;

    v_loan c_loan%ROWTYPE;
BEGIN
    OPEN c_loan;
    LOOP
        FETCH c_loan INTO v_loan;
        EXIT WHEN c_loan%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 1
        WHERE LoanID = v_loan.LoanID;

        DBMS_OUTPUT.PUT_LINE('Updated Loan ID: ' || v_loan.LoanID);
    END LOOP;
    CLOSE c_loan;
END;
/

/* =========================
   4. VERIFY OUTPUT
   ========================= */

SELECT * FROM Accounts;
SELECT * FROM Transactions;
SELECT * FROM Loans;