package com.example.dostava.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dostava.model.Narudzba;
import com.example.dostava.model.Dostavljac;
import com.example.dostava.model.Racun;
//import com.example.dostava.service.DostavljacService;
import com.example.dostava.service.DostavljacService;
import com.example.dostava.service.NarudzbaService;
import com.example.dostava.service.RacunService;

import com.example.dostava.support.NarudzbaDtoToNarudzba;
import com.example.dostava.support.NarudzbaToNarudzbaDto;
import com.example.dostava.web.dto.RacunDto;
import com.example.dostava.web.dto.NarudzbaDto;


@RestController
@RequestMapping(value = "/api/narudzbe", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class NarudzbaController {

	@Autowired
	private NarudzbaService porService;

	@Autowired
	private RacunService racService;
	@Autowired
	private DostavljacService dosService;

	@Autowired
	private NarudzbaDtoToNarudzba toTakmicenje;

	@Autowired
	private NarudzbaToNarudzbaDto toTakmicenjeDto;
	
//	@Autowired
//	private RacunDtoToRacun toGlas;
//
//	@Autowired
//	private RacunToRacunDto toGlasDto;

	
	@GetMapping
	  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	public ResponseEntity<List<NarudzbaDto>> getAll(
	        @RequestParam(required=false) String mestoIsporuke,
	        
	        @RequestParam(required=false) Long dostavljacId,
	        @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
	        @RequestParam(value = "totalPages", defaultValue = "0") int totalPages)
	      {

			
	Page<Narudzba> page=null;
//			if(zgradaId>=0) {
//			if(naslov!="") {
//				
//				page = porService.SEARCH3(naslov, pageNo);
//			}
//			
//			else {
			page = porService.SEARCH(mestoIsporuke,  dostavljacId, pageNo);
			//}//}
//		if(formatId>=0) {
//			page = zadatakService.find(ime, sprintId, pageNo);		   
//else {
//			page = porService.findAll(pageNo);
//		}
	   
	    
	   HttpHeaders headers = new HttpHeaders();
	   headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
	   System.out.println(page.getTotalPages());
	   totalPages= page.getTotalPages();

	    return new ResponseEntity<>(toTakmicenjeDto.convert(page.getContent()),headers, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	  @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Long id){
	  
		
	     
		Narudzba narudzba = porService.findOne(id);
	  
//	    int s= narudzba.getBodovi();
//	    Dostavljac dostavljac = dosService.findOne(narudzba.getSprint().getId());
//	    List<Narudzba>zadaci=dostavljac.getZadaci();
//	   Integer rez=0;
//	    for (Narudzba zadatak2 : zadaci) {
//			if(zadatak2.getId()==id) {
//			 System.out.println("ovo je to"+zadatak2.getBodovi());  
//			rez = Integer.parseInt(dostavljac.getUkupnoBodova())-zadatak2.getBodovi();
//			}
//			dostavljac.setUkupnoBodova(rez.toString());
//			System.out.println(rez);
//		}
//	    dostavljac.setUkupnoBodova(rez+"");
//		
//	    dosService.save(dostavljac);
//		
		
	  Narudzba obrisanZadatak = porService.delete(id);
	 // Narudzba sacuvaniZadatak = porService.save(obrisanZadatak);
	    if(obrisanZadatak != null) { 
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@GetMapping("/{id}")
	  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	public ResponseEntity<NarudzbaDto> getOne(@PathVariable Long id){
	    Narudzba por = porService.findOne(id);

	    if(por != null) {
	        return new ResponseEntity<>(toTakmicenjeDto.convert(por), HttpStatus.OK);
	    }else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	  @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<NarudzbaDto> create(@Valid @RequestBody NarudzbaDto zadatakDTO){
		
//		System.out.println("bodovi su"+zadatakDTO.getBodovi());
////	    if(!id.equals(zadatakDTO.getId())) {
////	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////    }
//	    Integer s= 0;
//	    Dostavljac dostavljac = dosService.findOne(zadatakDTO.getSprintId());
//	    System.out.println("Ukupni bodovi su"+dostavljac.getUkupnoBodova());
//	    s= zadatakDTO.getBodovi() + Integer.parseInt(dostavljac.getUkupnoBodova());
//	    
//	    dostavljac.setUkupnoBodova(s.toString());
	    
	    
	  //  dosService.save(dostavljac);

		
		
		
		
		Narudzba por = toTakmicenje.convert(zadatakDTO);
	    Narudzba sacuvanaPor = porService.save(por);

	    return new ResponseEntity<>(toTakmicenjeDto.convert(sacuvanaPor), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	 @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	public ResponseEntity<NarudzbaDto> update(@PathVariable Long id, @Valid @RequestBody NarudzbaDto zadatakDTO){

		//System.out.println(zadatakDTO.getBodovi());
	    if(!id.equals(zadatakDTO.getId())) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
//	    int s= zadatakDTO.getBodovi();
//	    Dostavljac dostavljac = dosService.findOne(zadatakDTO.getSprintId());
//	    List<Narudzba>zadaci=dostavljac.getZadaci();
//	   int rez=0;
//	    for (Narudzba zadatak2 : zadaci) {
//			if(zadatak2.getId()==id) {
//			 System.out.println(zadatak2.getBodovi());  
//			rez = Integer.parseInt(dostavljac.getUkupnoBodova())-zadatak2.getBodovi();
//			}
//		}
//	    System.out.println("rez je"+rez);
	    Narudzba narudzba = toTakmicenje.convert(zadatakDTO);
//	    Integer broj = 0;
//	    broj += Integer.parseInt(narudzba.getSprint().getUkupnoBodova());
//	   
//	   
//	    broj= rez+s;
//	    dostavljac.setUkupnoBodova(broj.toString());
	 //   dosService.save(dostavljac);
//	    narudzba.setSprint(dostavljac);
	    Narudzba sacuvanFilm = porService.update(narudzba);

	    return new ResponseEntity<>(toTakmicenjeDto.convert(sacuvanFilm),HttpStatus.OK);
	}
	@PutMapping(value = "/stanje/{id}")
	public ResponseEntity<NarudzbaDto> updateState(@PathVariable Long id ){
		  
		
		Narudzba narudzba = porService.findOne(id);
//		System.out.println(narudzba.getZaduzeni());
//		Racun racun=null;
//		if(narudzba.getId()==id) {			
//		 racun = narudzba.getStanje();}
//		List<Narudzba>ZADACI=racun.getZadaci();
//		for (Narudzba zadatak2 : ZADACI) {
//			if(zadatak2.getId()==narudzba.getId()) {
//				System.out.println("da da");
//				if(zadatak2.getStanje().getIme().contains("U TOKU")) {
//				System.out.println("da da");
//					Racun	stanje7=zadatak2.getStanje();
//					System.out.println(stanje7.getIme());
//					
//					zadatak2.setStanje(racService.findOne(3L));
//				}else if (zadatak2.getStanje().getIme().contains(("NOV"))) {
//					zadatak2.setStanje(racService.findOne(2L));
//				}
//			}
//		}
		
	  //  broj += Integer.parseInt(zadatak.getSprint().getUkupnoBodova());
	   
	   
	   
	   
	    Narudzba sacuvanFilm = porService.update(narudzba);

	    return new ResponseEntity<>(toTakmicenjeDto.convert(sacuvanFilm),HttpStatus.OK);
	}
	}
