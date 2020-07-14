package lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * author: LG
 * date: 2020-06-03 10:00
 * desc:
 */

@RestController
public class TestController {

    @Autowired
    EntityManager entityManager;

    public void testEM(){
        Query query = entityManager.createQuery("select * from t_user");

    }
}
