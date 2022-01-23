package day_05mavenİlkProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FirstMavenClass {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //2- arama kutusunu locate edelim
     driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
       WebElement kutu= driver.findElement(By.id("twotabsearchtextbox"));
       kutu.sendKeys("Samsung headphones"+ Keys.ENTER);
      // driver.findElement(By.id("nav-search-submit-button")).click();

       //4- Bulunan sonuc sayisini yazdiralim

        System.out.println(driver.findElement(By.xpath("(//span[@dir='auto'])[1]")).getText());
        //5- Ilk urunu tiklayalim

        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        //6- Sayfadaki tum basliklari yazdiralim

        driver.navigate().back();
        List<WebElement> başlıklar=driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        System.out.println("baslık sayısı: "+başlıklar.size());

        driver.close();
    }

}
