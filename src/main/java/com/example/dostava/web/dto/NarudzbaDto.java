package com.example.dostava.web.dto;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.example.dostava.model.Dostavljac;
import com.example.dostava.model.Racun;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

public class NarudzbaDto {

	
	private Long id;
	
	@Positive
	private Integer brojNarudzbe;
	
	@NotNull
	@NotEmpty
	@Size(max = 40)
	private String mestoIsporuke;
	
	private String datumKreiranja;;
	
	private Integer cena;
	
	private Long dostavljacId;
	
	private String opis;
	
	private Long racunId;
	
	private String dostavljacIme;
	
	
	
	
	
	

	

	



	public Long getId() {
		return id;
	}













	public void setId(Long id) {
		this.id = id;
	}

	


































































	public Integer getBrojNarudzbe() {
		return brojNarudzbe;
	}













	public void setBrojNarudzbe(Integer brojNarudzbe) {
		this.brojNarudzbe = brojNarudzbe;
	}













	public String getMestoIsporuke() {
		return mestoIsporuke;
	}













	public void setMestoIsporuke(String mestoIsporuke) {
		this.mestoIsporuke = mestoIsporuke;
	}













	public String getDatumKreiranja() {
		return datumKreiranja;
	}













	public void setDatumKreiranja(String datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}













	public Integer getCena() {
		return cena;
	}













	public void setCena(Integer cena) {
		this.cena = cena;
	}













	public Long getDostavljacId() {
		return dostavljacId;
	}













	public void setDostavljacId(Long dostavljacId) {
		this.dostavljacId = dostavljacId;
	}













	public String getOpis() {
		return opis;
	}













	public void setOpis(String opis) {
		this.opis = opis;
	}













	public Long getRacunId() {
		return racunId;
	}













	public void setRacunId(Long racunId) {
		this.racunId = racunId;
	}













	public String getDostavljacIme() {
		return dostavljacIme;
	}













	public void setDostavljacIme(String dostavljacIme) {
		this.dostavljacIme = dostavljacIme;
	}













	public NarudzbaDto() {
		super();
	}
	
	
	
	
	
}
