package com.example.dostava.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.dostava.model.Dostavljac;
import com.example.dostava.model.Korisnik;
//import com.example.dostava.web.dto.DostavljacDto;
import com.example.dostava.web.dto.DostavljactDto;
import com.example.dostava.web.dto.KorisnikDTO;

@Component
public class DostavljacToDostavljacDto  implements Converter<Dostavljac, DostavljactDto>{

	@Override
    public DostavljactDto convert(Dostavljac dostavljac) {
		DostavljactDto zgradaDto= new DostavljactDto();

        zgradaDto.setId(dostavljac.getId());
        
        zgradaDto.setBrojLk(dostavljac.getBrojLK());
        zgradaDto.setImePrezime(dostavljac.getImePrezime());
        zgradaDto.setJmbg(dostavljac.getJmbg());
        
    
//        dostavljacDto.setJmbg(format.getJmbg());
       // korisnikDTO.setKorisnickoIme(korisnik.getKorisnickoIme());

        return zgradaDto;
    }

    public List<DostavljactDto> convert(List<Dostavljac> formati){
        List<DostavljactDto> formatiDtos = new ArrayList<>();

        for(Dostavljac d : formati) {
            DostavljactDto dto = convert(d);
            formatiDtos.add(dto);
        }

        return formatiDtos;
    }
}
