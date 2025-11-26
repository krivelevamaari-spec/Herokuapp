package Herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IFrameTest extends BaseTestHero{

    @Test
    void checkingText(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

        String text = driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText();

        assertEquals(text,"Your content goes here.","Текс не совпадает");
    }
}
