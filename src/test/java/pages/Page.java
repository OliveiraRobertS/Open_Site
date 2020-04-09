package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.bytebuddy.utility.RandomString;

public class Page {
	
	private WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public void cadastro() throws InterruptedException {
		driver.get("https://phptravels.net/admin/");
		Assert.assertTrue("Titulo da pagina difere do esperado", driver.getTitle().contentEquals("Administator Login"));
	
		/*
		 * Login
		 */
		WebElement textBox = driver.findElement(By.name("email"));
		textBox.sendKeys("admin@phptravels.com");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("demoadmin");
	
		WebElement button = driver.findElement(By.xpath("/html/body/div[2]/form[1]/button"));
		button.click();
		/*
		 * End Login
		 */
		
		Thread.sleep(5000);
		
		/*
		 * Side Bar
		 */
		WebElement expandedAccounts = driver.findElement(By.xpath("//ul[@id='social-sidebar-menu']/li[5]/a"));
		click(expandedAccounts, 10);
		
		WebElement guestCustomers = driver.findElement(By.xpath("//ul[@id='ACCOUNTS']/li/a[contains(text(), 'GuestCustomers')]"));
		click(guestCustomers, 10);
		/*
		 * End Side Bar
		 */
		
		Thread.sleep(5000);
		
		/*
		 * Button Add
		 */
		WebElement buttonAdd = driver.findElement(By.xpath("//form[@class='add_button']/button"));
		buttonAdd.click();
		
		/*
		 * Form
		 */
		WebElement firstName = driver.findElement(By.xpath("//input[@name='fname']"));
		firstName.sendKeys("Robert");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lname']"));
		lastName.sendKeys("Silva");
		
		RandomString rand = new RandomString(10);
		
		String emailValidacao = rand.nextString() + "@hotmail.com";
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys(emailValidacao);
		
		WebElement password_2 = driver.findElement(By.xpath("//input[@name='password']"));
		password_2.sendKeys("123456");
		
		WebElement mobile = driver.findElement(By.xpath("//input[@name='mobile']"));
		mobile.sendKeys("11 99999 9999");
		
		WebElement country = driver.findElement(By.xpath("//label[text()='Country']/..//a"));
		click(country, 10);
		
		String countryName = "Brazil";
		
		WebElement inputCountry = driver.findElement(By.xpath("//div[@id='select2-drop']//input"));
		inputCountry.sendKeys(countryName);
		
		WebElement selectCountry = driver.findElement(By.xpath("//div[@class='select2-result-label']/span[text()='"+countryName+"']"));
		click(selectCountry, 10);
		
		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.sendKeys("Av. Ana Felicia Mendes");
		
		WebElement address2 = driver.findElement(By.xpath("//input[@name='address2']"));
		address2.sendKeys("Final da rua");
		
		WebElement bottonSubmit = driver.findElement(By.xpath("/html/body/div[3]/div/form/div[1]/div/div[3]/button"));
		bottonSubmit.click();
		/*
		 * End form
		 */
		
		Thread.sleep(5000);
		
		Assert.assertTrue("validacao do email cadastrado", driver.getPageSource().contains(emailValidacao));
	}
	
	/**
	 * Espera o elemento estar visivel na tela e clica.
	 * 
	 * @param element
	 * @param timeout
	 * @throws InterruptedException
	 */
	public static void click(WebElement element, int timeout) throws InterruptedException {
		int count = 0;
		while(count < timeout) {
			
			if(element.isDisplayed()) {
				element.click();
				break;
			}else {
					Thread.sleep(1000);
				}
				count++;
		}
		
	}
}
