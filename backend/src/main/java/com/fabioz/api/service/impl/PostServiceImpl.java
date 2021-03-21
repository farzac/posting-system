/**
 * @author fabioz
 *
 */
package com.fabioz.api.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fabioz.api.domain.entity.Post;
import com.fabioz.api.domain.repository.PostRepository;
import com.fabioz.api.payload.response.PostResponse;
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
	public List<PostResponse> findAll() {
		List<Post> post = repository.findAll();
		return copyPropertiesDtoToResponse(post);
	}

	private List<PostResponse> copyPropertiesDtoToResponse(List<Post> postList) {
		List<PostResponse> postResponseList = new ArrayList<PostResponse>();
		PostResponse postResponse = null;

		for (Post post : postList) {
			postResponse = new PostResponse();
			postResponse.setId(post.getId());
			postResponse.setText(post.getText());
			postResponse.setUpvote(post.getUpvote());
			postResponseList.add(postResponse);
		}

		postResponseList.sort(Comparator.comparing(PostResponse::getUpvote).reversed());
		return postResponseList;
	}

	
	@Override
	public Optional<Post> update(Integer id) {
		return repository.findById(id).map(posts -> {
			posts.setUpvote(posts.getUpvote() + 1);
			return repository.save(posts);
		});
	}

}
