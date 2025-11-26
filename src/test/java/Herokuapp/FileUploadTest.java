package Herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTestHero{

    @Test
    void checkingUploadFile(){
        driver.get("https://the-internet.herokuapp.com/upload");

        File file = new File("src/test/resources/photo_5229157309366341620_y.jpg");

        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        assertEquals(driver
                        .findElement(By.xpath("//div[@id='content']//h3"))
                        .getText(), "File Uploaded!","Файл не загружен");

        assertEquals(driver
                        .findElement(By
                        .xpath(
                                "//div[@id='uploaded-files' and contains(@class, 'panel')]")),
                                "photo_5229157309366341620_y.jpg",
                                "Фото не совпадает");
    }
}
