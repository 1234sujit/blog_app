package com.blog_app.controller;

import com.blog_app.dto.ArticleDto;
import com.blog_app.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {


    private final ArticleService articleService;


    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto articleDto) {
        ArticleDto articleDto1 = articleService.createArticle(articleDto);
        return new ResponseEntity<>(articleDto1, HttpStatus.CREATED);
    }


    @PutMapping("/{articleId}")
    public ArticleDto update(@PathVariable Long articleId, @RequestBody ArticleDto articleDto) {
        return articleService.updateArticle(articleDto, articleId);
    }

    @GetMapping("/{articleId}")
    public ArticleDto getArticle(@PathVariable("articleId") Long articleId) {
        return articleService.getArticle(articleId);
    }

    @GetMapping
    public Page<ArticleDto> getAll(Pageable pageable) {
        return articleService.getAll(pageable);
    }



    //create api to get articles of specific category
    @GetMapping("/category/{categoryId}")
    public List<ArticleDto> getArticlesByCategory(@PathVariable("categoryId") Long categoryId) {
        return articleService.getArticleOfCategory(categoryId);
    }

    @GetMapping("/user/{userId}")
    public List<ArticleDto> getArticlesByUser(@PathVariable("userId") Long userId) {
        return articleService.getArticleOfUser(userId);
    }

}

