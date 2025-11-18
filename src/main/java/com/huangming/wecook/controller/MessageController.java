package com.huangming.wecook.controller;

import com.huangming.wecook.dataclass.Message;
import com.huangming.wecook.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageRepo MessageRepo;

    @GetMapping
    public List<Message> getAllMessages() {
        System.out.println("getAllMessages are called");
        return MessageRepo.findAll();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable Integer id) {
        return MessageRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Integer insertMessage(@RequestBody Message message) {
        Message saved = MessageRepo.save(message);
        return saved.getId();
    }

    @PutMapping
    public void updateMessage(@RequestBody Message message) {
        MessageRepo.save(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Integer id) {
        MessageRepo.deleteById(id);
    }
}

