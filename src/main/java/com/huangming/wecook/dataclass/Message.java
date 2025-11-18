package com.huangming.wecook.dataclass;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String role;
    private String content;

    public Message() {}

    public Message(String content, String role) {
        this.role = role;
        this.content = content;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

}

