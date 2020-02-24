
import React from "react";
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardContent from "@material-ui/core/CardContent";
import CardActions from "@material-ui/core/CardActions";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import RemoveIcon from "@material-ui/icons/Remove";
import RefreshIcon from '@material-ui/icons/Refresh';
import Button from "@material-ui/core/Button/Button";
import Box from '@material-ui/core/Box';

export default class Item extends React.Component {

    constructor(props) {
        super(props)

        this.state = {title:props.title, description: props.description, price: props.price};

    }


    render() {


        return (


            <Box m={5}>
                <Card>
                    <CardContent>
                        <Typography variant="h5" component="h2">
                            {this.state.title}
                        </Typography>
                        {this.state.description}
                    </CardContent>
                    <CardActions>
                        <Button size="small">Add More</Button>
                    </CardActions>
                </Card>
            </Box>
        );
    }
}
