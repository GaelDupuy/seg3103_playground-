package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;

class AdminSeleniumTest {

  static Process server;
  private WebDriver driver;
  private boolean runDelete;
  private WebDriverWait wait;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }

  @BeforeEach
  void setUp() {
    // Pick your browser
    // driver = new FirefoxDriver();
    // driver = new SafariDriver();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 60);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/admin");
    // wait to make sure Selenium is done loading the page
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    WebElement usernameField = driver.findElement(By.id("loginId"));
    WebElement passwordField = driver.findElement(By.id("loginPasswd"));
    WebElement loginButton = driver.findElement(By.id("loginBtn"));

    usernameField.sendKeys("admin");
    passwordField.sendKeys("password");
    loginButton.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    if (runDelete) {
      runDelete = false;
      WebElement search = driver.findElement(By.id("searchBtn"));
      search.click();

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
      
      WebElement delete = driver.findElement(By.id("del-55555"));
      delete.click();
    }
    driver.close();
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }

  @Test
  void test1p_add_book() {
    runDelete = true;
    WebElement category = driver.findElement(By.id("addBook-category"));
    WebElement bookId = driver.findElement(By.id("addBook-id"));
    WebElement title = driver.findElement(By.id("addBook-title"));
    WebElement authors = driver.findElement(By.id("addBook-authors"));
    WebElement description = driver.findElement(By.id("longDescription"));
    WebElement cost = driver.findElement(By.id("cost"));
    WebElement add = driver.findElement(By.name("addBook"));
    
    category.sendKeys("category");
    bookId.sendKeys("55555");
    title.sendKeys("titlee");
    authors.sendKeys("authorr");
    description.sendKeys("desc");
    cost.sendKeys("5");
    add.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
    WebElement response = driver.findElement(By.tagName("h2"));

    String expected = "Successfully added book";
    String actual = response.getText();
    assertEquals(expected, actual);
  }

  @Test
  void test1n_add_book_without_title() {
    WebElement category = driver.findElement(By.id("addBook-category"));
    WebElement bookId = driver.findElement(By.id("addBook-id"));
    WebElement title = driver.findElement(By.id("addBook-title"));
    WebElement authors = driver.findElement(By.id("addBook-authors"));
    WebElement description = driver.findElement(By.id("longDescription"));
    WebElement cost = driver.findElement(By.id("cost"));
    WebElement add = driver.findElement(By.name("addBook"));
    
    category.sendKeys("category");
    bookId.sendKeys("55555");
    title.sendKeys("");
    authors.sendKeys("authorr");
    description.sendKeys("desc");
    cost.sendKeys("5");
    add.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
    WebElement response = driver.findElement(By.tagName("h2"));

    String expected = "Validation errors";
    String actual = response.getText();
    assertEquals(expected, actual);
  }

  @Test
  void test2p_search_by_category_X() {
    runDelete = true;
    WebElement category = driver.findElement(By.id("addBook-category"));
    WebElement bookId = driver.findElement(By.id("addBook-id"));
    WebElement title = driver.findElement(By.id("addBook-title"));
    WebElement authors = driver.findElement(By.id("addBook-authors"));
    WebElement description = driver.findElement(By.id("longDescription"));
    WebElement cost = driver.findElement(By.id("cost"));
    WebElement add = driver.findElement(By.name("addBook"));
    
    category.sendKeys("X");
    bookId.sendKeys("55555");
    title.sendKeys("titlee");
    authors.sendKeys("authorr");
    description.sendKeys("desc");
    cost.sendKeys("5");
    add.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("X");
    searchBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
    WebElement bookTitle = driver.findElement(By.id("title-55555"));
    

    String expected = "titlee";
    String actual = bookTitle.getText();
    assertEquals(expected, actual);
  }

  @Test
  void test2n_search_by_category_empty() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    List<WebElement> rows = driver.findElements(By.tagName("tr"));
    
    int expected = 9;
    int actual = rows.size();
    assertEquals(expected, actual);
  }

  @Test
  void test7p_add_book_and_delete_book() {
    WebElement category = driver.findElement(By.id("addBook-category"));
    WebElement bookId = driver.findElement(By.id("addBook-id"));
    WebElement title = driver.findElement(By.id("addBook-title"));
    WebElement authors = driver.findElement(By.id("addBook-authors"));
    WebElement description = driver.findElement(By.id("longDescription"));
    WebElement cost = driver.findElement(By.id("cost"));
    WebElement add = driver.findElement(By.name("addBook"));
    
    category.sendKeys("category");
    bookId.sendKeys("55555");
    title.sendKeys("titlee");
    authors.sendKeys("authorr");
    description.sendKeys("desc");
    cost.sendKeys("5");
    add.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
    WebElement search = driver.findElement(By.id("searchBtn"));
    search.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
    WebElement delete = driver.findElement(By.id("del-55555"));
    delete.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    assertThrows(NoSuchElementException.class, () -> {
      WebElement book = driver.findElement(By.id("title-55555"));
    });
  }

  private String[] getWords(String s) {
    return s.split("\\s+");
  }
}
