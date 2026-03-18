package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DanhSachSanPhamPage extends Page{
	public By txtTimKiem = By.id("s");
	public By btnTimKiem = By.name("sm_s");
	public By ketQuaTimKiem = By.xpath("//tbody/tr/td[3]/span");
	public By iconXoaSanPham = By.xpath("//a[@title='Xóa']");

	public DanhSachSanPhamPage(WebDriver dr) {
		super(dr);
	}
	
	public String clickXoaSanPham(String tenSanPham) {
		timKiem(tenSanPham);
		base.clickOnElement(iconXoaSanPham);
		clickOkButton();
		String result = base.getAlertMessage();
		return result;
	}

	
	public void timKiem(String textSearch) {
		base.inputText(txtTimKiem, textSearch);
		base.clickOnElement(btnTimKiem);
	}
	
	public void clickOkButton() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	
}
