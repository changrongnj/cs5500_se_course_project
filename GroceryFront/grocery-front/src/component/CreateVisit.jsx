import React from "react";
import VisitService from "../service/VisitService";



class CreateVisit extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            service:VisitService.getInstance()
        };
    }

    fetchData = (state) => {
        this.state.service
            .search({

            })
            .then(results => {

            });
    };

    render() {
        return (
            <div>

                <div>
                    <label htmlFor="visitDate">Visit Date:</label>
                    <input type="date" id="visitDate" name="visitDate" value="2020-07-04" required/>
                </div>

                <div>
                    <label htmlFor="entryTime">Entry Time:</label>
                    <input type="time" id="entryTime" name="entryTime"
                           min="06:00" max="21:00" value="06:00" required/>

                    <label htmlFor="leaveTime">Leave Time:</label>
                    <input type="time" id="leaveTime" name="leaveTime"
                           min="06:00" max="21:00" value="06:00" required/>
                </div>

                <div>
                    <span>Day of Week:</span>
                    <label htmlFor="weekday">Weekday</label>
                    <input id="weekday" type="radio" name="DayOfWeek" value="weekday"/>
                        <label htmlFor="weekend">Weekend</label>
                        <input id="weekend" type="radio" name="DayOfWeek" value="weekend"/>
                </div>

                <div>
                    <span>Weather of a Day:</span>
                    <label htmlFor="nice">Nice weather</label>
                    <input id="nice" type="radio" name="weather" value="nice"/>
                        <label htmlFor="normal">Normal weather</label>
                        <input id="normal" type="radio" name="weather" value="normal"/>
                            <label htmlFor="bad">Bad weather</label>
                            <input id="bad" type="radio" name="weather" value="bad"/>
                </div>

                <div>
                    <span>Holiday Type:</span>
                    <label htmlFor="holiday">Holiday</label>
                    <input id="holiday" type="radio" name="holidayType" value="holiday"/>
                        <label htmlFor="dayBeforeHoliday">Day before holiday</label>
                        <input id="dayBeforeHoliday" type="radio" name="holidayType" value="dayBeforeHoliday"/>
                            <label htmlFor="weekBeforeHoliday">Week before holiday</label>
                            <input id="weekBeforeHoliday" type="radio" name="holidayType" value="weekBeforeHoliday"/>
                                <label htmlFor="notHoliday">Holiday</label>
                                <input id="notHoliday" type="radio" name="holidayType" value="notHoliday"/>
                </div>

                <div>
                    <span>Special Reason for Visit:</span>
                    <label htmlFor="lunch">Lunch</label>
                    <input id="lunch" type="radio" name="event" value="lunch"/>
                        <label htmlFor="dinner">Dinner</label>
                        <input id="dinner" type="radio" name="event" value="dinner"/>
                            <label htmlFor="seniorDiscount">Senior Discount</label>
                            <input id="seniorDiscount" type="radio" name="event" value="seniorDiscount"/>
                                <label htmlFor="none">None</label>
                                <input id="none" type="radio" name="event" value="none"/>
                </div>

                <div>
                    <input onClick={() => this.fetchData(this.state)} type="Submit" value="Submit"/>
                </div>

            </div>
        );
    }
}

export default CreateVisit;
