package com.example.dostava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dostava.model.Dostavljac;
import com.example.dostava.model.Racun;
//import com.ftninformatika.jwd.modul3.cinema.model.Zanr;

@Repository
public interface RacunRepository extends JpaRepository<Racun, Long>{

	Racun findOneById(Long id);

	

	
}
