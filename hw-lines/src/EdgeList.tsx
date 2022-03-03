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
                    onChange={(evt) => this.textAreaOnChange(evt)}
                    value={this.state.textAreaValue}
                /> <br/>
                <button onClick={() => {
                    let listOfEdges = [];
                    let allEdges = this.state.textAreaValue.split("\n");
                    for (let i = 0; i < allEdges.length; i++) {
                        let values = allEdges[i].split(" ")
                        let edge: Edge = {
                            x1: parseInt(values[0]),
                            y1: parseInt(values[1]),
                            x2: parseInt(values[2]),
                            y2: parseInt(values[3]),
                            color: values[4],
                        }
                        listOfEdges.push(edge);
                    }
                    this.props.onChange(listOfEdges);}}>Draw</button>
                <button onClick={() => {this.setState({textAreaValue: ""})}}>Clear</button>
            </div>
        );
    }
}

export default EdgeList;
