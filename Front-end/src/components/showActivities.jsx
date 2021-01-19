import React, { useState, useEffect, Component } from 'react';
import { Button, Modal, Form, Table} from "react-bootstrap"
import { GetActivitiesURL } from "./../sites";
import facade from "./apiFacade";


function ShowActivities() {

    useEffect(() => {
        fetchActivities();
    }, []);

    const [activities, setActivities] = useState([]);

    const fetchActivities = async () => {
        const data = await fetch(
            GetActivitiesURL, facade.makeOptions("GET",true)
        );
        
        const activities = await data.json();
        
        console.log(activities);
        setActivities(activities);
    }
    return (
        <>
            <Table striped bordered hover size="sm">
                <thead>
                    <tr>
                        <th>Type</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Duration</th>
                        <th>Distance</th>
                        <th>Comment</th>
                        <th>City</th>
                    </tr>
                </thead>
                <tbody>
                {activities.map(activity => (
                    <tr>
                        <td>{activity.type}</td>
                        <td>{activity.date}</td>
                        <td>{activity.timeOfDay}</td>
                        <td>{activity.duration}</td>
                        <td>{activity.distance}</td>
                        <td>{activity.comment}</td>
                        <td>{activity.cityName}</td>
                    </tr>
                    ))}
                </tbody>
            </Table>
        </>
    );
};

export default ShowActivities;