import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Alert {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Wait жля модальных окон
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        // Переход на начальную страницу
        driver.get("https://mail.google.com");
        Thread.sleep(1500);

        // Развертывание страницы на весь экран
        driver.manage().window().maximize();
        Thread.sleep(1500);

        //Ввод Email, адрес не менять!!!
        WebElement inpEmail = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        inpEmail.sendKeys("yanautomtest6@gmail.com");
        //yanautomtest@gmail.com

        Thread.sleep(1500);
        //Нажатие кнопки "Next"
        WebElement btnNextEmail = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
        btnNextEmail.click();

        Thread.sleep(1500);
        //Ввод пароля
        WebElement inpPass = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        inpPass.sendKeys("Vinnitsa-2022");

        //Нажатие кнопки "Next"
        WebElement btnNextPass = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button"));
        btnNextPass.click();

        Thread.sleep(1500);
        //Открытие письма с кодом доступа
        WebElement emailOpen = driver.findElement(By.xpath("//*[@id=\":24\"]"));
        emailOpen.click();

        Thread.sleep(2500);
        //Считывание кода
        WebElement verCode = driver.findElement(By.xpath
                ("//div[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td/p/code"));
        //div[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td/p/code
        String CopyedText = verCode.getText();


        System.out.println(CopyedText);

        driver.get("https://dex-trade.com/activate-account?email=yanautomte.st.6%40gmail.com");

        org.openqa.selenium.Alert alert = wait.until(alertIsPresent());
        alert.accept();
        Thread.sleep(1500);

        // Развертывание страницы на весь экран
        driver.manage().window().maximize();

        WebElement pasteCode = driver.findElement(By.xpath
                ("//*[@id=\"__layout\"]/div/div[2]/div/div/div/div[2]/div/label/div/input[1]"));

        pasteCode.click();

        pasteCode.sendKeys(CopyedText);

    }


}