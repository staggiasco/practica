package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.AbstractPageObject;

public class Marcos extends AbstractPageObject {

	public Marcos(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		// TODO Auto-generated constructor stub
	}

		WebDriverWait wait = new WebDriverWait(driver, 5);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String mNombre = "Marco";
		String hojaValue = "2";
		float ancho = 10;
		float alto = 10;
		int r = (int) (Math.random()*100);
		
		String nombreMarco = null;
		
	
	public void ingresarAMarco() {
			WebElement marco = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[3]/a"));
			marco.click();
		}
		
	public void crearNuevoMarco() {
		System.out.println("Ingreso a Marcos Nuevo");
		WebElement nuevoMarco = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[3]/ul/li[1]/a"));
		nuevoMarco.click();
		// mNombre.sendKeys("SOyunMarco");
		driver.findElement(By.id("name")).sendKeys(mNombre + r);
		new Select(driver.findElement(By.id("cmbPaper"))).selectByValue(hojaValue);
		driver.findElement(By.id("width")).sendKeys(Float.toString(ancho));
		driver.findElement(By.id("height")).sendKeys(Float.toString(alto));
		driver.findElement(By.id("btnSave")).click();
		new Select(driver.findElement(By.name("layouts_length"))).selectByValue("100");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void eliminarMarco() {

		WebElement registro = driver.findElement(By.xpath("//*[@id='layouts_length']/label/select"));
		new Select(registro).selectByValue("100");

		int i = 0;

		WebElement tdbody = driver.findElement(By.xpath("//*[@id='layouts']/tbody"));

		List<WebElement> trs = tdbody.findElements(By.xpath("tr"));

		for (WebElement td : trs) {

			i++;

			System.out.println("========================");
			System.out.println("    La TR de la Tabla   ");
			System.out.println("========================");

			List<WebElement> tds = td.findElements(By.tagName("td"));

			for (WebElement g : tds) {

				String nomElem = g.getText();

				if (nomElem.equalsIgnoreCase(nombreMarco)) {
					nomElem = "BORRADO";
					td.findElement(By.xpath("//*[@id=\"layouts\"]/tbody/tr[" + i + "]/td[1]/button")).click();
					WebElement botonConf = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[1]"));
					wait.until(ExpectedConditions.visibilityOf(botonConf));
					botonConf.click();
				}

				System.out.println(nomElem);

			}

			System.out.println("Contador en :" + i);

		}
	}
	
}
