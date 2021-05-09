package com.example.dostava.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.dostava.model.Racun;
import com.example.dostava.model.Narudzba;
import com.example.dostava.web.dto.NarudzbaDto;
//import com.ftninformatika.jwd.modul3.cinema.model.Zanr;

@Component
public class NarudzbaToNarudzbaDto implements Converter<Narudzba, NarudzbaDto>{

	@Override
	public NarudzbaDto convert(Narudzba por) {
		
		NarudzbaDto dto = new NarudzbaDto();
		dto.setId(por.getId());
		List<Long> rezervacije = new ArrayList<>();
		
//		for (Racun g :por.getRerzervacije()) {
//			
//			rezervacije.add(g.getId());
//		}
		
		dto.setBrojNarudzbe(por.getBrojN());
		dto.setCena(por.getCena());
		dto.setDatumKreiranja(por.getDatumKreiranja().toString());
		dto.setDostavljacId(por.getDostavljac().getId());
		dto.setDostavljacIme(por.getDostavljac().getImePrezime());
		
		dto.setMestoIsporuke(por.getMestoIsporuke());
		
		dto.setOpis(por.getOpis());
		if(por.getRacun()==null) {
			dto.setRacunId(0L);
		}else {
		dto.setRacunId(por.getRacun().getId());
		}
		
	        return dto;
	}
	public List<NarudzbaDto> convert(List<Narudzba> porudzbine){
		List<NarudzbaDto> porDTO = new ArrayList<>();
		
		for (Narudzba narudzba : porudzbine) {
			porDTO.add(convert(narudzba));
		}
		return porDTO;
	
	}

}
