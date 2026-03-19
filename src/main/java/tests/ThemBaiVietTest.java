package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.DangNhapPage;
import pages.DanhSachBaiVietPage;
import pages.ThemMoiBaiVietPage;
import pages.TrangChuPage;
import tests.models.BaiViet;
import tests.models.DangNhap;

public class ThemBaiVietTest extends TestCase {

	@Test(testName = "[Thêm mới] Kiểm tra thêm mới thành công một bài viết", dataProvider = "ThemMoiBaiVietData_TC01")
	public void themMoiThanhCong(DangNhap dangNhap, BaiViet baiViet) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		DanhSachBaiVietPage danhSachBaiVietPage = trangChuPage.clickDanhSachBaiViet();
		ThemMoiBaiVietPage themMoiBaiVietPage = danhSachBaiVietPage.clickThemMoi();
		themMoiBaiVietPage.inputData(baiViet);
		String expectedMessage = "Thêm mới bài viết thành công";
		String actualMessage = themMoiBaiVietPage.getAlertMessage();
		assertEquals(expectedMessage, actualMessage); //TestNG framework	
		}

	@Test(testName = "[Thêm mới] Kiểm tra thêm mới không thành công một bài viết khi không nhập vào trường Tiêu đề", dataProvider = "ThemMoiBaiVietData_TC02")
	public void themMoiKhongThanhCongKhongNhapTieuDe(DangNhap dangNhap, BaiViet baiViet) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		DanhSachBaiVietPage danhSachBaiVietPage = trangChuPage.clickDanhSachBaiViet();
		ThemMoiBaiVietPage themMoiBaiVietPage = danhSachBaiVietPage.clickThemMoi();
		themMoiBaiVietPage.inputData(baiViet);
		String expectedMessage = "title không được rỗng";
		String actualMessage = themMoiBaiVietPage.getAlertMessage();
		org.testng.Assert.assertEquals(actualMessage, expectedMessage); //TestNG framework
	}

	@Test(testName = "[Thêm mới] Kiểm tra thêm mới không thành công một bài viết khi không nhập vào trường Người viết", dataProvider = "ThemMoiBaiVietData_TC03")
	public void themMoiKhongThanhCongKhongNhapNguoiViet(DangNhap dangNhap, BaiViet baiViet) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		DanhSachBaiVietPage danhSachBaiVietPage = trangChuPage.clickDanhSachBaiViet();
		ThemMoiBaiVietPage themMoiBaiVietPage = danhSachBaiVietPage.clickThemMoi();
		themMoiBaiVietPage.inputData(baiViet);
		String expectedMessage = "user không được rỗng";
		String actualMessage = themMoiBaiVietPage.getAlertMessage();
		assertEquals(expectedMessage, actualMessage); //TestNG framework	
	}

	@Test(testName = "[Thêm mới] Kiểm tra thêm mới không  công một bài viết khi bỏ trống trường bắt buộc", dataProvider = "ThemMoiBaiVietData_TC04")
	public void themMoiKhongThanhCongBoTrongTruongBatBuoc(DangNhap dangNhap, BaiViet baiViet) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		DanhSachBaiVietPage danhSachBaiVietPage = trangChuPage.clickDanhSachBaiViet();
		ThemMoiBaiVietPage themMoiBaiVietPage = danhSachBaiVietPage.clickThemMoi();
//		themMoiBaiVietPage.inputData(baiViet);
	    themMoiBaiVietPage.clickThemMoi();
		String expectedMessage = "title không được rỗng\\nuser không được rỗng\\ncontent không được rỗng\\ndescription không được rỗng\\nVui lòng chọn ảnh.\\nimage không được rỗng";
		String actualMessage = themMoiBaiVietPage.getAlertMessage();
		assertTrue(actualMessage.contains(expectedMessage)); //TestNG framework
	}

	@DataProvider(name = "ThemMoiBaiVietData_TC01")
	public Object[][] readDataTestCase1() {
		Utils utils = new Utils();
		Object[][] data = new Object[1][2];

		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		DangNhap dangNhap = new DangNhap();
		dangNhap.setUserName(dangNhapData[0][0]);
		dangNhap.setPassWord(dangNhapData[0][1]);
		data[0][0] = dangNhap;

		String[][] baiVietData = utils.readDataFormCSV("ThemMoiBaiViet_TC1.csv");
		BaiViet baiViet = new BaiViet();
		baiViet.setTieuDe(baiVietData[0][0]);
		baiViet.setNguoiViet(baiVietData[0][1]);
		baiViet.setHinhAnh(baiVietData[0][2]);
		baiViet.setMoTaNgan(baiVietData[0][3]);
		baiViet.setNoiDung(baiVietData[0][4]);
		data[0][1] = baiViet;

		return data;
	}

	@DataProvider(name = "ThemMoiBaiVietData_TC02")
	public Object[][] readDataTestCase2() {
		Utils utils = new Utils();
		Object[][] data = new Object[1][2];

		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		DangNhap dangNhap = new DangNhap();
		dangNhap.setUserName(dangNhapData[0][0]);
		dangNhap.setPassWord(dangNhapData[0][1]);
		data[0][0] = dangNhap;

		String[][] baiVietData = utils.readDataFormCSV("ThemMoiBaiViet_TC2.csv");
		BaiViet baiViet = new BaiViet();
		baiViet.setTieuDe(baiVietData[0][0]);
		baiViet.setNguoiViet(baiVietData[0][1]);
		baiViet.setHinhAnh(baiVietData[0][2]);
		baiViet.setMoTaNgan(baiVietData[0][3]);
		baiViet.setNoiDung(baiVietData[0][4]);
		data[0][1] = baiViet;

		return data;
	}

	@DataProvider(name = "ThemMoiBaiVietData_TC03")
	public Object[][] readDataTestCase3() {
		Utils utils = new Utils();
		Object[][] data = new Object[1][2];

		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		DangNhap dangNhap = new DangNhap();
		dangNhap.setUserName(dangNhapData[0][0]);
		dangNhap.setPassWord(dangNhapData[0][1]);
		data[0][0] = dangNhap;

		String[][] baiVietData = utils.readDataFormCSV("ThemMoiBaiViet_TC3.csv");
		BaiViet baiViet = new BaiViet();
		baiViet.setTieuDe(baiVietData[0][0]);
		baiViet.setNguoiViet(baiVietData[0][1]);
		baiViet.setHinhAnh(baiVietData[0][2]);
		baiViet.setMoTaNgan(baiVietData[0][3]);
		baiViet.setNoiDung(baiVietData[0][4]);
		data[0][1] = baiViet;

		return data;
	}

	@DataProvider(name = "ThemMoiBaiVietData_TC04")
	public Object[][] readDataTestCase4() {
		Utils utils = new Utils();
		Object[][] data = new Object[1][2];

		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		DangNhap dangNhap = new DangNhap();
		dangNhap.setUserName(dangNhapData[0][0]);
		dangNhap.setPassWord(dangNhapData[0][1]);
		data[0][0] = dangNhap;

		String[][] baiVietData = utils.readDataFormCSV("ThemMoiBaiViet_TC4.csv");
		BaiViet baiViet = new BaiViet();
		baiViet.setTieuDe(baiVietData[0][0]);
		baiViet.setNguoiViet(baiVietData[0][1]);
		baiViet.setHinhAnh(baiVietData[0][2]);
		baiViet.setMoTaNgan(baiVietData[0][3]);
		baiViet.setNoiDung(baiVietData[0][4]);
		data[0][1] = baiViet;

		return data;
	}
}

