package com.zipsh.zipshare.service.implservice;

import com.zipsh.zipshare.dto.PageDto;
import com.zipsh.zipshare.exceptions.NotFound;
import com.zipsh.zipshare.mapper.MapPage;
import com.zipsh.zipshare.model.Page;
import com.zipsh.zipshare.repository.PageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImplServicePageTest {

    @Mock
    private PageRepository mockRepository;

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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> servicePage.getPageCode(null));
        assertEquals("Código não pode ser null",exception.getMessage());
        verify(mockRepository, never()).getBycodePage(null);
    }
    @Test
    void deletePageByDate(){
        PageDto newPage = new PageDto(UUID.randomUUID(),"TestByDateDelete",LocalDate.now().minusMonths(2));
        when(mockRepository.getBycodePage(newPage.getCodePage())).thenReturn(null);
        Exception exception = assertThrows(NotFound.class, () -> servicePage.deletePageByDate(newPage));
        assertEquals("Erro ao deletar a pagina",exception.getMessage());
        // O copilot me recomendou fazer algumas verificações sobre o UUID, mesmo que eu não ache muito necessario por o uuid ser gerado no momento
        verify(mockRepository, never()).delete(any(Page.class));
        //Caso ele relate o erro de pagina não encontrada significa que a verificação está funcionando, porem ele sempre mostrara o erro porque a pagina não foi criada no banco de dados
    }
}