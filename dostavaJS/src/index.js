import React from "react";
import ReactDOM from "react-dom";
import { Route, Link, HashRouter as Router, Switch, Redirect } from "react-router-dom";
import { Navbar, Nav, Container, Button } from "react-bootstrap";
import Home from "./components/Home";


import Login from './components/authorization/Login';
import NotFound from "./components/NotFound";
import {logout} from './services/auth';



import Dostava from "./components/dostava/Dostava";
import Racun from "./components/dostava/Racun";

class App extends React.Component {
  constructor(){
    super()
    this.state = {
    
    }
  }

 

  render() {
    
    const jwt = window.localStorage['jwt'];

    if(jwt){
      return (
        <div>
          <Router>
            <Navbar expand bg="dark" variant="dark">
              <Navbar.Brand as={Link} to="/">
                  JWD
              </Navbar.Brand>
              <Nav>
               
                <Nav.Link as={Link} to="/dostava">
                  Dostava
                </Nav.Link>
                
               
                <Button onClick={()=>logout()}>Logout</Button>
              </Nav>
            </Navbar>
            <Container style={{paddingTop:"25px"}}>
              <Switch>
                <Route exact path="/" component={Home} />
                <Route exact path="/login" render={()=><Redirect to="/" />} />
               
                <Route exact path="/dostava" component={Dostava} />
                <Route exact path="/porudzbine/:id" component={Racun} />
             
                <Route component={NotFound} />
              </Switch>
            </Container>
          </Router>
        </div>
      );
    }else{
      return (
        <Container>
          <Router>
            <Switch>
              <Route exact path="/login" component={Login} />
              <Route render={()=><Redirect to="/login" />} />
            </Switch>
          </Router>
        </Container>
      );
    }

    
  }
}

ReactDOM.render(<App />, document.querySelector("#root"));
