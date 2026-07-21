import React, { useState } from "react";
import GuestPage from "./Components/GuestPage";
import UserPage from "./Components/UserPage";

function App() {
  const [login, setLogin] = useState(false);

  return (
    <div style={{ marginLeft: "100px", marginTop: "100px" }}>
      {login ? (
        <UserPage onClick={() => setLogin(false)} />
      ) : (
        <GuestPage onClick={() => setLogin(true)} />
      )}
    </div>
  );
}

export default App;