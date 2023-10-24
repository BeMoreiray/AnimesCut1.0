package com.projects.animescut.dto;

public class AnimesDatailsDTO {
	    private String title;
	    private String link;
	    private Integer releaseYear;
	    private String description;
	    private String studio;
	    private String creator;
	    private Double duarationMin; // Duração em minutos (para filmes)
	    private Integer numberSeasons;// Número de temporadas (para séries)
	    private Integer numberEpisodes;// Número de episódios (para séries)
		
	    
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
		public Integer getReleaseYear() {
			return releaseYear;
		}
		public void setReleaseYear(Integer releaseYear) {
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
		public Double getDuarationMin() {
			return duarationMin;
		}
		public void setDuarationMin(Double duarationMin) {
			this.duarationMin = duarationMin;
		}
		public Integer getNumberSeasons() {
			return numberSeasons;
		}
		public void setNumberSeasons(Integer numberSeasons) {
			this.numberSeasons = numberSeasons;
		}
		public Integer getNumberEpisodes() {
			return numberEpisodes;
		}
		public void setNumberEpisodes(Integer numberEpisodes) {
			this.numberEpisodes = numberEpisodes;
		}
	    
	    
	    
} 

