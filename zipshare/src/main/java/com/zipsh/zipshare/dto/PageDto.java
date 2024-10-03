package com.zipsh.zipshare.dto;

import java.util.Date;
import java.util.UUID;

public class PageDto {
    private UUID id;
    private String codePage;
    private Date datePage;

    public PageDto(UUID id, String codePage, Date datePage) {
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

    public Date getDatePage() {
        return datePage;
    }

    public void setDatePage(Date datePage) {
        this.datePage = datePage;
    }
}
