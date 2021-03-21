/**
 * @author fabioz
 *
 */
package com.fabioz.api.service.impl;

import java.util.List;
import java.util.Optional;

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
	public void save(Post post) {
		repository.save(post);
	}

	@Override
	public List<Post> findAll() {
		List<Post> post = repository.findAll();
		return post;
	}

	@Override
	public Optional<Post> update(Integer id) {
		return repository.findById(id).map(posts -> {
			posts.setUpvote(posts.getUpvote() + 1);
			return repository.save(posts);
		});
	}

}
