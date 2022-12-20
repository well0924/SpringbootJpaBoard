package com.example.springbootboard.Controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("view 테스트")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private final MockMvc mockMvc;

    public ArticleControllerTest(
            @Autowired
            MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }
    //@Disabled("개발중")
    @DisplayName("[view][get]게시글 리스트(게시판)페이지 -정상호출")
    @Test
    public void givenNothing_whenRequestArticleView_then()throws Exception{
        //given
        //when
        mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index"))
                .andExpect(model().attributeExists("articles"));
        //then
    }

    //@Disabled("개발중")
    @DisplayName("[view][get]게시글 상세페이지 -정상호출")
    @Test
    public void givenNothing_whenRequestArticleView_thenReturnArticleViews()throws Exception{
        //given
        //when
        mockMvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));
        //then
    }

    @Disabled("개발중")
    @DisplayName("[view][get]게시글 검색전용페이지 -정상호출")
    @Test
    public void givenNothing_whenRequestArticleSearchView_thenReturnArticleSearchViews()throws Exception{
        //given
        //when
        mockMvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/index"))
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search"));
        //then
    }

    @Disabled("개발중")
    @DisplayName("[view][get]게시글 해시태그검색페이지 -정상호출")
    @Test
    public void givenNothing_whenRequestArticleHashTagSearchView_thenReturnArticleHashTagSearchViews()throws Exception{
        //given
        //when
        mockMvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search-hashtag"));
        //then
    }


}