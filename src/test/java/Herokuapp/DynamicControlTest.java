package Herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.testng.Assert.*;

public class DynamicControlTest extends BaseTestHero{

    @Test
    void checkingDynamic(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        boolean isTextIsGoneDisplayed = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']//p")))
                        .isDisplayed();

        assertTrue(isTextIsGoneDisplayed,"Текст не загрузился");

        assertTrue(driver
                .findElements(By.xpath("//div[@id='checkbox']")).isEmpty(),
                "Чекбокс найден на странице.");

        boolean enabledInput = driver
                .findElement(By.xpath("//input[@type='text' and @disabled]")).isEnabled();

        assertFalse(enabledInput,"Инпут активен");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//button[@onclick='swapInput()']")))
                .click();

        String textIsEnabled = driver.findElement(By.xpath("//p[@id='message']")).getText();

        assertEquals(textIsEnabled,"It's enabled!","Текст не совпадает");

        boolean isEnabledInput = driver
                .findElement(By.xpath("//input[@type='text']")).isEnabled();

        assertTrue(isEnabledInput,"Инпут активен");
    }
}
