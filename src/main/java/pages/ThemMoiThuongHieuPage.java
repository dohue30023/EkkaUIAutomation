package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.models.ThuongHieu;

public class ThemMoiThuongHieuPage extends Page{
	public By txtTenDanhMuc = By.name("name");
	public By txtMaCode = By.name("code");
	public By txtNguoiTao = By.name("user");
	public By txtHinhAnh = By.id("upload-thumb");
	public By btnThemMoi = By.id("btn-submit");

	// CKEditor iframe + editable body for 'Mô Tả'
	public By iframeMoTa = By.cssSelector("iframe.cke_wysiwyg_frame");
	public By txtMoTa = By.cssSelector("body.cke_editable");

	public ThemMoiThuongHieuPage(WebDriver dr) {
		super(dr);
	}
	
	public void inputData(ThuongHieu thuongHieu) {
		base.inputText(txtTenDanhMuc, thuongHieu.getTenDanhMuc());
		base.inputText(txtMaCode, thuongHieu.getMaCode());
		base.inputText(txtNguoiTao, thuongHieu.getNguoiTao());

		String picturePath = System.getProperty("user.dir") + "\\testcase\\testdata\\";
		base.inputText(txtHinhAnh, picturePath + thuongHieu.getHinhAnh());

		try {
			    driver.switchTo().frame(driver.findElement(iframeMoTa));
			    WebElement body = driver.findElement(txtMoTa);
			    ((org.openqa.selenium.JavascriptExecutor) driver)
				    .executeScript("arguments[0].innerHTML = arguments[1];", body, thuongHieu.getMoTa());
			    driver.switchTo().defaultContent();
			    // Ensure the hidden textarea value is set so form submission includes description
			    ((org.openqa.selenium.JavascriptExecutor) driver)
				    .executeScript("document.getElementById('desc').value = arguments[0];", thuongHieu.getMoTa());
		} catch (org.openqa.selenium.NoSuchElementException ex) {
			// If CKEditor iframe not present, try to input directly into element
			    base.inputText(By.id("desc"), thuongHieu.getMoTa());
		}

		base.clickOnElement(btnThemMoi);
	}

	public String getAlertMessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = "";
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		result = alert.getText();
		return result;
	}
	
	public void clickThemMoi() {
		base.clickOnElement(btnThemMoi);
	}
}
