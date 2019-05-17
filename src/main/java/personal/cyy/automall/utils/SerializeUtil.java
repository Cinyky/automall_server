package personal.cyy.automall.utils;

import java.io.*;

/**
 * Created by Administrator on 14-5-20.
 */
public class SerializeUtil {
    public static byte[] serialize(Object object) {
        try {
            //序列化
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object deSerialize(byte[] value) {

        try {
            //反序列化
            InputStream bais = new ByteArrayInputStream(value);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
