package scraper;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Kenny on 11/5/2016.
 */
public class Scraper
{
    public static void main(String[] args) {
        Scraper s = new Scraper();
        s.scrape();

    }
    public void scrape(){
        System.setProperty("webdriver.chrome.driver", this.getClass().getResource("chromedriver.exe").getFile());
        WebDriver webDrive = new ChromeDriver();
        webDrive.get("https://www.edamam.com");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){

        }

        webDrive.findElement(By.xpath("//*[@id=\"search-results\"]/div[2]/div/ul/li[1]")).click();

        //scrape
    }
}

