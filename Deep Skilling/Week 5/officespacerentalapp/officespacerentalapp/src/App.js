import officeImg from "./images/office.jpg";

function App() {

  const office = {
    name: "ABC Tech Park",
    rent: 55000,
    address: "Chennai"
  };

  const officeList = [
    {
      name: "ABC Tech Park",
      rent: 55000,
      address: "Chennai"
    },
    {
      name: "Cyber Tower",
      rent: 75000,
      address: "Bangalore"
    },
    {
      name: "IT Hub",
      rent: 62000,
      address: "Hyderabad"
    }
  ];

  return (
    <div style={{ padding: "20px" }}>

      <h1>Office Space Rental App</h1>

      <img
        src={officeImg}
        alt="Office"
        width="400"
      />

      <h2>Single Office Details</h2>

      <p><b>Name:</b> {office.name}</p>

      <p style={{ color: office.rent < 60000 ? "red" : "green" }}>
        <b>Rent:</b> ₹{office.rent}
      </p>

      <p><b>Address:</b> {office.address}</p>

      <hr />

      <h2>Office List</h2>

      {officeList.map((item, index) => (

        <div key={index} style={{ marginBottom: "20px" }}>

          <p><b>Name:</b> {item.name}</p>

          <p
            style={{
              color: item.rent < 60000 ? "red" : "green"
            }}
          >
            <b>Rent:</b> ₹{item.rent}
          </p>

          <p><b>Address:</b> {item.address}</p>

        </div>

      ))}

    </div>
  );
}

export default App;