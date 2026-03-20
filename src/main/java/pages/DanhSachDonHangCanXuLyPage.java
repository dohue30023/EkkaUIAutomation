package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DanhSachDonHangCanXuLyPage extends Page{
	public By txtTimKiem = By.id("s");
	public By btnTimKiem = By.name("sm_s");
	public By ketQuaTimKiem = By.xpath("//tbody/tr/td[3]/span");
	public By iconXuLy = By.xpath("//a[text()='xử lý']");
//	public By btnXacNhan = By.xpath("//a[text()='Xác nhận']");
	public By btnXacNhan = By.xpath("//a[contains(@href,'id_order=43') and contains(@href,'confirm')]");
	public By btnHuyDon = By.xpath("//a[text()='Hủy Đơn']");
	
	public DanhSachDonHangCanXuLyPage(WebDriver dr) {
		super(dr);
	}
	
	
	public void clickiconXuLy(String maDonHang) {
		timKiemDonHangCanXuLy(maDonHang);
		base.clickOnElement(iconXuLy);
		clickbtnXacNhan();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timKiemDonHangCanXuLy(maDonHang);
		
		}
	public boolean checkXuLyIcon() {
		boolean result = false;
		WebElement iconXuLyElement = driver.findElement(iconXuLy);
		if(!iconXuLyElement.isDisplayed()) {
			result = true;
			System.out.println("abc" + result);
		}
		return result;

	}

	
	public void timKiemDonHangCanXuLy(String textSearch) {
		base.inputText(txtTimKiem, textSearch);
		base.clickOnElement(btnTimKiem);
	}
	
	public void timKiemDonHangDaXuLy(String textSearch) {
		base.inputText(txtTimKiem, textSearch);
		base.clickOnElement(btnTimKiem);
	}
	
	public void clickbtnXacNhan() {
		

	}
}
