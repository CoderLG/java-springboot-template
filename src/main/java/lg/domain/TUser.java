package lg.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Data
@Entity
@Table(name="t_user")
public class TUser {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//数据库中的对应字段 user_id
	private Integer userId;


	private Integer age;
	private String name;

	@Column(name = "gridset")
	//数据库中的对应字段 gridset
	private String gridSet;

	//数据库中的对应字段 map_default
	private Integer mapDefault = 0;


	public static List<TUser> getTusers(List<Map<String,Object>> users){
        ArrayList<TUser> tUsers = new ArrayList<>();
        if (users == null || users.size() == 0) {
            return tUsers;
        }
        Set<String> keys = users.get(0).keySet();

        for (Map<String, Object> user : users) {
            TUser tUser = new TUser();

            if(keys.contains("user_id"))
                tUser.setUserId(Integer.valueOf(user.get("user_id").toString()));

            if(keys.contains("age"))
                tUser.setAge(Integer.valueOf(user.get("age").toString()));

            if(keys.contains("name"))
                tUser.setName(user.get("name").toString());

            if(keys.contains("gridset"))
                tUser.setGridSet(user.get("gridset").toString());

            if(keys.contains("map_default"))
                tUser.setMapDefault(Integer.valueOf(user.get("map_default").toString()));

            tUsers.add(tUser);
        }
        return tUsers;
    }
}
