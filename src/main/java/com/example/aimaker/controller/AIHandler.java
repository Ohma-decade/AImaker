package com.example.aimaker.controller;

import com.example.aimaker.entity.AI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class AIHandler {
AI ai;
    @GetMapping("/start")
    public ModelAndView start(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start");
        return modelAndView;
    }//负责将页面引导至start.jsp

    @PostMapping("/createAI")
    public ModelAndView createAI(
            @RequestBody Map<String, Object> params
            ){
                String Hello = (String) params.get("Hello");
                String Bye = (String) params.get("Bye");
                String Default = (String) params.get("Default");
                String OrderReply1 = (String) params.get("OrderReply1");
                String OrderReply2 = (String) params.get("OrderReply2");
                HashMap<String, String> ItemList1 = (HashMap<String, String>) params.get("ItemList1");
                HashMap<String, String> ItemList2 = (HashMap<String, String>) params.get("ItemList2");
                HashMap<String, String> ReplyList = (HashMap<String, String>) params.get("ReplyList");
                ai = new AI(Hello,Bye,Default,OrderReply1,OrderReply2,ItemList1,ItemList2,ReplyList);
                System.out.println(ai.toString());
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("run");
                return modelAndView;
    }//接收前端传入的、用以构建一个AI实体的数据，并用此赋值给全局变量ai

    @GetMapping("/run")
    public ModelAndView run(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("run");
        return modelAndView;
    }//在AI实体构建完成后跳转至run.jsp页面

    @RequestMapping("/runAI")
    @ResponseBody
    public String runAI(String input){
        System.out.println("success");
        return ai.AIDealer(input);
    }//负责接受前端传回数据，经过AI实体中的方法处理后返回数据给前端
}
