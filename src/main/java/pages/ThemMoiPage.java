package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.models.SanPham;

public class ThemMoiPage extends Page {
	public By txtTenSanPham = By.id("product-name");
	public By txtMaSanPham = By.id("product-code");
	public By txtGiaSanPham = By.name("price");
	public By txtGiaKhuyenMai = By.name("promotional_price");
	public By txtSoLuong = By.name("quantity");
	public By txtNguoiTao = By.name("user");
	public By txtManHinh = By.name("screen");
// To do
	public By btnThemMoi = By.name("btn_submit");



	public ThemMoiPage(WebDriver dr) {
		super(dr);
	}

	public void inputData(SanPham sanPham) {
		base.inputText(txtTenSanPham, sanPham.getTenSanPham());
		base.inputText(txtMaSanPham, sanPham.getMaSanPham());
		base.inputText(txtGiaSanPham, sanPham.getGiaSanPham());
		base.inputText(txtGiaKhuyenMai, sanPham.getGiaKhuyenMai());
// tO do
		base.clickOnElement(btnThemMoi);
	}

}
