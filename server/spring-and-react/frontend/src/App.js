import React from 'react';
import logo from './logo.svg';

import Item from './components/Item';


import './App.css';
import Container from "@material-ui/core/Container/Container";
import AppBar from "@material-ui/core/AppBar/AppBar";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";
import IconButton from "@material-ui/core/IconButton/IconButton";
import Typography from "@material-ui/core/Typography/Typography";

class App extends React.Component {


    constructor(props){
        super(props);
        this.state ={items:[]};

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
        return(
        <Container maxWidth={"md"}r>
            <AppBar position="static" style={{marginBottom:"20px" }} >
                <Toolbar>
                    <IconButton edge="start" color="inherit" aria-label="menu">
                    </IconButton>
                    <Typography variant="h6" >
                        Cart
                    </Typography>
                </Toolbar>
            </AppBar>



            <Container component="main">

            {this.state.items.map(item => {

                return (<Item m={10} title={item.title} description={item.description} price={item.price}/>);
            })}
        </Container>
        </Container>








    )
}
//     state = {};
//
//     componentDidMount() {
//         setInterval(this.hello, 250);
//     }
//
//     hello = () => {
//         fetch('/api/hello')
//             .then(response => response.text())
//             .then(message => {
//                 this.setState({message: message});
//             });
//     };
//
//     render() {
//         return (
//             <div className="App">
//                 <header className="App-header">
//                     <img src={logo} className="App-logo" alt="logo"/>
//                     <h1 className="App-title">{this.state.message}</h1>
//                 </header>
//                 <p className="App-intro">
//                     To get started, edit <code>src/App.js</code> and save to reload.
//                 </p>
//             </div>
//         );
//     }



}

export default App;
