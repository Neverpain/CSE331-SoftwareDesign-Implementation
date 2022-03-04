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
    onChange(edges: Edge[]): void;
}

interface EdgeListState {
    textAreaValue: string;
}

export interface Edge {
    x1: number;
    y1: number;
    x2: number;
    y2: number;
    color: string;
}

/**
 * A text field that allows the user to enter the list of edges.
 * Also contains the buttons that the user will use to interact with the app.
 */
class EdgeList extends Component<EdgeListProps, EdgeListState> {
    constructor(props: EdgeListProps) {
        super(props);
        this.state = {
            textAreaValue: "I'm stuck..."
        }
    }

    textAreaOnChange(evt: any) {
        this.setState({
            textAreaValue: evt.target.value
        })
    }

    render() {
        return (
            <div id="edge-list">
                Edges <br/>
                <textarea
                    rows={5}
                    cols={30}
                    value={this.state.textAreaValue}
                    onChange={(evt) => this.textAreaOnChange(evt)}
                /> <br/>
                <button onClick={() => {
                    let listOfEdges = [];

                    //Parses string into string[] where each string represents an edge
                    let allEdges = this.state.textAreaValue.split("\n");

                    //Parse edges into its data and creates an edge object
                    for (let i = 0; i < allEdges.length; i++) {
                        let values = allEdges[i].split(" ")
                        let edge: Edge = {
                            x1: parseFloat(values[0]),
                            y1: parseFloat(values[1]),
                            x2: parseFloat(values[2]),
                            y2: parseFloat(values[3]),
                            color: values[4],
                        }

                        // Checks for valid formatting of edge data/inputs
                        if (values.length != 5) {
                            alert("Edges must follow the format (x1 y1 x2 y2 color)." + "\nThe edge: " + values.toString().replaceAll
                            (",", " ") + " is not a valid input.")
                        }
                        else if (edge.x1 > 4000 || edge.x2 > 4000 || edge.y1 > 4000 || edge.y2 > 4000 ||
                            edge.x1 < 0 || edge.x2 < 0 || edge.y1 < 0 || edge.y2 < 0) {
                            alert("Edges must have coordinates greater than or equal to 0 and less than or equal to 4000." +
                            "\nThe edge: " + values.toString().replaceAll(",", " ") + " is not a valid input.")
                        }
                        else if (Number.isNaN(edge.x1) || Number.isNaN(edge.x2) || Number.isNaN(edge.y1) || Number.isNaN(edge.y2)) {
                            alert("Edges must have number coordinates." + "\nThe edge: " + values.toString().replaceAll
                            (",", " ") + " is not a valid input.")
                        }
                        else if (!Number.isNaN(parseFloat(values[4]))) {
                            alert("The color of the edge must not be a number." + "\nThe edge: " + values.toString().replaceAll
                            (",", " ") + " is not a valid input.")
                        }

                        //Pushes edge objects into a list and returns the list as a prop if inputs are fine
                        else {
                        listOfEdges.push(edge);
                        }
                    }
                    this.props.onChange(listOfEdges);}}>Draw</button>
                <button onClick={() => {this.setState({textAreaValue: ""})}}>Clear</button>
            </div>
        );
    }
}

export default EdgeList;
