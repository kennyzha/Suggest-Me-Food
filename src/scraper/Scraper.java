package scraper;

import org.openqa.selenium.WebDriver;
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
        System.out.println(this.getClass().getResource("chromedriver.exe").getFile());
        System.setProperty("webdriver.chrome.driver", this.getClass().getResource("chromedriver.exe").getFile());
        WebDriver webDrive = new ChromeDriver();
    }
}

