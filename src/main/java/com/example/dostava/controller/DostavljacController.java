package com.example.dostava.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.dostava.model.Dostavljac;
//import com.example.dostava.service.DostavljacService;
import com.example.dostava.service.DostavljacService;
//import com.example.dostava.support.DostavaljacDtoToDostavljac;
import com.example.dostava.support.DostavljacDtoToDostavljac;
import com.example.dostava.support.DostavljacToDostavljacDto;
import com.example.dostava.web.dto.NarudzbaDto;
//import com.example.dostava.web.dto.DostavljacDto;
import com.example.dostava.web.dto.DostavljactDto;




@RestController
@RequestMapping(value = "/api/dostavljaci", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class DostavljacController {

	@Autowired
	private DostavljacService fService;
	
	@Autowired
	private DostavljacDtoToDostavljac toFormat;
	
	@Autowired
	private DostavljacToDostavljacDto toFormatDto;

	
	 @GetMapping
	 // @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")  
	 public ResponseEntity<List<DostavljactDto>> getAll(){

	        List<Dostavljac> dostavljac = fService.findAll();

	        return new ResponseEntity<>(toFormatDto.convert(dostavljac), HttpStatus.OK);
	    }

	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	  @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<DostavljactDto> create(@Valid @RequestBody DostavljactDto zadatakDTO){
		
	//	System.out.println("bodovi su"+zadatakDTO.getBodovi());
//	    if(!id.equals(zadatakDTO.getId())) {
//	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////	    }
//	    Integer s= 0;
//	    Dostavljac sprint = sprintService.findOne(zadatakDTO.getSprintId());
//	    System.out.println("Ukupni bodovi su"+sprint.getUkupnoBodova());
//	    s= zadatakDTO.getBodovi() + Integer.parseInt(sprint.getUkupnoBodova());
//	    
//	    sprint.setUkupnoBodova(s.toString());
//	  

		
		
		
		
		Dostavljac por = toFormat.convert(zadatakDTO);
	    Dostavljac sacuvanaPor = fService.save(por);

	    return new ResponseEntity<>(toFormatDto.convert(sacuvanaPor), HttpStatus.CREATED);
	}
}
