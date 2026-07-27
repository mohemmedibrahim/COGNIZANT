import React, { Component } from "react";

class EventExamples extends Component {

    constructor(props) {
        super(props);

        this.state = {
            count: 0
        };
    }

    increment = () => {
        this.setState({ count: this.state.count + 1 });
    };

    decrement = () => {
        this.setState({ count: this.state.count - 1 });
    };

    sayHello = () => {
        alert("Hello! Welcome to React Event Handling.");
    };

    sayWelcome = (message) => {
        alert(message);
    };

    handleClick = () => {
        alert("I was clicked");
    };

    handleIncrement = () => {
        this.increment();
        this.sayHello();
    };

    render() {
        return (
            <div align="center">

                <h2>Counter : {this.state.count}</h2>

                <button onClick={this.handleIncrement}>
                    Increment
                </button>

                &nbsp;

                <button onClick={this.decrement}>
                    Decrement
                </button>

                <br /><br />

                <button onClick={() => this.sayWelcome("Welcome")}>
                    Say Welcome
                </button>

                <br /><br />

                <button onClick={this.handleClick}>
                    OnPress
                </button>

            </div>
        );
    }
}

export default EventExamples;