package pages;

import org.openqa.selenium.WebDriver;

import common.TestBase;

public class Page {
	public WebDriver driver;
	public TestBase base = new TestBase();
	public Page(WebDriver dr) {

		this.driver = dr;
		base.webDriver = dr;

	}

}
