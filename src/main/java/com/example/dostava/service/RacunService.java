package com.example.dostava.service;

import java.util.List;
import java.util.Set;

import com.example.dostava.model.Dostavljac;
import com.example.dostava.model.Racun;
//import com.ftninformatika.jwd.modul3.cinema.model.Zanr;

public interface RacunService {
		
	Racun save(Racun racun);

	List<Racun> findAll();

	void delete(Set<Racun>prijave);
	
	Racun findOne(Long id);
	
	
	List<Racun> findbyLinija(Long ids);
	
	
}
