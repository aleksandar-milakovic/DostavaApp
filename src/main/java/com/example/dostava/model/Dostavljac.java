package com.example.dostava.model;

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
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;



@Entity
public class Dostavljac {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String jmbg;
	
	
	@Column(nullable = false, unique = true)
	private String brojLk;
	
	
	@Column(nullable = false)
	private String imePrezime;

	

	@OneToMany(mappedBy = "dostavljac", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private List<Narudzba> narudzbe = new ArrayList<>();
	
	public Dostavljac() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

	



	
	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getBrojLK() {
		return brojLk;
	}

	public void setBrojLK(String brojLk) {
		this.brojLk = brojLk;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public List<Narudzba> getNarudzbe() {
		return narudzbe;
	}

	public void setNarudzbe(List<Narudzba> narudzbe) {
		this.narudzbe = narudzbe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dostavljac other = (Dostavljac) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	



}
