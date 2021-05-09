package com.example.dostava.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.dostava.model.Dostavljac;
import com.example.dostava.model.Racun;
import com.example.dostava.model.Narudzba;
//import com.example.dostava.service.DostavljacService;
import com.example.dostava.service.DostavljacService;
import com.example.dostava.service.RacunService;
import com.example.dostava.service.NarudzbaService;
//import com.example.dostava.service.RacunService;
import com.example.dostava.web.dto.NarudzbaDto;
@Component
public class NarudzbaDtoToNarudzba implements Converter<NarudzbaDto, Narudzba> {
	
	@Autowired
	private NarudzbaService porSer;
	@Autowired
	private DostavljacService forSer;;
	@Autowired
	private RacunService racSer;
	
	@Override
	public Narudzba convert(NarudzbaDto dto) {
			Narudzba narudzba;
		
		if(dto.getId()==null) {
			narudzba= new Narudzba();
			
		}else {
			narudzba = porSer.findOne(dto.getId());
		} 
		if(narudzba!=null) {
			narudzba.setBrojN(dto.getBrojNarudzbe());
			narudzba.setCena(dto.getCena());
			narudzba.setDatumKreiranja(getLocalDate(dto.getDatumKreiranja()));
			narudzba.setDostavljac(forSer.findOne(dto.getDostavljacId()));
			narudzba.setMestoIsporuke(dto.getMestoIsporuke());
			narudzba.setOpis(dto.getOpis());
			if(racSer.findOne(dto.getRacunId())==null) {
				narudzba.setRacun(null);
			}else {
				narudzba.setRacun(racSer.findOne(dto.getRacunId()));
			}
			
			
			
	
		
		}
		return narudzba;
	}

	private LocalDateTime getLocalDate(String dateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }
}
