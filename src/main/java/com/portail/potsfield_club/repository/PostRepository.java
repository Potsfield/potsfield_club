package com.portail.potsfield_club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portail.potsfield_club.model.Post;



@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
