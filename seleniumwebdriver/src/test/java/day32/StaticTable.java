package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1. Find total no. of rows in the table.
		int row=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); 		//preferred if we have multiple tables in a webpage.
		//int row=driver.findElements(By.tagName("tr")).size();  		//preferred when there is only one table in a webpage.
		System.out.println("Number of Rows:"+row);
		
		//2. Find no. of columns
		int col=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		//int col=driver.findElements(By.tagName("th")).size();
		System.out.println("Number of Rows:"+col);
		
		//3. Read data from a specific row and column. ex: 5th row and 1st column
		String BookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println(BookName);
		
		
		//4. Read all the values from the table.-->> similar to matrix but here no indexing, starts from 1
		
		for(int r=2;r<=row;r++) 			//can't get here the headers as xpath doesn't have th tag.
		{
			for(int c=1;c<=col;c++)
			{
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText(); 			//can't pass string/variables in xpath so we have to follow this syntax where + should be added before and after variable and it should be in the double qoutes
				System.out.print(value+"\t"); 			//  \t is for tab
			}
			System.out.println();
		}
		
		//5. Print book names whose author is mukesh
		
		for(int r=2;r<=row;r++)
		{
			String authorname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText(); //taking text of 2nd column for each row.
			if(authorname.equals("Mukesh"))
			{
				String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookname+"\t"+authorname);
			}
		
		}
		
		//6. Find total price of all the books
		int total=0;
		for(int r=2;r<=row;r++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText(); //can't perform arithmetic operation on price as everything accessed from webpage is string
			total+=Integer.parseInt(price);
		}
		System.out.println("Total price of the books:"+total);
		
	}

}
