import React from "react";
import VisitService from "../../service/VisitService";

class ShowVisits extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            service: VisitService.getInstance(),
            visits:[],
            isLoading:true
        };
    }

    fetchAllVisits = async () => {
        let data = await fetch("http://localhost:8080/visits/all/unordered", {
            method: "GET",
            credentials: "include"
        });
        let visits = await data.json();
        console.log(visits);
        this.setState({visits:visits, isLoading:false});
    };

    renderVisits() {
        return this.state.visits.map((visit) => {
            return (
                <tr key={visit.visitID}>
                    <td>{visit.visitID}</td>
                    <td>{visit.entryDate}</td>
                    <td>{visit.entryTime}</td>
                    <td>{visit.leaveTime}</td>
                    <td>{visit.duration}</td>
                    <td>{visit.holiday}</td>
                    <td>{visit.dayOfWeek}</td>
                </tr>
            )
        })
    }

    componentDidMount = () => {
        this.fetchAllVisits();
    };

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
                    <h1>All Visits</h1>
                    <table>
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
