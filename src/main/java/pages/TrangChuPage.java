package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrangChuPage extends Page {
	public By lblSanPham = By.xpath("//*[text()='Sản Phẩm']");
	public By lblThemMoi = By.xpath("//a[text()='Thêm mới']");
	public TrangChuPage(WebDriver dr) {
		super(dr);
	}

	public ThemMoiPage  clickThemMoi() {
		base.clickOnElement(lblSanPham);
		base.clickOnElement(lblThemMoi);
		return new ThemMoiPage(driver);

	}

}
