package personal.cyy.automall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import personal.cyy.automall.component.SpingApplicationContext;
import personal.cyy.automall.log.GameLog;
import personal.cyy.automall.service.inter.IService;

import java.util.Collection;

@SpringBootApplication
@EnableWebSecurity // 启用 web 安全
public class AutomallApplication {

    public static void main(String[] args) {
        GameLog.SYS.info("auto mall start ... ");
        SpringApplication.run(AutomallApplication.class, args);
        Collection<IService> iServices = SpingApplicationContext.getApplicationContext().getBeansOfType(IService.class).values();
        iServices.stream().forEach(iService ->
                {
                    long beginTimeMillis = System.currentTimeMillis();
                    GameLog.SYS.info("serive {} init start ...", iService.getClass().getSimpleName());
                    iService.init();
                    GameLog.SYS.info("serive {} init sucess spend time {} ms", iService.getClass().getSimpleName(), System.currentTimeMillis() - beginTimeMillis);
                }
        );
        GameLog.SYS.info("auto mall sunccess!");
    }

}
