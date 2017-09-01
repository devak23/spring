package com.ak.learning.springjpa.repositories;

import com.ak.learning.springjpa.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends CrudRepository<Post, Long>{
}
