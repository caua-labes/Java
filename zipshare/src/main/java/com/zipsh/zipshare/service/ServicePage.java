package com.zipsh.zipshare.service;

import com.zipsh.zipshare.dto.PageDto;
import com.zipsh.zipshare.model.Page;

import java.util.List;
import java.util.UUID;

public interface ServicePage {
    PageDto postPage(PageDto pageDto);
    List<PageDto> getPage();
    PageDto getPageCode(String code);
    void delPage(UUID id);
    void deletePageByDate(PageDto page);
}
