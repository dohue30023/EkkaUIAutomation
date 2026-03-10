package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DanhSachBaiVietPage extends Page {
	public By btnThemMoi = By.id("add-new");


	public DanhSachBaiVietPage(WebDriver dr) {
		super(dr);
	}
	
	public ThemMoiBaiVietPage clickThemMoi() {
		base.clickOnElement(btnThemMoi);
		return new ThemMoiBaiVietPage(driver);
	}

}
