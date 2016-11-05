package scraper;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        final int SECONDARY_DRIVES = 5;
        System.out.println("hello");
        System.setProperty("webdriver.chrome.driver", this.getClass().getResource("chromedriver.exe").getFile());
        ArrayList<ChromeDriver> driverArray = new ArrayList<>();
        boolean[] boolArray = new boolean[SECONDARY_DRIVES];            // false for unfinished true for finished

        for(int i = 0; i < SECONDARY_DRIVES; i++){
            driverArray.add(new ChromeDriver());
        }

        WebDriver webDriver = new ChromeDriver();
        WebDriver secondaryWebDriver = new ChromeDriver();
        webDriver.get("https://www.edamam.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
        }

        String mainURL = webDriver.getCurrentUrl();

        try{
            ArrayList<String> urls = new ArrayList<>();
            int index = 1;
            while(true){
                secondaryWebDriver.get(mainURL);
                String imgxPath = "//*[@id=\"search-results\"]/div[2]/div/ul/li[" + index +"]/div[2]/div/div[1]/a/span[1]/span/img";
                String clickablexPath = "//*[@id=\"search-results\"]/div[2]/div/ul/li[" + index + "]";
                WebElement wait1 = new WebDriverWait(secondaryWebDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(imgxPath)));
                WebElement wait2 = new WebDriverWait(secondaryWebDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickablexPath)));

                String imgURL = secondaryWebDriver.findElement(By.xpath(imgxPath)).getAttribute("src"); // getting img url
                // //*[@id="search-results"]/div[2]/div/ul/li[1]/div[2]/div/div[1]/a/span[1]/span/img vs //*[@id="search-results"]/div[2]/div/ul/li[5]/div[2]/div/div[1]/a/span[1]/span/img vs //*[@id="search-results"]/div[2]/div/ul/li[2]/div[2]/div/div[1]/a/span[1]/span/img
                System.out.println("Image url is " + imgURL);
                secondaryWebDriver.findElement(By.xpath(clickablexPath)).click();
                ////*[@id="search-results"]/div[2]/div/ul/li[3] . //*[@id="search-results"]/div[2]/div/ul/li[1]
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                index++;
                System.out.println("Current index is " + index);
            }
        } catch (NoSuchElementException e){
            System.out.println("THere are no more elements");
        }


        //scrape
    }
}

