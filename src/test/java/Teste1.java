import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Teste1 {

    //Executado antes de cada teste em todos os testes
    // Pré-condição
    @BeforeMethod
    public void before()
    {
        System.out.println("Essa mensagem aparecerá antes de cada teste");
    }

    //Testes
    //Executa na setinha verde ao lado
    @Test
    public void testeValoresDiferentes()
    {
        String nome = "Aline";
        System.out.println("Teste valores diferentes");
        Assert.assertNotEquals(nome, "Aline Zenin");
    }

    @Test
    public void testeValoresIguais()
    {
        String nome = "Aline";
        System.out.println("Teste valores iguais");
        Assert.assertEquals(nome, "Aline");
    }

    @Test
    public void testeContemValor()
    {
        String nome = "Aline";
        System.out.println("Teste contém o valor");
        Assert.assertTrue(nome.contains("Aline"));
    }

    @Test
    public void testeNaoContemValor()
    {
        String nome = "Aline";
        System.out.println("Teste não contém o valor");
        Assert.assertFalse(nome.contains("Carol"));
    }

    //Executado depois de cada teste
    //Pós-condição
    @AfterMethod
    public void after()
    {
        System.out.println("Essa mensagem aparecerá depois de cada teste");
    }
}
