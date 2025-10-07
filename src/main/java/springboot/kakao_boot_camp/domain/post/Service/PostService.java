package springboot.kakao_boot_camp.domain.post.Service;

import org.springframework.stereotype.Service;
import springboot.kakao_boot_camp.domain.post.dto.PostDtos.*;
import springboot.kakao_boot_camp.domain.post.entity.Post;
import springboot.kakao_boot_camp.domain.post.exception.PostNotFoundException;
import springboot.kakao_boot_camp.domain.post.repository.PostRepository;

import java.util.Optional;

@Service
public class PostService {

    private  final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository=postRepository;
    }

    public PostGetRes getPost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);

        return new PostGetRes(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getImageUrl(),
                post.getLikeCount(),
                post.getViewCount(),
                post.getCommentCount(),
                post.getCratedAt(),
                post.getUpdatedAt()
        );

    }
    public PostCreateRes createPost(PostCreateReq req){
        Post post = new Post();
        post.setTitle(req.title());
        post.setContent(req.content());
        post.setImageUrl(req.imageUrl());

        Post saved = postRepository.save(post);

        return new PostCreateRes(
                saved.getId(),
                saved.getTitle(),
                saved.getContent(),
                saved.getImageUrl(),
                saved.getCratedAt()
        );
    }
}
