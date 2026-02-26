package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DangNhapPage extends Page {
	public By txtUserName = By.name("username");
	public By txtPassword = By.name("password");
	public By btnLogin = By.name("SignIn");

	public DangNhapPage(WebDriver dr) {
		super(dr);
	}

	public TrangChuPage login(String userName, String pass) {
		base.inputText(txtUserName, userName);
		base.inputText(txtPassword, pass);
		base.clickOnElement(btnLogin);
		return new TrangChuPage(driver);
	}

}
