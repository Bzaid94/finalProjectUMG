package com.umg.edu.manager;

import com.umg.edu.entity.Message;

import java.util.List;

public interface MessageManager {
        Message saveMessage(Message message);

        Message getMessageById(Long id);
        List<Message> getAllMessages();

        Message updateMessage(Message message, Long id);

        void deleteMessage(Long id);

        void deleteListMessage(List<Long> ids);

        void activateUser(Long id);
}