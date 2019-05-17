package personal.cyy.automall.utils;

import java.util.UUID;

/**
 * @Author Cinyky
 * @Date 20:26 2019-05-16
 */


public class CommonUtils {

    public static String getGUID() {
        String guid = UUID.randomUUID().toString();
        return guid.substring(0, 8) + guid.substring(9, 13)
                + guid.substring(14, 18) + guid.substring(19, 23)
                + guid.substring(24);
    }
}
