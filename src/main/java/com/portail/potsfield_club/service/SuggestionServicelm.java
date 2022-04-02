package com.portail.potsfield_club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portail.potsfield_club.model.Suggestion;
import com.portail.potsfield_club.repository.SuggestionRepository;



@Service
public class SuggestionServicelm implements SuggestionService {

	
	@Autowired
	private SuggestionRepository suggestionRepository;

	@Override
	public List<Suggestion> getAllSugg() {
		// TODO Auto-generated method stub
		return suggestionRepository.findAll();
	}

	@Override
	public void saveSuggestion(Suggestion suggestion) {
		
		this.suggestionRepository.save(suggestion);
		
	}

	@Override
	public void deleteSuggestionById(long id) {
		
			this.suggestionRepository.deleteById(id);
			
		
	}


}
