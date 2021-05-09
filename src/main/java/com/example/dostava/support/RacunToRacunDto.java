package com.example.dostava.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.dostava.model.Narudzba;
import com.example.dostava.model.Racun;
import com.example.dostava.service.NarudzbaService;
import com.example.dostava.web.dto.NarudzbaDto;
import com.example.dostava.web.dto.RacunDto;
@Component
public class RacunToRacunDto implements Converter<Racun, RacunDto> {

	
	@Autowired
	private NarudzbaService narSer;

	@Override
	public RacunDto convert(Racun racun) {
		RacunDto dto = new RacunDto();
		//dto.setLinijabrojMesta(rezervacija.getPoruka().getBrojMesta());
		dto.setId(racun.getId());
		dto.setBrojRacuna(racun.getBrojRacuna());
		dto.setDatumKreiranja(racun.getDatumKreiranja().toString());
		dto.setUkupnaCena(racun.getUkupnaCena());
		if(racun.getNarudzba()==null) {
			dto.setNarudzbaId(0L);
		}else {
		dto.setNarudzbaId(racun.getNarudzba().getId());
		}
		
		return dto;
	}
	public List<RacunDto> convert(List<Racun> racuni){
		List<RacunDto> por = new ArrayList<>();
		
		for (Racun racun : racuni) {
			por.add(convert(racun));
		}
		return por;
	
	}


}
