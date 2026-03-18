package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.DangNhapPage;
import pages.DanhSachBaiVietPage;
import pages.TrangChuPage;
import tests.models.BaiViet;
import tests.models.DangNhap;

public class TimKiemBaiVietTest extends TestCase {
//	@Test(testName = "[Tìm kiếm] Kiểm tra tìm kiếm thành công khi nhập vào textbox = Tiêu đề đã tồn tại trong DB", dataProvider = "DangNhapData")
	public void timKiemThanhCong(String username, String password) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(username, password);
		DanhSachBaiVietPage danhSachBaiVietPage = trangChuPage.clickDanhSachBaiViet();
		boolean timKiemResult = danhSachBaiVietPage.getSearchResult("Apple");
		assertTrue(timKiemResult);
	}

	@DataProvider(name = "DangNhapData")
	public Object[][] readDataTestCase1() {
		Utils utils = new Utils();
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		return dangNhapData;
	}

	@Test(testName = "[Tìm kiếm] Kiểm tra tìm kiếm không  thành công khi nhập vào textbox =Tiêu đề chưa tồn tại trong DB", dataProvider = "DangNhapData")
	public void timKiemKhongThanhCong(String username, String password) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(username, password);
		DanhSachBaiVietPage danhSachBaiVietPage = trangChuPage.clickDanhSachBaiViet();
		boolean timKiemResult = danhSachBaiVietPage.getSearchResult("!@#$");
		System.out.println(">>>>: " + timKiemResult);

		assertTrue(timKiemResult);
	}

	@DataProvider(name = "DangNhapData2")
	public Object[][] readDataTestCase2() {
		Utils utils = new Utils();
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		return dangNhapData;
	}

}
