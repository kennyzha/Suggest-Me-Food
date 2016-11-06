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
    public static void main(String[] args) throws Exception{
        Scraper s = new Scraper();
        s.scrape();

    }
    public void scrape() throws Exception{
        final String ingredient = "chicken";
        final int SECONDARY_DRIVERS = 2;
        System.out.println("hello");
        System.setProperty("webdriver.chrome.driver", this.getClass().getResource("chromedriver.exe").getFile());
        ArrayList<ChromeDriver> driverArray = new ArrayList<>();
        boolean[] driverStatus = new boolean[SECONDARY_DRIVERS];            // false for occupied true for unoccupied

        for(int i = 0; i < driverStatus.length; i++){
            driverStatus[i] = true;
        }

        for(int i = 0; i < SECONDARY_DRIVERS; i++){
            driverArray.add(new ChromeDriver());
        }

        WebDriver webDriver = new ChromeDriver();
//        WebDriver secondaryWebDriver = new ChromeDriver();
        webDriver.get("https://www.edamam.com/recipes/" + ingredient);

        String mainURL = webDriver.getCurrentUrl();

        try{
            ArrayList<String> urls = new ArrayList<>();
            int index = 1;
            int driverIndex = 0;
            while(true){
                Thread.sleep(10);



                System.out.println("loooping");;
                ChromeDriver currDriver = driverArray.get(driverIndex);
                if(!driverStatus[driverIndex]){
                    continue;
                }
// test gitignore2
                driverStatus[driverIndex] = false;
                final int currentIndex = index;
                final int currentDriver = driverIndex;
                new Thread(){
                    @Override
                    public void run(){

                        currDriver.get(mainURL);
                        String imgxPath = "//*[@id=\"search-results\"]/div[2]/div/ul/li[" + currentIndex +"]/div[2]/div/div[1]/a/span[1]/span/img";
                        String clickablexPath = "//*[@id=\"search-results\"]/div[2]/div/ul/li[" + currentIndex + "]";
                        WebElement wait1 = new WebDriverWait(currDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(imgxPath)));
                        WebElement wait2 = new WebDriverWait(currDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickablexPath)));

                        String imgURL = currDriver.findElement(By.xpath(imgxPath)).getAttribute("src"); // getting img url
                        // //*[@id="search-results"]/div[2]/div/ul/li[1]/div[2]/div/div[1]/a/span[1]/span/img vs //*[@id="search-results"]/div[2]/div/ul/li[5]/div[2]/div/div[1]/a/span[1]/span/img vs //*[@id="search-results"]/div[2]/div/ul/li[2]/div[2]/div/div[1]/a/span[1]/span/img
                        System.out.println("Image url is " + imgURL);
                        currDriver.findElement(By.xpath(clickablexPath)).click();
                        ////*[@id="search-results"]/div[2]/div/ul/li[3] . //*[@id="search-results"]/div[2]/div/ul/li[1]
        //                try {
        //                    Thread.sleep(1000);
        //                } catch (InterruptedException e) {
        //                    e.printStackTrace();
        //                }

                        System.out.println("Current index is " + currentIndex);
                        driverStatus[currentDriver] = true;

                    }
                }.start();
                index++;
                driverIndex++;
                if(driverIndex > SECONDARY_DRIVERS - 1){
                    driverIndex = 0;
                }

            }
        } catch (NoSuchElementException e){
            System.out.println("THere are no more elements");
        }


        //scrape
    }
}

