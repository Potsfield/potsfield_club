package com.portail.potsfield_club.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portail.potsfield_club.model.Suggestion;


public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

	

}
