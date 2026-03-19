package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.DangNhapPage;
import pages.DanhSachSanPhamPage;
import pages.ThemMoiSanPhamPage;
import pages.TrangChuPage;
import tests.models.DangNhap;
import tests.models.SanPham;

public class TimKiemSanPhamTest extends TestCase{
	@Test(testName = "[Tìm kiếm] Kiểm tra tìm kiếm thành công khi nhập vào textbox = tên sản phẩm đã tồn tại trong DB", dataProvider = "DangNhapData")
	public void timKiemThanhCong(String username, String password) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(username, password);
		DanhSachSanPhamPage danhSachSanPhamPage = trangChuPage.clickDanhSachSanPham();
		boolean timKiemResult = danhSachSanPhamPage.getSearchResult("iPhone 11 Pro Max 64GB");
		assertTrue(timKiemResult);
	}
	
	@DataProvider(name = "DangNhapData")
	public Object[][] readDataTestCase1() {
		Utils utils = new Utils();
		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
		return dangNhapData;
	}
	
		@Test(testName = "[Tìm kiếm] Kiểm tra tìm kiếm thành công khi nhập vào textbox = tên sản phẩm chưa tồn tại trong DB", dataProvider = "TimKiemSanPham_TC2")
	public void timKiemKhongThanhCong(DangNhap dangNhap, SanPham sanPham) {
		DangNhapPage dangNhapPage = new DangNhapPage(testBase.webDriver);
		TrangChuPage trangChuPage = dangNhapPage.login(dangNhap.getUserName(), dangNhap.getPassWord());
		DanhSachSanPhamPage danhSachSanPhamPage = trangChuPage.clickDanhSachSanPham();
		boolean timKiemResult = danhSachSanPhamPage.getSearchResult("đăng tin");
		System.out.println(">>>>: " + timKiemResult);
		assertTrue(timKiemResult);
	}
	
//	@DataProvider(name = "DangNhapData2")
//	public Object[][] readDataTestCase2() {
//		Utils utils = new Utils();
//		String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
//		return dangNhapData;
//	}
		@DataProvider(name = "TimKiemSanPham_TC2")
		public Object[][] readDataTestCase2() {
			Utils utils = new Utils();
			Object[][] data = new Object[1][2];

			// Đọc dữ liệu đăng nhập
			String[][] dangNhapData = utils.readDataFormCSV("DangNhap_Data.csv");
			DangNhap dangNhap = new DangNhap();
			dangNhap.setUserName(dangNhapData[0][0]);
			dangNhap.setPassWord(dangNhapData[0][1]);
			data[0][0] = dangNhap;

			// Đọc dữ liệu sản phẩm
			String[][] sanPhamData = utils.readDataFormCSV("ThemMoi_TC1.csv");
			SanPham sanPham = new SanPham();
			sanPham.setTenSanPham(sanPhamData[0][0]);
			sanPham.setMaSanPham(sanPhamData[0][1]);
			sanPham.setGiaSanPham(sanPhamData[0][2]);
			sanPham.setGiaKhuyenMai(sanPhamData[0][3]);
			sanPham.setSoLuong(sanPhamData[0][4]);
			sanPham.setNguoiTao(sanPhamData[0][5]);
			sanPham.setManHinh(sanPhamData[0][6]);
			sanPham.setRam(sanPhamData[0][7]);
			sanPham.setCpu(sanPhamData[0][8]);
			sanPham.setBoNho(sanPhamData[0][9]);
			sanPham.setHeDieuHanh(sanPhamData[0][10]);
			sanPham.setCameraTruoc(sanPhamData[0][11]);
			sanPham.setCameraSau(sanPhamData[0][12]);
			sanPham.setDoHotSanPham(sanPhamData[0][13]);
			sanPham.setTrangThai(sanPhamData[0][14]);
			sanPham.setDanhMucSanPham(sanPhamData[0][15]);
			sanPham.setThuongHieuSanPham(sanPhamData[0][16]);
			sanPham.setHinhAnh(sanPhamData[0][17]);
			sanPham.setMoTaSanPham(sanPhamData[0][18]);
			data[0][1] = sanPham;

			return data;

		}
	
}
