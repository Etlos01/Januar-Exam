import React from "react";
import { Nav, NavItem } from "react-bootstrap";
import { Link } from "react-router-dom";

const UserNavigator = () => {
  return (
    <NavItem href="/UserSite">
      <Nav.Link as={Link} to="/activities">
        See activitis
      </Nav.Link>
    </NavItem>
  );
};

export default UserNavigator;
