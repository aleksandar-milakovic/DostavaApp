package com.example.dostava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Value;

import com.sun.istack.Nullable;

@Entity
public class Narudzba {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( nullable =   false,unique = true)
	private Integer brojNar;
	@Column( nullable =   false)
	private LocalDateTime datumKreiranja;
	
	@Column(nullable = false)
	private String mestoIsporuke;
	
	@Column
	private Integer cena;
	
	@Column 
	private String opis;
	
	
	
	
	
	
	




	
	
	
	
	@ManyToOne
	private  Dostavljac dostavljac;
	
	
	@OneToOne
	private Racun racun;

	

	public Narudzba() {
		super();
	}




	public Long getId() {
		return id;   
	}




	public void setId(Long id) {
		this.id = id;
	}

	
	

	




	
















	




	



	









	






	








	


	public Integer getBrojN() {
		return brojNar;
	}




	public void setBrojN(Integer brojN) {
		this.brojNar = brojN;
	}




	public LocalDateTime getDatumKreiranja() {
		return datumKreiranja;
	}




	public void setDatumKreiranja(LocalDateTime datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}




	public String getMestoIsporuke() {
		return mestoIsporuke;
	}




	public void setMestoIsporuke(String mestoIsporuke) {
		this.mestoIsporuke = mestoIsporuke;
	}




	public Integer getCena() {
		return cena;
	}




	public void setCena(Integer cena) {
		this.cena = cena;
	}




	public String getOpis() {
		return opis;
	}




	public void setOpis(String opis) {
		this.opis = opis;
	}




	public Dostavljac getDostavljac() {
		return dostavljac;
	}




	public void setDostavljac(Dostavljac dostavljac) {
		this.dostavljac = dostavljac;
	}




	public Racun getRacun() {
		return racun;
	}




	public void setRacun(Racun racun) {
		this.racun = racun;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Narudzba other = (Narudzba) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	

	
	



}
