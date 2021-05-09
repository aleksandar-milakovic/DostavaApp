import React from "react";
import CinemaAxios from "../../apis/CinemaAxios";
import {Button, ButtonGroup, Table, Form, Col, Row} from 'react-bootstrap';

class Dostava extends React.Component {
  constructor(props) {
    super(props);
    let narudzba = {
      brojNarudzbe: "",
      datumKreiranja: "",
      mestoIsporuke: "",
      cena: "",
      opis:"",
      dostavljacId:"",
  }
  let racun = {
    id:null,
    brojRacuna: "",
    datumKreiranja: "",
   
    ukupnaCena: "",
   
    narudzbaId:"",
}
    let rezervacija={

      linijaId:0,
    }

    let search = {
      mestoIsporuke: "",
      dostavljacId: "",
      
    }
    this.state = { 
      narudzbe: [],
      dostavljaci: [],
      stanja:[],
      pageNo: 0,
      totalPages: 0,
      narudzba:narudzba,
       search: search,
       racun:racun
    }
  }

  componentDidMount() {
    this.getDostava(0);
    this.getDostavljaci();
    
  }
  deleteFromState(movieId) {
    var movies = this.state.narudzbe;
    movies.forEach((element, index) => {
        if (element.id === movieId) {
            movies.splice(index, 1);
            this.setState({zadaci: movies});
        }
    });
}
async create(e){
  e.preventDefault();

  try{

      let narudzba = this.state.narudzba;
      let zadatakDTO = {
          brojNarudzbe:narudzba.brojNarudzbe,
          datumKreiranja:narudzba.datumKreiranja,
          mestoIsporuke:narudzba.mestoIsporuke,
          cena:narudzba.cena,
          opis:narudzba.opis,
          dostavljacId:narudzba.dostavljacId
      }

      let response = await CinemaAxios.post("/narudzbe", zadatakDTO);
              //console.log(linijaDTO)
      window.location.reload()
      alert("Uspesno dodavanje narudzbe")
  }catch(error){
      alert("Couldn't save the narudzba");
  }
}
async createRacun(e,brR,cena,id){
  e.preventDefault();
  var vreme= new Date()
  vreme = vreme.getFullYear()+"-"+((vreme.getMonth()+1)<9 ? "0"+(vreme.getMonth()+1):(vreme.getMonth()+1))+"-"+
  ((vreme.getDate()+1)<9 ? "0"+(vreme.getDate()+1):(vreme.getDate()+1))+"T"+vreme.getHours()+":"+vreme.getMinutes()
  try{

      let narudzba = this.state.racun;
      let racunDTO = {
          
          brojRacuna:brR,
          datumKreiranja:vreme,
         
          ukupnaCena:cena,
        
          narudzbaId:id
      }

      let response = await CinemaAxios.post("/racuni", racunDTO);
              //console.log(linijaDTO)
      window.location.reload()
      alert("Uspesno kreiranje racuna")
  }catch(error){
      alert("Racun nije kreiran");
  }
}


valueInputChanged(e) {
  let input = e.target;

  let name = input.name;
  let value = input.value;
console.log(value)
  let poruka = this.state.narudzba;
  poruka[name] = value;

  this.setState({ narudzba: poruka });
}

  delete(takmicenjeId) {
    CinemaAxios.delete('/narudzbe/' + takmicenjeId)
    .then(res => {
        // handle success
        console.log(res);
        alert('Narudzba je izbrisana!');
        this.deleteFromState(takmicenjeId); // ili refresh page-a window.location.reload();
    })
    .catch(error => {
        // handle error
        console.log(error);
        alert('Error occured please try again!');
     });
}

  //TODO prokomentarisati sto sam promenio da se radi sa pageNo, a ne changeDir!!
  async getDostava(pageNo) {
    let config = { 
      params: {
        pageNo: pageNo
      }
    };

   // za pretragu
    if(this.state.search.mestoIsporuke != ""){
      config.params.mestoIsporuke=this.state.search.mestoIsporuke
        }
    if(this.state.search.dostavljacId != ""){
      config.params.dostavljacId=this.state.search.dostavljacId
    }
    // if(this.state.search.prevoznikId != -1){
    //   config.params.prevoznikId=this.state.search.prevoznikId
    // }

    try {

      let result = await CinemaAxios.get("/narudzbe", config);
      if (result && result.status === 200){
        this.setState({
          narudzbe: result.data,
          pageNo: pageNo,
          totalPages: result.headers["total-pages"]
          });
          console.log(result.data)
      }
    } catch (error) {
      console.log(error);
    }
  }
  GOtoRacun(id) {
    this.props.history.push("/porudzbine/"+id);}

  async getDostavljaci(){
    try {
      let result = await CinemaAxios.get("/dostavljaci");
      if (result && result.status === 200){
        this.setState({
          dostavljaci: result.data
          });
          console.log(result.data)
      }
    } catch (error) {
      console.log(error);
    }
  }
 
 

  searchValueInputChange(event) {
    let name = event.target.name;
    let value = event.target.value;
    console.log(value)
    //Ovo ne radi za objekta sa objektima u sebi (shallow copy)
    let search = this.state.search
    search[name] = value;

    this.setState({ search: search });
    this.getDostava(0);
  }

 

  render() {
    return (
      <div>
       
      
        <Form style={{marginTop:35}}>
          <Row>
          <Col  xs="12" sm="10" md="8">
            <Form.Group>
            <Form.Label>Broj narudzbe</Form.Label>
            <Form.Control
             
              name="brojNarudzbe"
              as="input"
              type="number"
              onChange={(e) => this.valueInputChanged(e)}
            ></Form.Control>
          </Form.Group>
          
         
            <Form.Group>
            <Form.Label>Datum kreiranja</Form.Label>
            <Form.Control
             
              name="datumKreiranja"
              as="input"
              type="datetime-local"
              

              onChange={(e) => this.valueInputChanged(e)}
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Mesto isporuke</Form.Label>
            <Form.Control
             
              name="mestoIsporuke"
              as="input"
              type="text"
              onChange={(e) => this.valueInputChanged(e)}
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Cena</Form.Label>
            <Form.Control
             
              name="cena"
              as="input"
              type="number"
              onChange={(e) => this.valueInputChanged(e)}
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Opis</Form.Label>
            <Form.Control
             
              name="opis"
              as="input"
              type="text"
              onChange={(e) => this.valueInputChanged(e)}
            ></Form.Control>
          </Form.Group>
         <Form.Group>
            <Form.Label>Dostavljac</Form.Label>
            <Form.Control
               onChange={(event) => this.valueInputChanged(event)}
               name="dostavljacId"
               
               as="select">
               <option value={-1}></option>
               {this.state.dostavljaci.map((dostavljac) => {
                 return (
                   <option value={dostavljac.id} key={dostavljac.id}>
                     {dostavljac.imePrezime}
                   </option>
                 );
               })}
            </Form.Control>
          </Form.Group>
         
         
          </Col>
          </Row>
          
         
          <Button onClick={(event)=>{this.create(event);}}>Add</Button>


            <Form style={{marginTop:35}}>
            <h3>Pretraga</h3> <br/>
          <Row>
        
          <Col md={6}>
          <Form.Group>
            <Form.Label>Mesto isporuke</Form.Label>
            <Form.Control
               onChange={(event) =>this.searchValueInputChange(event)}
               name="mestoIsporuke"
               value={this.state.search.mestoIsporuke}
               as="input"
               type="text">
              
              
            </Form.Control>
          </Form.Group>
          
        

          <Form.Group>
            <Form.Label>Dostavljac</Form.Label>
            <Form.Control
               onChange={(event) => this.searchValueInputChange(event)}
               name="dostavljacId"
               value={this.state.search.dostavljacId}
               as="select">
               <option value={""}></option>
               {this.state.dostavljaci.map((dostavljac) => {
                 return (
                   <option value={dostavljac.id} key={dostavljac.id}>
                     {dostavljac.imePrezime}
                   </option>
                 );
               })}
            </Form.Control>
          </Form.Group>
         </Col>
         
         
         
          </Row>

        </Form>
        </Form>

        <br/><br/>
        <div>
         
          <br />

          <br/>
          <br/>

          <Table id="movies-table" style={{marginTop:5}}>
            <thead>
              <tr>
                <th>Ime</th>
                <th>Zaduzeni</th>
                <th>Stanje</th>
                <th>Sprint</th>
                <th>Bodovi</th>
                <th>Akcije</th>
              </tr>
            </thead>
            <tbody>
              {this.state.narudzbe.map((narudzba) => {
                return (
                  <tr key={narudzba.id}>
                    <td>{narudzba.brojNarudzbe}</td>
                    <td>{narudzba.datumKreiranja}</td>
                    <td>{narudzba.mestoIsporuke}</td>
                    <td>{narudzba.cena}</td>
                    <td>{narudzba.opis}</td>
                    <td>{narudzba.dostavljacIme}</td>
                    <td>{narudzba.racunId}</td>

                 
                    {window.localStorage['role']=="ROLE_ADMIN"?
                  [
                  <td><Button variant="danger" onClick={() => this.delete(narudzba.id)}>Delete</Button></td>]
                  :null}
                    {window.localStorage['role']=="ROLE_ADMIN"?
                  [
                  <td><Button style={{backgroundColor:"violet"}} onClick={() => this.goToEdit(narudzba.id)}>Edit</Button></td>
                   ] :null}
                
                <td><Button  style={{visibility:narudzba.racunId>0 ? 'visible':'hidden'}} onClick={() => this.GOtoRacun(narudzba.id)} >Prikazi racun</Button></td>
                  <td><Button style={{visibility:narudzba.racunId<=0 ? 'visible':'hidden'}}  onClick={(e) => this.createRacun(e,narudzba.brojNarudzbe,narudzba.cena,narudzba.id)}>Kreiraj racun</Button></td>
                
                  </tr>
                );
              })}
            </tbody>
          </Table>

          <ButtonGroup style={{ marginTop: 25 }}>
          <Button 
            disabled={this.state.pageNo==0} onClick={()=>this.getDostava(this.state.pageNo-1)}>
            Previous
          </Button>
          <Button
            disabled={this.state.pageNo==this.state.totalPages-1} onClick={()=>this.getDostava(this.state.pageNo+1)}>
            Next
          </Button>
        </ButtonGroup>

        </div>
      </div>
    );
  }
}

export default Dostava;