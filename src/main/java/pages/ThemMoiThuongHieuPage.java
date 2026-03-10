package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.models.ThuongHieu;

public class ThemMoiThuongHieuPage extends Page{
	public By txtTenDanhMuc = By.id("title");
	public By txtMaCode = By.id("title");
	public By txtNguoiTao = By.name("image");
	public By txtMoTa = By.xpath("//html//body/p");
	public By txtHinhAnh = By.name("image");
	public By btnThemMoi = By.name("btn_submit");

	public ThemMoiThuongHieuPage(WebDriver dr) {
		super(dr);
	}
	
	public void inputData(ThuongHieu thuongHieu) {
		base.inputText(txtTenDanhMuc, thuongHieu.getTenDanhMuc());
		base.inputText(txtMaCode, thuongHieu.getMaCode());
		base.inputText(txtNguoiTao, thuongHieu.getNguoiTao());
		base.inputText(txtMoTa, thuongHieu.getMoTa());
		base.inputText(txtHinhAnh, thuongHieu.getHinhAnh());
		base.clickOnElement(btnThemMoi);
	}

	public String getAlertMessage() {
		String result = "";
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		result = alert.getText();
		return result;
	}
}
