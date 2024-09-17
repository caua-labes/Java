package com.zipsh.zipshare.mapper;

import com.zipsh.zipshare.dto.pageContentDto;
import com.zipsh.zipshare.model.pageContent;
import org.springframework.web.bind.annotation.Mapping;

public class mapPageContent {

    public static pageContent mapToEnt(pageContentDto contentDto){
        return new pageContent(
                contentDto.getId(),
                mapPage.mapToEnt(contentDto.getPage()),
                contentDto.getContent()
        );
    }
    public static pageContentDto mapToDto(pageContent content){
        return new pageContentDto(
                content.getId(),
                content.getContent(),
                mapPage.mapToDto(content.getPage())
        );
    }
}
