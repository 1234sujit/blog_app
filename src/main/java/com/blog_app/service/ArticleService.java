package com.blog_app.service;

import com.blog_app.dto.ArticleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    Page<ArticleDto> getAll(Pageable pageable);
    ArticleDto getArticle(Long articleId);
    ArticleDto createArticle(ArticleDto articleDto);
    ArticleDto updateArticle(ArticleDto articleDto, Long articleId );
    void deleteArticle(Long articleId);

    List<ArticleDto> getArticleOfCategory(Long categoryId);

    List<ArticleDto> getArticleOfUser(Long userId);

}
