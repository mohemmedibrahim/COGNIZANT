import { useState } from "react";

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    if (employeeName.trim() === "" || complaint.trim() === "") {
      alert("Please fill all fields");
      return;
    }

    const referenceNumber = Math.floor(
      100000 + Math.random() * 900000
    );

    alert(
      `Complaint Raised Successfully!\n\nEmployee Name: ${employeeName}\nReference Number: ${referenceNumber}`
    );

    setEmployeeName("");
    setComplaint("");
  };

  return (
    <div
      style={{
        width: "400px",
        margin: "50px auto",
        padding: "20px",
        border: "1px solid #ccc",
        borderRadius: "10px",
      }}
    >
      <h2>Ticket Raising App</h2>

      <form onSubmit={handleSubmit}>
        <label>Employee Name</label>
        <br />
        <input
          type="text"
          value={employeeName}
          onChange={(e) => setEmployeeName(e.target.value)}
          placeholder="Enter Employee Name"
          style={{ width: "100%", padding: "8px", marginBottom: "15px" }}
        />

        <label>Complaint</label>
        <br />
        <textarea
          rows="5"
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
          placeholder="Enter Complaint"
          style={{ width: "100%", padding: "8px", marginBottom: "15px" }}
        />

        <button type="submit">Submit Complaint</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;