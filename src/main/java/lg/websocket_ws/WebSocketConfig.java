
package lg.websocket_ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketMessageHandler webSocketMessageHandler;
    @Autowired
    private WebSocketInterceptor webSocketInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // registry.addHandler(webSocketMessageHandler, "dmStatistics").addInterceptors(webSocketInterceptor)
        //         .setAllowedOrigins("*");
        // 部分 支持websocket 的访问链接,允许跨域
        registry.addHandler(webSocketMessageHandler, "/websocket").addInterceptors(webSocketInterceptor)
                .setAllowedOrigins("*");
        // 部分 不支持websocket的访问链接,允许跨域
        registry.addHandler(webSocketMessageHandler, "/sockjs/websocket").addInterceptors(webSocketInterceptor)
                .setAllowedOrigins("*").withSockJS();
    }
}
