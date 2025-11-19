package com.huangming.wecook.controller;

import com.huangming.wecook.dataclass.ChatRequest;
import com.huangming.wecook.dataclass.ChatResponse;
import com.huangming.wecook.dataclass.Ingredient;
import com.huangming.wecook.dataclass.Message;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/llm")
public class ChatController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> handleChat(@RequestBody ChatRequest request) {
        List<Message> messages = request.getMessages();
        List<Ingredient> ingredients = request.getIngredients();

        for (Ingredient ingredient : ingredients) {
            System.out.println("name = "+ingredient.getName()+"\n");
            System.out.println("category = "+ingredient.getCategory()+"\n");
            System.out.println("weightInGram = "+ingredient.getWeightInGrams()+"\n");
            System.out.println("purchase date = "+ingredient.getPurchaseDate()+"\n");
        }

        ChatResponse pythonResponse = restTemplate.postForObject(
                "http://localhost:8000/chat",  // Python API URL
                request,                        // 发送 ChatRequest JSON
                ChatResponse.class               // 接收 Python 返回 JSON
        );

        return ResponseEntity.ok(pythonResponse);
    }
}
