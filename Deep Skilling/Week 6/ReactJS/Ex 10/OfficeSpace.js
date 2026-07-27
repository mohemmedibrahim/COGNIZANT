import React from "react";

function OfficeSpace() {

    const offices = [
        {
            name: "Tech Park",
            rent: 45000,
            address: "Chennai",
            image: "https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=600"
        },
        {
            name: "Business Hub",
            rent: 75000,
            address: "Bangalore",
            image: "https://images.unsplash.com/photo-1497366811353-6870744d04b2?w=600"
        },
        {
            name: "Corporate Tower",
            rent: 90000,
            address: "Hyderabad",
            image: "https://images.unsplash.com/photo-1497366216548-37526070297c?w=600"
        }
    ];

    return (
        <div align="center">

            <h1>Office Space Rental App</h1>

            {offices.map((office, index) => (

                <div
                    key={index}
                    style={{
                        border: "1px solid black",
                        padding: "15px",
                        margin: "15px",
                        width: "350px"
                    }}
                >

                    <img
                        src={office.image}
                        alt={office.name}
                        width="300"
                        height="180"
                    />

                    <h2>{office.name}</h2>

                    <h3
                        style={{
                            color: office.rent < 60000 ? "red" : "green"
                        }}
                    >
                        Rent : ₹{office.rent}
                    </h3>

                    <h4>Address : {office.address}</h4>

                </div>

            ))}

        </div>
    );
}

export default OfficeSpace;