package com.zipsh.zipshare.mapper;

import com.zipsh.zipshare.dto.PageContentDto;
import com.zipsh.zipshare.model.PageContent;

public class MapPageContent {

    public static PageContent mapToEnt(PageContentDto contentDto){
        return new PageContent(
                contentDto.getId(),
                MapPage.mapToEnt(contentDto.getPage()),
                contentDto.getContent()
        );
    }
    public static PageContentDto mapToDto(PageContent content){
        return new PageContentDto(
                content.getId(),
                content.getContent(),
                MapPage.mapToDto(content.getPage())
        );
    }
}
