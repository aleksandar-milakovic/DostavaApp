package com.example.dostava.repository;
//package com.example.dostava.repository;

import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dostava.model.Narudzba;
//import com.ftninformatika.jwd.modul3.cinema.model.Film;

@Repository
public interface NarudzbaRepository extends JpaRepository<Narudzba, Long> {

	Narudzba findOneById(Long id);
	
	Page<Narudzba> findAll(Pageable pageable);
//	
//	Page<Narudzba> findByNaslovIgnoreCaseContainsAndTipIgnoreCaseContainsAndZgradaId(String naslov, String tip,Long id,Pageable pageable);
//	
//	Page<Narudzba> findByNaslovIgnoreCaseContains(String naslov,Pageable pageable);
//	
//	Page<Narudzba> findByTip(String tip,Pageable pageable);
//Page<Narudzba> findByNaslovIgnoreCaseContainsAndTipIgnoreCaseContains(String naslov,String tip,Pageable pageable);

	 

@Query("SELECT p FROM Narudzba p WHERE" +
       
        " (:mestoIsporuke = NULL OR  p.mestoIsporuke  LIKE  :mestoIsporuke) AND " +
      
        "(:dostavljacId = NULL OR p.dostavljac.id = :dostavljacId)")
	Page<Narudzba> findByImeIgnoreCaseContainsAndSprintId(@Param("mestoIsporuke")String destinacija,@Param("dostavljacId") Long sprintId, Pageable pageable);
	//List<Narudzba> findByZgradaId(Long prijavaId);

}
