package com.example.springbootboard.domain.dto.request;

import com.example.springbootboard.domain.Article;
import com.example.springbootboard.domain.UserAccount;
import com.example.springbootboard.domain.dto.ArticleDto;
import com.example.springbootboard.domain.dto.UserAccountDto;

import java.time.LocalDateTime;

public record ArticleRequest(
    String title,
    String content,
    String hashtag
) {
    public static ArticleRequest of(String title, String content, String hashtag) {
        return new ArticleRequest(title, content, hashtag);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return ArticleDto.of(
                userAccountDto,
                title,
                content,
                hashtag
        );
    }
}
