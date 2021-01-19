import {useState, useEffect} from "react";
import { getAllURL } from "./../sites";



function Home(){

  useEffect(() => {
    fetchTotalActivityCount();
}, []);

const [count, setCount] = useState([]);

const fetchTotalActivityCount = async () => {
    const data = await fetch(
        getAllURL
    );
    
    const count = await data.json();
    setCount(count);
}
  return (
    <>
      <h1 style={{textAlign : 'center'}}>Welcome to this awesome activity logger</h1>
      <h2 style={{textAlign : 'center'}}>Click on login to start loggin'!</h2>
      <h3 style={{textAlign : 'center'}}>Check how many count have been logged so far!</h3>
      <h1 style={{textAlign : 'center'}}>{count}</h1>
    
    </>
  );
}

export default Home;
