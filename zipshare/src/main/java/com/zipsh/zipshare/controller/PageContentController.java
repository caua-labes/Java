package com.zipsh.zipshare.controller;

import com.zipsh.zipshare.dto.PageContentDto;
import com.zipsh.zipshare.mapper.MapPageContent;
import com.zipsh.zipshare.model.PageContent;
import com.zipsh.zipshare.service.ServicePageContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("zipsh/pageContent")

public class PageContentController {

    private final ServicePageContent serviceContent;

    public PageContentController(ServicePageContent serviceContent){
        this.serviceContent = serviceContent;
    }
    @PostMapping
    public ResponseEntity<PageContentDto> postPageContent (@RequestBody PageContentDto content){
        PageContentDto pageContentSaved = serviceContent.postPageContent(content);
        return new ResponseEntity<>(pageContentSaved, HttpStatus.CREATED);
    }

    @GetMapping("{pageId}")
    public ResponseEntity<List<PageContentDto>> getPageContent (@PathVariable("pageId") UUID pageId){
        List<PageContentDto> listContent = serviceContent.getPageContent(pageId);
        return new ResponseEntity<>(listContent, HttpStatus.OK);
    }


}
