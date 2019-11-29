package com.jiankongyi.mybatis.impl.junit;

import com.jiankongyi.mybatis.impl.pojo.Menu;
import com.jiankongyi.mybatis.impl.pojo.User;
import net.sf.json.JSONArray;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

public class MybatisFirstTest {

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws Exception {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";

        InputStream in = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void testMybatis() throws Exception {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql
        User user = sqlSession.selectOne("test.findUserById", 10);

        System.out.println(user);
    }

    @Test
    public void testfindUserByUsername() throws Exception {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行sql
        List<User> users = sqlSession.selectList("test.findUserByUsername", "五");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql
        User user = new User();
        user.setUsername("孙云省");
        user.setBirthday(new Date());
        user.setAddress("山东菏泽");
        user.setSex("男");
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();

        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUserById() {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql
        User user = new User();
        user.setId(29);
        user.setUsername("孙云省");
        user.setBirthday(new Date());
        user.setAddress("山东菏泽");
        user.setSex("女");
        sqlSession.update("test.updateUserById", user);
        sqlSession.commit();
    }

    @Test
    public void testDelete() {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUserById", 29);
        sqlSession.commit();
    }

    @Test
    public void testMenu() {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Menu> menuList = sqlSession.selectList("menu.getMenuList");
        Map<Integer, Menu> menuMap = new HashMap<Integer, Menu>();
        List<Menu> menuList1 = new ArrayList<Menu>();
        for (Menu menu : menuList) {
            menuMap.put(menu.getId(), menu);
        }
        for (Menu menu : menuList) {
            if (menu.getPid() == 0) {
                menuList1.add(menu);
            } else {
                menuMap.get(menu.getPid()).addSubMenu(menu);
            }
        }

        JSONArray jsonArray = new JSONArray();
        for (Menu menu : menuList1) {
            menu.toJson(jsonArray);
        }
        String string = jsonArray.toString();
        System.out.println(string);
    }
}
