/*
 * @Author: your name
 * @Date: 2020-06-06 13:17:04
 * @LastEditTime: 2020-06-08 11:30:02
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: \datamanagerJpa\src\main\java\com\geovis\datamanager\model\BaseEntity.java
 */ 
package lg.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Package: cn.com.geovis.dm.po
 * @ClassName: BaseEntity
 * @Description: po的基类，用来自动插入时间和id；
 * @Author: 李昕哲
 * @CreateDate: 2019/7/17 11:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/7/17 11:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
@ApiModel
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = -8104028530994201645L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @ApiModelProperty(value = "创建时间", example = "2018-05-18 02:21:50", allowEmptyValue = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreatedDate
    private Date createTime ;

    /**
     * 如此也可以
     */
//    @CreatedDate
//    private Date createTime = new Date();


    /**
     * 在配置文件中配置
     */
    @LastModifiedDate
    private Date updateTime;

}
