package lg.dao;

import lg.domain.TUser;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * author: LG
 * date: 2019-10-08 18:42
 * desc:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUpdate(){

        System.out.println("init");

        List<Map<String, Object>> maps = userDao.queryBySome();

        List<TUser> tusers = TUser.getTusers(maps);


    }

    @Test
    public void create(){

       System.out.println("init");
      userDao.createTable("aaa");

    }





}