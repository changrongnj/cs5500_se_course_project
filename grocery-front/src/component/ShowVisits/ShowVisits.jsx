import React from "react";
import VisitService from "../../service/VisitService";
import "./ShowVisits.css";
import {InputGroup, FormControl, DropdownButton, Dropdown} from "react-bootstrap";

class ShowVisits extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            service: VisitService.getInstance(),
            visits:[],
            isLoading:true,
            sortType:"Unsorted",
            minDuration:null,
            maxDuration:null,
            startDate:null,
            endDate:null
        };
    }

    fetchAllVisits = () => {
        this.state.service.findAllVisits().then(results => {this.setState({visits:results, isLoading:false})});
    };

    sortByEntryTime = () => {
        this.setState({sortType:"SortByEntryTime", visit:this.state.visits.sort(function (a, b) {
                return new Date(a.entryTime) - new Date(b.entryTime);
            })})
    };

    updateForm = event => {
        // console.log(event.target.value);
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    applyFilter = () => {
        console.log(this.state.visits);
        console.log(this.state);
        let results = [];
        for(let i=0; i < this.state.visits.length; i++) {
            let visit = this.state.visits[i];
            if(this.state.minDuration !== null && visit.duration < this.state.minDuration) {
                continue;
            }
            if(this.state.maxDuration !== null && visit.duration > this.state.maxDuration) {
                continue;
            }
            if(this.state.startDate !== null && new Date(visit.entryTime) < new Date(this.state.startDate)) {
                continue;
            }
            if(this.state.endDate !== null && new Date(visit.leaveTime) > new Date(this.state.endDate)) {
                continue;
            }
            results.push(visit);
        }
        this.setState({visits:results});
        console.log(this.state.visits);
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
        // console.log(this.state.visits);
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
                    <div id="filter">
                        <InputGroup>
                            <DropdownButton
                                as={InputGroup.Prepend}
                                variant="outline-secondary"
                                title={this.state.sortType}
                                id="input-group-dropdown-1"
                            >
                                <Dropdown.Item onClick={this.sortByEntryTime}>SortByEntryTime</Dropdown.Item>
                            </DropdownButton>
                            <FormControl name="minDuration" onChange={this.updateForm} value={this.state.minDuration} placeholder="min duration"/>
                            <FormControl name="maxDuration" onChange={this.updateForm} value={this.state.maxDuration} placeholder="max duration"/>
                            <FormControl name="startDate" type="date" onChange={this.updateForm} value={this.state.startDate} placeholder="start date"/>
                            <FormControl name="endDate" type="date" onChange={this.updateForm} value={this.state.endDate} placeholder="end date"/>
                            <button
                                type="button"
                                className="btn btn-outline-dark"
                                onClick={() => this.applyFilter()}>
                                Apply
                            </button>
                        </InputGroup>
                    </div>
                    {this.state.visits.length > 0 && <table id="visits">
                        <tbody>
                        <tr>{this.renderHeader()}</tr>
                        {this.renderVisits()}
                        </tbody>
                    </table>}
                </div>
            )
        } else {
            return <div>Loading...</div>
        }
    }
}

export default ShowVisits;
