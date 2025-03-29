import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestFone {

    @Test
    public void inicializacao(){
        Fone fone = new Fone(Tipo.CASA, "(88)22161-5300");
        Fone fone1 = new Fone(Tipo.TRABALHO, "(88)93162-5665");
        Fone fone2 = new Fone(Tipo.CELULAR, "(35)90429-3605");
        Fone fone3 = new Fone(Tipo.CASA, "(76)95862-9705");
        Fone fone4 = new Fone(Tipo.TRABALHO, "(45)94200-0844");
        Fone fone5 = new Fone(Tipo.CASA, "(59)94762-3373");
        assertEquals(Tipo.CASA, fone.getTipo(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals(Tipo.TRABALHO, fone1.getTipo(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals(Tipo.CELULAR, fone2.getTipo(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals(Tipo.CASA, fone3.getTipo(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals(Tipo.TRABALHO, fone4.getTipo(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals(Tipo.CASA, fone5.getTipo(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals("(88)22161-5300", fone.getNumero(),
            "Ao inicializar um fone, o seu numero deve ser igual ao informado no construtor.");
    }

    @Test
    public void validarFoneComParenteses(){
        Fone fone = new Fone(Tipo.CASA, "(88)22161-5300");
        assertTrue(Fone.eValido(fone.getNumero()),
            "Deve ser possível um numero de telefone que contenha apenas os caracteres - , () , . e digitos de 0-9.");
    }

    @Test
    public void validarFoneSemParenteses(){
        Fone fone = new Fone(Tipo.CASA, "88221615300");
        assertTrue(Fone.eValido(fone.getNumero()),
            "Deve ser possível um numero de telefone que contenha apenas os caracteres - , () , . e digitos de 0-9.");
    }

    @Test
    public void validarFoneComParentesesDeslocado(){
        Fone fone = new Fone(Tipo.CASA, "15642-15(77)");
        assertTrue(Fone.eValido(fone.getNumero()),
            "Deve ser possível um numero de telefone que contenha apenas os caracteres - , () , . e digitos de 0-9.");
    }

    @Test
    public void invalidarFoneComLetra(){
        Fone fone = new Fone(Tipo.CASA, "(99)1564-124a");
        assertFalse(Fone.eValido(fone.getNumero()),
            "Não deve ser possível um numero de telefone que não contenha apenas os caracteres de - , () , . e digitos de 0-9.");
        
    }

    @Test
    public void invalidarFoneComColchetes(){
        Fone fone = new Fone(Tipo.CASA, "991564.124a[]");
        assertFalse(Fone.eValido(fone.getNumero()),
            "Não deve ser possível um numero de telefone que não contenha apenas os caracteres de - , () , . e digitos de 0-9.");
    }
}