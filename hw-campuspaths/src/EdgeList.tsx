/*
 * Copyright (C) 2022 Hal Perkins.  All rights reserved.  Permission is
 * hereby granted to students registered for University of Washington
 * CSE 331 for use solely during Winter Quarter 2022 for purposes of
 * the course.  No other use, copying, distribution, or modification
 * is permitted without prior written consent. Copyrights for
 * third-party components of this work must be honored.  Instructors
 * interested in reusing these course materials should contact the
 * author.
 */

import React, {Component} from 'react';

interface EdgeListProps {
    onChange(edges: Point[]): void;
}

interface EdgeListState {
    startBuilding: string;
    endBuilding: string;
    buildings: string[];
}

export interface Point {
    x: number;
    y: number;
}

/**
 * A text field that allows the user to enter the list of edges.
 * Also contains the buttons that the user will use to interact with the app.
 */
class EdgeList extends Component<EdgeListProps, EdgeListState> {
    constructor(props: EdgeListProps) {
        super(props);
        this.state = {
            startBuilding: "",
            endBuilding: "",
            buildings: []
        }
    }

    //loads building names for program to run
    componentDidMount() {
        this.getBuildingNames();
    }

    //callbacks to change the starting building
    startChange(evt: any) {
        this.setState({
            startBuilding: evt.target.value
        })
    }

    //callbacks to change the ending building
    endChange(evt: any) {
        this.setState({
            endBuilding: evt.target.value
        })
    }

    //Requests from spark server information about the path from one building to
    //another
    findPath = async (start: string, end: string) => {
        try {
            let response = await fetch("http://localhost:4567/findPath?start="+ start + "&end=" + end);
            if (!response.ok) {
                alert("The status is wrong! Expected: 200, Was: " + response.status);
                return; // Don't keep trying to execute if the response is bad.
            }
            let data = await response.json();
            let path: Point[] = [];

            //Pushes the start and end points of each segment in path to an array of points
            for (let i = 0; i < data['path'].length; i++) {
                path.push(data['path'][i]['end']);
            }
            this.props.onChange(path);
        } catch (e) {
            alert("There was an error contacting the server.");
            console.log(e);
        }
    };

    //Requests from spark server information about all the building names
    getBuildingNames = async () => {
        try {
            let response = await fetch("http://localhost:4567/buildingNames");
            if (!response.ok) {
                alert("The status is wrong! Expected: 200, Was: " + response.status);
                return; // Don't keep trying to execute if the response is bad.
            }
            let data = await response.json();
            let keys = Object.keys(data);
            let buildingNames:string[] = [];

            //Iterates through map and key values and prints out short and long names of buildings
            for (let i = 0; i < keys.length; i++) {
                buildingNames.push("" + keys[i] + ", " + data[keys[i]]);
            }
            this.setState({
                buildings: buildingNames
            });
        } catch (e) {
            alert("There was an error contacting the server.");
            console.log(e);
        }
    };

    render() {
        return (
            <div id="edge-list">
                Find a Path <br/>
                <div>
                    <select onChange={(evt) => this.startChange(evt)} value = {this.state.startBuilding}>
                        <option value={""}>Select a starting building!</option>
                        {this.state.buildings.map(building => {
                        return (<option key={building} value={building}>{building}</option>);
                    })}
                    </select>
                </div>
                <br/>
                <div>
                    <select onChange={(evt) => this.endChange(evt)} value = {this.state.endBuilding}>
                        <option value={""}>Select an ending building!</option>
                        {this.state.buildings.map(building => {
                            return (<option key={building} value={building}>{building}</option>);
                        })}
                    </select>
                <br/>
                </div>
                <button onClick={() => {
                    if (this.state.startBuilding == this.state.endBuilding || this.state.endBuilding == "" || this.state.
                    startBuilding == "") {
                       alert("Please select two different buildings that are within the UW campus.")
                    }
                    else {
                        this.findPath(this.state.startBuilding.slice(0, this.state.startBuilding.indexOf(", ")),
                        this.state.endBuilding.slice(0, this.state.endBuilding.indexOf(", ")))}}}>Draw
                </button>
                <button onClick={() => {
                    this.setState({
                        startBuilding: "",
                        endBuilding: ""
                    })
                    this.props.onChange([])}}>Clear
                </button>
            </div>
        );
    }
}

export default EdgeList;
