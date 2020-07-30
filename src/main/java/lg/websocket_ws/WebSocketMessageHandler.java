
package lg.websocket_ws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;



@Slf4j
@Component
public class WebSocketMessageHandler extends TextWebSocketHandler {

    /**
     * socket 建立成功事件
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Object token = session.getAttributes().get("token");
        if (token != null) {
            // 用户连接成功，放入在线用户缓存,使用用户的最后10位来进行判断
            String userToken = token.toString();
            WsSessionManager.add(userToken, session);
        } else {
            throw new RuntimeException("用户登录已经失效!");
        }
    }

    /**
     * 接收消息事件
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 获得客户端传来的消息
        String payload = message.getPayload();
        // Object token = session.getAttributes().get("token");
        log.info("server 接收到的消息是： " + payload);
        // session.sendMessage(
        // new TextMessage("server 发送给 " + token + " 消息 " + payload + " " +
        // LocalDateTime.now().toString()));

    }

    /**
     * socket 断开连接时
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Object token = session.getAttributes().get("token");
        if (token != null) {
            // 用户退出，移除缓存
            String userToken = token.toString();
            WsSessionManager.remove(userToken);
        }
    }

    /**
     * 给指定在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUser(String userId,TextMessage message) {
        WebSocketSession user = WsSessionManager.get_SESSION_POOL().get(userId);
        try {
            if (user.isOpen()) {
                user.sendMessage(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : WsSessionManager.get_SESSION_POOL().values()) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}