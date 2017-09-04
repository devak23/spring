package com.ak.learning.blogsapp.repositories;

import com.ak.learning.blogsapp.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends CrudRepository<Post, Long>{

  List<Post> findAllByOrderByPostedOnDesc();

  List<Post> findAllByOrderByIdDesc();

  List<Post> findAllByOrderByPostedOnAsc();

  Post findFirstByOrderByPostedOnDesc();
}
