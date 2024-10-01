package com.zipsh.zipshare.service;

import com.zipsh.zipshare.dto.PageDto;

import java.util.List;

public interface ServicePage {
    PageDto postPage(PageDto pageDto);
    List<PageDto> getPage();
    PageDto getPageCode(String code);
    void delPage(Long id);

}
