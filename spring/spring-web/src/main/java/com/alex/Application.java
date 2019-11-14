package com.alex;

import com.alex.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Application {
    /*public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontex.xml");
        User user = (User)ac.getBean("user");
        System.out.println(user);

        User user1 = (User)ac.getBean("user");
        System.out.println(user1);

        User user2 = (User)ac.getBean("user2");
        System.out.println(user2);

        User user3 = (User)ac.getBean("user3");
        System.out.println(user3);

        {
            User user4 = (User)ac.getBean("user4");
            System.out.println(user4);
        }
    }
*/
    @Test
    public void Test1() {
        System.out.println(1);
    }
}
