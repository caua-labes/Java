package com.zipsh.zipshare.mapper;

import com.zipsh.zipshare.dto.pageDto;
import com.zipsh.zipshare.model.page;

public class mapPage {

    public static page mapToEnt(pageDto dtoContent){
        return new page(
                dtoContent.getId(),
                dtoContent.getCodePage(),
                dtoContent.getDatePage()
        );
    }
    public static pageDto mapToDto(page content){
        return new pageDto(
                content.getId(),
                content.getCodePage(),
                content.getDatePage()
        );
    }
}
