import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TesteHtml {

    //Variáveis Globais
    private WebDriver driver;
    private String url;

    //Executado antes de cada teste em todos os testes
    // Pré-condição
    @BeforeMethod
    public void before()
    {
        String caminhoDriver = "C:\\driver\\chromedriver.exe"; //Caminho do driver
        url = System.getProperty("user.dir") + "/src/paginas/olaMundo.html"; //Url da página
        System.setProperty("webdriver.chrome.driver", caminhoDriver);//instancia do driver
        driver = new ChromeDriver(); //instancia do navegador, nesse caso estamos usando o Chrome

    }

    //Testes
    //Executa na setinha verde ao lado
    @Test
    public void testeCliqueGoogle()
    {
        //Se for digitar um link, coloque http antes
        driver.get("http://google.com.br"); //Entra na página passada pelo url
        WebElement desenho = driver.findElement(By.id("hplogo")); //Pega algum elemento pelo Id
        desenho.click();    //Clica no desenho acima

    }

    //Testes
    //Executa na setinha verde ao lado
    @Test
    public void testeBuscaGoogle() throws InterruptedException {
        //Se for digitar um link, coloque http antes
        driver.get("http://google.com.br"); //Entra na página passada pelo url
        WebElement busca = driver.findElement(By.name("q")); //Pega o campo de busca pelo nome
        busca.sendKeys("Teste de software");   //Digita os dados para o elemento de busca
        Thread.sleep(1500);
        WebElement resultadoLista = driver.findElement(By.className("wM6W7d"));
        resultadoLista.click();
        WebElement cwi = driver.findElement(By.partialLinkText("https://cwi.com.br"));
        cwi.click();

    }

    //Executado depois de cada teste
    //Pós-condição
    @AfterMethod
    public void after()
    {
        //driver.quit();
    }
}
