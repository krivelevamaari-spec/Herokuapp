package Herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest extends BaseTestHero{

    @Test
    public void checkingAddRemoveElements(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement AddButton = driver.findElement(By.cssSelector("[onclick='addElement()']"));
        AddButton.click();
        AddButton.click();
        List<WebElement> DeleteButtons = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        assertEquals(DeleteButtons.size(), 2);

        DeleteButtons.get(0).click();
        DeleteButtons = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        assertEquals(DeleteButtons.size(), 1);
    }
}
