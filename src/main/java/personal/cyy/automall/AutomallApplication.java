package personal.cyy.automall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import personal.cyy.automall.log.GameLog;

@SpringBootApplication
public class AutomallApplication {

    public static void main(String[] args) {
        GameLog.SYS.info("auto mall start ... ");
        SpringApplication.run(AutomallApplication.class, args);
        GameLog.SYS.info("auto mall sunccess!");
    }

}
