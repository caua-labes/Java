package entidades;

import java.util.List;

public class empresa {
    private  int id;
    private String nome;
    private List<departamentos> departamentosList;

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

    public List<departamentos> getDepartamentosList() {
        return departamentosList;
    }

    public void setDepartamentosList(List<departamentos> departamentos) {
        this.departamentosList = departamentos;
    }
}
