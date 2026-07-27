import React, { Component } from "react";
import Guest from "./Guest";
import User from "./User";

class LoginControl extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isLoggedIn: false
        };
    }

    login = () => {
        this.setState({ isLoggedIn: true });
    };

    logout = () => {
        this.setState({ isLoggedIn: false });
    };

    render() {

        if (this.state.isLoggedIn) {

            return (
                <div align="center">
                    <User />
                    <br />
                    <button onClick={this.logout}>Logout</button>
                </div>
            );

        } else {

            return (
                <div align="center">
                    <Guest />
                    <br />
                    <button onClick={this.login}>Login</button>
                </div>
            );

        }

    }
}

export default LoginControl;