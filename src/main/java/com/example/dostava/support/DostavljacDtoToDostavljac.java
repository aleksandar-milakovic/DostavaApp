package com.example.dostava.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.dostava.model.Dostavljac;
import com.example.dostava.service.DostavljacService;
import com.example.dostava.web.dto.DostavljactDto;

@Component
public class DostavljacDtoToDostavljac implements Converter<DostavljactDto, Dostavljac> {

	@Autowired
	private DostavljacService zgrada;
	
	
	@Override
	public Dostavljac convert(DostavljactDto zgradaDto) {
		Dostavljac dostavljac = null;
		
		if(zgradaDto.getId()==null) {
			dostavljac= new Dostavljac();
			
		}else {
			dostavljac = this.zgrada.findOne(zgradaDto.getId());
		}
		
		if(dostavljac!=null) {
			dostavljac.setBrojLK(zgradaDto.getBrojLk());
			dostavljac.setImePrezime(zgradaDto.getImePrezime());
			dostavljac.setJmbg(zgradaDto.getJmbg());
			
			
			dostavljac.setId(zgradaDto.getId());
		
		}
		
		return dostavljac;
	}


}
