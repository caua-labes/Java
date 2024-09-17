package com.zipsh.zipshare.model;

public class page {
    private Long id;
    private String codePage;

    public page(long id, String codePage) {
        this.setId(id);
        this.setCodePage(codePage);
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
