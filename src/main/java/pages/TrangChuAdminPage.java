package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrangChuAdminPage extends Page {
	public By lblSanPham =  By.xpath("//*[text()='Sản Phẩm']");
	public By lblThemMoi =  By.xpath("//a[text()='Thêm mới']");
	public By txtTenSanPham =  By.id("product-name");

	public TrangChuAdminPage(WebDriver dr) {
		super(dr);
	}
	public void themMoi() {
base.clickOnElement(lblSanPham);
base.clickOnElement(lblThemMoi);
base.inputText(txtTenSanPham, "Quần áo");
	}

}

