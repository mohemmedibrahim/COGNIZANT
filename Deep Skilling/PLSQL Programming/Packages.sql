
/* =========================
   1. DROP TABLES (SAFE RUN)
   ========================= */

BEGIN EXECUTE IMMEDIATE 'DROP TABLE Customers'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Employees'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Accounts'; EXCEPTION WHEN OTHERS THEN NULL; END;
/

/* =========================
   2. CREATE TABLES
   ========================= */

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmpID NUMBER PRIMARY KEY,
    EmpName VARCHAR2(50),
    Salary NUMBER
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    Balance NUMBER
);

/* =========================
   3. INSERT SAMPLE DATA
   ========================= */

INSERT INTO Customers VALUES (1,'Ravi',5000);
INSERT INTO Customers VALUES (2,'Priya',8000);

INSERT INTO Employees VALUES (101,'Arun',40000);
INSERT INTO Employees VALUES (102,'Meena',50000);

INSERT INTO Accounts VALUES (1,1,3000);
INSERT INTO Accounts VALUES (2,1,2000);
INSERT INTO Accounts VALUES (3,2,8000);

COMMIT;

SET SERVEROUTPUT ON;

-- =====================================================
-- 🔷 SCENARIO 1: CUSTOMER MANAGEMENT PACKAGE
-- =====================================================

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_balance NUMBER);
    FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER)
    IS
    BEGIN
        INSERT INTO Customers VALUES (p_id, p_name, p_balance);
        DBMS_OUTPUT.PUT_LINE('Customer Added: ' || p_name);
    END;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_balance NUMBER)
    IS
    BEGIN
        UPDATE Customers
        SET Balance = p_balance
        WHERE CustomerID = p_id;

        DBMS_OUTPUT.PUT_LINE('Customer Updated ID: ' || p_id);
    END;

    FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_id;

        RETURN v_balance;
    END;

END CustomerManagement;
/

-- =====================================================
-- 🔷 SCENARIO 2: EMPLOYEE MANAGEMENT PACKAGE
-- =====================================================

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER);
    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER)
    IS
    BEGIN
        INSERT INTO Employees VALUES (p_id, p_name, p_salary);
        DBMS_OUTPUT.PUT_LINE('Employee Hired: ' || p_name);
    END;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER)
    IS
    BEGIN
        UPDATE Employees
        SET Salary = p_salary
        WHERE EmpID = p_id;

        DBMS_OUTPUT.PUT_LINE('Employee Updated ID: ' || p_id);
    END;

    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmpID = p_id;

        RETURN v_salary * 12;
    END;

END EmployeeManagement;
/

-- =====================================================
-- 🔷 SCENARIO 3: ACCOUNT OPERATIONS PACKAGE
-- =====================================================

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_accid NUMBER, p_custid NUMBER, p_balance NUMBER);
    PROCEDURE CloseAccount(p_accid NUMBER);
    FUNCTION TotalBalance(p_custid NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(p_accid NUMBER, p_custid NUMBER, p_balance NUMBER)
    IS
    BEGIN
        INSERT INTO Accounts VALUES (p_accid, p_custid, p_balance);
        DBMS_OUTPUT.PUT_LINE('Account Opened: ' || p_accid);
    END;

    PROCEDURE CloseAccount(p_accid NUMBER)
    IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_accid;
        DBMS_OUTPUT.PUT_LINE('Account Closed: ' || p_accid);
    END;

    FUNCTION TotalBalance(p_custid NUMBER) RETURN NUMBER
    IS
        v_total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance),0)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_custid;

        RETURN v_total;
    END;

END AccountOperations;
/

-- =====================================================
-- 🔷 TESTING PACKAGES
-- =====================================================

BEGIN
    CustomerManagement.AddCustomer(3,'Arun',9000);
    CustomerManagement.UpdateCustomer(1,7000);
END;
/

SELECT CustomerManagement.GetBalance(1) AS Balance FROM DUAL;

BEGIN
    EmployeeManagement.HireEmployee(103,'John',45000);
    EmployeeManagement.UpdateEmployee(101,45000);
END;
/

SELECT EmployeeManagement.CalculateAnnualSalary(101) AS AnnualSalary FROM DUAL;

BEGIN
    AccountOperations.OpenAccount(4,2,6000);
    AccountOperations.CloseAccount(2);
END;
/

SELECT AccountOperations.TotalBalance(1) AS TotalBalance FROM DUAL;

-- FINAL CHECK
SELECT * FROM Customers;
SELECT * FROM Employees;
SELECT * FROM Accounts;