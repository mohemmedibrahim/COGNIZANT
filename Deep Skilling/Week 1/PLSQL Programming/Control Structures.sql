CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(5)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER,
    DueDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Customers VALUES (1,'Ravi',65,12000,'FALSE');
INSERT INTO Customers VALUES (2,'Priya',45,8000,'FALSE');
INSERT INTO Customers VALUES (3,'Arun',70,15000,'FALSE');
INSERT INTO Customers VALUES (4,'Meena',62,5000,'FALSE');

INSERT INTO Loans VALUES (101,1,9,DATE '2026-07-15');
INSERT INTO Loans VALUES (102,2,10,DATE '2026-09-01');
INSERT INTO Loans VALUES (103,3,8,DATE '2026-07-20');
INSERT INTO Loans VALUES (104,4,11,DATE '2026-07-05');

COMMIT;

BEGIN
    FOR c IN (SELECT CustomerID FROM Customers WHERE Age > 60)
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = c.CustomerID;
    END LOOP;

    COMMIT;
END;
/

BEGIN
    FOR c IN (SELECT CustomerID, Balance FROM Customers)
    LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/
SET SERVEROUTPUT ON;

BEGIN
    FOR l IN (
        SELECT CustomerID, LoanID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ' || l.CustomerID ||
            ' Loan ' || l.LoanID ||
            ' Due on ' || TO_CHAR(l.DueDate,'DD-MON-YYYY')
        );
    END LOOP;
END;
/

SELECT * FROM Customers;

SELECT * FROM Loans;