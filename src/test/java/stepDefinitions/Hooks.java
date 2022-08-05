package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    // This class has methods which contain opening and closing browsers.

    @Before
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
