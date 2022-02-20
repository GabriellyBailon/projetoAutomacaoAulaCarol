import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestePagina {

    //Variáveis Globais
    private WebDriver driver;
    private String url;

    //Executado antes de cada teste em todos os testes
    // Pré-condição
    @BeforeMethod
    public void before()
    {
        String caminhoDriver = "C:\\driver\\chromedriver.exe"; //Caminho do driver
        url = System.getProperty("user.dir") + "src/paginas/componentes.html"; //Url da página
        System.setProperty("webdriver.chrome.driver", caminhoDriver);//instancia do driver
        driver = new ChromeDriver(); //instancia do navegador, nesse caso estamos usando o Chrome

    }

    //Testes
    //Executa na setinha verde ao lado
    @Test
    public void campoDeTreinamento() throws InterruptedException {
        driver.get("file:///C:/Users/gabri/OneDrive/%C3%81rea%20de%20Trabalho/Trabalho%20Pratico%202%20ESII/ufvjm_alunos/ufvjm_alunos/src/paginas/componentes.html");

        //Como fazer em uma linha
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Gabrielly");

        //Fazendo separadamente usando variaveis
        WebElement sobrenome = driver.findElement(By.id("elementosForm:sobrenome"));
        sobrenome.sendKeys("Bailon");

        WebElement sexo = driver.findElement(By.id("elementosForm:sexo:1")); //Pega uma opção
        sexo.click();

        //Selecionando as comidas
        WebElement comida = driver.findElement(By.name("elementosForm:comidaFavorita")); //Pega uma caixinha
        comida.click();

        WebElement comida2 = driver.findElement(By.id("elementosForm:comidaFavorita:1")); //Pega uma caixinha
        comida2.click();

        //Pega a lista de opções
        Select listaEscolaridade = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
        listaEscolaridade.selectByVisibleText("Doutorado");

        //Selecionar Natação
        Select listaEsportes = new Select(driver.findElement(By.id("elementosForm:esportes")));
        listaEsportes.selectByVisibleText("Natacao");

        //Enviar sugestões
        WebElement sugestao = driver.findElement(By.id("elementosForm:sugestoes"));
        sugestao.sendKeys("Muito interessante o exercício");

        //Marcar checkbox da linha Maria
        WebElement checkbox = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[2]/td[4]/input"));
        checkbox.click();

        //Marcar radio da linha Usuario A
        WebElement radio = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[3]/td[5]/table/tbody/tr/td/input"));
        radio.click();

        //Preencher input da linha Usuario B
        WebElement inputLinhaB = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[5]/td[6]/input"));
        inputLinhaB.sendKeys("Envio de input");

        //Botão de enviar
        WebElement botaoCadastro = driver.findElement(By.id("elementosForm:cadastrar"));
        botaoCadastro.click();

        //Cadastro
        //É um WebElement mas com o getText, se transforma em String
        String resultado = driver.findElement(By.xpath("/html/body/center/div[2]/span")).getText();

        //Assert de exemplo
        Assert.assertEquals(resultado, "Cadastrado!");

    }

    //Executado depois de cada teste
    //Pós-condição
    @AfterMethod
    public void after() throws InterruptedException {
        //Thread.sleep(1500);
        //driver.quit();
    }

}
