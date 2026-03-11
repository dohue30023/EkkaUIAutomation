package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.DangNhapPage;
import pages.DanhSachBaiVietPage;
import pages.DanhSachThuongHieuPage;
import pages.TrangChuPage;

public class TimKiemThuongHieuTest extends TestCase {
	@Test(testName = "[Tìm kiếm] Kiểm tra tìm kiếm thành công khi nhập vào textbox = Tên thương hiệu đã tồn tại trong DB", dataProvider = "DangNhapData")
	public void timKiemThanhCong(String username, String password) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(username,password);
		DanhSachThuongHieuPage danhSachThuongHieuPage = trangChuPage.clickDanhSachThuongHieu();
		boolean timKiemResult = danhSachThuongHieuPage.getSearchResult("Apple");
		assertTrue(timKiemResult);
	}

	@DataProvider(name = "DangNhapData")
	public Object[][] readDataTestCase1() {
		Utils utils = new Utils();
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		return dangNhapData;
	}
	
//	@Test(testName = "[Tìm kiếm] Kiểm tra tìm kiếm không  thành công khi nhập vào textbox =Tên thương hiệu chưa tồn tại trong DB", dataProvider = "DangNhapData")
	public void timKiemKhongThanhCong(String username, String password) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(username,password);
		DanhSachThuongHieuPage danhSachThuongHieuPage = trangChuPage.clickDanhSachThuongHieu();
		boolean timKiemResult = danhSachThuongHieuPage.getSearchResult("123");
		assertTrue(timKiemResult);
	}

	@DataProvider(name = "DangNhapData")
	public Object[][] readDataTestCase2() {
		Utils utils = new Utils();
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		return dangNhapData;
	}
}
