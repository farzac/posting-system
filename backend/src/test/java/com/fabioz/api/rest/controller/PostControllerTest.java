package com.fabioz.api.rest.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fabioz.api.domain.entity.Post;
import com.fabioz.api.service.IPostService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author fabioz
 *
 */
@ExtendWith(MockitoExtension.class)
class PostControllerTest {

	@InjectMocks
	private PostController postController;

	@Mock
	private IPostService ipostService;

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(postController);
	}

	@Test
	public void getPostTest() {
		// Arrange
		Post post = new Post();
		post.setText("Testando post1");
		post.setUpvote(1);
		List<Post> postList = new ArrayList<Post>();
		postList.add(post);

		when(this.ipostService.findAll()).thenReturn(postList);

		// Action
		ResponseEntity<?> httpStatus = this.postController.findAll();

		// Assert
		assertEquals(HttpStatus.OK, httpStatus.getStatusCode());
	}

	@Test
	public void updatePostTest() {
		// Arrange
		Integer id = 1;

		Post post = new Post();
		post.setText("Testando post1");
		post.setUpvote(1);

		when(this.ipostService.update(id)).thenReturn(post);

		// Action
		ResponseEntity<?> httpStatus = this.postController.update(id);

		// Assert
		assertEquals(HttpStatus.OK, httpStatus.getStatusCode());
	}
}
