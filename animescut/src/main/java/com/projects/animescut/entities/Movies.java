package com.projects.animescut.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_movies")
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "duration_min")
	private Double duarationMin;
	
	@ManyToOne
	@JoinColumn(name = "animes_id")
	private Animes animes;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getDuarationMin() {
		return duarationMin;
	}
	public void setDuarationMin(Double duarationMin) {
		this.duarationMin = duarationMin;
	}
	public Animes getAnimes() {
		return animes;
	}
	public void setAnimes(Animes animes) {
		this.animes = animes;
	}
	
	
}
