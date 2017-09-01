package com.ak.learning.springjpa.services;

import com.ak.learning.springjpa.models.Post;

import java.util.List;

public interface IPostService {

  List<Post> getPosts();

  void createPost(Post post);

  void saveAll(List<Post> posts);

  Post getPostById(Long postId);
}
