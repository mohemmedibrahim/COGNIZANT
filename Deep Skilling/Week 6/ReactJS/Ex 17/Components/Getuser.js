import React, { Component } from "react";

class GetUser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      user: null,
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch("https://api.randomuser.me/");
      const data = await response.json();

      this.setState({
        user: data.results[0],
      });
    } catch (error) {
      console.log(error);
    }
  }

  render() {
    const { user } = this.state;

    if (!user) {
      return <h2>Loading...</h2>;
    }

    return (
      <div
        style={{
          textAlign: "center",
          marginTop: "40px",
        }}
      >
        <h1>Fetch User App</h1>

        <img
          src={user.picture.large}
          alt="User"
          style={{
            borderRadius: "50%",
          }}
        />

        <h2>
          {user.name.title} {user.name.first}
        </h2>
      </div>
    );
  }
}

export default GetUser;