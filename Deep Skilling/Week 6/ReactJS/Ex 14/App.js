import React, { useState } from "react";
import EmployeesList from "./EmployeesList";
import ThemeContext from "./ThemeContext";

function App() {

  const [theme] = useState("light");

  return (
    <ThemeContext.Provider value={theme}>
      <div>
        <h1>Employee Management</h1>

        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;