package com.zipsh.zipshare.service;

import com.zipsh.zipshare.dto.PageContentDto;

import java.util.List;
import java.util.UUID;

public interface ServicePageContent {
    PageContentDto postPageContent (PageContentDto pageContentDto);
    List<PageContentDto> getPageContent (UUID pageId);
    PageContentDto getByIdPageContent (UUID id);
    PageContentDto putPageContent (UUID id, PageContentDto pageContent);
    void delPageContent (UUID id);
}
