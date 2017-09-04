package com.ak.learning.blogsapp.services;

import com.ak.learning.blogsapp.models.Post;

import java.util.List;

public interface IPostService {

  List<Post> getPosts();

  void createPost(Post post);

  void saveAll(List<Post> posts);

  Post getPostById(Long postId);

  Post getLatestPost();
}
