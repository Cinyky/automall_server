package personal.cyy.automall.component;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yuyunchen
 * @date 2019/12/17 16:19
 * @email cyy1079276272@163.com
 */
@Component
public class UrlComponent implements ApplicationListener<WebServerInitializedEvent> {
    private int serverPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }

    public int getPort() {
        return this.serverPort;
    }

    public String getUrl() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        return String.format("http://%s:%d", address.getHostAddress(), serverPort);
    }
}
