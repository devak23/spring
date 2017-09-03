package com.ak.learning.blogsapp.services;

import com.ak.learning.blogsapp.helpers.AppValidator;
import com.ak.learning.blogsapp.models.Post;
import com.ak.learning.blogsapp.repositories.IPostRepository;
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

  @Override
  public void saveAll(List<Post> posts) {
    postRepository.save(posts);
  }

  @Override
  public Post getPostById(Long postId) {
    Post post = postRepository.findOne(postId);
    AppValidator.checkEntityExists(post, "The post with id = " + postId + " does not exist!");

    return post;
  }
}
