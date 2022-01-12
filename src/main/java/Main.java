import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class Main {

    public WebDriver driverFirst;
    public WebDriver driverSecond;

    Main() {
        System.setProperty("webdriver.chrome.driver","/Users/zenapoznak/Desktop/WebDriver/chromedriver");
        driverFirst = new ChromeDriver();
        driverSecond = new ChromeDriver();

        driverFirst.get("https://the-internet.herokuapp.com/tables");
        driverSecond.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }
    public static void main(String[] args) {

    }
}
