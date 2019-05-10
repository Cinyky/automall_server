package personal.cyy.automall.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import personal.cyy.automall.model.User;

import java.util.List;

/**
 * @Author Cinyky
 * @Date 19:56 2019-05-10
 */

@Mapper
public interface IUserDao {
    /**
     * @param user
     * @return
     */
    @Insert("insert into user(name) values(#{name})")
    Boolean insertUser(User user);

    @Select("select * from user where id = #{id}")
    List<User> selectById(@Param("id") String id);

    @Select("select * from user")
    List<User> selectByAll();
}
