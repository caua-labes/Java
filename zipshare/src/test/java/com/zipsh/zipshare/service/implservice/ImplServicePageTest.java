package com.zipsh.zipshare.service.implservice;

import com.zipsh.zipshare.mapper.MapPage;
import com.zipsh.zipshare.model.Page;
import com.zipsh.zipshare.repository.pageRepository;
import com.zipsh.zipshare.service.ServicePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImplServicePageTest {

    @Mock
    private pageRepository mockRepository;

    @InjectMocks
    private ImplServicePage servicePage;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void postPage() {

    }

    @Test
    void getPageCode() {
        Page pageResult = new Page(UUID.fromString("100b98ca-dac1-467f-b14b-4ed03eb90d13"),"asd",LocalDate.parse("2024-10-03"));
        when(mockRepository.getBycodePage("asd")).thenReturn(pageResult);
        var resultado = servicePage.getPageCode("asd");
        assertEquals(pageResult.getId(), MapPage.mapToEnt(resultado).getId());
    }
    @Test
    void getPageCodeNull(){
        String result = "Pagina não encontrada"
    }

    @Test
    void delPage() {
    }

    @Test
    void deletePageByDate() {
    }
}