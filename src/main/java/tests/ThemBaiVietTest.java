package tests;

import org.testng.annotations.Test;

import pages.DangNhapPage;
import pages.ThemMoiBaiVietPage;
import pages.ThemMoiSanPhamPage;
import pages.TrangChuPage;
import tests.models.BaiViet;
import tests.models.DangNhap;
import tests.models.SanPham;

	public class ThemBaiVietTest extends TestCase {
		@Test(testName = "[Thêm mới] Kiểm tra thêm mới thành công một bài viết", dataProvider = "ThemMoiBaiViet.csv")
		public void themMoiThanhCong(DangNhap dangNhap, BaiViet baiViet) {
			DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
//			TrangChuPage trangChuAdminPage = dangNhapPage.login("admin", "admin");
			TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
			ThemMoiBaiVietPage themMoiPage = trangChuPage.clickThemMoiBaiViet();
			themMoiPage.inputData(baiViet);
			
		}
	}
