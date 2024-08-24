package myalice_automation_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass {
	
	WebDriver driver;
	
	public  PageObjectClass(WebDriver d) {
		
		driver=d;
		PageFactory.initElements(d, this);
		
	}
	
	@FindBy(id="username")
	WebElement UserName;
	public void setUserName(String username) {
		UserName.sendKeys(username);
	}

	@FindBy(id="password")
	WebElement Password;
	public void setPassword(String pass) {
		Password.sendKeys(pass);
	}
	@FindBy(id="login-btn")
	WebElement LoginBtn;
	public void clickLoginBtn() {
		LoginBtn.click();
	}
	
	//search box 
	
	@FindBy(id="manga-search")
	WebElement mangaSearch;
	
	public void setmangaSearch(String ms) {
		mangaSearch.sendKeys(ms);
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]/button")
	WebElement Search;
	
	public void clickSearch() {
		Search.click();
	}
	
	//click details
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[7]/p[1]/span")
	WebElement details;
	public void clcikdetails() {
		details.click();
	}
	
	//close btn click
	@FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div/button")
	WebElement CloseBtn;
	 public void clickCloseBtn() {
		 CloseBtn.click();
	 }
	
	
	
} 	
