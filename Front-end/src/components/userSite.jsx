import { useState, Col } from "react";
import AddActivity from "./addActivity";
import ShowActivities from "./showActivities";


const UserSite = () => {

  return (
    <>
    <h3>Add new activity</h3>
    <AddActivity/>
    <h3>Show all activities</h3>
    <ShowActivities/>
    </>
  );
};

export default UserSite;
