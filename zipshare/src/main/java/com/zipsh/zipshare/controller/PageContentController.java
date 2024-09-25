package com.zipsh.zipshare.controller;

import com.zipsh.zipshare.dto.pageContentDto;
import com.zipsh.zipshare.mapper.mapPageContent;
import com.zipsh.zipshare.model.pageContent;
import com.zipsh.zipshare.service.servicePageContent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zipsh.pageContent.zipshare")
public class PageContentController {

    private servicePageContent servicePageContent;
    private PageContentController(servicePageContent service){
        this.servicePageContent = service;
    }
    @PostMapping
    public ResponseEntity<pageContentDto> postPageContent (@RequestBody pageContent content){
        servicePageContent.postPageContent(mapPageContent.mapToDto(content))
    }



}
