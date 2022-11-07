import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Maksim2404Test {


    // ТС1 : открыть страницу опенвезер, набравть в строке грода Париж , нажать пункт меню Search, из выпадающего
    // списка выбрать PAris, Fr, подтвердить что заголовок изменился га paris,FR.
    @Test
    public void testH2TextWhenSearchingCityCountry() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\maksMCalister\\Desktop\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']"));
        searchCityField.click();
        searchCityField.sendKeys(cityName);
        WebElement searchButton = driver.findElement(
                By.xpath("//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(1000);
        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();
        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();
        Thread.sleep(5000);
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }

    //TC_11_01
    //1.  Открыть базовую ссылку
    //2.  Нажать на пункт меню Guide
    //3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и
    // что title этой страницы OpenWeatherMap API guide - OpenWeatherMap
    @Test
    public void testGuideWhenSlideToThePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\maksMCalister\\Desktop\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String nameofFields = "Guide";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(2000);

        WebElement approveThatThisIsRightAddress = driver.findElement(new By.ByLinkText(nameofFields));

        approveThatThisIsRightAddress.click();
        Thread.sleep(3000);

        String actualResult1 = driver.getCurrentUrl();
        String actualResult2 = driver.getTitle();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();

    }

    /*
     * TC_11_02
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на единицы измерения Imperial: °F, mph
     * 3.  Подтвердить, что температура для города показана в Фарингейтах
     */
    @Test
    public void testShowsFarinheit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\maksMCalister\\Desktop\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String name = "°F";
        String expectedResult = "true";

        driver.get(url);
        Thread.sleep(5000);

        WebElement metricSystem = driver.findElement(By.xpath("//span[@class='heading']"
        ));

        metricSystem.click();

        Thread.sleep(5000);

        WebElement approveFarenheit = driver.findElement(
                By.xpath("//div[@id='weather-widget']//div[3]")
        );

        Boolean isApproveFarenheit = approveFarenheit.getText().contains("°F");

        Assert.assertTrue(isApproveFarenheit);
        driver.quit();
    }

    @Test
    public void testCheckPanelWithText() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\maksMCalister\\Desktop\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "We use cookies which are essential for the site to work. We also use non-essential "
                + "cookies to help us improve our services. Any data collected is anonymised. "
                + "You can allow all cookies or manage them individually.";
        String expectedResult2 = "Allow all";
        String expectedResult3 = "Manage cookies";

        driver.get(url);
        Thread.sleep(2000);

        WebElement checkExp1 = driver.findElement(
                By.xpath("//div[@id='stick-footer-panel']//p")
        );
        Thread.sleep(2000);

        WebElement searchButton1 = driver.findElement(
                By.xpath(" //div[@id='stick-footer-panel']//button")
        );

        Thread.sleep(2000);

        WebElement searchButton2 = driver.findElement(
                By.xpath(" //div[@id='stick-footer-panel']//a")
        );

        Thread.sleep(2000);

        String actualResult1 = checkExp1.getText();
        String actualResult2 = searchButton1.getText();
        String actualResult3 = searchButton2.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();

    }

    @Test

    public void testConfirmThatSupportHave3Types() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\maksMCalister\\Desktop\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "FAQ";
        String expectedResult2 = "How to start";
        String expectedResult3 = "Ask a question";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchButton = driver.findElement(
                By.id("support-dropdown")
        );

        searchButton.click();

        Thread.sleep(2000);

        WebElement confirm1 = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href='/faq']"));

        String actualResult1 = confirm1.getText();

        Thread.sleep(2000);

        WebElement confirm2 = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href='/appid']")
        );

        String actualResult2 = confirm2.getText();

        Thread.sleep(2000);

        WebElement confirm3 = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href='https://home.openweathermap.org/questions']")
        );

        String actualResult3 = confirm3.getText();

        Thread.sleep(2000);

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();

    }

    //1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
    @Test
    public void testConfirmMistake() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\maksMCalister\\Desktop\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        String url = "https://openweathermap.org/";
        String email = "test@test.com";
        String message = "Help";
        String expectedResult = "reCAPTCHA verification failed, please try again.";
        driver.get(url);
        Thread.sleep(4000);
        WebElement idSupportDropDown = driver.findElement(By.xpath(
                "//li[@class='with-dropdown']"
        ));
        idSupportDropDown.click();
        Thread.sleep(4000);
//        WebElement askAQuestionMenu = driver.findElement(By.linkText("Ask a question"));
//        askAQuestionMenu.click();
        driver.get("https://home.openweathermap.org/questions");
        WebElement emailField = driver.findElement(By.id("question_form_email"));
        emailField.click();
        emailField.sendKeys(email);
        WebElement selectSubject = driver.findElement(By.xpath(
                "//div[@class='col-sm-8']//select"
        ));
        selectSubject.click();
        WebElement textMessage = driver.findElement(By.xpath(
                "//textarea[@id='question_form_message']"
        ));
        textMessage.click();
        textMessage.sendKeys(message);
        WebElement clickSubmitButton = driver.findElement(By.xpath(
                "//input[@data-disable-with='Create Question form']"
        ));
        clickSubmitButton.click();
        Thread.sleep(3000);
        WebElement divHasError = driver.findElement(By.xpath(
                "//div[@class='has-error']//div"
        ));
        String actualResult = divHasError.getText();
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    /*
     * TC_11_06
     * 1. Открыть базовую ссылку
     * 2. Нажать пункт меню Support → Ask a question
     * 3. Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
     * 4. Оставить пустым поле Email
     * 5. Заполнить поля  Subject, Message
     * 6. Подтвердить CAPTCHA
     * 7. Нажать кнопку Submit
     * 8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”
     */

    @Test
    public void confirmErrorEmael() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\maksMCalister\\Desktop\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://openweathermap.org/";
        String expectedResult = "can't be blank";
        String subject = "hello";

        driver.get(url);
        Thread.sleep(5000);

        WebElement idSupportDropDown = driver.findElement(By.xpath(
                "//li[@class='with-dropdown']"
        ));
        idSupportDropDown.click();
        Thread.sleep(4000);

        driver.get("https://home.openweathermap.org/questions");

        WebElement selectSuibject = driver.findElement(
                By.xpath("//select[@id='question_form_subject']")
        );
        selectSuibject.click();
        Thread.sleep(4000);
        WebElement selectAdditionalSubject = driver.findElement(
                By.xpath("//select[@id='question_form_subject']/option[@value='Sales']")
        );

        selectAdditionalSubject.click();
        Thread.sleep(4000);

        WebElement captcha = driver.findElement(
                By.xpath("//label[@class='rc-anchor-center-item rc-anchor-checkbox-label']")
        );
        Thread.sleep(4000);

        WebElement captcha1 = driver.findElement(
                By.xpath("//div[@class='recaptcha-checkbox-border']")
        );
        captcha1.click();
        Thread.sleep(4000);

        WebElement submitButton = driver.findElement(
                By.xpath("//div[@class='col-sm-8']/input[@type='submit']")
        );
        submitButton.click();
        Thread.sleep(4000);

        WebElement errorBlank = driver.findElement(new By.ByLinkText("can't be blank"));

        String actualResult = errorBlank.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

    //   * TC_11_08
//     * 1.  Открыть базовую ссылку
//     * 2.  Нажать на лого компании
//     * 3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась
//     */
    @Test
    public void testconfirmSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\maksMCalister\\Desktop\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement getLogo = driver.findElement(
                By.xpath("//li[@class='logo']")
        );
        getLogo.click();
        Thread.sleep(5000);

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();

    }







}