package com.zipsh.zipshare.dto;

public class pageContentDto {
    private long id;

    public pageDto getPage() {
        return page;
    }

    public void setPage(pageDto page) {
        this.page = page;
    }

    private pageDto page;
    private String content;

    public pageContentDto(long id, String content, pageDto pageDto) {
        this.id = id;
        this.content = content;
        this.page = pageDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
