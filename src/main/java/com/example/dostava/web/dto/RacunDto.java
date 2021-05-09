package com.example.dostava.web.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.example.dostava.model.Narudzba;
import com.sun.istack.NotNull;

public class RacunDto {

	
	private Long id;
	
	
	private Integer brojRacuna ;
	
	private String datumKreiranja;
	
	private Integer ukupnaCena;
	
	
	
	private Long narudzbaId;
	
	
	

	
	
	


	







	public Long getNarudzbaId() {
		return narudzbaId;
	}





	public void setNarudzbaId(Long narudzbaId) {
		this.narudzbaId = narudzbaId;
	}





	public Integer getBrojRacuna() {
		return brojRacuna;
	}





	public void setBrojRacuna(Integer brojRacuna) {
		this.brojRacuna = brojRacuna;
	}





	public String getDatumKreiranja() {
		return datumKreiranja;
	}





	public void setDatumKreiranja(String datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}





	public Integer getUkupnaCena() {
		return ukupnaCena;
	}





	public void setUkupnaCena(Integer ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	





	










	public RacunDto() {
		super();
	}





	
	



	

}
