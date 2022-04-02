package com.portail.potsfield_club.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suggestion")
public class Suggestion {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "suggestion_desc")
		private String suggestionDesc;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getSuggestionDesc() {
			return suggestionDesc;
		}

		public void setSuggestionDesc(String suggestionDesc) {
			this.suggestionDesc = suggestionDesc;
		}

		
		
		
}
