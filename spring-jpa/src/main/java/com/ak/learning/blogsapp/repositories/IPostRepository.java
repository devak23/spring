package com.ak.learning.blogsapp.repositories;

import com.ak.learning.blogsapp.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends CrudRepository<Post, Long>{
}
