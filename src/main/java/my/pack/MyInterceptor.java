package my.pack;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        response.setCharacterEncoding("UTF-8");

        String uri = request.getRequestURI().replace(request.getContextPath(), "");

        if (uri.startsWith("/api/forward")) {
            request.getRequestDispatcher(uri.replace("forward", "")).forward(request, response);
            return false;
        }
        return true;
    }
}
