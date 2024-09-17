package com.zipsh.zipshare.dto;

public class pageDto {
    private Long id;
    private String codePage;

    public pageDto(Long id, String codePage) {
        this.id = id;
        this.codePage = codePage;
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
}
