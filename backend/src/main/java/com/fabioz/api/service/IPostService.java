package com.fabioz.api.service;

import java.util.List;

import com.fabioz.api.domain.entity.Post;


/**
 * @author fabioz
 *
 */
public interface IPostService {

	Post save(Post post);

	List<Post> findAll();
	
	Post update(Integer id);

}
