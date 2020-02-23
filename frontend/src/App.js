import React from 'react';
import Item from './components/Item';

import './App.css';
import Container from "@material-ui/core/Container/Container";

class App extends React.Component{


    constructor(props){
        super(props);

    }
    componentDidMount(){

        this.setState({items:[{title:"Bike", description:"very big bike", price:2.3},
                {title:"Bear Glasses", description:"very good looking glasses", price:2.3},
                {title:"TeddyBears", description:"very big bike", price:2.3},
                {title:"Bike", description:"very big bike", price:2.3},
                {title:"Bike", description:"very big bike", price:2.3},
                {title:"Bike", description:"very big bike", price:2.3}

            ]});
    }


    render() {

        if(this.state) {
            return (


                <Container component="main">

                    {this.state.items.map(item => {

                        return (<Item title={item.title} description={item.description} price={item.price}/>);
                    })}
                </Container>
            );
        }

        return (<div></div>);
    }
}

export default App;
