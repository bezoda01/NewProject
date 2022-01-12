import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test1 extends Main{

    ArrayList<String> example = new ArrayList<String>()  {{
        add("John");
        add("Frank");
        add("Jason");
        add("Tim");
    }};

    @Test
    public void test1() {
        Assert.assertNotNull(driverFirst.toString(), "Страница таблиц открыта");
        System.out.println("Страница таблиц открыта");
    }

    @Test
    public void test2() {

        WebElement heading = driverFirst.findElement(By.xpath("//div[@id = 'content']//*[text()='Data Tables']"));
        String headin = heading.getText();

        Assert.assertEquals(headin, "Data Tables", "Элемент заголовка присутствует на странице");
        System.out.println("Элемент заголовка присутствует на странице");
    }

    @Test
    public void test3() {
        List<WebElement> temp = driverFirst.findElements(By.xpath("//table[@id = 'table1']//*[text() = 'John' or text() = 'Frank' or text() = 'Jason' or text() ='Tim']"));

        List<String> newWords = new ArrayList<String>();
        for(int i = 0;i < temp.size();i++) {
            newWords.add(temp.get(i).getText());
        }

        Assert.assertEquals(newWords, example, "Найдено 4 элемента");
        System.out.println("Найдено 4 элемента");
    }

    @Test
    public void test4() {

        Assert.assertNotNull(driverSecond.toString());
        System.out.println("Страница открыта");
    }

    @Test
    public void test5() {
        boolean ask = true;
        WebElement element = driverSecond.findElement(By.xpath("//button[text() = 'Add Element']"));
        Assert.assertEquals(element.isEnabled(), ask);
        System.out.println("На странице присутствует кнопка 'Add Element'");

    }

    @Parameters({"button"})
    @Test
    public void test6(String button) {

        Assert.assertNotEquals(driverSecond.findElement(By.xpath("//button")).getText(), button);

        System.out.println("На странице отсутствует кнопка 'Delete'");

    }
}
