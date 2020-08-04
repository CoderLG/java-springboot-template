package lg.controller;

import io.swagger.annotations.Api;
import lg.dao.DaoCenter;
import lg.dao.impl.UserDao;
import lg.domain.TUser;
import lg.dto.req.UserVo;
import lg.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

@Api(tags = "实体操作")
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    DaoCenter daoCenter;

    //============================创建数据库============================
    @PostMapping("createTable")
    @Transactional
    public void createTable(){
        try {
            String createSql = "CREATE TABLE \"public\".\"" + new Random().nextInt(10) + "_data_info\"(\"id\" SERIAL primary key,\"create_time\" timestamp(6),\"update_time\" timestamp(6));";
            log.info("创建数据库 " + createSql);
            daoCenter.getEntityManager().createNativeQuery(createSql).executeUpdate();
        } catch (Exception e) {
            log.error("创建数据库出错",e);
        }
    }
    //============================创建数据库============================



    //============================入参校验============================
    @PostMapping("verifyParams")
    public void verifyParams(@RequestBody  @Validated UserVo userVo){
        log.info(userVo.getUserName());
    }
    //============================入参校验============================



    //============================时间============================
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

    //============================时间============================





}
