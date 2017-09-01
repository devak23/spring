package com.ak.learning.springjpa.helpers;

import com.ak.learning.springjpa.services.IAuthorService;
import com.ak.learning.springjpa.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer  implements ApplicationListener<ApplicationReadyEvent> {
  @Autowired
  private IPostService postService;
  @Autowired
  private IAuthorService authorService;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//    Author author = new Author("Abhay", "Kulkarni");
//    authorService.createAuthor(author);
//
//    Post post = new Post("Shoemaker Winner Hug Discovers Near Earth Asteroid 2013 AS27")
//        .setTeaser("Using a Planetary Society provided camera, Gary Hug in Kansas, USA discovered Potentially Hazardous Asteroid 2013 AS27 on Jan. 7, 2013")
//        .setPostedOn(new Date())
//        .setAuthor(author);
//
//    postService.createPost(post);
  }
}
