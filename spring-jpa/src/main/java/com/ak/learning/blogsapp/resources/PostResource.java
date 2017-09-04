package com.ak.learning.blogsapp.resources;

import com.ak.learning.blogsapp.models.Post;
import com.ak.learning.blogsapp.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PostResource.POSTS_BASE_URI)
public class PostResource {
  public static final String POSTS_BASE_URI = "/blogsapp/api/v1/posts";
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

  @RequestMapping(value = "/latest")
  public Post getLatestPost() {
    return postService.getLatestPost();
  }
}
