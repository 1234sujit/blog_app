package com.blog_app.repository;


import com.blog_app.entity.Article;
import com.blog_app.entity.Category;
import com.blog_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    //custom methods
    List<Article> findByCategory(Category category);
    List<Article> findByUser(User user);
    List<Article> findByCategoryAndUser(Category category, User user);

}