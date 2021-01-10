import { useEffect ,useState } from "react";
import { getEventURL } from "../../sites";
import facade from "./../apiFacade";
const url = getEventURL;






 
function DateAndName(event){
  const DateAndNames = event.map((data) => {
     const newObject = { title: data.title, startDate : data.startDate, endDate: data.endDate, allDay: data.fullday };
     return newObject;
  });
  return DateAndNames;
}

export function Event(){

 const [events, setEvents] = useState([]);
 useEffect(() => {
    fetch(url, facade.makeOptions("GET", true))
    .then((res) => res.json())
    .then((data) => {
      setEvents(DateAndName(data));
    });
}, []);
return events
};