import React from "react";

function IndianPlayers() {

    const IndianTeam = [
        "Sachin",
        "Dhoni",
        "Virat",
        "Rohit",
        "Yuvraj",
        "Raina"
    ];

    const [first, second, third, fourth, fifth, sixth] = IndianTeam;

    const T20Players = [
        "Hardik",
        "Surya",
        "Gill"
    ];

    const RanjiPlayers = [
        "Pujara",
        "Rahane",
        "Saha"
    ];

    const mergedPlayers = [...T20Players, ...RanjiPlayers];

    return (

        <div>

            <h1>Odd Team Players</h1>

            <ul>
                <li>{first}</li>
                <li>{third}</li>
                <li>{fifth}</li>
            </ul>

            <hr />

            <h1>Even Team Players</h1>

            <ul>
                <li>{second}</li>
                <li>{fourth}</li>
                <li>{sixth}</li>
            </ul>

            <hr />

            <h1>Merged Players</h1>

            <ul>
                {mergedPlayers.map((player, index) => (
                    <li key={index}>{player}</li>
                ))}
            </ul>

        </div>

    );
}

export default IndianPlayers;