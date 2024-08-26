package entidades;

import java.math.BigDecimal;

public class departamentos {
    private int id;
    private String nome;
    private BigDecimal valorTotalDeVendas;

    public BigDecimal getValorTotalDeVendas() {
        return valorTotalDeVendas;
    }

    public void setValorTotalDeVendas(BigDecimal valorTotalDeVendas) {
        this.valorTotalDeVendas = valorTotalDeVendas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public departamentos(String nome,int id, BigDecimal valorTotalDeVendas) {
        this.nome = nome;
        this.id = id;
        this.valorTotalDeVendas = valorTotalDeVendas;
    }
}
