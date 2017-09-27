package com.ak.learning.blogsapp.helpers;

import com.ak.learning.blogsapp.models.Author;
import com.ak.learning.blogsapp.models.Post;
import com.ak.learning.blogsapp.services.IAuthorService;
import com.ak.learning.blogsapp.services.IPostService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Profile("dev")
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
    loadAuthors();
    loadPosts();
  }

  private void loadPosts() {
    System.out.println("Loading Posts...");
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<List<Post>> typeRef = new TypeReference<List<Post>>() {};
    InputStream in = TypeReference.class.getClass().getResourceAsStream("/data/posts.json");
    try {
      List<Post> posts = mapper.readValue(in, typeRef);
      postService.saveAll(posts);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private void loadAuthors() {
    System.out.println("Loading Authors...");
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<List<Author>> typeRef = new TypeReference<List<Author>>() {};
    InputStream in = TypeReference.class.getClass().getResourceAsStream("/data/authors.json");
    try {
      List<Author> authors = mapper.readValue(in, typeRef);
      authorService.saveAll(authors);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
