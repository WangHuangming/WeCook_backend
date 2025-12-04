package com.huangming.wecook.controller;

import com.huangming.wecook.dataclass.ChatRequest;
import com.huangming.wecook.dataclass.ChatResponse;
import com.huangming.wecook.dataclass.Ingredient;
import com.huangming.wecook.dataclass.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/llm")
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> handleChat(@RequestBody ChatRequest request) {
        List<Message> messages = request.getMessages();
        List<Ingredient> ingredients = request.getIngredients();

//        for (Ingredient ingredient : ingredients) {
//            System.out.println("name = "+ingredient.getName()+"\n");
//            System.out.println("category = "+ingredient.getCategory()+"\n");
//            System.out.println("weightInGram = "+ingredient.getWeightInGrams()+"\n");
//            System.out.println("purchase date = "+ingredient.getPurchaseDate()+"\n");
//        }
        log.info("try llm api");
        ChatResponse pythonResponse = restTemplate.postForObject(
                "http://localhost:8000/chat",
                request,
                ChatResponse.class
        );
        log.info("llm api success");
        log.info("\nreply :{}", pythonResponse.getReply());
        return ResponseEntity.ok(pythonResponse);
    }
}
