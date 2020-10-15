package lg.dao;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Data
public class DaoCenter {
    /**
     * 被EntityManager持久化到数据库中的对象，或者从数据库拉入内存中的对象，
     * 也会同时被一个持久化上下文（PersistenceContext）管理。
     * 这些被管理的对象统称为受管对象（Managed Object），每个受管对象都有一个唯一的id。
     * EntityManager和PersistenceContext之间的关系，一般可以是多对一的，
     * 即多个EntityManager可以同时指向一个PersistenceContext。
     * 这其实很好理解，就是EntityManager虽然有多个实例，但是它们背后的持久化上下文却只有一个，
     * 这样就保证了多个EntityManager所管理的受管对象拥有的ID是唯一的。
     *
     * 受到容器托管的EntityManager可以直接通过注解@PersistenceContext注入的方式来获得
     */
    @PersistenceContext
    private EntityManager entityManager;
     
}