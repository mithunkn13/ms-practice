package com.microservice.post.repository;

import com.microservice.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Not Necessary
public interface PostRepository extends JpaRepository<Post,String>
{

}
