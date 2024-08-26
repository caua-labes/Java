package testes;


import controlador.empresaControle;
import entidades.departamentos;
import entidades.empresa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class empresaControleTest {
    public static empresa empresaE = new empresa();
    @Before
    @Test
    public void salvarDepartamento() {
        List<departamentos> listaDeDepartamento = new ArrayList<departamentos>();
        departamentos departamento1 = new departamentos("Departamento1",1,BigDecimal.valueOf(11099.76));
        listaDeDepartamento.add(departamento1);
        departamentos departamento2 = new departamentos("Departamento2",2,BigDecimal.valueOf(13036.96));
        listaDeDepartamento.add(departamento2);
        departamentos departamento3 = new departamentos("Departamento3",3,BigDecimal.valueOf(16019.65));
        listaDeDepartamento.add(departamento3);
        empresaE.setDepartamentosList(listaDeDepartamento);
    }

    @Test
    public void calcularValorTotalDeDepartamentos() {
        BigDecimal valorTotaldeVendas = new BigDecimal(0);
        for (departamentos departamento : empresaE.getDepartamentosList()) {
            valorTotaldeVendas = valorTotaldeVendas.add(departamento.getValorTotalDeVendas());
        }
        BigDecimal valorTotal = valorTotaldeVendas.divide(new BigDecimal(empresaE.getDepartamentosList().size()),2, RoundingMode.UP);
        Assert.assertEquals("valor diferente, "+ valorTotal, BigDecimal.valueOf(13385.46), valorTotal);
    }
    @Test
    public void verificarDepartamentos() {
        Assert.assertNotNull("Lista vazia ",empresaE.getDepartamentosList());
    }
}