package com.example.dostava.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dostava.model.Racun;
//import com.example.dostava.repository.GlasRepository;
import com.example.dostava.repository.RacunRepository;
import com.example.dostava.service.RacunService;

@Repository
public class JpaRacunService  implements RacunService{

	
	@Autowired
	private RacunRepository racRep;

	@Override
	public List<Racun> findAll() {
		return racRep.findAll();
	}

	@Override
	public Racun findOne(Long id) {
		return racRep.findOneById(id);
	}

	@Override
	public Racun save(Racun racun) {
		return racRep.save(racun);
		
	}

	

	@Override
	public void delete(Set<Racun> prijave) {
	 racRep.deleteAll(prijave);
		
	}

	@Override
	public List<Racun> findbyLinija(Long ids) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
	
}
