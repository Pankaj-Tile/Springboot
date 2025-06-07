package com.smartcontact.project1.helper;

public class message {
    private String Content;
    private String type;
    public message(String content, String type) {
        this.Content = content;
        this.type = type;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
}
