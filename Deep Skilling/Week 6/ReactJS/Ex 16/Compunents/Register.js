import { useState } from "react";

function Register() {
  const [form, setForm] = useState({
    name: "",
    email: "",
    password: "",
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;

    setForm({
      ...form,
      [name]: value,
    });
  };

  const validate = () => {
    let temp = {};

    if (form.name.length < 5) {
      temp.name = "Name should have at least 5 characters";
    }

    if (!(form.email.includes("@") && form.email.includes("."))) {
      temp.email = "Enter a valid Email";
    }

    if (form.password.length < 8) {
      temp.password = "Password should have at least 8 characters";
    }

    return temp;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const validationErrors = validate();

    if (Object.keys(validationErrors).length === 0) {
      alert("Registration Successful");
      setForm({
        name: "",
        email: "",
        password: "",
      });
      setErrors({});
    } else {
      setErrors(validationErrors);
    }
  };

  return (
    <div
      style={{
        width: "400px",
        margin: "40px auto",
        padding: "20px",
        border: "1px solid gray",
        borderRadius: "10px",
      }}
    >
      <h2>Mail Register App</h2>

      <form onSubmit={handleSubmit}>

        <label>Name</label><br />
        <input
          type="text"
          name="name"
          value={form.name}
          onChange={handleChange}
        />
        <br />
        <span style={{ color: "red" }}>{errors.name}</span>
        <br /><br />

        <label>Email</label><br />
        <input
          type="email"
          name="email"
          value={form.email}
          onChange={handleChange}
        />
        <br />
        <span style={{ color: "red" }}>{errors.email}</span>
        <br /><br />

        <label>Password</label><br />
        <input
          type="password"
          name="password"
          value={form.password}
          onChange={handleChange}
        />
        <br />
        <span style={{ color: "red" }}>{errors.password}</span>
        <br /><br />

        <button type="submit">Register</button>

      </form>
    </div>
  );
}

export default Register;