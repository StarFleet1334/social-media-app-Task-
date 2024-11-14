package org.example.easytask.service;

import org.example.easytask.model.Post;
import org.example.easytask.model.User;
import org.example.easytask.repository.PostRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    public void savePost_ReturnsSavedPost() {

        User author = new User();
        author.setId(1L);

        Post post = new Post();
        post.setAuthor(author);

        when(postRepository.save(post)).thenReturn(post);

        Post createdPost = postService.savePost(post);

        verify(postRepository).save(post);

        assertEquals(createdPost, post);

    }
}