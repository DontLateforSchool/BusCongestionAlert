package GDSC.DAU.DontLateforSchool.domain;

import GDSC.DAU.DontLateforSchool.domain.global.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    //수정 메서드
    public void updateContents(String contents) {
        this.contents = contents;
    }

    //생성자, 연관관계 메서드
    public Comment(String contents, Post post) {
        this.contents = contents;
        this.post = post;
        post.getComment().add(this);
    }
}
