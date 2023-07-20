package GDSC.DAU.DontLateforSchool.repository;

import GDSC.DAU.DontLateforSchool.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
