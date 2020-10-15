
package lg.websocket_ws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Slf4j
@Component
public class WebSocketInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {
        log.info("握手开始");
        // 获得请求参数
        if (request instanceof ServletServerHttpRequest) {
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();

            // 获取请求连接之前的token参数.
            Enumeration enu = servletRequest.getParameterNames();
            while (enu.hasMoreElements()) {
                String paraName = (String) enu.nextElement();

                if (paraName.equalsIgnoreCase("token")) {
                    // 放入属性域
                    attributes.put("token", servletRequest.getParameter(paraName));
                    log.info("用户id" + servletRequest.getParameter(paraName) + " 握手成功！");
                    return true;
                }

            }

            // 从session中获取到当前登录的用户信息. 作为socket的账号信息.
            // session的的WEBSOCKET_USERNAME信息,在用户打开页面的时候设置.
            // String userName = (String)
            // servletRequest.getSession().getAttribute("WEBSOCKET_USERNAME");
            // attributes.put("WEBSOCKET_USERNAME", userName);
        }

        return false;
    }

    /**
     * 握手后
     *
     * @param request
     * @param response
     * @param wsHandler
     * @param exception
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Exception exception) {
        log.info("握手完成");
    }
}