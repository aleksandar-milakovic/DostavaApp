package com.example.dostava.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import com.example.dostava.model.Dostavljac;
import com.example.dostava.model.Racun;
import com.example.dostava.service.NarudzbaService;
import com.example.dostava.service.RacunService;

import org.springframework.stereotype.Component;

//import com.example.dostava.web.dto.DostavljacDto;
import com.example.dostava.web.dto.RacunDto;

@Component
public class RacunDtoToRacun implements Converter<RacunDto, Racun> {

	@Autowired
	private RacunService racSer;
	
	@Autowired
	private NarudzbaService porSer;
	
	@Override
	public Racun convert(RacunDto racunDto) {
		Racun racun = null;
		
		if(racunDto.getId()==null) {
			System.out.println(racunDto.getId());
			racun= new Racun();
			
		}else {
			racun = racSer.findOne(racunDto.getId());
		}
		
		if(racun!=null) {
			//racun.setId(racunDto.getId());
			racun.setBrojRacuna(racunDto.getBrojRacuna());
			racun.setDatumKreiranja(getLocalDateTime(racunDto.getDatumKreiranja()));
			if(porSer.findOne(racunDto.getNarudzbaId())==null) {
				racun.setNarudzba(null);
			}
			
			else {
			racun.setNarudzba(porSer.findOne(racunDto.getNarudzbaId()));
			}
			racun.setUkupnaCena(racunDto.getUkupnaCena());
			
		}
	//	System.out.println(rezervacija.getLinija().getId());
		
		return racun;
	}
	private LocalDateTime getLocalDateTime(String dateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }

}
