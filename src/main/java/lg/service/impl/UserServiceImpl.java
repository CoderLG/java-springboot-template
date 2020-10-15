package lg.service.impl;

import lg.dao.impl.UserDao;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * author: LG
 * date: 2019-09-05 13:23
 * desc:
 */
@Service
@Slf4j
@Data
public class UserServiceImpl {

    @Autowired
    private UserDao userDao;



    public void noTransactionalUpdateSomeThing(String name ,int userid){
        userDao.updateSomeThing(name,userid);
    }

    @Transactional
    public void transactionalUpdateSomeThing(String name ,int userid){
        userDao.updateSomeThing(name,userid);
        int aa = 1/0;

   }



    public void transactionalUpdateSomeThing2(String name ,int userid){
        userDao.updateSomeThing(name,userid);
    }

    public void deleteOne(Long id){
        userDao.deleteById(id);
    }

    public void deleteOne2(Long id){
        userDao.deleteById(id);
        int aa = 1/0;
    }

    @Transactional
    public void deleteOne3(Long id){
        userDao.deleteById(id);
        int aa = 1/0;
    }

}
