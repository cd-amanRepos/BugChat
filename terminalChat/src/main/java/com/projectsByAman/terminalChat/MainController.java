package  com.projectsByAman.terminalChat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @MessageMapping("/interviews")
    @SendTo("/topic/interviews")
    public Message broadcastInterviewDetails(@Payload Message message) {
        //System.out.println(message.toString());
        return message;
    }

}
