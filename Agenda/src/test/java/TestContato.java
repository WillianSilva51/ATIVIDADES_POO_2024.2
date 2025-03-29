import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestContato {
    
    @Test
    public void inicializacao(){
        Contato contato = new Contato("Alex");
        assertEquals("Alex", contato.getNome(),
            "Ao inicializar um contato, o seu nome deve ser igual ao informado no construtor.");
        assertEquals(0, contato.getQuantidadeFones(),
            "Ao inicializar um contato, não deve haver fones na lista de fones.");
    }

    @Test
    public void adicionarFoneValido(){
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone(Tipo.CASA, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato.adicionarFone(new Fone(Tipo.TRABALHO, "(16)69902-3026")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertEquals(2, contato.getQuantidadeFones(),
                "Ao adicionar telefones válidos, eles serão salvos na lista de telefones do contato.");
    }

    @Test
    public void adicionarFoneInvalido(){
        Contato contato = new Contato("Alex");
        assertFalse(contato.adicionarFone(new Fone(Tipo.CASA, "(59)195.36-20[5]4")),
            "Não deve ser possível adicionar um fone a um contato se o número estiver incorreto.");
        assertFalse(contato.adicionarFone(new Fone(Tipo.TRABALHO, "(59)num1597-753")),
            "Não deve ser possível adicionar um fone a um contato se o número estiver incorreto.");
    }

    @Test
    public void removerFoneExistente(){
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone(Tipo.CASA, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato.adicionarFone(new Fone(Tipo.TRABALHO, "(14)49574-2545")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato.removerFone(0),
            "Deve ser possível remover um contato se o index informado estiver presente na lista de fones.");
        assertTrue(contato.adicionarFone(new Fone(Tipo.CELULAR, "(71)22666-0341")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato.removerFone(1),
            "Deve ser possível remover um contato se o index informado estiver presente na lista de fones.");
    }

    @Test
    public void removerFoneInexistente(){
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone(Tipo.CASA, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertFalse(contato.removerFone(2),
            "Não deve ser possível remover um contato se o index informado não estiver presente na lista de fones.");
        assertFalse(contato.removerFone(-1),
            "Não deve ser possível remover um contato se o index informado não estiver presente na lista de fones.");
    }
}
