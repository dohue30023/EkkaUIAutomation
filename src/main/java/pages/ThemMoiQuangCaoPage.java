package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.models.QuangCao;

public class ThemMoiQuangCaoPage extends Page{
	public By txtNguoiTao = By.name("user");
	public By ddlKieu = By.name("type");
	public By txtHinhAnh = By.name("image");
	public By btnThemMoi = By.name("btn_submit");

	public ThemMoiQuangCaoPage(WebDriver dr) {
		super(dr);
	}
	public void inputData(QuangCao quangCao) {
		base.inputText(txtNguoiTao, quangCao.getNguoiTao());
		base.selectDropDownByVisibleText(ddlKieu, quangCao.getKieu());	
		String picturePath = System.getProperty("user.dir") + "\\testcase\\" + "testdata\\";
		base.inputText(txtHinhAnh, picturePath + quangCao.getHinhAnh());
		base.clickOnElement(btnThemMoi);
}

public String getAlertMessage() {
	String result = "";
	Alert alert = driver.switchTo().alert();
	result = alert.getText();
	return result;
	

}
}