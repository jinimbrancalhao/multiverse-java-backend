package com.pluralsight.pluralsightdemo.controllers;

import com.pluralsight.pluralsightdemo.models.Message;
import com.pluralsight.pluralsightdemo.repositories.MessageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageRepository messageRepository;

    @GetMapping
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Message> getMessage(@PathVariable Long id) {
        return messageRepository.findById(id);
    }

    @PostMapping
    public void createMessage(@RequestBody final Message message) {
        messageRepository.save(message);
        messageRepository.flush();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteMessage(@PathVariable Long id) {
        messageRepository.deleteById(id);
        return "Message Deleted";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Message updateMessage(@PathVariable Long id, @RequestBody Message message) {

        Message existingMessage = messageRepository.findById(id).orElseThrow(() -> new IllegalStateException("Message does not exist"));
        BeanUtils.copyProperties(message, existingMessage, "messageId");
        messageRepository.save(existingMessage);

        return existingMessage;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Message patchMessage(@PathVariable Long id, @RequestBody Message message) {
        Message existingMessage = messageRepository.findById(id).orElseThrow(() -> new IllegalStateException("Message does not exist"));
        BeanUtils.copyProperties(message, existingMessage, "messageId");
        messageRepository.save(existingMessage);

        return existingMessage;

    }
}
