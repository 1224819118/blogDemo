package com.example.blogdemo.Controller;


import com.example.blogdemo.Service.ArticleService;
import com.example.blogdemo.Service.UserService;
import com.example.blogdemo.entity.AjaxResponse;
import com.example.blogdemo.entity.Article;
import com.example.blogdemo.entity.Commit;
import com.example.blogdemo.entity.User;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login/{userName}/{password}",method = RequestMethod.GET,produces = "application/json")
    public AjaxResponse login(@PathVariable String userName, @PathVariable String password, HttpServletRequest request){
        User login = userService.login(userName, password);
        if(login.getUserName().equals("false")){
            return AjaxResponse.requestFalse();
        }
        HttpSession session = request.getSession();
        session.setAttribute("userName",userName);
        return AjaxResponse.SUCCESS(login);
    }

    @PostMapping("/users")
    public AjaxResponse register(@RequestBody User user){
        int i = userService.register(user);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }

    @PutMapping("/users")
    public AjaxResponse changeOwnMessage(@RequestBody User user){
        int i = userService.updateUser(user);
        if (i>=0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }


    @PostMapping("/articles/{userId}")
    public AjaxResponse writeNewArticle(@PathVariable int userId,@RequestBody Article article){
        int i = articleService.addNewArticle(article, userId);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }

        return AjaxResponse.requestFalse(article);
    }

    @PostMapping("/commits/{userId}/{articleId}")
    public AjaxResponse commitArticle(@RequestBody Commit commit,@PathVariable int userId,@PathVariable int articleId){
        int i = userService.addNewCommit(commit, articleId, userId);
        if(i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }

    @DeleteMapping("/users")
    public AjaxResponse deldteUser(@RequestBody User user){
        int i = userService.cancelUser(user);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }



}
