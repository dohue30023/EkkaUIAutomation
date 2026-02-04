package tests;

import org.testng.annotations.BeforeMethod;

import common.TestBase;

public class TestCase {
public TestBase testBase = new TestBase();

	

	@BeforeMethod

	public void setUp() {

		String browser ="chrome";

		String url="http://localhost/store/admin/?modules=users&controller=index&action=login";

		testBase.openWeb(browser, url);

	}

	

	public void tearDown() {

		

	}
}
