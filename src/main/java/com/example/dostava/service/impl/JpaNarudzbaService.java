package com.example.dostava.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.example.dostava.model.Narudzba;
import com.example.dostava.repository.NarudzbaRepository;

import com.example.dostava.service.NarudzbaService;

@Service
public class JpaNarudzbaService implements NarudzbaService {

	@Autowired
	private NarudzbaRepository porRep;

	@Override
	public Narudzba findOne(Long id) {
		return porRep.findOneById(id);	}

	@Override
	public List<Narudzba> findAll() {
		return porRep.findAll();
	}

	@Override
	public Narudzba save(Narudzba narudzba) {
		return porRep.save(narudzba)
;	}

	@Override
	public Narudzba update(Narudzba narudzba) {
		return porRep.save(narudzba)
				;	}

	@Override
	public Narudzba delete(Long id) {
		Optional<Narudzba> por=  porRep.findById(id);
		
		if (por.isPresent()){
		porRep.deleteById(id);
		//porRep.delete(por.get());
			
			
			return por.get();
		}
		return null;
	}

	@Override
	public Page<Narudzba> SEARCH(String naslov,Long dID, int pageNo) {
		
	
		
		
		return porRep.findByImeIgnoreCaseContainsAndSprintId(naslov, dID, PageRequest.of(pageNo, 3));
	}
		

	@Override
	public Page<Narudzba> findAll(int pageNo) {
		return porRep.findAll(PageRequest.of(pageNo, 3));}



	
}
