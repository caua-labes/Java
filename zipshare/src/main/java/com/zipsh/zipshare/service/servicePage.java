package com.zipsh.zipshare.service;

import com.zipsh.zipshare.dto.pageContentDto;
import com.zipsh.zipshare.dto.pageDto;
import org.hibernate.query.Page;

import java.util.List;

public interface servicePage {
    pageDto postPage(pageDto pageDto);
    List<pageDto> getPage();
    pageDto getPageCode(String code);
    void delPage(Long id);

}
