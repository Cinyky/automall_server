package personal.cyy.automall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import personal.cyy.automall.component.SpingApplicationContext;
import personal.cyy.automall.log.GameLog;
import personal.cyy.automall.service.inter.IService;

import java.util.Collection;

@SpringBootApplication
public class AutomallApplication {

    public static void main(String[] args) {
        GameLog.SYS.info("auto mall start ... ");
        SpringApplication.run(AutomallApplication.class, args);
        Collection<IService> iServices = SpingApplicationContext.getApplicationContext().getBeansOfType(IService.class).values();
        iServices.stream().forEach(iService ->
                {
                    GameLog.SYS.info("serive {} init start ...", iService.getClass().getSimpleName());
                    iService.init();
                    GameLog.SYS.info("serive {} init sucess", iService.getClass().getSimpleName());
                }
        );
        GameLog.SYS.info("auto mall sunccess!");
    }

}
