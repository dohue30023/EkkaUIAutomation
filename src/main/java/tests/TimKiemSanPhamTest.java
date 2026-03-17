package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.DangNhapPage;
import pages.ThemMoiSanPhamPage;
import pages.TrangChuPage;
import tests.models.DangNhap;
import tests.models.SanPham;

public class TimKiemSanPhamTest extends TestCase{
//	@Test(testName = "[Tìm kiếm] Kiểm tra tìm kiếm thành công khi nhập vào textbox = tên sản phẩm đã tồn tại trong DB", dataProvider = "DangNhapData")
	public void themMoiThanhCong(DangNhap dangNhap, SanPham sanPham) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		ThemMoiSanPhamPage themMoiPage = trangChuPage.clickThemMoiSanPham();
		boolean timKiemResult = themMoiPage.getSearchResult("iPhone 11 Pro Max");
		assertTrue(timKiemResult);
	}
	
	@DataProvider(name = "DangNhapData")
	public Object[][] readDataTestCase1() {
		Utils utils = new Utils();
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		return dangNhapData;
	}
	
	@Test(testName = "[Tìm kiếm] Kiểm tra tìm kiếm thành công khi nhập vào textbox = tên sản phẩm chưa tồn tại trong DB", dataProvider = "DangNhapData")
	public void themMoiKhongThanhCong(DangNhap dangNhap, SanPham sanPham) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		ThemMoiSanPhamPage themMoiPage = trangChuPage.clickThemMoiSanPham();
		boolean timKiemResult = themMoiPage.getSearchResult("đăng tin");
		assertTrue(timKiemResult);
	}
	
	@DataProvider(name = "DangNhapData")
	public Object[][] readDataTestCase2() {
		Utils utils = new Utils();
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		return dangNhapData;
	}
}
