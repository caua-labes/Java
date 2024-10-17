package com.zipsh.zipshare.dto;

import java.util.UUID;

public class PageContentDto {
    private UUID id;

    public PageDto getPage() {
        return page;
    }

    public void setPage(PageDto page) {
        this.page = page;
    }

    private PageDto page;
    private String content;

    public PageContentDto(UUID id, String content, PageDto pageDto) {
        this.id = id;
        this.content = content;
        this.page = pageDto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
