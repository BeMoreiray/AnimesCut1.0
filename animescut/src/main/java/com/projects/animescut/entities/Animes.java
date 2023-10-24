package com.projects.animescut.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_animes")
public class Animes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Titulo obrigatório")
	private String title;
	@NotBlank(message="Link obrigatório")
	private String link;
	@Column(name = "release_year")
	@NotNull
	@Min(value= 1900)
	private int releaseYear;
	@Column(name= "description_anime", columnDefinition = "TEXT")
	@NotBlank(message="Descrição obrigatória")
	private String description;
	@NotBlank(message="Studio obrigatório")
	private String studio;
	@NotBlank(message="Criador obrigatório")
	private String creator;
	
	@ManyToOne
	@JoinColumn(name = "types_Animes_id")
	private TypesAnimes typesAnimes;
	
	public Animes() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public TypesAnimes getTypes() {
		return typesAnimes;
	}

	public void setTypes(TypesAnimes types) {
		this.typesAnimes = types;
	}
	
	
	
	
}
