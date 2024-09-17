package com.zipsh.zipshare.service;

import com.zipsh.zipshare.dto.pageContentDto;
import com.zipsh.zipshare.dto.pageDto;
import org.hibernate.query.Page;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

public interface servicePageContent {
    pageContentDto postPageContent (pageContentDto pageContentDto);
    List<pageContentDto> getPageContent ();
    pageContentDto getByIdPageContent (Long id);
    pageContentDto putPageContent (Long id, pageContentDto pageContent);
    void delPageContent (Long id);
}
