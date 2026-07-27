import React from "react";
import EmployeeCard from "./EmployeeCard";

function EmployeesList() {

  const employees = [
    { id: 1, name: "John", designation: "Developer" },
    { id: 2, name: "David", designation: "Tester" },
    { id: 3, name: "Peter", designation: "Manager" }
  ];

  return (
    <div>

      {employees.map((employee) => (

        <EmployeeCard
          key={employee.id}
          employee={employee}
        />

      ))}

    </div>
  );
}

export default EmployeesList;