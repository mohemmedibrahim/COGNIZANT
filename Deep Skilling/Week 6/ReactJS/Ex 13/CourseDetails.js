import React from "react";

function CourseDetails() {

    const courses = [
        { id: 1, name: "React", duration: "45 Days" },
        { id: 2, name: "Java", duration: "60 Days" },
        { id: 3, name: "Spring Boot", duration: "30 Days" }
    ];

    return (
        <div>

            <h2>Course Details</h2>

            <table border="1" cellPadding="8">

                <thead>
                    <tr>
                        <th>Course</th>
                        <th>Duration</th>
                    </tr>
                </thead>

                <tbody>
                    {courses.map(course => (
                        <tr key={course.id}>
                            <td>{course.name}</td>
                            <td>{course.duration}</td>
                        </tr>
                    ))}
                </tbody>

            </table>

        </div>
    );
}

export default CourseDetails;