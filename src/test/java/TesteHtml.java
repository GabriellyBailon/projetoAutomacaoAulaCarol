import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TesteHtml {

    //Variáveis Globais
    private WebDriver driver;



    //Executado antes de cada teste em todos os testes
    // Pré-condição
    @BeforeMethod
    public void before()
    {
        String caminhoDriver = "C:\\driver\\chromedriver.exe"; //Caminho do driver
        String url = System.getProperty("user.dir") + "/src/paginas/olaMundo.html"; //Url da página
        System.setProperty("webdriver.chrome.driver", caminhoDriver);//instancia do driver
        driver = new ChromeDriver(); //instancia do navegador
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

    //Executado depois de cada teste
    //Pós-condição
    @AfterMethod
    public void after()
    {
        System.out.println("Essa mensagem aparecerá depois de cada teste");
    }
}
