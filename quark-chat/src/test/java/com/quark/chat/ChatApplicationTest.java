package com.quark.chat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.quark.common.dao.UserDao;
import com.quark.common.entity.User;

/**
 * @Author : ChinaLHR
 * @Date : Create in 10:01 2017/10/22
 * @Email : 13435500980@163.com
 */
@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:chat.properties"})
@SpringBootTest
public class ChatApplicationTest {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private ChatService chatService;
//
//    @Autowired
//    private ChannelManager manager;
//
//    @Autowired
//    private UserAuthHandler handler;

    @Test
    public void testUserDao() {
        User user = userDao.findById(2).get();
        System.out.println(user);
    }

    @Test
    public void testNumber() {
       byte a = 0x10;
       System.out.println(a);
    }

    @Test
    public void testService(){
//       handler.test();
    }

}
