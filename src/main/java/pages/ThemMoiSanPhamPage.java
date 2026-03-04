package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.models.SanPham;

public class ThemMoiSanPhamPage extends Page {
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
	public By ddlDoHotSanPham = By.name("level");
	public By ddlTrangThai = By.name("status");
	public By ddlDanhMucSanPham = By.name("id_category");
	public By ddlThuongHieuSanPham = By.name("id_brand");
	public By txtHinhAnh = By.name("image");
	public By iframe = By.xpath("//iframe");
	public By txtMoTaSanPham = By.xpath("//html//body/p");
	public By btnThemMoi = By.name("btn_submit");

	public ThemMoiSanPhamPage(WebDriver dr) {
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
		base.selectDropDownByVisibleText(ddlDoHotSanPham, sanPham.getDoHotSanPham());
		base.selectDropDownByVisibleText(ddlTrangThai, sanPham.getTrangThai());
		base.selectDropDownByVisibleText(ddlDanhMucSanPham, sanPham.getDanhMucSanPham());
		base.selectDropDownByVisibleText(ddlThuongHieuSanPham, sanPham.getThuongHieuSanPham());
		String picturePath = System.getProperty("user.dir") + "\\testcase\\" + "testdata\\" + "\\";

		base.inputText(txtHinhAnh, picturePath + sanPham.getHinhAnh());
		WebDriver beforeDriver = driver;
		WebElement iframeElement = driver.findElement(iframe);
		driver.switchTo().frame(iframeElement);
		base.inputText(txtMoTaSanPham, sanPham.getMoTaSanPham());
		driver.switchTo().defaultContent();
		driver = beforeDriver;

		base.clickOnElement(btnThemMoi);
	}

	public String getAlertMessage() {
		String result = "";
		Alert alert = driver.switchTo().alert();
		result = alert.getText();
		return result;
		

	}

}
