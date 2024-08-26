package testes;

import classe.FuncoesDeCalculos;
import org.junit.Test;

import static org.junit.Assert.*;
public class FuncoesDeCalculosTest {

    /*@Test
    public void soma() {
        int resultato= FuncoesDeCalculos.Soma(1,2);
        assertEquals(resultato, 3);
    }

    @Test
    public void subtracao() {
        int resultato = FuncoesDeCalculos.Subtracao(1,2);
        assertEquals(resultato,-1);
    }

    @Test
    public void multiplicacao() {
        int resultato = FuncoesDeCalculos.Multiplicacao(1,2);
        assertEquals(resultato,2);
    }

    @Test
    public void divisao() {
        int resultato = FuncoesDeCalculos.Divisao(1,2);
        assertEquals(resultato,0);
    }*/
    @Test
    public void funcoesDeCalculos() {
        int resultado = FuncoesDeCalculos.funcoesDeCalculos("+",1,2);
        assertEquals(3,resultado);
    }
}