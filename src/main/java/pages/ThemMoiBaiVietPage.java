package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.models.BaiViet;
import tests.models.SanPham;

public class ThemMoiBaiVietPage extends Page{
	public By txtTieuDe = By.id("title");
	public By txtNguoiViet = By.id("title");
	public By txtHinhAnh = By.name("image");
	public By txtMoTaNgan = By.xpath("//html//body/p");
	public By btnThemMoi = By.name("btn_submit");

	public ThemMoiBaiVietPage(WebDriver dr) {
		super(dr);
	}
	
	public void inputData(SanPham sanPham) {
		base.inputText(txtTieuDe, sanPham.getTieuDe());
		
		base.clickOnElement(btnThemMoi);
	}

	public void inputData() {
	}

}
