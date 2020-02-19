package com.example.blogdemo.Controller;

import com.example.blogdemo.Service.KindService;
import com.example.blogdemo.entity.AjaxResponse;
import com.example.blogdemo.entity.Kind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class KindController {
    @Autowired
    KindService kindService;

    @GetMapping("/kinds")
    public AjaxResponse getKindList(){
        List<Kind> kindList = kindService.getKindList();
        if (kindList.size()!=0){
            return AjaxResponse.SUCCESS(kindList);
        }
        return AjaxResponse.requestFalse();
    }

    @PostMapping("/kinds")
    public AjaxResponse addNewKind(@RequestBody Kind kind){
        int i = kindService.addNewKind(kind);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }

    @DeleteMapping(value = "/kinds")
    public AjaxResponse deleteKind(@RequestBody(required = false) Kind kind){
        System.out.println(kind);
        int i = kindService.deleteKind(kind);
        if (i>0){
            return AjaxResponse.SUCCESS();
        }
        return AjaxResponse.requestFalse();
    }
}
