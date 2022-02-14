package com.example.aimaker.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceTest {
    public Boolean findInHello(String input){
        List<String> HelloSignList = new ArrayList<String>(){{
            add("Hello");
            add("Hi");
            add("hello");
            add("hi");
            add("你好");
        }
        };//欢迎触发符列表

        for(int i=0;i < HelloSignList.size();i++){
            if(input.contains(HelloSignList.get(i))){
                return true;
            }
        }//遍历欢迎列表，如果发送的语句中包含欢迎触发词，则返回true
        return false;//如果遍历完毕仍然没有，则返回false
    }//findInHello单元测试
    public Boolean findInBye(String input){
        List<String> ByeSignList = new ArrayList<String>(){{
            add("bye");
            add("88");
            add("再见");
            add("拜");
        }};//再见触发符列表
        for(int i=0;i < ByeSignList.size();i++){
            if(input.contains(ByeSignList.get(i))){
                return true;
            }
        }//遍历再见列表，如果发送的语句中包含再见触发词，则返回true
        return false;//如果遍历完毕仍然没有，则返回false
    }//findInBye单元测试
    public String findInList_test1(String input){
        HashMap<String, String> ItemList = new HashMap<>();
        ItemList.put("菠萝","5");
        ItemList.put("苹果","3");
        ItemList.put("荔枝","4");
        ItemList.put("西瓜","2");
        ItemList.put("梨","3");
        String OrderReply = "您要买的%s价值%s元/斤";
        for (HashMap.Entry<String, String> entry : ItemList.entrySet()){
            if(input.contains(entry.getKey())){
                return String.format(OrderReply,entry.getKey(),entry.getValue());
            }
        }
        return "default";
    }//findInList单元测试其一（水果店场景）
    public String findInList_test2(String input){
        HashMap<String, String> ItemList = new HashMap<>();
        ItemList.put("西餐厅","二楼");
        ItemList.put("服装店","二楼");
        ItemList.put("珠宝店","一楼");
        ItemList.put("海鲜市场","三楼");
        ItemList.put("药店","一楼");
        ItemList.put("全友家私","四楼");
        String OrderReply = "您要去的%s在%s";
        for (HashMap.Entry<String, String> entry : ItemList.entrySet()){
            if(input.contains(entry.getKey())){
                return String.format(OrderReply,entry.getKey(),entry.getValue());
            }
        }
        return "default";
    }//findInList单元测试其二（百货大楼场景）
    public String findInList_test3(String input){
        HashMap<String, String> ItemList = new HashMap<>();
        ItemList.put("程序设计实践","周一");
        ItemList.put("操作系统","周二");
        ItemList.put("编译原理与技术","周四");
        ItemList.put("体育专项","周五");
        String OrderReply = "%s在%s";
        for (HashMap.Entry<String, String> entry : ItemList.entrySet()){
            if(input.contains(entry.getKey())){
                return String.format(OrderReply,entry.getKey(),entry.getValue());
            }
        }
        return "default";
    }//findInList单元测试其三（学校课程场景）
    public String findInReplyList1(String input){
        HashMap<String, String> ReplyList = new HashMap<>();
        ReplyList.put("预约","您好，本餐馆采取落座即食的服务策略，暂不支持预约，为您带来的不便敬请谅解");
        ReplyList.put("预定","您好，本餐馆采取落座即食的服务策略，暂不支持预约，为您带来的不便敬请谅解");
        ReplyList.put("打包","您好，您的食物即将为您打包，还请稍等片刻");
        ReplyList.put("问题","您好，您的反馈我们已经收到，稍后将由餐馆所有者亲自前来与您沟通，为您带来的不便敬请谅解，还请稍等片刻");
        ReplyList.put("难吃","您好，您的反馈我们已经收到，稍后将由餐馆所有者亲自前来与您沟通，为您带来的不便敬请谅解，还请稍等片刻");
        ReplyList.put("投诉","您好，您的反馈我们已经收到，稍后将由餐馆所有者亲自前来与您沟通，为您带来的不便敬请谅解，还请稍等片刻");
        for (HashMap.Entry<String, String> entry : ReplyList.entrySet()){
            if(input.contains(entry.getKey())){
                return entry.getValue();
            }
        }
        return "default";
    }//findInReplyList单元测试其一（餐馆场景）
    public String findInReplyList2(String input){
        HashMap<String, String> ReplyList = new HashMap<>();
        ReplyList.put("急诊","您好，您的消息我们已经收到，稍后将立即由人工客服前来为您沟通，请尽快将病患送至医院门口");
        ReplyList.put("救","您好，您的消息我们已经收到，稍后将立即由人工客服前来为您沟通，请尽快将病患送至医院门口");
        ReplyList.put("发票","您好，如果您需要提供发票，请前往一楼药房处办理");
        ReplyList.put("开门","您好，本院工作时间为8:00——20:00（工作日），9:00——19:00（节假日），急诊24h在线");
        ReplyList.put("关门","您好，本院工作时间为8:00——20:00（工作日），9:00——19:00（节假日），急诊24h在线");
        ReplyList.put("工作","您好，本院工作时间为8:00——20:00（工作日），9:00——19:00（节假日），急诊24h在线");
        for (HashMap.Entry<String, String> entry : ReplyList.entrySet()){
            if(input.contains(entry.getKey())){
                return entry.getValue();
            }
        }
        return "default";
    }//findInReplyList单元测试其二（医院场景）
    public String findInReplyList3(String input){
        HashMap<String, String> ReplyList = new HashMap<>();
        ReplyList.put("借","您好，如果您需要借阅，请到距离您最近的自动借阅处，将书上的标识和您的学生证在机器上扫描即可");
        ReplyList.put("还","您好，如果您需要归还借阅的书本，请到距离您最近的自动归还处，将书上的标识和您的学生证在机器上扫描即可");
        ReplyList.put("开门","您好，本图书馆开放时间为7:00——23:00，一楼通宵自习室24h开放");
        ReplyList.put("关门","您好，本图书馆开放时间为7:00——23:00，一楼通宵自习室24h开放");
        for (HashMap.Entry<String, String> entry : ReplyList.entrySet()){
            if(input.contains(entry.getKey())){
                return entry.getValue();
            }
        }
        return "default";
    }//findInReplyList单元测试其三（学校图书馆场景）
}
