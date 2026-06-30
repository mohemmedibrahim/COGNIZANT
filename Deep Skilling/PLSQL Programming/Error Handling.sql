BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ErrorLog';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmpID NUMBER PRIMARY KEY,
    EmpName VARCHAR2(50),
    Salary NUMBER
);

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER
);

CREATE TABLE ErrorLog (
    ErrorMessage VARCHAR2(200),
    ErrorTime DATE
);
INSERT INTO Accounts VALUES (1,'Ravi',5000);
INSERT INTO Accounts VALUES (2,'Priya',3000);

INSERT INTO Employees VALUES (101,'Arun',40000);
INSERT INTO Employees VALUES (102,'Meena',50000);

INSERT INTO Customers VALUES (1,'Ravi',65,12000);

COMMIT;
DECLARE
    v_amount NUMBER := 1000;
BEGIN
    UPDATE Accounts
    SET Balance = Balance - v_amount
    WHERE AccountID = 1;

    UPDATE Accounts
    SET Balance = Balance + v_amount
    WHERE AccountID = 2;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        INSERT INTO ErrorLog VALUES ('Fund transfer failed', SYSDATE);
        ROLLBACK;
END;
/

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_empid IN NUMBER,
    p_percent IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmpID = p_empid;

    IF SQL%ROWCOUNT = 0 THEN
        INSERT INTO ErrorLog VALUES ('Employee not found: ' || p_empid, SYSDATE);
    END IF;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        INSERT INTO ErrorLog VALUES ('Salary update failed', SYSDATE);
END;
/
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_id NUMBER,
    p_name VARCHAR2,
    p_age NUMBER,
    p_balance NUMBER
)
IS
BEGIN
    INSERT INTO Customers VALUES (p_id, p_name, p_age, p_balance);
    COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        INSERT INTO ErrorLog VALUES ('Duplicate Customer ID: ' || p_id, SYSDATE);

    WHEN OTHERS THEN
        INSERT INTO ErrorLog VALUES ('Customer insert failed', SYSDATE);
END;
/
BEGIN
    UpdateSalary(101, 10)
/* =========================
   1. DROP TABLES (SAFE)
   ========================= */

BEGIN EXECUTE IMMEDIATE 'DROP TABLE ErrorLog'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Accounts'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Employees'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Customers'; EXCEPTION WHEN OTHERS THEN NULL; END;
/

/* =========================
   2. CREATE TABLES
   ========================= */

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmpID NUMBER PRIMARY KEY,
    EmpName VARCHAR2(50),
    Salary NUMBER
);

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER
);

CREATE TABLE ErrorLog (
    ErrorMessage VARCHAR2(200),
    ErrorTime DATE
);

/* =========================
   3. INSERT DATA
   ========================= */

INSERT INTO Accounts VALUES (1,'Ravi',5000);
INSERT INTO Accounts VALUES (2,'Priya',3000);

INSERT INTO Employees VALUES (101,'Arun',40000);
INSERT INTO Employees VALUES (102,'Meena',50000);

INSERT INTO Customers VALUES (1,'Ravi',65,12000);

COMMIT;

/* =========================
   4. SCENARIO 1
   FUND TRANSFER
   ========================= */

DECLARE
    v_amount NUMBER := 1000;
BEGIN
    UPDATE Accounts
    SET Balance = Balance - v_amount
    WHERE AccountID = 1;

    UPDATE Accounts
    SET Balance = Balance + v_amount
    WHERE AccountID = 2;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        INSERT INTO ErrorLog VALUES ('Fund transfer failed', SYSDATE);
        ROLLBACK;
END;
/

/* =========================
   5. SCENARIO 2
   UPDATE SALARY PROCEDURE
   ========================= */

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_empid IN NUMBER,
    p_percent IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmpID = p_empid;

    IF SQL%ROWCOUNT = 0 THEN
        INSERT INTO ErrorLog VALUES ('Employee not found: ' || p_empid, SYSDATE);
    END IF;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        INSERT INTO ErrorLog VALUES ('Salary update failed', SYSDATE);
END;
/

/* =========================
   6. SCENARIO 3
   ADD CUSTOMER PROCEDURE
   ========================= */

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_id NUMBER,
    p_name VARCHAR2,
    p_age NUMBER,
    p_balance NUMBER
)
IS
BEGIN
    INSERT INTO Customers VALUES (p_id, p_name, p_age, p_balance);
    COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        INSERT INTO ErrorLog VALUES ('Duplicate Customer ID: ' || p_id, SYSDATE);

    WHEN OTHERS THEN
        INSERT INTO ErrorLog VALUES ('Customer insert failed', SYSDATE);
END;
/

/* =========================
   7. TEST RUN
   ========================= */

BEGIN
    UpdateSalary(101, 10);
END;
/

BEGIN
    AddNewCustomer(1,'Test',30,5000);
END;
/

/* =========================
   8. CHECK OUTPUT TABLES
   ========================= */

SELECT * FROM Accounts;
SELECT * FROM Employees;
SELECT * FROM Customers;
SELECT * FROM ErrorLog;;
END;
/

BEGIN
    AddNewCustomer(1,'Test',30,5000);
END;
/

SELECT * FROM ErrorLog;
SELECT * FROM Employees;
SELECT * FROM Customers;

DELETE FROM LOANS
WHERE
        LOANID = :LOANID
    AND CUSTOMERID = :CUSTOMERID
    AND INTERESTRATE = :INTERESTRATE
    AND DUEDATE = :DUEDATE;

DELETE FROM CUSTOMERS
WHERE
        CUSTOMERID = :CUSTOMERID
    AND CUSTOMERNAME = :CUSTOMERNAME
    AND AGE = :AGE
    AND BALANCE = :BALANCE
    AND ISVIP = :ISVIP;