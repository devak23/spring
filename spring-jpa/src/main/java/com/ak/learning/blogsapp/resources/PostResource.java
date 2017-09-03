package com.ak.learning.blogsapp.resources;

import com.ak.learning.blogsapp.models.Post;
import com.ak.learning.blogsapp.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostResource {

  private IPostService postService;

  @Autowired
  public void setPostService(IPostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public Iterable<Post> getPosts() {
    return postService.getPosts();
  }

  @RequestMapping( value = "/{id}", method = RequestMethod.GET)
  public Post getPostById(@PathVariable("id") long id) {
    return postService.getPostById(id);
  }
}
