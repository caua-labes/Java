package com.zipsh.zipshare.service.implservice;


import com.zipsh.zipshare.dto.pageContentDto;
import com.zipsh.zipshare.dto.pageDto;
import com.zipsh.zipshare.mapper.mapPage;
import com.zipsh.zipshare.model.page;
import com.zipsh.zipshare.repository.pageRepository;
import com.zipsh.zipshare.service.servicePage;
import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class implServicePage implements servicePage {

    private pageRepository pageRepository;
    public implServicePage(pageRepository repository){
        this.pageRepository = repository;
    }
    //Falta finalizar a logica e os metodos
    @Override
    public pageDto postPage(pageDto pageDto) {
        page page = mapPage.mapToEnt(pageDto);
        page pageSave = pageRepository.save(page);
        return mapPage.mapToDto(pageSave);
    }

    @Override
    public List<pageDto> getPage() {
        List<page> pageList = pageRepository.findAll();
        return pageList.stream().map((page) -> mapPage.mapToDto(page)).collect(Collectors.toList());
    }

    @Override
    public pageDto getPageCode(String code) {
        if(pageRepository.findByString(code).equals(null)){
            return mapPage.mapToDto(pageRepository.save(new page(getPage().size(), code)));
        }
        else{
            return mapPage.mapToDto(pageRepository.findByString(code));
        }
        //return mapPage.mapToDto(pageRepository.findByString(code));
    }

    @Override
    public void delPage(Long id) {

    }
}
