package accountfeature;

import org.testng.annotations.BeforeMethod;
import testUtil.AbstractTest;

import java.net.MalformedURLException;

public class AddNewAccountTest extends AbstractTest {
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        buttonNavigationBar.getAdvanceFunctionsButton().click();
    }

}
