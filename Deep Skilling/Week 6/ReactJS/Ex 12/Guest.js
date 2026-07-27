import React from "react";

function Guest() {
    return (
        <div align="center">
            <h2>Flight Details</h2>

            <table border="1" cellPadding="10">
                <thead>
                    <tr>
                        <th>Flight</th>
                        <th>From</th>
                        <th>To</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>AI101</td>
                        <td>Chennai</td>
                        <td>Delhi</td>
                    </tr>

                    <tr>
                        <td>AI202</td>
                        <td>Bangalore</td>
                        <td>Mumbai</td>
                    </tr>
                </tbody>
            </table>

            <h3>Please Login to Book Tickets</h3>
        </div>
    );
}

export default Guest;