package com.zipsh.zipshare.service.implservice;


import com.zipsh.zipshare.dto.PageDto;
import com.zipsh.zipshare.mapper.MapPage;
import com.zipsh.zipshare.model.Page;
import com.zipsh.zipshare.repository.pageRepository;
import com.zipsh.zipshare.service.ServicePage;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ImplServicePage implements ServicePage {

    private pageRepository pageRepository;
    public ImplServicePage(pageRepository repository){
        this.pageRepository = repository;
    }
    //Falta finalizar a logica e os metodos
    @Override
    public PageDto postPage(PageDto pageDto) {
        Page page = MapPage.mapToEnt(pageDto);
        page.setId(UUID.randomUUID());
        Page pageSave = pageRepository.save(page);
        return MapPage.mapToDto(pageSave);
    }

    @Override
    public List<PageDto> getPage() {
        List<Page> pageList = pageRepository.findAll();
        return pageList.stream().map((page) -> MapPage.mapToDto(page)).collect(Collectors.toList());
    }

    @Override
    public PageDto getPageCode(String code) {
        //trocar id por uuid
        Date datePage = new Date(System.currentTimeMillis());
        Page page = pageRepository.getBycodePage(code);
        if(page == null){
            Page newPage = new Page(UUID.randomUUID(), code,datePage);
            return MapPage.mapToDto(pageRepository.save(newPage));
        }
        return MapPage.mapToDto(page);

        //return mapPage.mapToDto(pageRepository.findByString(code));
    }

    @Override
    public void delPage(Long id) {
        Page page = pageRepository.findById(id).orElseThrow();
        pageRepository.delete(page);
    }
}
