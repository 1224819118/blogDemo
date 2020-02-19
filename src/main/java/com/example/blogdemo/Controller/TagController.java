package com.example.blogdemo.Controller;

import com.example.blogdemo.Service.TagService;
import com.example.blogdemo.entity.AjaxResponse;
import com.example.blogdemo.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public AjaxResponse getTagList(){
        List<Tag> tagList = tagService.getTagList();
        if (tagList.size()!=0){
            return AjaxResponse.SUCCESS(tagList);
        }
        return AjaxResponse.requestFalse();
    }

    //false
    @PostMapping("/tags")
    public AjaxResponse addNewTag(@RequestBody Tag tag){
        int i = tagService.addNewTag(tag);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }
}
