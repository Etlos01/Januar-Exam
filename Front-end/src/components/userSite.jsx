import { useState } from "react";

/*<p>
Her skal der vises en kalender.
<br/> husk:
<br/>npm install @material-ui/core og 
npm i --save @devexpress/dx-react-core @devexpress/dx-react-scheduler samt
npm i --save @devexpress/dx-react-scheduler-material-ui <br/>
og npm i @date-io/date-fns@1.x date-fns
</p>*/
function Arrays() {
  const holiday_array = ""

  const appointment_array = "";

  if (holiday_array === undefined && appointment_array === undefined) {
    console.log("loading");
  } else {
    const data = holiday_array.concat(appointment_array);
    return data;
  }
}

const UserSite = () => {
  const initialValue = {
    title: "",
    startDate: "",
    endDate: "",
    allDay: "",
    category: "",
  };

  const [newEvent, setNewEvent] = useState(initialValue);
  console.log(newEvent);

  const data = Arrays();
  console.log(data);
  if (newEvent === initialValue) {
    console.log("Et eller andet");
  } else {
    data.push(newEvent);
  }
  //}
  return (
    <>
    </>
  );
};

export default UserSite;
