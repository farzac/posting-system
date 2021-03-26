/**
 * @author fabioz
 *
 */
package com.fabioz.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fabioz.api.domain.entity.Post;
import com.fabioz.api.domain.repository.PostRepository;
import com.fabioz.api.service.IPostService;

import lombok.AllArgsConstructor;

/**
 * @author fabioz
 *
 */
@Service
@AllArgsConstructor
public class PostServiceImpl implements IPostService {

	private final PostRepository repository;

	@Override
	public Post save(Post post) {
		return repository.save(post);
	}

	@Override
	public List<Post> findAll() {
		List<Post> post = repository.findAll();
		return post;
	}

	@Override
	public Post update(Integer id) {
		Post post = repository.findById(id).orElse(null);
		post.setUpvote(post.getUpvote() + 1);
		return repository.save(post);
	//	});
	}

}
