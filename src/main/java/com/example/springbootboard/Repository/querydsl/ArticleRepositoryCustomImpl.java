package com.example.springbootboard.Repository.querydsl;

import com.example.springbootboard.domain.Article;
import com.example.springbootboard.domain.QArticle;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ArticleRepositoryCustomImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom{
    public ArticleRepositoryCustomImpl() {
        super(Article.class);
    }

    @Override
    public List<String> findAllDistinctHashtags() {
        QArticle article = QArticle.article;
        JPQLQuery<String>query = from(article)
                .distinct()
                .select(article.hashtag)
                .where(article.hashtag.isNotNull());
        return query.fetch();
    }
}
