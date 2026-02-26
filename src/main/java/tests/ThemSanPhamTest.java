package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.DangNhapPage;
import pages.ThemMoiPage;
import pages.TrangChuPage;
import tests.models.DangNhap;
import tests.models.SanPham;

public class ThemSanPhamTest extends TestCase {
	@Test(testName = "[Thêm mới] Kiểm tra thêm mới thành công một sản phẩm", dataProvider = "ThemMoiData_TC01")
	public void themMoiThanhCong(DangNhap dangNhap, SanPham sanPham) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
//		TrangChuPage trangChuAdminPage = dangNhapPage.login("admin", "admin");
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		ThemMoiPage themMoiPage = trangChuPage.clickThemMoi();
		themMoiPage.inputData(sanPham);
		

//trangChuAdminPage.themMoi();
	}

	@DataProvider(name = "ThemMoiData_TC01")
	public Object[][] readData() {
		Utils utils = new Utils();
		Object[][] data = new Object[1][2];
		DangNhap dangNhap = new DangNhap();
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		dangNhap.setUserName(dangNhapData[0][0]);
		dangNhap.setPassWord(dangNhapData[0][1]);
		data[0][0] = dangNhap;
		SanPham sanPham = new SanPham();
		String[][] sanPhamData = utils.readDataFormCSV("ThemMoi_TC1.csv");
		sanPham.setTenSanPham(sanPhamData[0][0]);
		sanPham.setMaSanPham(sanPhamData[0][1]);
		sanPham.setGiaSanPham(sanPhamData[0][2]);
		sanPham.setGiaKhuyenMai(sanPhamData[0][3]);
		sanPham.setSoLuong(sanPhamData[0][4]);
		sanPham.setMaSanPham(sanPhamData[0][4]);

// To do : Bổ sung 19 trường còn lại
		data[0][1] = sanPham;
		return data;

	}
}
