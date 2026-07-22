import React, { useState } from "react";

function CurrencyConvertor() {

  const [rupees, setRupees] = useState("");
  const [euro, setEuro] = useState("");

  const handleSubmit = () => {

    const value = Number(rupees);

    const result = value / 90;

    setEuro(result.toFixed(2));

    alert("Converting to Euro Amount is " + result.toFixed(2));
  };

  return (

    <div>

      <h1 style={{ color: "green" }}>
        Currency Convertor!!!
      </h1>

      <label>Amount</label>

      <br />

      <input
        type="number"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
      />

      <br /><br />

      <label>Currency</label>

      <br />

      <input
        type="text"
        value={euro}
        readOnly
      />

      <br /><br />

      <button onClick={handleSubmit}>
        Submit
      </button>

    </div>

  );
}

export default CurrencyConvertor;