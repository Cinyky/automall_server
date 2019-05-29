package personal.cyy.automall.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Cinyky
 * @Date 11:53 2019-05-15
 */

@RestController
@RequestMapping("/security")
public class TestRestController extends IController {


    @RequestMapping("/test")
    public String security() {
        return "hello world security";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/test1")
    public String test1() {
        return "有权限访问 test1";
    }


}
