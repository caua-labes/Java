package com.zipsh.zipshare.dto;

public class PageContentDto {
    private long id;

    public PageDto getPage() {
        return page;
    }

    public void setPage(PageDto page) {
        this.page = page;
    }

    private PageDto page;
    private String content;

    public PageContentDto(long id, String content, PageDto pageDto) {
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
