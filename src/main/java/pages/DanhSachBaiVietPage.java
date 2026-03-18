package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DanhSachBaiVietPage extends Page {
	public By btnThemMoi = By.id("add-new");
	public By txtTimKiem = By.id("s");
	public By btnTimKiem = By.name("sm_s");
	public By ketQuaTimKiem = By.xpath("//tbody/tr/td[3]/span");

	public DanhSachBaiVietPage(WebDriver dr) {
		super(dr);
	}
	
	public ThemMoiBaiVietPage clickThemMoi() {
		base.clickOnElement(btnThemMoi);
		return new ThemMoiBaiVietPage(driver);
	}

	public void timKiem(String textSearch) {
		base.inputText(txtTimKiem, textSearch);
		base.clickOnElement(btnTimKiem);
	}
//	public boolean getSearchResult(String textSearch) {
//		timKiem(textSearch);
//		List<WebElement> resultElements = driver.findElements(ketQuaTimKiem);
//		for (WebElement e : resultElements) {
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
}
