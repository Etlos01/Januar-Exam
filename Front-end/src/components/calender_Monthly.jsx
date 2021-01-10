import { useState } from "react";
import Paper from "@material-ui/core/Paper";
import { ViewState } from "@devexpress/dx-react-scheduler";
import {
  Scheduler,
  WeekView,
  Appointments,
  Toolbar,
  ViewSwitcher,
  MonthView,
  DayView,
  DateNavigator,
  TodayButton,
  AllDayPanel,
  CurrentTimeIndicator,
} from "@devexpress/dx-react-scheduler-material-ui";
import Picker from "./calender_components/datePicker";

export default function Month(props) {
  const data = props.events;

  const appointments = [
    {
      endDate: "2020-12-31T24:00",
      startDate: "2020-12-31T22:00",
      title: "Nytårsaftensdag",
    },
  ];

  const Appointment = ({ children, style, ...restProps }) => (
    <Appointments.Appointment
      {...restProps}
      style={{
        ...style,
        backgroundColor: "#4615b2",
        borderRadius: "8px",
      }}
    >
      {children}
    </Appointments.Appointment>
  );
  return (
    <>
      <Paper>
        <Scheduler data={data} height={650}>
          <ViewState
            defaultCurrentDate={new Date()}
            defaultCurrentViewName="Week"
          />

          <WeekView startDayHour={10} endDayHour={19} />
          <MonthView />
          <DayView />

          <Toolbar />
          <DateNavigator />
          <TodayButton />

          <AllDayPanel />
          <ViewSwitcher />

          <Appointments appointmentComponent={Appointment} />
          <CurrentTimeIndicator />
        </Scheduler>
      </Paper>
    </>
  );
}
