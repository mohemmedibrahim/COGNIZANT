
/* =========================
   1. DROP TABLE (SAFE)
   ========================= */

BEGIN EXECUTE IMMEDIATE 'DROP TABLE Accounts'; EXCEPTION WHEN OTHERS THEN NULL; END;
/

/* =========================
   2. CREATE TABLE
   ========================= */

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    DOB DATE,
    Balance NUMBER
);

/* =========================
   3. INSERT SAMPLE DATA
   ========================= */

INSERT INTO Accounts VALUES (1,'Ravi',DATE '1995-05-10',5000);
INSERT INTO Accounts VALUES (2,'Priya',DATE '1980-03-15',12000);
INSERT INTO Accounts VALUES (3,'Arun',DATE '2000-07-20',3000);

COMMIT;

/* =====================================================
   SCENARIO 1
   Function: GetCustomerAge (DOB → Age)
   ===================================================== */

CREATE OR REPLACE FUNCTION GetCustomerAge (
    p_dob DATE
)
RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/

/* =====================================================
   SCENARIO 2
   Function: GetMonthlyEMI (Loan EMI Calculation)
   Formula: P * R * (1+R)^N / ((1+R)^N - 1)
   ===================================================== */

CREATE OR REPLACE FUNCTION GetMonthlyEMI (
    p_amount NUMBER,
    p_rate   NUMBER,
    p_years  NUMBER
)
RETURN NUMBER
IS
    r NUMBER;
    n NUMBER;
    emi NUMBER;
BEGIN
    r := p_rate / (12 * 100);
    n := p_years * 12;

    emi := (p_amount * r * POWER(1 + r, n)) /
           (POWER(1 + r, n) - 1);

    RETURN emi;
END;
/

/* =====================================================
   SCENARIO 3
   Function: CheckBalanceStatus (TRUE/FALSE)
   ===================================================== */

CREATE OR REPLACE FUNCTION CheckBalanceStatus (
    p_acc_id NUMBER,
    p_amount NUMBER
)
RETURN VARCHAR2
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_acc_id;

    IF v_balance >= p_amount THEN
        RETURN 'TRUE';
    ELSE
        RETURN 'FALSE';
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'ACCOUNT NOT FOUND';
END;
/

/* =========================
   4. TEST FUNCTIONS
   ========================= */

-- Age Function
SELECT GetCustomerAge(DOB) AS AGE FROM Accounts;

-- EMI Function
SELECT GetMonthlyEMI(100000, 10, 5) AS EMI FROM DUAL;

-- Balance Check Function
SELECT CheckBalanceStatus(1, 2000) AS STATUS FROM DUAL;
SELECT CheckBalanceStatus(3, 5000) AS STATUS FROM DUAL;