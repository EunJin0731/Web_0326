package kr.hs.dgsw.web_01_0326.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data // Getter Setter 기타 등등등..
@NoArgsConstructor // 기본 생성자 -> 왜 만들어지는지 이해하기
public class Comment {

    @Id // 기본키
    @GeneratedValue // 자동 증가
    private Long id;

    private Long userid;
    private String content;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime modified;

    // NoArgsConstructor => public Comment(){}


    public Comment(Comment c){
        this.id = c.getId();
        this.content = c.getContent();
        this.userid = c.getUserid();
        this.created = c.getCreated();
        this.modified = c.getModified();
    }

    public Comment(Long userid, String content){
        this.userid = userid;
        this.content = content;
    }
}
