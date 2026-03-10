package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrangChuPage extends Page {
	public By lblSanPham = By.xpath("//*[text()='Sản Phẩm']");
	public By lblThemMoi = By.xpath("//a[text()='Thêm mới']");
	public By lblBaiViet = By.xpath("//*[text()='Bài Viết']");
	public By lblDanhSachBaiViet = By.xpath("//a[text()='Danh sách']");
	public By lblThuongHieu = By.xpath("//*[text()='Thương Hiệu']");
	public By lblDanhSachThuongHieu = By.xpath("//a[text()='Danh sách']");



	public TrangChuPage(WebDriver dr) {
		super(dr);
	}

	public ThemMoiSanPhamPage  clickThemMoiSanPham() {
		base.clickOnElement(lblSanPham);
		base.clickOnElement(lblThemMoi);
		return new ThemMoiSanPhamPage(driver);

	}
	
	public DanhSachBaiVietPage  clickDanhSachBaiViet() {
		base.clickOnElement(lblBaiViet);
		base.clickOnElement(lblDanhSachBaiViet);
		return new DanhSachBaiVietPage(driver);

	}

	public ThemMoiThuongHieuPage clickThemMoiThuongHieu() {
		base.clickOnElement(lblThuongHieu);
		base.clickOnElement(lblDanhSachThuongHieu);
		return new ThemMoiThuongHieuPage(driver);
	}
}
