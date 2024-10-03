package com.zipsh.zipshare.mapper;

import com.zipsh.zipshare.dto.PageDto;
import com.zipsh.zipshare.model.Page;

public class MapPage {

    public static Page mapToEnt(PageDto dtoContent){
        return new Page(
                dtoContent.getId(),
                dtoContent.getCodePage(),
                dtoContent.getDatePage()
        );
    }
    public static PageDto mapToDto(Page content){
        return new PageDto(
                content.getId(),
                content.getCodePage(),
                content.getDatePage()
        );
    }
}
