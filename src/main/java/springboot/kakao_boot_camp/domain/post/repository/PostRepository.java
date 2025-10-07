package springboot.kakao_boot_camp.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.kakao_boot_camp.domain.post.entity.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

}
