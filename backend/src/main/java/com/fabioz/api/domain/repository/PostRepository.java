package com.fabioz.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabioz.api.domain.entity.Post;


/**
 * @author fabioz
 *
 */
public interface PostRepository extends JpaRepository<Post, Integer>{

}
