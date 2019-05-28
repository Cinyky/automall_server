package personal.cyy.automall.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Cinyky
 * @Date 17:46 2019-05-16
 */


public interface GameLog {
    /**
     * 系统操作记录日志
     */
    Logger SYS = LoggerFactory.getLogger("sys");
    /**
     * 用户操作记录日志
     */
    Logger USER = LoggerFactory.getLogger("user");
    /**
     * 支付日志
     */
    Logger PAY = LoggerFactory.getLogger("pay");
    /**
     * 游戏内错误统一使用此日志方式
     */
    Logger ERROR = LoggerFactory.getLogger("error");
}

