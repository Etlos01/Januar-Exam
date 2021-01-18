import React, { useState, useEffect } from "react";
import facade from "./apiFacade";
import { Form, Button, Spinner } from "react-bootstrap";


function LogIn({ login }) {
  const init = { username: "", password: "" };
  const [loginCredentials, setLoginCredentials] = useState(init);

  const performLogin = (evt) => {
    evt.preventDefault();
    login(loginCredentials.username, loginCredentials.password);
  };
  const onChange = (evt) => {
    setLoginCredentials({
      ...loginCredentials,
      [evt.target.id]: evt.target.value,
    });
  };

  return (
    <>
    <div style={{textAlign : 'center'}}>
      <h2>Login</h2>
      <Form onChange={onChange}>
        <Form.Group>
        <input type="text" placeholder="User Name" id="username" />
        </Form.Group>
        <Form.Group>
        <input type="password" placeholder="Password" id="password" />
        </Form.Group>
        <Button variant='dark' onClick={performLogin}>Login</Button>
      </Form>
    </div>
    <br></br>
    <AddUser/>
    </>

  );
}
function LoggedIn() {
  const [dataFromServer, setDataFromServer] = useState(<Spinner animation="border" />);

  useEffect(() => {
    facade.fetchData().then((data) => {
      setDataFromServer(data.msg);
    });
  }, []);

  return (
    <div >
      <h2>Data Received from server</h2>
      <h3>{dataFromServer}</h3>
    </div>
  );
}

const AddUser = () => {
  
    const initialValue = {
      fname: "",
      password: ""
    };
    const [user, setUser] = useState(initialValue);

    const handleChange = (event) => {
      const target = event.target;
      const value = target.value;
      const name = target.name;
      setUser({...user,[name]: value});
    };

    const handleSubmit = (event) => {
      event.preventDefault();
      window.alert(JSON.stringify(user));
      facade.addUser(user.fname,user.password);
    }
  return (
    <div style={{textAlign : 'center'}}> 
      <h2>Add New User</h2>
      <Form onChange={handleChange} onSubmit={handleSubmit}>
      <Form.Group controlId="formBasicEmail">
      <input name="fname" placeholder="Enter Name" />
      </Form.Group>
      <Form.Group controlId="formBasicPassword">
      <input name="password" placeholder="Password" />
      </Form.Group>
      <Button variant="dark" type="submit">Add Me</Button>
      </Form>
      </div>
  );
};

function LoginComplete(props) {
  //const [loggedIn, setLoggedIn] = useState(false);

  const logout = () => {
    facade.logout();
    props.setLoggedIn(false);
  };
  const login = (user, pass) => {
    facade.login(user, pass).then((res) => props.setLoggedIn(true));
  };

  return (
    <div>
      {!props.loggedIn ? (
        <LogIn login={login} />
      ) : (
        <div style={{textAlign : 'center'}}>
          <LoggedIn />
          <Button variant='dark'onClick={logout}>Logout</Button>
        </div>
      )}
    </div>
    
  );
}
export default LoginComplete;
