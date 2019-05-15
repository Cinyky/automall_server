package personal.cyy.automall.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.cyy.automall.dao.IUserDao;

import javax.annotation.Resource;

/**
 * 用户controller
 * @Author Cinyky
 * @Date 19:58 2019-05-10
 */

@Controller
@RequestMapping("/api/user")
public class UserApi extends IApi {

    @Resource
    IUserDao userDao;


}


