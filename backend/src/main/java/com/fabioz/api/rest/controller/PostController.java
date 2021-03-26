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
	@ApiOperation(value = "Recupera os dados de todas as postagens.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna 200 quando os postagens forem retornadas com sucesso.") })
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Post> postagem = postService.findAll();
		return ResponseEntity.ok().body(postagem);
	}

	@CrossOrigin
	@ApiOperation(value = "Registra um nova postagem na base de dados H2.")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retorna 201 quando a postagem for cadastrada com sucesso."),
			@ApiResponse(code = 400, message = "Retorna 400 quando ocorrer algum erro de validação.") })
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PostRequest postRequest) {
		Post post = new Post();
		BeanUtils.copyProperties(postRequest, post);
		
		Post savePost = postService.save(post);
		return ResponseEntity.ok(savePost);
	}

	@CrossOrigin
	@ApiOperation(value = "Atualiza a postagem adicionando mais um voto para o post.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna 200 quando o post for atualizada com sucesso."),
			@ApiResponse(code = 400, message = "Retorna 400 quando ocorrer algum erro de validação."),
			@ApiResponse(code = 404, message = "Retorna 404 quando o post que se deseja atualizar não existe na base de dados.") })
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		Post updatePost = postService.update(id);
		return ResponseEntity.ok(updatePost);
	}
}
