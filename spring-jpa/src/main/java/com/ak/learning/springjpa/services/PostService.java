package com.ak.learning.springjpa.services;

import com.ak.learning.springjpa.models.Post;
import com.ak.learning.springjpa.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PostService implements IPostService {

  private IPostRepository postRepository;

  @Autowired
  public void setPostRepository(IPostRepository postRepository) {
    this.postRepository = postRepository;
  }


  @Override
  public List<Post> getPosts() {
    return (List<Post>) postRepository.findAll();
  }

  @Override
  public void createPost(Post post) {
    postRepository.save(post);
  }
}
