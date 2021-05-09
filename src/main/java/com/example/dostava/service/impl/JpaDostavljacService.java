package com.example.dostava.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dostava.model.Dostavljac;
import com.example.dostava.repository.DostavljacRepository;
//le.dostava.service.DostavljacService;
import com.example.dostava.service.DostavljacService;


@Service
public class JpaDostavljacService  implements DostavljacService {

	
	@Autowired
	private DostavljacRepository dostavaljacRepository;

	@Override
	public List<Dostavljac> findAll() {
		return dostavaljacRepository.findAll();
	}

	@Override
	public Dostavljac findOne(Long id) {
		// TODO Auto-generated method stub
		return dostavaljacRepository.findOneById(id);
	}

	@Override
	public Dostavljac save(Dostavljac dostavljac) {
	return dostavaljacRepository.save(dostavljac);
	}

	
}
