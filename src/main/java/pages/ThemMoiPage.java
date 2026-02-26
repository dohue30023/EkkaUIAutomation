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
	public By txtRam = By.name("ram");
	public By txtCpu = By.name("cpu");
	public By txtBoNho = By.name("memory");
	public By txtHeDieuHanh = By.name("operating_system");
	public By txtCameraTruoc = By.name("front_camera");
	public By txtCameraSau = By.name("rear_camera");
	public By txtDoHotSanPham = By.name("level");
	public By txtTrangThai = By.name("status");
	public By txtDanhMucSanPham = By.name("id_category");
	public By txtThuongHieuSanPham = By.name("id_brand");
	public By txtHinhAnh = By.name("file");
	public By txtMoTaSanPham = By.name("description");
	public By btnThemMoi = By.name("btn_submit");

	public ThemMoiPage(WebDriver dr) {
		super(dr);
	}

	public void inputData(SanPham sanPham) {
		base.inputText(txtTenSanPham, sanPham.getTenSanPham());
		base.inputText(txtMaSanPham, sanPham.getMaSanPham());
		base.inputText(txtGiaSanPham, sanPham.getGiaSanPham());
		base.inputText(txtGiaKhuyenMai, sanPham.getGiaKhuyenMai());
		base.inputText(txtSoLuong, sanPham.getSoLuong());
		base.inputText(txtNguoiTao, sanPham.getNguoiTao());
		base.inputText(txtManHinh, sanPham.getManHinh());
		base.inputText(txtRam, sanPham.getRam());
		base.inputText(txtCpu, sanPham.getCpu());
		base.inputText(txtBoNho, sanPham.getBoNho());
		base.inputText(txtHeDieuHanh, sanPham.getHeDieuHanh());
		base.inputText(txtCameraTruoc, sanPham.getCameraTruoc());
		base.inputText(txtCameraSau, sanPham.getCameraSau());
		base.inputText(txtDoHotSanPham, sanPham.getDoHotSanPham());
		base.inputText(txtTrangThai, sanPham.getTrangThai());
		base.inputText(txtDanhMucSanPham, sanPham.getDanhMucSanPham());
		base.inputText(txtThuongHieuSanPham, sanPham.getThuongHieuSanPham());
		base.inputText(txtHinhAnh, sanPham.getHinhAnh());
		base.inputText(txtMoTaSanPham, sanPham.getMoTaSanPham());

		base.clickOnElement(btnThemMoi);
	}

}
