package com.portail.potsfield_club.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portail.potsfield_club.model.Post;
import com.portail.potsfield_club.repository.PostRepository;



@Service
public class PostServiceIm implements PostService{

	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> getAllPosts() {
		
		return postRepository.findAll();
	}

	@Override
	public void savePost(Post post) {
		
		this.postRepository.save(post);
		
	}

	@Override
	public Post getPostById(long id) {
		Optional<Post> optional =postRepository.findById(id);
		Post post = null;
		if(optional.isPresent()) {
			post = optional.get();
		}
		else {
			throw new RuntimeException("Post not found forid ::"+id);
		}
		
		return post;
	}

	@Override
	public void deletePostById(long id) {

		this.postRepository.deleteById(id);
		
	}

	
	
}
