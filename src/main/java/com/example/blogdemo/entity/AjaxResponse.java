package com.example.blogdemo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AjaxResponse {
    private boolean isok;//是否成功
    private int code;//状态码
    private String message;//信息
    private Object data;//数据


    public static AjaxResponse SUCCESS(Object data){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("Success");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }
    public static AjaxResponse SUCCESS(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("Success");
        return ajaxResponse;
    }

    public static AjaxResponse requestFalse(Object data){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(false);
        ajaxResponse.setCode(500);
        ajaxResponse.setMessage("systemFalse");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }
    public static AjaxResponse requestFalse(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(false);
        ajaxResponse.setCode(500);
        ajaxResponse.setMessage("systemFalse");
        return ajaxResponse;
    }
}
