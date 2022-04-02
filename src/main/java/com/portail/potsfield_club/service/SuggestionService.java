package com.portail.potsfield_club.service;

import java.util.List;

import com.portail.potsfield_club.model.Suggestion;



public interface SuggestionService {
	List<Suggestion>getAllSugg();
	
	void saveSuggestion(Suggestion suggestion);
	void deleteSuggestionById(long id);	
}
