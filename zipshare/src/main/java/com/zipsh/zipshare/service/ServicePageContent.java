package com.zipsh.zipshare.service;

import com.zipsh.zipshare.dto.PageContentDto;

import java.util.List;

public interface ServicePageContent {
    PageContentDto postPageContent (PageContentDto pageContentDto);
    List<PageContentDto> getPageContent (Long pageId);
    PageContentDto getByIdPageContent (Long id);
    PageContentDto putPageContent (Long id, PageContentDto pageContent);
    void delPageContent (Long id);
}
