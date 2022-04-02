package com.portail.potsfield_club.service;

import java.util.List;

import com.portail.potsfield_club.model.Post;


public interface PostService {

	List<Post>getAllPosts();
	
	void savePost(Post post);
	
	Post getPostById(long id);
	
	void deletePostById(long id);
	
}
