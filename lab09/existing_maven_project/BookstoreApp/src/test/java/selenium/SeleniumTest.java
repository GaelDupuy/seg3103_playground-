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

class SeleniumTest {

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
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }

  @Test
  void test3p_4p_add_book_to_cart_and_check_books_in_cart() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();
    WebElement cartBtn = driver.findElement(By.id("cartLink"));
    cartBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    WebElement numBooks = driver.findElement(By.id("hall001"));
    WebElement bookCost = driver.findElement(By.id("tothall001"));

    String expectedNumBooks = "1";
    String expectedBookCosts = "$39.95";
    String actualNumBooks = numBooks.getAttribute("value");
    String actualBookCosts = bookCost.getText();

    assertEquals(expectedNumBooks, actualNumBooks);
    assertEquals(actualBookCosts, actualBookCosts);
  }

  @Test
  void test3n_4n_empty_cart() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    WebElement cartBtn = driver.findElement(By.id("cartLink"));
    cartBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    List<WebElement> rows = driver.findElements(By.tagName("tr"));

    int expected = 5;
    int actual = rows.size();
    assertEquals(expected, actual);
  }

  @Test
  void test5p_add_book_to_cart_and_update_books_in_cart() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();
    WebElement cartBtn = driver.findElement(By.id("cartLink"));
    cartBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    WebElement numBooks = driver.findElement(By.id("hall001"));
    WebElement updateBtn = driver.findElement(By.className("updatebt"));

    numBooks.clear();
    numBooks.sendKeys("2");
    updateBtn.click();

    String expectedNumBooks = "2";
    String actualNumBooks = numBooks.getAttribute("value");

    assertEquals(expectedNumBooks, actualNumBooks);
  }

  @Test
  void test6p_add_book_to_cart_and_checkout_books_in_cart() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();
    WebElement cartBtn = driver.findElement(By.id("cartLink"));
    cartBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    WebElement checkoutBtn = driver.findElement(By.name("checkout"));
    checkoutBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

    WebElement totalCost = driver.findElement(By.id("order_total"));
    WebElement tax = driver.findElement(By.id("order_taxes"));
    WebElement handlingShipping = driver.findElement(By.id("order_shipping"));

    String expectedTotalCost = "$57.14";
    String expectedTax = "$5.19";
    String expectedHandlingShipping = "$12.00";
    String actualTotalCost = totalCost.getText();
    String actualTax = tax.getText();
    String actualHandlingShipping = handlingShipping.getText();

    assertEquals(expectedTotalCost, actualTotalCost);
    assertEquals(expectedTax, actualTax);
    assertEquals(expectedHandlingShipping, actualHandlingShipping);
  }



}
