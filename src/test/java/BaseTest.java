import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    final String BASE_URL = "https://mvnrepository.com";
    WebDriver driver;

    @BeforeEach
    public void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true); //тест без открытия браузера
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        System.out.println("Start");
    }

    @AfterEach
    public void finish() {
        driver.quit();
        System.out.println("Finish");
    }

    /*@BeforeEach
    public void start() {
        //устанавливаем драйвер с помощью WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        //создаём опцию что бы браузер был скрыт
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        //инициализируем драйвер
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //делаем браузер во весь экран
        driver.manage().window().maximize();
        //указываем стартовую страницу
        driver.get(BASE_URL);
        System.out.println("Start");
    }*/

}
