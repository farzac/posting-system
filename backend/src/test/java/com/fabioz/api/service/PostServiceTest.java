package com.fabioz.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.fabioz.api.domain.entity.Post;
import com.fabioz.api.domain.repository.PostRepository;
import com.fabioz.api.payload.response.PostRequest;
import com.fabioz.api.service.impl.PostServiceImpl;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author fabioz
 *
 */
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

	@InjectMocks
	private PostServiceImpl postService;

	@Mock
	private PostRepository postRepository;

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(postService);
	}

	@Test
	public void getPostTest() {
		// Arrange
		Post post = new Post();
		post.setText("Testando post1");
		post.setUpvote(1);
		List<Post> postList = new ArrayList<Post>();
		postList.add(post);

		when(this.postService.findAll()).thenReturn(postList);

		// Action
		List<Post> expectedtList = this.postService.findAll();

		// Assert
		assertEquals(postList, expectedtList);
	}

	@Test
	public void savePostTest() {
		// Arrange
		PostRequest postRequest = new PostRequest();
		postRequest.setText("Testando post1");
		postRequest.setUpvote(1);

		Post post = new Post();
		BeanUtils.copyProperties(postRequest, post);

		when(this.postService.save(post)).thenReturn(post);

		// Action
		Post expectedPost = this.postService.save(post);

		// Assert
		assertEquals(post, expectedPost);

	}
	
}