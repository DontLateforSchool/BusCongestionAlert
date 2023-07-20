package GDSC.DAU.DontLateforSchool.service;

import GDSC.DAU.DontLateforSchool.domain.Comment;
import GDSC.DAU.DontLateforSchool.domain.Post;
import GDSC.DAU.DontLateforSchool.dto.comment.CommentRequest;
import GDSC.DAU.DontLateforSchool.repository.CommentRepository;
import GDSC.DAU.DontLateforSchool.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public void save(CommentRequest request, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. postId=" + postId));
        Comment comment = new Comment(request.getContents(), post);
        commentRepository.save(comment);
    }
}
