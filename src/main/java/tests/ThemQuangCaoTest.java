package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.DangNhapPage;
import pages.ThemMoiQuangCaoPage;
import pages.ThemMoiSanPhamPage;
import pages.TrangChuPage;
import tests.models.DangNhap;
import tests.models.QuangCao;
import tests.models.SanPham;

public class ThemQuangCaoTest extends TestCase{
	@Test(testName = "[Thêm mới] Kiểm tra thêm mới thành công một slider", dataProvider = "ThemMoiQuangCao_TC1.csv")
	public void themMoiThanhCong(DangNhap dangNhap, QuangCao quangCao) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		ThemMoiQuangCaoPage themMoiQuangCaoPage = trangChuPage.clickThemMoiQuangCao();
		themMoiQuangCaoPage.inputData(quangCao);
		String expectedMessage = "Thêm mới thành công";
		String actualMessage = themMoiQuangCaoPage.getAlertMessage();
		System.out.println("EXPECTED: [" + expectedMessage + "] | ACTUAL: [" + actualMessage + "]");
		assertEquals(expectedMessage, actualMessage); //TestNG framework
	}
	
	@DataProvider(name = "ThemMoiQuangCao_TC1.csv")
	public Object[][] readDataTestCase1() {
		Utils utils = new Utils();
		Object[][] data = new Object[1][2];

		// Đọc dữ liệu đăng nhập
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		DangNhap dangNhap = new DangNhap();
		dangNhap.setUserName(dangNhapData[0][0]);
		dangNhap.setPassWord(dangNhapData[0][1]);
		data[0][0] = dangNhap;

		// Đọc dữ liệu sản phẩm
		String[][] quangCaoData = utils.readDataFormCSV("ThemMoiQuangCao_TC1.csv");
		QuangCao quangCao = new QuangCao();
		quangCao.setNguoiTao(quangCaoData[0][0]);
		quangCao.setKieu(quangCaoData[0][1]);
		quangCao.setHinhAnh(quangCaoData[0][2]);
		data[0][1] = quangCao;
		return data;
	}
}
