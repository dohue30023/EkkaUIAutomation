package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.models.BaiViet;

public class ThemMoiBaiVietPage extends Page{
	public By txtTieuDe = By.id("title");
	public By txtNguoiViet = By.name("user");
	public By txtHinhAnh = By.name("image");
	public By txtMoTaNgan = By.id("desc");
	public By iframeNoiDung = By.cssSelector("iframe.cke_wysiwyg_frame");
	public By txtNoiDung = By.cssSelector("body.cke_editable");
	public By btnThemMoi = By.name("btn_submit");

	public ThemMoiBaiVietPage(WebDriver dr) {
		super(dr);
	}
	
	public void inputData(BaiViet baiViet) {
		base.inputText(txtTieuDe, baiViet.getTieuDe());
		base.inputText(txtNguoiViet, baiViet.getNguoiViet());
		String picturePath = System.getProperty("user.dir") + "\\testcase\\" + "testdata\\" + "\\";
		base.inputText(txtHinhAnh, picturePath + baiViet.getHinhAnh());
		base.inputText(txtMoTaNgan, baiViet.getMoTaNgan());
		// CKEditor lives inside an iframe. Switch to it, set the body HTML, then switch back
		driver.switchTo().frame(driver.findElement(iframeNoiDung));
		WebElement body = driver.findElement(txtNoiDung);
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = arguments[1];", body, baiViet.getNoiDung());
		driver.switchTo().defaultContent();
		base.clickOnElement(btnThemMoi);
	}
	
	public String getAlertMessage() {
		String result = "";
		Alert alert = driver.switchTo().alert();
		result = alert.getText();
		return result;
		

	}
}
