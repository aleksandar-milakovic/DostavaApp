import React from 'react';
import { Form, Row, Col, Button} from 'react-bootstrap';
import CinemaAxios from '../../apis/CinemaAxios';

class Racun extends React.Component {

  constructor(props){
    super(props);

    let racun = {
        brojRacuna: 0,
        datumKreiranja: "",
        ukupnaCena: "",
       
    }
    var vreme= new Date()
    vreme = vreme.getFullYear()+"-"+((vreme.getMonth()+1)<9 ? "0"+(vreme.getMonth()+1):(vreme.getDate()+1))+"-"+((vreme.getDate()+1)<9 ? "0"+(vreme.getDate()+1):(vreme.getMonth()+1))
    +" "+vreme.getHours()+":"+vreme.getMinutes()
    this.state = {vreme:vreme,racun: racun, dostavljaci: []};
}



// TODO: Dobaviti filmove


componentDidMount() {
    this.getRacunById(this.props.match.params.id);
    
}


 getRacunById(porudzbaId) {
     CinemaAxios.get('/racuni/' + porudzbaId)
     .then(res => {
         // handle success
         console.log(res);
         this.setState({racun:res.data});
     })
     .catch(error => {
         // handle error
         console.log(error);
         alert('Error occured please try again!');
      });
 }







// TODO: Omogućiti odabir filma za projekciju
render(){
    return (
        <>
        <Row>
            <Col></Col>
            <Col xs="12" sm="10" md="8">
            <h1></h1>
            <Form>
                <Form.Group>
                <Form.Label htmlFor="pime">Br racuna</Form.Label>
                <Form.Control id="pime" value={this.state.racun.brojRacuna} /> <br/>
                </Form.Group>
                <Form.Group>
                <Form.Label htmlFor="pzaduzeni">Datum racuna</Form.Label>
                <Form.Control id="pzaduzeni"  value={this.state.racun.datumKreiranja} /> <br/>
                </Form.Group>
                <Form.Group>
                <Form.Label id="pbodovi">Ukupna cena</Form.Label>
                <Form.Control type="text" id="pbodovi"  value={this.state.racun.ukupnaCena}/> <br/>
                </Form.Group>
                <Form.Group>
                {/* <Form.Label htmlFor="pPrice">Price</Form.Label> */}
                {/* <Form.Control type="number" step=".01" id="pPrice" name="price" value={this.state.zadatak.sprintId} onChange={(e)=>this.valueInputChanged(e)}/> <br/> */}
                </Form.Group>
               
              
             
            </Form>
            </Col>
            <Col></Col>
        </Row>
        </>
    )
}
}

export default Racun;