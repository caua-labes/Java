package com.zipsh.zipshare.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;


import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "page")
public class Page {
   @Id
    private UUID id;
    private String codePage;
    //Esse tempo será usado para limpar a pagina depois de um mês
    private LocalDate datePage;

    public Page(){
    }

    public Page(UUID id, String codePage, LocalDate datePage) {
        this.setId(id);
        this.setCodePage(codePage);
        this.setDatePage(datePage);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCodePage() {
        return codePage;
    }

    public void setCodePage(String codePage) {
        this.codePage = codePage;
    }

    public LocalDate getDatePage() {
        return datePage;
    }

    public void setDatePage(LocalDate datePage) {
        this.datePage = datePage;
    }
}
