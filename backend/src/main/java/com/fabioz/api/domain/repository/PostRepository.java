package com.fabioz.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabioz.api.domain.entity.Post;


/**
 * @author fabioz
 *
 */
public interface PostRepository extends JpaRepository<Post, Integer>{
	
	public List<Post> findAllByOrderByUpvoteDesc();

}
