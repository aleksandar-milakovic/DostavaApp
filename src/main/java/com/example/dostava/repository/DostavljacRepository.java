package com.example.dostava.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dostava.model.Dostavljac;
@Repository
public interface DostavljacRepository extends JpaRepository<Dostavljac, Long>{

	Dostavljac findOneById(Long id);
	
	

}
