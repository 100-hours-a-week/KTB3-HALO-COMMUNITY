package springboot.kakao_boot_camp.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.kakao_boot_camp.domain.comment.dto.CommentDtos.*;
import springboot.kakao_boot_camp.domain.comment.entity.Comment;
import springboot.kakao_boot_camp.domain.comment.repository.CommentRepository;
import springboot.kakao_boot_camp.domain.post.entity.Post;
import springboot.kakao_boot_camp.domain.post.exception.PostNotFoundException;
import springboot.kakao_boot_camp.domain.post.repository.PostRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public CommentCreateRes createComment(Long postId, CommentCreateReq commentCreateReq) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        Comment comment = Comment.builder()
                .content(commentCreateReq.content())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Comment saved = commentRepository.save(comment);

        return CommentCreateRes.from(saved);
    }

}
