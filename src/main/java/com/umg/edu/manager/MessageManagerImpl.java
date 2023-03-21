package com.umg.edu.manager;

import com.umg.edu.entity.Message;
import com.umg.edu.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MessageManagerImpl implements MessageManager{
    Logger logger = LoggerFactory.getLogger(MessageManagerImpl.class);

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message saveMessage(Message message) {
        logger.info("Message saved {}", message);
        return messageRepository.save(message);
    }

    @Override
    public Message getMessageById(Long id) {
        logger.info("Message by ID {}", id);
        return messageRepository.findById(id).get();
    }

    @Override
    public List<Message> getAllMessages() {
        logger.info("Get all messages");
        return messageRepository.findByStatusTrue();
    }

    @Override
    public Message updateMessage(Message message, Long id) {
        Message messageUpdate = messageRepository.findById(id).get();

        if(Objects.nonNull(message.getMessage()) && !"".equalsIgnoreCase(message.getMessage())){
            messageUpdate.setMessage(message.getMessage());
        }

        if(Objects.nonNull(message.getAuthor()) && !"".equalsIgnoreCase(message.getAuthor())){
            messageUpdate.setAuthor(message.getAuthor());
        }
        logger.info("Message updated {}", messageUpdate);
        return messageRepository.save(messageUpdate);
    }

    @Override
    public void deleteMessage(Long id) {
        logger.info("Message deleted {}", id);
        Message message = messageRepository.findById(id).orElseThrow(()->
        new RuntimeException("Message not found with Id: " + id));
        message.setStatus(false);
        messageRepository.save(message);
    }

    @Override
    public void deleteListMessage(List<Long> ids) {
        logger.info("Messages list deleted {}", ids);
        List<Message> messages = messageRepository.findAllById(ids);
        for (Message message: messages) {
            message.setStatus(false);
        }
        messageRepository.saveAll(messages);
    }

    @Override
    public void activateUser(Long id) {
        Optional<Message> findMessage = messageRepository.findById(id);
        if (findMessage.isPresent()) {
            Message message = findMessage.get();
            message.setStatus(true);
            logger.info("Message activated {}", message);
            messageRepository.save(message);
        } else {
            logger.info("User not found with id {}", id);
            throw new RuntimeException("User not found with id " + id);
        }
    }
}