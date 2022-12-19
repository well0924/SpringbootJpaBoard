package com.example.springbootboard.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.example.springbootboard.domain.Article} entity
 */
public record ArticleDto(
        String title,
        String content,
        String hashtag,
        String createdBy,
        LocalDateTime createdAt,

        String modifiedBy,
        LocalDateTime modifiedAt) implements Serializable {

}