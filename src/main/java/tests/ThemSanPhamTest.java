package tests;

import org.testng.annotations.Test;

import pages.DangNhapPage;
import pages.TrangChuAdminPage;

public class ThemSanPhamTest extends TestCase {
	@Test
public void themMoiThanhCong() {
DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
TrangChuAdminPage trangChuAdminPage = dangNhapPage.login("admin", "admin");
trangChuAdminPage.themMoi();
}
}
