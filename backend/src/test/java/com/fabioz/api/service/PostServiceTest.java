package com.fabioz.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fabioz.api.domain.entity.Post;
import com.fabioz.api.payload.response.PostRequest;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author fabioz
 *
 */
@ExtendWith(MockitoExtension.class)
class PostServiceTest {
   
	@Mock
	private IPostService ipostService;
	
	//Mock
	//private PostRepository postRepository;
	
	
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(ipostService);
	}
	
	@Test
    public void getPostTest(){
    	// Arrange
		Post post = new Post();
    	post.setText("Testando post1");
    	post.setUpvote(1);
	
    	List<Post> postList = new ArrayList<Post>();
    	postList.add(post);
    	
    	when(this.ipostService.findAll()).thenReturn(postList);
        
    	// Action
        List<Post> expectedtList = this.ipostService.findAll();

        // Assert
        assertEquals(postList, expectedtList);
    }
	
	@Test
    public void savePostTest(){
        // Arrange
		Post post = new Post();
    	post.setText("Testando post1");
    	post.setUpvote(1);
    	
    	PostRequest postRequest = new PostRequest();
    	postRequest.setText("Testando post1");
    	postRequest.setUpvote(1);
    	 
        when(this.ipostService.save(post)).thenReturn(post);
        
        // Action
        Post expectedPost = this.ipostService.save(post);
        
        // Assert
        assertEquals(post, expectedPost);
    
    }
    

    @Test
    public void updatePostTest(){
        // Arrange
        /*Integer id = 1;
        Post post = new Post();
        post.setId(id);
        
        when(this.ipostService.update(post.getId())).thenReturn(post);
        
        // Action
        ResponseEntity<?> httpStatus = this.postController.update(post.getId());

        // Assert
        assertEquals(HttpStatus.OK, httpStatus.getStatusCode());
        */
    }
}