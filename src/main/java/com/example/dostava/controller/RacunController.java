package com.example.dostava.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dostava.model.Narudzba;
import com.example.dostava.model.Racun;
//import com.example.dostava.service.DostavljacService;
import com.example.dostava.service.RacunService;
import com.example.dostava.service.NarudzbaService;
//import com.example.dostava.support.DostavaljacDtoToDostavljac;
import com.example.dostava.support.DostavljacToDostavljacDto;
import com.example.dostava.support.RacunDtoToRacun;
import com.example.dostava.support.RacunToRacunDto;
import com.example.dostava.web.dto.NarudzbaDto;
import com.example.dostava.web.dto.RacunDto;

@RestController
@RequestMapping(value = "/api/racuni", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class RacunController {

	@Autowired
	private RacunService rService;
	
	@Autowired
	private NarudzbaService pService;
	
	@Autowired
	private RacunDtoToRacun toPrijava;
	
	@Autowired
	private RacunToRacunDto toPrijavaDto;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	public ResponseEntity<RacunDto> create(@Valid @RequestBody RacunDto prijavaDto){
			
       System.out.println(prijavaDto.getBrojRacuna());
       System.out.println(prijavaDto.getId());
       System.out.println(prijavaDto.getDatumKreiranja());
       System.out.println(prijavaDto.getNarudzbaId());
       System.out.println(prijavaDto.getUkupnaCena());
		prijavaDto.setId(prijavaDto.getNarudzbaId());
       Racun racun = new Racun();
//       racun.setId(prijavaDto.getId());
//       racun.setBrojRacuna(prijavaDto.getBrojRacuna());
//       racun.setUkupnaCena(prijavaDto.getUkupnaCena());
//       racun.setDatumKreiranja(getLocalDateTime(prijavaDto.getDatumKreiranja()));
		Narudzba zadatak = pService.findOne(prijavaDto.getNarudzbaId());
     
		prijavaDto.setId(null);
		racun = toPrijava.convert(prijavaDto);
		// System.out.println(zadatak.getMestoIsporuke());
       zadatak.setRacun(racun);
       
       //pService.update(zadatak);
       
       
//       List<Racun> rezervacije= zadatak.getRerzervacije();
//       
//       rezervacije.add(toPrijava.convert(prijavaDto));
//       
//       zadatak.setBrojMesta(zadatak.getBrojMesta()-1);
		
		//pService.update(zadatak);
       System.out.println("DSADasdsads"+prijavaDto.getId());
			Racun por = toPrijava.convert(prijavaDto);
			System.out.println(por);
	    Racun sacuvanaPor = rService.save(racun);
	    pService.update(zadatak);

	    return new ResponseEntity<>(toPrijavaDto.convert(racun), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	public ResponseEntity<RacunDto> getOne(@PathVariable Long id){
	    Racun por = rService.findOne(id);

	    if(por != null) {
	        return new ResponseEntity<>(toPrijavaDto.convert(por), HttpStatus.OK);
	    }else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@GetMapping
    public ResponseEntity<List<RacunDto>> getAll(){

        List<Racun> racun = rService.findAll();

        return new ResponseEntity<>(toPrijavaDto.convert(racun), HttpStatus.OK);
    }
	private LocalDateTime getLocalDateTime(String dateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }

}
