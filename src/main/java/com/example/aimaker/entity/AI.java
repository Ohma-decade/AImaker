package com.example.aimaker.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AI {
    private String Hello;//问候语
    private String Bye;//结束语
    private String Default;//无法识别处理语
    private String OrderReply1;//命令处理语句1
    private String OrderReply2;//命令处理语句2
    private HashMap<String, String> ItemList1;//实例对应表1
    private HashMap<String, String> ItemList2;//实例对应表2
    private HashMap<String, String> ReplyList;//应答设定语句表

    private List<String> HelloSignList = new ArrayList<String>(){{
        add("Hello");
        add("Hi");
        add("hello");
        add("hi");
        add("你好");
    }
    };//欢迎触发符列表
    private List<String> ByeSignList = new ArrayList<String>(){{
        add("bye");
        add("88");
        add("再见");
        add("拜");
    }};//再见触发符列表

    private Boolean findInHello(String input){
        for(int i=0;i < HelloSignList.size();i++){
            if(input.contains(HelloSignList.get(i))){
                return true;
            }
        }//遍历欢迎列表，如果发送的语句中包含欢迎触发词，则返回true
        return false;//如果遍历完毕仍然没有，则返回false
    }
    private Boolean findInBye(String input){
        for(int i=0;i < ByeSignList.size();i++){
            if(input.contains(ByeSignList.get(i))){
                return true;
            }
        }//遍历再见列表，如果发送的语句中包含再见触发词，则返回true
        return false;//如果遍历完毕仍然没有，则返回false
    }
    private String findInList(String input,HashMap<String,String> ItemList,String OrderReply){
        for (HashMap.Entry<String, String> entry : ItemList.entrySet()){
            if(input.contains(entry.getKey())){
                return String.format(OrderReply,entry.getKey(),entry.getValue());
            }
        }
        return "default";
    }//遍历实例对应表，返回添加了对应键值对的命令处理语句1
    private String findInReplyList(String input){
        for (HashMap.Entry<String, String> entry : ReplyList.entrySet()){
            if(input.contains(entry.getKey())){
                return entry.getValue();
            }
        }
        return "default";
    }//遍历应答设定语句表，返回对应的应答语句

    public AI(String hello, String bye, String aDefault, String orderReply1, String orderReply2, HashMap<String, String> itemList1, HashMap<String, String> itemList2, HashMap<String, String> replyList) {
        Hello = hello;
        Bye = bye;
        Default = aDefault;
        OrderReply1 = orderReply1;
        OrderReply2 = orderReply2;
        ItemList1 = itemList1;
        ItemList2 = itemList2;
        ReplyList = replyList;
    }

    @Override
    public String toString() {
        return "AI{" +
                "Hello='" + Hello + '\'' +
                ", Bye='" + Bye + '\'' +
                ", Default='" + Default + '\'' +
                ", OrderReply1='" + OrderReply1 + '\'' +
                ", OrderReply2='" + OrderReply2 + '\'' +
                ", ItemList1=" + ItemList1 +
                ", ItemList2=" + ItemList2 +
                ", ReplyList=" + ReplyList +
                '}';
    }


    public String AIDealer(String input){
        if(!findInList(input,ItemList1,OrderReply1).equals("default")){//如果在实例表一中找到关键词
            if(!findInList(input,ItemList2,OrderReply2).equals("default")){
                return findInList(input,ItemList1,OrderReply1)+findInList(input,ItemList2,OrderReply2);
            }//如果实例表二中也找到关键词，则将两个返回语句合并后作为返回结果
            else {
                return findInList(input,ItemList1,OrderReply1);
            }//如果实例表二中未找到关键词，则只返回表一中的结果
        }
        else if(!findInList(input,ItemList2,OrderReply2).equals("default")){
                return findInList(input,ItemList2,OrderReply2);
        }//如果实例表一中未找到关键词而在实例表二中找到，则只返回表二中的结果
        else if(!findInReplyList(input).equals("default")){
            return findInReplyList(input);
        }//如果在回复触发符列表中找到了关键词，则返回对应的回复语句
        else if(findInHello(input)){
            return Hello;
        }//如果在Hello触发符列表中找到了关键词，则返回欢迎语句
        else if(findInBye(input)){
            return Bye;
        }//如果在Bye触发符列表中找到了关键词，则返回欢迎语句
        else{
            return Default;
            //如果都没有找到，则返回无法识别语句
        }
    }//负责接收前端客户传入请求、并返回对应的返回值

}
