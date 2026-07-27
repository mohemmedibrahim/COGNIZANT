
import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Virat", score: 90 },
        { name: "Rohit", score: 85 },
        { name: "Gill", score: 72 },
        { name: "Rahul", score: 65 },
        { name: "Hardik", score: 80 },
        { name: "Jadeja", score: 60 },
        { name: "Ashwin", score: 55 },
        { name: "Bumrah", score: 40 },
        { name: "Shami", score: 68 },
        { name: "Siraj", score: 75 },
        { name: "Iyer", score: 95 }
    ];

    const lowScorePlayers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>

            {players.map((player, index) => (
                <p key={index}>
                    {player.name} - {player.score}
                </p>
            ))}

            <h2>Players with Score Below 70</h2>

            {lowScorePlayers.map((player, index) => (
                <p key={index}>
                    {player.name} - {player.score}
                </p>
            ))}
        </div>
    );
}

export default ListofPlayers;