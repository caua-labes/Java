package com.zipsh.zipshare.service.implservice;

import com.zipsh.zipshare.dto.PageContentDto;
import com.zipsh.zipshare.exceptions.NotFound;
import com.zipsh.zipshare.mapper.MapPage;
import com.zipsh.zipshare.mapper.MapPageContent;
import com.zipsh.zipshare.model.PageContent;
import com.zipsh.zipshare.repository.pageContentRepository;
import com.zipsh.zipshare.service.ServicePageContent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplServicePageContent implements ServicePageContent {
    private pageContentRepository pageContentRepository;
    public ImplServicePageContent(pageContentRepository pageContentRepository){
        this.pageContentRepository = pageContentRepository;
    }
    @Override
    public PageContentDto postPageContent(PageContentDto pageContentDto) {
        PageContent page = pageContentRepository.save(MapPageContent.mapToEnt(pageContentDto) );
        return MapPageContent.mapToDto(page);
    }

    @Override
    public List<PageContentDto> getPageContent(Long pageId) {
        return pageContentRepository.findAll().stream().filter(content -> content.getPage().getId().equals(pageId)).map((content) -> MapPageContent.mapToDto(content)).collect(Collectors.toList());
    }

    @Override
    public PageContentDto getByIdPageContent(Long id) {
        return MapPageContent.mapToDto(pageContentRepository.findById(id).orElseThrow(() -> new NotFound("Erro ao pegar o conteudo por id")));
    }

    @Override
    public PageContentDto putPageContent(Long id, PageContentDto pageContent) {
        PageContent pageC = pageContentRepository.findById(id).orElseThrow(() -> new NotFound("Erro ao alterar o conteudo"));
        pageC.setPage(MapPage.mapToEnt(pageContent.getPage()));
        pageC.setContent(pageC.getContent());
        return MapPageContent.mapToDto(pageContentRepository.save(pageC));
    }

    @Override
    public void delPageContent(Long id) {
        pageContentRepository.deleteById(pageContentRepository.findById(id).orElseThrow(() -> new NotFound("Erro ao deletar o conteudo da pagina")).getId());
    }
}
