package com.huangming.wecook.dataclass;

import java.util.List;

public class ChatRequest {

    private List<Message> messages;
    private List<Ingredient> ingredients;

    public ChatRequest() {}

    public ChatRequest(List<Message> messages, List<Ingredient> ingredients) {
        this.messages = messages;
        this.ingredients = ingredients;
    }

    public List<Message> getMessages() { return messages; }
    public void setMessages(List<Message> messages) { this.messages = messages; }

    public List<Ingredient> getIngredients() { return ingredients; }
    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }
}
