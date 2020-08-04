/*
 * @Description: 
 * @Author: lixz
 * @Date: 2020-05-25 14:57:49
 * @LastEditTime: 2020-05-25 15:27:45
 * @LastEditors: lixz
 */
package lg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface DaoBase<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

  /**
   * JpaRepository 主要特点，将返回类型 Iterable 转换成了List， 并新增了写方法 List<T> findAll();
   * List<T> findAll(Sort sort); List<T> findAll(Iterable<ID> ids); <S extends T>
   * List<S> save(Iterable<S> entities); void flush(); <S extends T> S
   * saveAndFlush(S entity); void deleteInBatch(Iterable<T> entities); void
   * deleteAllInBatch(); T getOne(ID id);
   */
  /**
   * JpaSpecificationExecutor 实现了带条件的查询 T findOne(Specification<T>); List<T>
   * findAll(Specification<T>); List<T> findAll(Specification<T>, Sort); List<T>
   * findAll(Specification<T>, Pageable); long count(Specification<T>);
   */
}
