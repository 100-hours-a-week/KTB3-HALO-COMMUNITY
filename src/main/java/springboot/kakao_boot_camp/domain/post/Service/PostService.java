package springboot.kakao_boot_camp.domain.post.Service;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.kakao_boot_camp.domain.post.dto.PostDtos.*;
import springboot.kakao_boot_camp.domain.post.entity.Post;
import springboot.kakao_boot_camp.domain.post.exception.PostNotFoundException;
import springboot.kakao_boot_camp.domain.post.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    // -- Get --
    @Transactional
    public PostGetRes getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);

        return PostGetRes.from(post);

    }

    // -- Post --
    public PostCreateRes createPost(PostCreateReq req) {
        Post post = new Post();
        post.setTitle(req.title());

        // Todo : 후 인증 기능 추가하면 넣을 예정
        // post.setUser();

        post.setContent(req.content());
        post.setImageUrl(req.imageUrl());
        post.setCratedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        Post saved = postRepository.save(post);

        return PostCreateRes.from(post);
    }

    // -- Update : Patch --
    @Transactional
    public PostUpdateRes updatePost(Long postId, PostUpdateReq req) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        // 더티 체킹
        if (post.getTitle() != null) {
            post.setTitle(req.title());
        }
        if (post.getContent() != null) {
            post.setContent(req.content());
        }
        if (post.getImageUrl() != null) {
            post.setImageUrl(req.imageUrl());
        }

        return PostUpdateRes.from(post);
    }

    // -- Delete --
    @Transactional
    public PostDeleteRes deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        postRepository.delete(post); // 실제 삭제

        return PostDeleteRes.from(postId, LocalDateTime.now());

    }


}
