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
@Table(name="tb_series")
public class Series {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "number_episodes")
	private Integer numberEpisodes;
	@Column(name = "number_seasons")
	private Integer numberSeasons;
	
	@ManyToOne
	@JoinColumn(name = "animes_id")
	private Animes animes;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumberEpisodes() {
		return numberEpisodes;
	}
	public void setNumberEpisodes(Integer numberEpisodes) {
		this.numberEpisodes = numberEpisodes;
	}
	public Integer getNumberSeasons() {
		return numberSeasons;
	}
	public void setNumberSeasons(Integer numberSeasons) {
		this.numberSeasons = numberSeasons;
	}
	public Animes getAnimes() {
		return animes;
	}
	public void setAnimes(Animes animes) {
		this.animes = animes;
	}
	
}
