import React from "react";
import VisitService from "../../service/VisitService";
import "./ShowVisits.css";

class ShowVisits extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            service: VisitService.getInstance(),
            visits:[],
            isLoading:true
        };
    }

    fetchAllVisits = () => {
        this.state.service.findAllVisits().then(results => {this.setState({visits:results, isLoading:false})});
    };

    componentDidMount = () => {
        this.fetchAllVisits();
    };

    renderVisits() {
        return this.state.visits.map((visit) => {
            return (
                <tr key={visit.visitID}>
                    <td>{visit.visitID}</td>
                    <td>{visit.entryTime.split(":00.000Z")[0].replace("T", " ")}</td>
                    <td>{visit.leaveTime.split(":00.000Z")[0].replace("T", " ")}</td>
                    <td>{visit.duration}</td>
                    <td>{visit.holiday}</td>
                    <td>{visit.dayOfWeek}</td>
                </tr>
            )
        })
    }

    renderHeader() {
        console.log(this.state.visits);
        let header = Object.keys(this.state.visits[0]).slice(1,7);
        return header.map((key, index) => {
            return <th key={index}>{key.toUpperCase()}</th>
        })
    }

    render() {
        if(!this.state.isLoading) {
            return (
                <div>
                    <h1 id="title">All Visits</h1>
                    <table id="visits">
                        <tbody>
                        <tr>{this.renderHeader()}</tr>
                        {this.renderVisits()}
                        </tbody>
                    </table>
                </div>
            )
        } else {
            return <div>Loading...</div>
        }
    }
}

export default ShowVisits;
