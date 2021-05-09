package com.example.dostava.service;

import java.util.List;

import com.example.dostava.model.Dostavljac;





public interface DostavljacService {

	List<Dostavljac> findAll();

	Dostavljac findOne(Long id);
	
	Dostavljac save(Dostavljac dostavljac);
}
