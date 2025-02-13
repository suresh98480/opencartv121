package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\loginData.xlsx";
		
		ExcelUtility xlUtil=new ExcelUtility(path);
		int totalrows=xlUtil.getRowCount("Sheet1");
		int totalcells=xlUtil.getCellCount("Sheet1", 1);
		
		String ocloginData[][]=new String [totalrows][totalcells];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcells;j++)
			{
				ocloginData[i-1][j]=xlUtil.getCellData("Sheet1", i, j);
			}
		}
		return ocloginData;
	}

}
