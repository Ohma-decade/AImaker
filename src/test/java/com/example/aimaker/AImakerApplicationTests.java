package com.example.aimaker;

import com.example.aimaker.service.ServiceTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AImakerApplication.class)
class AImakerApplicationTests {

    @Autowired
    private ServiceTest serviceTest;//自动连接测试类

    @Test
    public void findInHelloTest() throws Exception {
        Assert.assertEquals(true,serviceTest.findInHello("你好~"));
        Assert.assertEquals(true,serviceTest.findInHello("hi"));
        Assert.assertEquals(false,serviceTest.findInHello("再见"));
    }//findInHello测试样例
    @Test
    public void findInByeTest() throws Exception {
        Assert.assertEquals(true,serviceTest.findInBye("88"));
        Assert.assertEquals(true,serviceTest.findInBye("再见~"));
        Assert.assertEquals(false,serviceTest.findInBye("你好"));
    }//findInBye测试样例
    @Test
    public void findInListTest1() throws Exception {
        Assert.assertEquals("您要买的苹果价值3元/斤",serviceTest.findInList_test1("苹果多少钱？"));
        Assert.assertEquals("您要买的菠萝价值5元/斤",serviceTest.findInList_test1("菠萝咋卖？"));
        Assert.assertEquals("您要买的西瓜价值2元/斤",serviceTest.findInList_test1("西瓜怎么说？"));
        Assert.assertEquals("default",serviceTest.findInList_test1("五花肉怎么卖啊？"));
        Assert.assertEquals("default",serviceTest.findInList_test1("njakjbcnb"));
    }//findInList测试其一
    @Test
    public void findInListTest2() throws Exception {
        Assert.assertEquals("您要去的海鲜市场在三楼",serviceTest.findInList_test2("请问海鲜市场怎么走？"));
        Assert.assertEquals("您要去的西餐厅在二楼",serviceTest.findInList_test2("西餐厅在哪？"));
        Assert.assertEquals("您要去的药店在一楼",serviceTest.findInList_test2("怎么去药店？"));
        Assert.assertEquals("default",serviceTest.findInList_test2("我该怎么去火车站？"));
        Assert.assertEquals("default",serviceTest.findInList_test2("fnaojnoajnv"));
    }//findInList测试其二
    @Test
    public void findInListTest3() throws Exception {
        Assert.assertEquals("程序设计实践在周一",serviceTest.findInList_test3("程序设计实践在周几？"));
        Assert.assertEquals("体育专项在周五",serviceTest.findInList_test3("体育专项哪天上？"));
        Assert.assertEquals("编译原理与技术在周四",serviceTest.findInList_test3("哪天上编译原理与技术？"));
        Assert.assertEquals("default",serviceTest.findInList_test3("哪天上素描实践？"));
        Assert.assertEquals("default",serviceTest.findInList_test3("anjcnkjcndxj"));
    }//findInList测试其三
    @Test
    public void findInReplyListTest1() throws Exception {
        Assert.assertEquals("您好，本餐馆采取落座即食的服务策略，暂不支持预约，为您带来的不便敬请谅解",serviceTest.findInReplyList1("请问可以预约吗？"));
        Assert.assertEquals("您好，本餐馆采取落座即食的服务策略，暂不支持预约，为您带来的不便敬请谅解",serviceTest.findInReplyList1("能预定不？"));
        Assert.assertEquals("您好，您的反馈我们已经收到，稍后将由餐馆所有者亲自前来与您沟通，为您带来的不便敬请谅解，还请稍等片刻",serviceTest.findInReplyList1("菜做得有问题啊，叫你们老板来！"));
        Assert.assertEquals("default",serviceTest.findInReplyList1("请问电冰箱多少钱？"));
        Assert.assertEquals("default",serviceTest.findInReplyList1("nkjanadkjn"));
    }//findInReply测试其一
    @Test
    public void findInReplyListTest2() throws Exception {
        Assert.assertEquals("您好，您的消息我们已经收到，稍后将立即由人工客服前来为您沟通，请尽快将病患送至医院门口",serviceTest.findInReplyList2("我今晚吃坏肚子了，现在急性腹泻，请问怎么挂急诊？"));
        Assert.assertEquals("您好，您的消息我们已经收到，稍后将立即由人工客服前来为您沟通，请尽快将病患送至医院门口",serviceTest.findInReplyList2("救命！我哥刚刚被大卡车撞了！"));
        Assert.assertEquals("您好，本院工作时间为8:00——20:00（工作日），9:00——19:00（节假日），急诊24h在线",serviceTest.findInReplyList2("我明天想去看病，医院多久开门啊？"));
        Assert.assertEquals("default",serviceTest.findInReplyList2("虾多少钱一斤？"));
        Assert.assertEquals("default",serviceTest.findInReplyList2("rcajkcs"));
    }//findInReply测试其二
    @Test
    public void findInReplyListTest3() throws Exception {
        Assert.assertEquals("您好，如果您需要借阅，请到距离您最近的自动借阅处，将书上的标识和您的学生证在机器上扫描即可",serviceTest.findInReplyList3("我在哪借这本书啊？"));
        Assert.assertEquals("您好，如果您需要归还借阅的书本，请到距离您最近的自动归还处，将书上的标识和您的学生证在机器上扫描即可",serviceTest.findInReplyList3("我怎么还这本书？"));
        Assert.assertEquals("您好，本图书馆开放时间为7:00——23:00，一楼通宵自习室24h开放",serviceTest.findInReplyList3("图书馆多久关门？"));
        Assert.assertEquals("default",serviceTest.findInReplyList3("苹果多少钱一斤？"));
        Assert.assertEquals("default",serviceTest.findInReplyList3("jfakmklm"));
    }//findInReply测试其三
}
