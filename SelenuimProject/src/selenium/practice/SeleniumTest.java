package selenium.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		// 1. 크롬 드라이버를 사용할 준비를 한다.
		// 자바와 크롬을 연동하기 위한 준비
		WebDriver driver = new ChromeDriver();

		// 2. 접속하고자 하는 웹페이지의 주소를 작성한다.
		// driver.get("https://finance.naver.com/");
//		driver.get("https://www.naver.com/");
//
//		/// html/body/div[2]/div[1]/div/div[5]/ul/li[6]/a/span[1]
//		// xpath란 : 태그의 경로를 써놓은것
//		// 엘리먼트를 받아오기
//		WebElement financeButton = driver
//				.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/ul/li[6]/a/span[1]"));
//		
//		// 증권 메뉴를 클릭해보자
//		financeButton.click();

		driver.get("https://finance.naver.com/");
		String mainPage = driver.getWindowHandle();
		driver.switchTo().window(mainPage);

		// input box를 받아옴
//		WebElement searchBox = driver
//				.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/form/input[1]"));
//		searchBox.sendKeys("삼성전자"); // inputBox에 삼성전자 라는 문자를 보냄

//		 1. 클릭 -> 안됨
//		 driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/form/div/div/div/div[1]/div/ul/li[1]/div[1]")).click();

		// 2. Enter버튼 입력
//		searchBox.sendKeys(Keys.ENTER);

		// 뉴스가져오기
		/// html/body/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div/ul
		/// html/body/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div/ul/li[1] -> li태그 [1]지우고 진행
		List<WebElement> newsTitleList = driver
				.findElements(By.xpath("/html/body/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div/ul/li"));

		for (WebElement webElement : newsTitleList) {
			System.out.println(webElement.getText());
		} // 데이터 크롤링
	}

}
