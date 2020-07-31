package lg.dao;

import lg.domain.TUser;
import lg.domain.UserResp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao extends JpaRepository<TUser, Long>{


    /**
     * 创建数据库
     *
     * 无法动态传参
     * @param tableName
     */
    @Transactional
    @Query(value = "CREATE TABLE ?1 (id SERIAL primary key ,create_time timestamp(6),update_time timestamp(6),test_col varchar(255));",nativeQuery = true)
    @Modifying
    void createTable(String tableName);


    /**
     * 自定义返回
     * @return
     */
    @Query(value = "select age,name from t_user",nativeQuery = true )
    List<Map<String,Object>> queryBySome();


    @Query(value = "select * from t_user where name like %?1%" ,nativeQuery = true)
    List<TUser> queryAny(String name);

    /**
     * 修改必须加事务
     * @param name
     * @param user_id
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "update t_user set name = :na where user_id = :id" ,nativeQuery = true)
    Integer updateSomeThing(@Param("na")String name, @Param("id") Integer user_id);


    /**
     * 多字段模糊查询
     * 多字段排序
     *
     * @param name
     * @param set
     * @param pageable
     * @return
     */
    Page<UserResp> findByNameLikeAndGridSetLikeOrderByIdDescNameAsc(String name, String set, Pageable pageable);




}
