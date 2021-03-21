package com.fabioz.api.service;

import java.util.List;
import java.util.Optional;

import com.fabioz.api.domain.entity.Post;


/**
 * @author fabioz
 *
 */
public interface IPostService {

	public void save(Post post);

	public List<Post> findAll();
	
	Optional<Post> update(Integer id);

}
