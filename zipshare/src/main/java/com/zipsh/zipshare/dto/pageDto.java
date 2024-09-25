package com.zipsh.zipshare.dto;

import java.util.Date;

public class pageDto {
    private Long id;
    private String codePage;
    private Date datePage;

    public pageDto(Long id, String codePage, Date datePage) {
        this.id = id;
        this.codePage = codePage;
        this.setDatePage(datePage);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
