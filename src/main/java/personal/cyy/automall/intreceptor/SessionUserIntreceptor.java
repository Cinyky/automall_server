package personal.cyy.automall.intreceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import personal.cyy.automall.constant.ExcludeUri;
import personal.cyy.automall.constant.SessionCheckType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * 会话拦截器
 * 没有登录成功的用户除了登录&资源无法访问其他页面
 *
 * @Author： Cyy
 * @Date: 2018/6/1
 * @Time: 上午11:16
 * ========================
 */
public class SessionUserIntreceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println(request.getRequestURI());

        ExcludeUri[] all = ExcludeUri.getAll();
        String requestURI = request.getRequestURI();
        boolean isExcluded = false;

        for (ExcludeUri excludeUri : all) {
            int type = excludeUri.getType();
            String value = excludeUri.getValue();
            SessionCheckType sessionCheckType = SessionCheckType.getByValue(type);

            switch (sessionCheckType) {
                case EQUAL:
                    isExcluded = requestURI.equals(value);
                    break;
                case CONTAIN:
                    isExcluded = requestURI.contains(value);
                    break;
                default:
                    break;
            }
            if (isExcluded) {
                break;
            }

        }
        if (isExcluded) {
            return true;
        }
        //验证session是否存在
        Object obj = request.getSession().getAttribute("_session_user");
        if (obj == null) {
            try {
                response.sendRedirect("/user/login_view");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
