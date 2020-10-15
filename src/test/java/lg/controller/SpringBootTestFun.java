package lg.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * author: LG
 * date: 2020-06-10 11:11
 * desc:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootTestFun {

    @Autowired
    EntityManager entityManager;

    @Test
    public void testEM() {
        Query query = entityManager.createNativeQuery("select name from t_user");
        query.getResultList();
    }
}