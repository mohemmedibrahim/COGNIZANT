import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee }) {

  const theme = useContext(ThemeContext);

  return (

    <div
      style={{
        border: "1px solid black",
        margin: "10px",
        padding: "10px"
      }}
    >

      <h3>{employee.name}</h3>

      <p>{employee.designation}</p>

      <button className={theme}>
        View Details
      </button>

    </div>

  );
}

export default EmployeeCard;