package com.zipsh.zipshare.model;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "page")
public class Page {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codePage;
    //Esse tempo será usado para limpar a pagina depois de um mês
    private Date datePage;

    public Page(){
    }

    public Page(String codePage, Date datePage) {
        this.setCodePage(codePage);
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
