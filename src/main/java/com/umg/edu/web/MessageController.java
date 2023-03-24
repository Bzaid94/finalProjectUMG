package com.umg.edu.web;

import com.umg.edu.entity.Message;
import com.umg.edu.manager.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {
    @Autowired
    private MessageManager messageManager;

    @PostMapping("/new/")
    public Message saveMessage(@RequestBody Message message) {
        message.setStatus(true);
        return messageManager.saveMessage(message);
    }

    @GetMapping("/get/{id}/")
    public Message getMessageById(@PathVariable("id") Long id) {
        return messageManager.getMessageById(id);
    }

    @GetMapping("/listAll/")
    public List<Message> getMessageList() {
        return messageManager.getAllMessages();
    }

    @PutMapping("/update/{id}/")
    public Message updateMessage(@RequestBody Message message, @PathVariable("id") Long id) {
            return messageManager.updateMessage(message, id);
    }

    @DeleteMapping("/delete/{id}/")
    public String deleteMessageById(@PathVariable("id") Long id){
        messageManager.deleteMessage(id);
        return "Message deleted successfully";
    }

    @DeleteMapping("/deleteList/")
    public String deleteListMessageById(@RequestBody List<Long> ids){
        messageManager.deleteListMessage(ids);
        return "Messages deleted successfully";
    }

    @PostMapping("/activeMessage/{id}/")
    public String activeMessageById(@PathVariable("id") Long id){
            messageManager.activateMessage(id);
        return "Messages activated";
    }
}