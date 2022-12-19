package com.example.springbootboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class ArticleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @Setter
    private Article article;
    @Setter
    @Column(nullable = false,length = 500)
    private String content;
    @CreatedBy
    @Column(nullable = false)
    private String createdBy;
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    protected ArticleComment(){
    }

    private ArticleComment(Article article,String content){
        this.article = article;
        this.content = content;
    }

    public static ArticleComment of(Article article,String content){
        return new ArticleComment(article,content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
