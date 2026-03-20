package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BanHangPage extends Page{
	public By iconXuLy = By.xpath("//tbody/tr/td[9]/span/a[text()='xử lý']");
	


	public BanHangPage(WebDriver dr) {
		super(dr);
	}

//	public String clickXuLy(String tenSanPham) {
//		timKiem(tenSanPham);
//		base.clickOnElement(iconXoaSanPham);
//		clickOkButton();
//		String result = base.getAlertMessage();
//		return result;
//	}
	
//	public String getAlertMessage() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		String result = "";
//		Alert alert = driver.switchTo().alert();
//		result = alert.getText();
//		return result;
//		
//	}
}
