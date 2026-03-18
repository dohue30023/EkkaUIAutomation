package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Reporter;

import common.Utils;
import pages.DangNhapPage;
import pages.DanhSachBaiVietPage;
import pages.DanhSachThuongHieuPage;
import pages.ThemMoiBaiVietPage;
import pages.ThemMoiThuongHieuPage;
import pages.TrangChuPage;
import tests.models.BaiViet;
import tests.models.DangNhap;
import tests.models.ThuongHieu;

public class ThemThuongHieuTest extends TestCase {
	@Test(testName = "[Thêm mới] Kiểm tra thêm mới thành công một thương hiệu", dataProvider = "ThemMoiThuongHieuData")
	public void themMoiThanhCong(DangNhap dangNhap, ThuongHieu thuongHieu) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		DanhSachThuongHieuPage danhSachThuongHieuPage = trangChuPage.clickDanhSachThuongHieu();
		ThemMoiThuongHieuPage themMoiThuongHieuPage = danhSachThuongHieuPage.clickThemMoi();
		themMoiThuongHieuPage.inputData(thuongHieu);
		String expectedMessage = "Thêm mới thành công";
		String actualMessage = themMoiThuongHieuPage.getAlertMessage();
		assertEquals(expectedMessage, actualMessage); // TestNG framework
	}

	 @Test(testName = "[Thêm mới] Kiểm tra thêm mới không thành công một thương hiệu khi không nhập vào các trường bắt buộc", dataProvider = "ThemMoiData_TC02")
	public void themMoiKhongThanhCongVoiTenSanPhamBlank(DangNhap dangNhap, ThuongHieu thuongHieu) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		DanhSachThuongHieuPage danhSachThuongHieuPage = trangChuPage.clickDanhSachThuongHieu();
		ThemMoiThuongHieuPage themMoiThuongHieuPage = danhSachThuongHieuPage.clickThemMoi();
//		themMoiThuongHieuPage.inputData(thuongHieu);
	    themMoiThuongHieuPage.clickThemMoi();
		String expectedMessage = "Thêm mới danh mục sản phẩm thất bại haha";
		String actualMessage = themMoiThuongHieuPage.getAlertMessage();
		assertEquals(expectedMessage, actualMessage); // TestNG framework
	}

	@DataProvider(name = "ThemMoiThuongHieuData")
	public Object[][] readDataTestCase1() {
		Utils utils = new Utils();
		Object[][] data = new Object[1][2];

		// Đọc dữ liệu đăng nhập
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		DangNhap dangNhap = new DangNhap();
		dangNhap.setUserName(dangNhapData[0][0]);
		dangNhap.setPassWord(dangNhapData[0][1]);
		data[0][0] = dangNhap;

		// Đọc dữ liệu thương hiệu
		String[][] thuongHieuData = utils.readDataFormCSV("ThemMoiThuongHieu_TC1.csv");
		ThuongHieu thuongHieu = new ThuongHieu();
		thuongHieu.setTenDanhMuc(thuongHieuData[0][0]);
		thuongHieu.setMaCode(thuongHieuData[0][1]);
		thuongHieu.setNguoiTao(thuongHieuData[0][2]);
		thuongHieu.setMoTa(thuongHieuData[0][3]);
		thuongHieu.setHinhAnh(thuongHieuData[0][4]);
		data[0][1] = thuongHieu;

		return data;

	}

	@DataProvider(name = "ThemMoiData_TC02")
	public Object[][] readDataTestCase02() {
		Utils utils = new Utils();
		Object[][] data = new Object[1][2];

		// Đọc dữ liệu đăng nhập
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		DangNhap dangNhap = new DangNhap();
		dangNhap.setUserName(dangNhapData[0][0]);
		dangNhap.setPassWord(dangNhapData[0][1]);
		data[0][0] = dangNhap;

		// Tạo dữ liệu thương hiệu với Tên danh mục blank để test negative case
		ThuongHieu thuongHieu = new ThuongHieu();
		thuongHieu.setTenDanhMuc("");
		thuongHieu.setMaCode("AutoCode");
		thuongHieu.setNguoiTao(dangNhapData[0][0]);
		thuongHieu.setMoTa("Mô tả test");
		thuongHieu.setHinhAnh("samsung5.jpg");
		data[0][1] = thuongHieu;

		return data;
	}
}
