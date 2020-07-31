package lg.controller.template;

import lg.dao.UserDao;
import lg.domain.TUser;
import lg.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    /**
     * 查看创建时间和修改时间 是否生成
     */
    @GetMapping("randUser")
    public ResponseEntity<TUser> randUser(){
        TUser tUser = new TUser();
        tUser.setAge(new Random().nextInt(10) + 1);
        userDao.save(tUser);
        return  new ResponseEntity(tUser,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 查看创建时间和修改时间的变换
     * @param userid
     * @return
     */
    @PutMapping("editeRandUser")
    public ResponseEntity<TUser> editeRandUser(Long userid){
        TUser user = userDao.getOne(userid);
        user.setAge(new Random().nextInt(10) + 1);
        userDao.save(user);
        return  ResponseEntity.ok(user);
    }


    /**
     * 查看创建时间和修改时间的变换
     *
     * 2020-07-30 19:29:17.61
     * 2020-07-30 19:29:17
     */
    @PutMapping("editeUserCreateTime")
    public ResponseEntity<TUser> editeUserCreateTime(Long userid,String time){
        TUser user = userDao.getOne(userid);
        user.setCreateTime(new Date(TimeUtils.strFormatLong(time)));
        userDao.save(user);
        return  ResponseEntity.ok(user);
    }

    @PutMapping("showTimeZone")
    public void showTimeZone(){
       TimeUtils.showTimeZone();
    }






}
