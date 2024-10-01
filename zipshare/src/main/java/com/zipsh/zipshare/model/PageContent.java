package com.zipsh.zipshare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pageContent")
public class PageContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Page page;
    private String content;

    public PageContent(long id, Page page, String content) {
        this.id = id;
        this.page = page;
        this.content = content;
    }

    public PageContent(){
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
