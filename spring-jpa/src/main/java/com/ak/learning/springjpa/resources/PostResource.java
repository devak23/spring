package com.ak.learning.springjpa.resources;

import com.ak.learning.springjpa.models.Post;
import com.ak.learning.springjpa.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResource {

  private IPostService postService;

  @Autowired
  public void setPostService(IPostService postService) {
    this.postService = postService;
  }

  @RequestMapping( value = "/", method = RequestMethod.GET)
  public Iterable<Post> getPosts() {
    return postService.getPosts();
  }

  @RequestMapping( value = "/{id}", method = RequestMethod.GET)
  public Post getPostById(@PathVariable("id") long id) {
    return postService.getPostById(id);
  }
}
