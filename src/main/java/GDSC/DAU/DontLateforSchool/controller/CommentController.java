package GDSC.DAU.DontLateforSchool.controller;

import GDSC.DAU.DontLateforSchool.dto.comment.CommentRequest;
import GDSC.DAU.DontLateforSchool.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{postId}/comment/new")
    public void createComment(@RequestBody CommentRequest request, @PathVariable Long postId) {
        commentService.save(request, postId);
    }

}
