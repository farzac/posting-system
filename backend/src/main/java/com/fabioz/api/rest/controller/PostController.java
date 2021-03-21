package com.fabioz.api.rest.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabioz.api.domain.entity.Post;
import com.fabioz.api.payload.response.PostRequest;
import com.fabioz.api.payload.response.PostResponse;
import com.fabioz.api.service.IPostService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;


/**
 * @author fabioz
 *
 */
@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

	private final IPostService postService;

	@CrossOrigin
    @ApiOperation(value = "Cria um novo produto na base de dados")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retorna 201 quando o produto foi criado com sucesso."),
            @ApiResponse(code = 400, message = "Retorna 400 quando ocorrer algum erro de validação do domínio.")
    })
	@GetMapping
    public ResponseEntity<?> findAll() {
        List<PostResponse> postagem = postService.findAll();
        return ResponseEntity.ok().body(postagem);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PostRequest body) {
    	Post post = new Post();
		BeanUtils.copyProperties(body, post);
    	postService.save(post);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id) {
        postService.update(id);
        return ResponseEntity.noContent().build();
    }
}
