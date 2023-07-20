package GDSC.DAU.DontLateforSchool.repository;

import GDSC.DAU.DontLateforSchool.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
