package GDSC.DAU.DontLateforSchool.dto.comment;

import GDSC.DAU.DontLateforSchool.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private String contents;
    private LocalDateTime createdAt;

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getContents(), comment.getCreatedAt());
    }

}
