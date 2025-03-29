import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(final String[] args) {
        
        Agenda agenda = new Agenda();
        
        Contato contato = new Contato("Adriele");
        contato.adicionarFone(new Fone(Tipo.CASA, "(77)89085-9077"));
        contato.adicionarFone(new Fone(Tipo.CELULAR, "(63)61730-9301"));
        System.out.println(contato); // - Adriele [0:Case:(77)89085-9077] [1:Celular:(63)61730-9301]
        
        Contato contato1 = new Contato("Biatriz");
        contato1.adicionarFone(new Fone(Tipo.TRABALHO, "(80)63810-9092"));
        System.out.println(contato1); // - Biatriz [0:Trabalho:(80)63810-9092]
        
        Contato contato2 = new Contato("Ariele");
        contato2.adicionarFone(new Fone(Tipo.TRABALHO, "(24)62362-1925"));
        contato2.adicionarFone(new Fone(Tipo.CELULAR, "(79)98614-1326"));
        if(!contato2.adicionarFone(new Fone(Tipo.CASA, "(24)62362-abc"))){
            System.out.println("fail: numero de telefone invalido"); //fail: numero de telefone invalido
        }
        System.out.println(contato2); // - Ariele [0:Trabalho:(24)62362-1925] [1:Celular:(79)98614-1326]
        
        agenda.adicionarContato(contato);
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        System.out.println(agenda);
        /*
            - Adriele [0:Claro:(77)89085-9077] [1:Tim:(63)61730-9301]
            - Adriele [0:Casa:(77)89085-9077] [1:Celular:(63)61730-9301]
            - Biatriz [0:Trabalho:(80)63810-9092]
        */

        int quantidade = agenda.getQuantidadeDeFones(Tipo.TRABALHO);
        System.out.println("Total de telefones com o identifcador (Trabalho) é igual a " +  quantidade);
        // Total de telefones com o identifcador (Trabalho) é igual a 2

        Contato contato3 = new Contato("Biatriz");
        contato3.adicionarFone(new Fone(Tipo.CELULAR, "(59)67638-0967"));
        contato3.adicionarFone(new Fone(Tipo.CASA, "(59)67638-0967"));
        agenda.adicionarContato(contato3);
        System.out.println(agenda);
        /*
            - Adriele [0:Casa:(77)89085-9077] [1:Celular:(63)61730-9301]
            - Ariele [0:Trabalho:(24)62362-1925] [1:Celular:(79)98614-1326]
            - Biatriz [0:Trabalho:(80)63810-9092] [1:Celular:(59)67638-0967] [2:Casa:(59)67638-0967]
        */

        agenda.removerFone("Adriele", 1);
        System.out.println(agenda);
        /*
            - Adriele [0:Casa:(77)89085-9077]
            - Ariele [0:Trabalho:(24)62362-1925] [1:Celular:(79)98614-1326]
            - Biatriz [0:Trabalho:(80)63810-9092] [1:Celular:(59)67638-0967] [2:Casa:(59)67638-0967]
        */

        int quantidadeTotal = agenda.getQuantidadeDeFones();
        System.out.println("Total de telefones cadastrados na agenda é igual a " + quantidadeTotal);
        //"Total de telefones cadastrados na agenda é igual a 6

        if(!agenda.removerContato("Alex")){
            System.out.println("fail: nome do contato não esta cadastrado na agenda"); 
            // fail: nome do contato não esta cadastrado na agenda
        }

        List<Contato> resultados = agenda.pesquisar("le");
        for(Contato resultado : resultados)
            System.out.println(resultado.toString());
        /*
            - Adriele [0:Casa:(77)89085-9077]
            - Ariele [0:Trabalho:(24)62362-1925] [1:Celular:(79)98614-1326]
        */
    }
}
