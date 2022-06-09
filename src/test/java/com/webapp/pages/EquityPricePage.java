package com.webapp.pages;

import com.webapp.commonDef.CommonDef;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquityPricePage {

	public EquityPricePage() {}
	static By codeBy= By.xpath("//*[@id='pills-active']/table/tbody/tr[XXXX]/td[1]");
	static By nameBy= By.xpath("//*[@id='pills-active']/table/tbody/tr[XXXX]/th/div/a");
	static By changeBy=	By.xpath("//*[@id='pills-active']/table/tbody/tr[XXXX]/td[3]");
	static By volBy= By.xpath("//*[@id='pills-active']/table/tbody/tr[XXXX]/td[4]");
	static By closeBy= By.xpath("//a[text()='Close']");
	static By mostActiveBy= By.xpath("(//a[@class='nav-link btn btn-effect btn-white active' and @id='pills-active-tab'])[1]");
	
	/**
	 * Method will sort on change column and printing columns data to console
	 *
	 * 
	 * @return boolean
	 */
	public static boolean sortEquityprices() {
		String [][] table=new String[10][4];
		double []change=new double[table.length];
		List<String> codeList=new ArrayList<String>();
		
		try {
			
			CommonDef.click(closeBy);
			CommonDef.moveToElement(mostActiveBy);
			for(int i=0;i<=table.length-1;i++) {

				table[i][0]=CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(codeBy,String.valueOf(i+1))).getText();
				table[i][1]=CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(nameBy,String.valueOf(i+1))).getText();
				if(!(CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(changeBy,String.valueOf(i+1))).getText().equals("-"))) {
					change[i]=Double.parseDouble(CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(changeBy,String.valueOf(i+1))).getText());
					table[i][2]=CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(changeBy,String.valueOf(i+1))).getText();
				}
				else
				{
					table[i][2]="0.000";
				}
				table[i][3]=CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(volBy,String.valueOf(i+1))).getText();

			}
			Arrays.sort(change);	
			System.out.println("Code      |Name      |Change     |Vol         ");
			for(int j=change.length-1;j>=0;j--) {
				for(int i=0;i<=table.length-1;i++) {
					if(change[j]==Double.parseDouble((table[i][2]))&&!(codeList.contains(table[i][1])))
					{
						codeList.add(table[i][1]);
						System.out.println(CommonDef.rightPadding(table[i][0])+"|"+CommonDef.rightPadding(table[i][1])+"|"+CommonDef.rightPadding(table[i][2])+" |"+CommonDef.rightPadding(table[i][3]));
						CommonDef.logs(Arrays.toString(table[i]));
						break;
					}
				}
			}
			return true;

		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
			return false;
		}
		
	}
	


}
