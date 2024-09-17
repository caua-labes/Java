package com.zipsh.zipshare.model;

public class pageContent {
    private long id;
    private page page;
    private String content;

    public pageContent(long id, page page, String content) {
        this.id = id;
        this.page = page;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public com.zipsh.zipshare.model.page getPage() {
        return page;
    }

    public void setPage(com.zipsh.zipshare.model.page page) {
        this.page = page;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
