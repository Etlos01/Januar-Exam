import { useEffect ,useState } from "react";
import { HolidayURL } from "../../sites";





 const url = HolidayURL;


function DateAndName(holiday){
  const DateAndNames = holiday.map((data) => {
     const newObject = { title: ''+data.localName+'', startDate : ''+data.date+'T22:00', endDate: ''+data.date+'T24:00'};
     return newObject;
  });
  return DateAndNames;
}

 
 export function Holidays(){
 

const [holiday, setHoliday] = useState([]);
useEffect(() => {
   fetch(url)
    .then((res) => res.json())
    .then((data) => {
        setHoliday(DateAndName(data.allHolidays));
    });
}, []);
return holiday
};



  


