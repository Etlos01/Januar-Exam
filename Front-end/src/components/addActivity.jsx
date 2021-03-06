import { useState, useEffect, Col } from "react";
import { Button, Modal, Form } from "react-bootstrap"
import { Link } from "react-router-dom";
import Grid from '@material-ui/core/Grid';
import DateFnsUtils from '@date-io/date-fns';
import {
    MuiPickersUtilsProvider,
    KeyboardTimePicker,
    KeyboardDatePicker,
} from '@material-ui/pickers';
import facade from "./apiFacade";

const CityInfoURL = "https://dawa.aws.dk/steder?hovedtype=Bebyggelse&undertype=by&primærtnavn=";

const AddActivity = () => {

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const [selectedDate, setSelectedDate] = useState();

    const handleDateChange = (date) => {
        setSelectedDate(date);
    };


    const initialValue = {
        date: "",
        type: "",
        timeOfDay: "",
        duration: "",
        distance: "",
        comment: "",
        cityName: ""
    };
    const [activity, setActivity] = useState(initialValue);

    const handleFormChange = (event) => {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        setActivity({ ...activity, [name]: value });
    };


    const cityValues = {
        cityGeo: "",
        cityMun: "",
        cityPop: ""
    };

    const [cityInfo, setCityInfo] = useState([]);

    const fetchCityInfo = async () => {
        const data = await fetch(
            CityInfoURL+activity.cityName, facade.makeOptions("GET",true)
        );
        return data.json();
    }

    const handleSubmit = async (event) => {
        const cityInfo = await fetchCityInfo();
        // console.log(cityInfo);

        // setCityInfo(cityInfo);

        // console.log(cityInfo.cityInfo.id)
        // console.log("out of fetch going into map")
        // console.log()
        
        setShow(false);
        event.preventDefault();

        
        facade.addActivity(activity.date, activity.type, activity.timeOfDay, activity.duration, activity.distance, activity.comment, activity.cityName);
        window.alert("New activity was added to your profile");
    }


    return (
        <>
            <Button variant='dark' onClick={handleShow}>Add New Activity</Button>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>New Activity</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onChange={handleFormChange} onSubmit={handleSubmit}>
                        <Form.Group controlId="activity">
                            <Form.Label>Type of activity</Form.Label>
                            <Form.Control name="type" />
                        </Form.Group>
                        <Form.Row>
                            <Form.Group controlId="date">
                                <Form.Label>Date</Form.Label>
                                <Form.Control name="date" />
                            </Form.Group>
                            <Form.Group controlId="time">
                                <Form.Label>Time for activity</Form.Label>
                                <Form.Control name="timeOfDay" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group controlId="duration">
                                <Form.Label>Duration in minutes</Form.Label>
                                <Form.Control name="duration" />
                            </Form.Group>
                            <Form.Group controlId="distance">
                                <Form.Label>Distance in meter</Form.Label>
                                <Form.Control name="distance" />
                            </Form.Group>
                            <Form.Group controlId="comment">
                                <Form.Label>Comment</Form.Label>
                                <Form.Control name="comment" />
                            </Form.Group>
                            <Form.Group controlId="cityname">
                                <Form.Label>City</Form.Label>
                                <Form.Control name="cityName" />
                            </Form.Group>
                        </Form.Row>
                        {/* <MuiPickersUtilsProvider utils={DateFnsUtils}>
                  <Grid container justify="space-around">
                    <KeyboardDatePicker
                      margin="normal"
                      id="date-picker-dialog"
                      label="Select date"
                      format="MM/dd/yyyy"
                      value={selectedDate}
                      onChange={handleDateChange}
                      KeyboardButtonProps={{
                        'aria-label': 'change date',
                      }}
                    />
                    <KeyboardTimePicker
                      margin="normal"
                      id="time-picker"
                      label="Time for activity"
                      value={selectedDate}
                      onChange={handleDateChange}
                      KeyboardButtonProps={{
                        'aria-label': 'change time',
                      }}
                    />
                  </Grid>
                </MuiPickersUtilsProvider> */}
                        <b></b>
                        {/* <Form.Row>
                <Form.Group as={Col} controlId="formGridCity">
                  <Form.Label>City</Form.Label>
                  <Form.Control />
                </Form.Group>
    
                <Form.Group as={Col} controlId="formGridState">
                  <Form.Label>State</Form.Label>
                  <Form.Control as="select" defaultValue="Choose...">
                    <option>Choose...</option>
                    <option>...</option>
                  </Form.Control>
                </Form.Group>
    
                <Form.Group as={Col} controlId="formGridZip">
                  <Form.Label>Zip</Form.Label>
                  <Form.Control />
                </Form.Group>
              </Form.Row> */}
                    </Form>
                    <b></b>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
              </Button>
                    <Button type="submit" variant="dark" onClick={handleSubmit}>
                        Save Changes
              </Button>

                </Modal.Footer>
            </Modal>
        </>
    );
};

export default AddActivity;