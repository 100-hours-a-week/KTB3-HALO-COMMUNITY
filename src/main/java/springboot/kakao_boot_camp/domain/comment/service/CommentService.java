package springboot.kakao_boot_camp.domain.comment.service;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.kakao_boot_camp.domain.comment.dto.CommentDtos.*;
import springboot.kakao_boot_camp.domain.comment.entity.Comment;
import springboot.kakao_boot_camp.domain.comment.exception.CommentNotFoundException;
import springboot.kakao_boot_camp.domain.comment.repository.CommentRepository;
import springboot.kakao_boot_camp.domain.post.entity.Post;
import springboot.kakao_boot_camp.domain.post.exception.PostNotFoundException;
import springboot.kakao_boot_camp.domain.post.repository.PostRepository;
import springboot.kakao_boot_camp.domain.user.entity.User;
import springboot.kakao_boot_camp.domain.user.exception.UserNotFoundException;
import springboot.kakao_boot_camp.domain.user.repository.UserRepo;
import springboot.kakao_boot_camp.global.dto.CursorInfo;
import springboot.kakao_boot_camp.global.dto.PageInfo;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final UserRepo userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    // -- C --
    public CommentCreateRes createComment(Long postId, CommentCreateReq commentCreateReq) {

        Long userId = 1L;
        User user =userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);


        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        Comment comment = Comment.builder()
                .user(user)
                .post(post)
                .content(commentCreateReq.content())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Comment saved = commentRepository.save(comment);

        return CommentCreateRes.from(saved);
    }


    // -- R --
    @Transactional(readOnly = true)
    public CommentListRes getCommentList(Long postId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Comment> commentPage = commentRepository.findByPostId(postId, pageable);

        List<CommentListRes.CommentSummary> commentList = commentPage.getContent().stream()
                .map(comment -> CommentListRes.CommentSummary.of(
                        comment.getId(),
                        comment.getUser().getNickName(),
                        comment.getUser().getProfileImage(),
                        comment.getContent(),
                        comment.getCreatedAt(),
                        comment.getUpdatedAt()
                ))
                .toList();

        PageInfo pageInfo = PageInfo.of(commentPage);

        return CommentListRes.of(commentList, pageInfo);
    }

    @Transactional(readOnly = true)
    public CommentDetailRes getCommentDetail(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);

        return CommentDetailRes.of(comment);
    }


    // -- U --
    @Transactional
    public CommentUpdateRes updateComment(Long commentId, CommentUpdateReq req) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);

        if (req.content() != null && !req.content().isBlank()) {
            comment.setContent(req.content());
            comment.setUpdatedAt(LocalDateTime.now());
        }

        return CommentUpdateRes.of(comment);
    }


    // -- D --
    @Transactional
    public CommentDeleteRes deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);

        commentRepository.delete(comment);

        return CommentDeleteRes.of(commentId, LocalDateTime.now());
    }


}
