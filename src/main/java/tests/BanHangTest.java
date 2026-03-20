package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.BanHangPage;
import pages.DangNhapPage;
import pages.DanhSachDonHangCanXuLyPage;
import pages.TrangChuPage;
import tests.models.DangNhap;

public class BanHangTest extends TestCase{
	@Test(testName = "[Bán hàng] Kiểm tra xử lý đơn hàng thành công", dataProvider = "BanHangData_TC01")
public void xuLyDonHangThanhCong(String username, String password) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(username,password);
		
		DanhSachDonHangCanXuLyPage danhSachDonHangCanXuLyPage = trangChuPage.clickDonHangCanXuLy();
		danhSachDonHangCanXuLyPage.clickiconXuLy("root(1698557444)");
		assertTrue(danhSachDonHangCanXuLyPage.checkXuLyIcon());
}
	@DataProvider(name = "BanHangData_TC01")
	public Object[][] readDataTestCase1() {
		Utils utils = new Utils();
		Object[][] data = new Object[1][2];

		// Đọc dữ liệu đăng nhập
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
//		DangNhap dangNhap = new DangNhap();
//		dangNhap.setUserName(dangNhapData[0][0]);
//		dangNhap.setPassWord(dangNhapData[0][1]);
//		data[0][0] = dangNhap;
		return dangNhapData;
	}
}
