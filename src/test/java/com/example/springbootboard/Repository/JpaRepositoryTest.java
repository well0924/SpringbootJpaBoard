package com.example.springbootboard.Repository;

import com.example.springbootboard.Config.JpaConfig;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import  static org.assertj.core.api.Assertions.*;
@DisplayName("Crud 테스트")
@Import(JpaConfig.class)
@DataJpaTest
public class JpaRepositoryTest {

    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    
}
