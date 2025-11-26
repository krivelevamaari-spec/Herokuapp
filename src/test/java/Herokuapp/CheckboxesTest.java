package Herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CheckboxesTest extends BaseTestHero{

    @Test
    public void checkingCheckbox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkbox = driver.findElements(By.cssSelector("input[type='checkbox']"));

        assertEquals(checkbox.size(), 2,"Количество чекбоксов не совпадает");

        assertFalse(checkbox.get(0).isSelected(),"Чек бокс1 выбран");

        checkbox.get(0).click();
        assertTrue(checkbox.get(0).isSelected(),"Чек бокс1 не выбран");


        assertTrue(checkbox.get(1).isSelected(),"Чек бокс2 не выбран");
        checkbox.get(1).click();

        assertFalse(checkbox.get(1).isSelected(),"Чек бокс2 выбран");
    }
}
