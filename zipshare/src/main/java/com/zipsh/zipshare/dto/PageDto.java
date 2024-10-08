package com.zipsh.zipshare.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class PageDto {
    private UUID id;
    private String codePage;
    private LocalDate datePage;

    public PageDto(UUID id, String codePage, LocalDate datePage) {
        this.id = id;
        this.codePage = codePage;
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
