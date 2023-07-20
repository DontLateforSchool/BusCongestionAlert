package GDSC.DAU.DontLateforSchool.service;

import GDSC.DAU.DontLateforSchool.domain.Comment;
import GDSC.DAU.DontLateforSchool.domain.Post;
import GDSC.DAU.DontLateforSchool.dto.post.PostCommentResponse;
import GDSC.DAU.DontLateforSchool.dto.post.PostRequest;
import GDSC.DAU.DontLateforSchool.dto.post.PostResponse;
import GDSC.DAU.DontLateforSchool.repository.CommentRepository;
import GDSC.DAU.DontLateforSchool.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void save(PostRequest request) {
        Post post = new Post(request.getTitle(), request.getContents());
        postRepository.save(post);
    }

    public List<PostResponse> getAllPosts() {
        List<Post> findPosts = postRepository.findAll();

        List<PostResponse> responses = new ArrayList<>();
        for (Post post : findPosts) {
            responses.add(PostResponse.from(post));
        }

        return responses;
        /** 이렇게도 됨
         return postRepository.findAll().stream()
         .map(post -> PostResponse.from(post))
         .collect(Collectors.toList());
         **/
    }

    //게시물 하나 가져오기
    public PostCommentResponse getPost(Long postId) {
        Post findPost = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. postId=" + postId));
        return PostCommentResponse.from(findPost);
    }

    //게시물 수정
    @Transactional
    public void updatePost(PostRequest post, Long postId) {
        Post findPost = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. postId=" + postId));

        findPost.updateTitle(post.getTitle());  //생성자로 수정
        findPost.updateContents(post.getContents());
    }

    //게시물 삭제
    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}






