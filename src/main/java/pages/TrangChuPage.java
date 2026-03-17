package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrangChuPage extends Page {
	public By lblSanPham = By.xpath("//*[text()='Sản Phẩm']");
	public By lblThemMoi = By.xpath("//a[text()='Thêm mới']");
	public By lblBaiViet = By.xpath("//*[text()='Bài Viết']");
	public By lblDanhSachBaiViet = By.xpath("//*[text()='Bài Viết']/following::a[text()='Danh sách'][1]");
	public By lblThuongHieu = By.xpath("//*[text()='Thương Hiệu']");
	public By lblDanhSachThuongHieu = By.xpath("//*[text()='Thương Hiệu']/following::a[text()='Danh sách'][1]");
	public By lblQuangCao = By.xpath("//*[text()='Slider']");
	public By lblThemMoiQuangCao = By.xpath("//span[text()='Slider']/../following-sibling::ul[@class='sub-menu']//a[text()='Thêm mới']");
	public By lblDanhSachSanPham = By.xpath("//*[text()='Sản Phẩm']/following::a[text()='Danh sách'][1]");



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

	public DanhSachThuongHieuPage clickDanhSachThuongHieu() {
		base.clickOnElement(lblThuongHieu);
		base.clickOnElement(lblDanhSachThuongHieu);
		return new DanhSachThuongHieuPage(driver);
	}
	public ThemMoiQuangCaoPage  clickThemMoiQuangCao() {
		base.clickOnElement(lblQuangCao);
		base.clickOnElement(lblThemMoiQuangCao);
		return new ThemMoiQuangCaoPage(driver);

	}
	public DanhSachSanPhamPage clickDanhSachSanPham() {
		base.clickOnElement(lblSanPham);
		base.clickOnElement(lblDanhSachSanPham);
		return new DanhSachSanPhamPage(driver);
	}
}
