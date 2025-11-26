package Herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownTest extends BaseTestHero{

    @Test
    void selectOption(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        WebElement SelectedOption = select.getFirstSelectedOption();

        assertEquals(SelectedOption.getText(),"Please select an option","Error message");

        select.selectByVisibleText("Option 1");

        WebElement firstSelectedOption1 = select.getFirstSelectedOption();

        assertEquals(firstSelectedOption1.getText(),"Option 1","Error message");

        select.selectByVisibleText("Option 2");
        WebElement firstSelectedOption2 = select.getFirstSelectedOption();

        assertEquals(firstSelectedOption2.getText(),"Option 2","Error message");
    }
}
