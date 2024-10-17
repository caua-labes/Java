package com.zipsh.zipshare.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "pageContent")
public class PageContent {
    @Id
    private UUID id;
    @ManyToOne
    private Page page;
    private String content;

    public PageContent(UUID id, Page page, String content) {
        this.id = id;
        this.page = page;
        this.content = content;
    }

    public PageContent(){
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
