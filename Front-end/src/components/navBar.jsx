import React, { useState } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { Navbar, Nav, NavItem } from "react-bootstrap";
import Login from "./login";
import Home from "./home";
import facade from "./apiFacade";
import ValidateRoleSite from "./validateRoleSite";
import UserSite from "./userSite";
import AdminSite from "./adminSite";
import AddActivity from "./addActivity";

const NavBarIO = () => {
  const [loggedIn, setLoggedIn] = useState(false);

  return (
    <>
      <Router>
        <Header loggedIn={loggedIn} />
        <Content setLoggedIn={setLoggedIn} loggedIn={loggedIn} />
      </Router>
    </>
  );
};

const Header = (props) => {
  return (
    <>
        <Navbar collapseOnSelect expand="lg" variant="light">
          <Navbar.Brand as={Link} to="/">
           Activityz
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="mr-auto">
              <ValidateRoleSite loggedIn={props.loggedIn} />
            </Nav>
            <Nav>
              <NavItem href="/Login">
                <Nav.Link as={Link} to="/Login">
                  <IsLoggedIn loggedIn={props.loggedIn} />
                </Nav.Link>
              </NavItem>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
    </>
  );
};

const Content = (props) => {
  return (
    <Switch>
      <Route exact path="/" component={Home} />
      <Route path="/adminSite" component={AdminSite} />
      <Route path="/activities" component={UserSite} />
      <Route path="/login">
        <Login setLoggedIn={props.setLoggedIn} loggedIn={props.loggedIn} />
      </Route>
      <Route path="/addactivity" component={AddActivity} />
      <Route path="*" component={NoMatch} />
    </Switch>
  );
};

const NoMatch = () => {
  return <p>There was no match</p>;
};

const IsLoggedIn = (props) => {
  if (props.loggedIn) {
    const userName = facade.getUserName();
    console.log("IsLoggedIn(), ", userName);
    return <>{userName}</>;
  } else {
    return <>Login</>;
  }
};

export default NavBarIO;
