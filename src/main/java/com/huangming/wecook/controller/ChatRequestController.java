package com.huangming.wecook.controller;

import com.huangming.wecook.dataclass.ChatRequest;
import com.huangming.wecook.dataclass.Ingredient;
import com.huangming.wecook.dataclass.Message;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/llm")
public class ChatRequestController {

    @PostMapping("/chat")
    public ResponseEntity<String> handleChat(@RequestBody ChatRequest request) {
        List<Message> messages = request.getMessages();
        List<Ingredient> ingredients = request.getIngredients();

        System.out.println("Messages: " + messages);
        System.out.println("Ingredients: " + ingredients);

        return ResponseEntity.ok("Received!");
    }
}
