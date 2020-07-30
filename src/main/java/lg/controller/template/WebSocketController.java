package lg.controller.template;

import cn.hutool.core.util.StrUtil;
import lg.websocket_ws.WebSocketMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

/**
 * CrossOrigin 解决解决接口跨域的问题
 */
@CrossOrigin
@RestController
public class WebSocketController {
    @Autowired
    private WebSocketMessageHandler webSocketMessageHandler;
    /**
     * 发送消息
     */
    @RequestMapping("/socket/push/{userId}")
    public String pushToWeb(@PathVariable String userId, String message) {

        TextMessage textMessage = new TextMessage(message);
        if (StrUtil.isNotEmpty(userId)) {
            webSocketMessageHandler.sendMessageToUsers(textMessage);
        }else{
            webSocketMessageHandler.sendMessageToUser(userId,textMessage);
        }

        return "推送成功";
    }
}
