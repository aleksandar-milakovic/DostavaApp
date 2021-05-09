package com.example.dostava.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dostava.model.Narudzba;
//import com.ftninformatika.jwd.modul3.cinema.model.Film;



public interface NarudzbaService {
	
	Narudzba findOne(Long id);

    List<Narudzba> findAll();

   // List<Narudzba> findByTakmicenjeId(Long takmicenjaId);


    Narudzba save(Narudzba narudzba);

    Narudzba update(Narudzba narudzba);

    Narudzba delete(Long id);
    
    Page<Narudzba> SEARCH(String naslov,Long dID, int pageNo);
    
//    Page<Narudzba> SEARCH2(String naslov, String tip, int pageNo);
//    
//    Page<Narudzba> SEARCH3(String naslov,  int pageNo);
//    
//    Page<Narudzba> SEARCH4(String s , int pageNO);

    Page<Narudzba> findAll(int pageNo);
    
    

}
