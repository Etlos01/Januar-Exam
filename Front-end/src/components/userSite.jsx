import { useState, Col } from "react";
import AddActivity from "./addActivity";
import ShowActivities from "./showActivities";
import AddCircleIcon from '@material-ui/icons/AddCircle';
import Tooltip from '@material-ui/core/Tooltip';



const UserSite = () => {

  return (
    <>
    <h3 style={{textAlign : 'center'}}>Activities</h3>
    <AddActivity/>
    <ShowActivities/>
    </>
  );
};

export default UserSite;
{/* <Tooltip title="Add activity" >
    <AddCircleIcon fontSize='large'/>
    </Tooltip> */}