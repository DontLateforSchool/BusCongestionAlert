package GDSC.DAU.DontLateforSchool.dto.post;

import GDSC.DAU.DontLateforSchool.domain.Comment;
import GDSC.DAU.DontLateforSchool.domain.Post;
import GDSC.DAU.DontLateforSchool.dto.comment.CommentResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class PostCommentResponse {
    private Long id;
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<CommentResponse> comments;

    //엔티티에 매핑
    public static PostCommentResponse from(Post post) {
        List<CommentResponse> commentResponses = post.getComment().stream()
                .map(CommentResponse::from)
                .collect(Collectors.toList());

        return PostCommentResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContents())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdateAt())
                .comments(commentResponses)
                .build();
    }
}
