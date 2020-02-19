package com.example.blogdemo.Controller;

import com.example.blogdemo.Service.ArticleService;
import com.example.blogdemo.entity.AjaxResponse;
import com.example.blogdemo.entity.Article;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public AjaxResponse showArticleList(){
        List<Article> articleList = articleService.showArticleList();
        return AjaxResponse.SUCCESS(articleList);
    }

    @GetMapping("/articles/{userId}")
    public AjaxResponse showOwnArticles(@PathVariable int userId){
        List<Article> articleList = articleService.showUserArticles(userId);
        return AjaxResponse.SUCCESS(articleList);
    }

    @DeleteMapping("/articles")
    public AjaxResponse deleteArticle(@RequestBody Article article){
        System.out.println(article.getId());
        int i = articleService.deleteArticle(article);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }

    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article){
        int i = articleService.updateArticle(article);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }

    @PostMapping("/article_kinds/{kindId}")
    public AjaxResponse setArticleKind(@PathVariable int kindId,@RequestBody Article article){
        int i = articleService.setArticleKind(article, kindId);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }

    @PostMapping("/article_tags/{tagId}")
    public AjaxResponse setArticleTag(@PathVariable int tagId,@RequestBody Article article){
        int i = articleService.setArticleTag(article, tagId);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }



}
