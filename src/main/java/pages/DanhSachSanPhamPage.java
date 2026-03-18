package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

//	public boolean getSearchResult(String textSearch) {
//		timKiem(textSearch);
//		java.util.List<org.openqa.selenium.WebElement> resultElements = driver.findElements(ketQuaTimKiem);
//		for (org.openqa.selenium.WebElement e : resultElements) {
//			if (e.getText() != null && e.getText().contains(textSearch)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	public boolean getSearchResult(String textSearch) {
		boolean result = false;
		timKiem(textSearch);
		List<WebElement> resultElements = driver.findElements(ketQuaTimKiem);
		int count = 0;
		for(WebElement e : resultElements) {
			String actualTitle = e.getText();
			if(actualTitle.contains(textSearch)) {
				count ++;
			}
		}
		
		if(count == resultElements.size()) {
			result = true;
		}
		
		return result;
	}
	
	public void clickOkButton() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public String getAlertMessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = "";
		Alert alert = driver.switchTo().alert();
		result = alert.getText();
		return result;
		
	}
}
