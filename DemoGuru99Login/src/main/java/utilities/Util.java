package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;



public class Util {
	  
	  public static final String EXPECT_ERROR = "User or Password is not valid";
	  public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
	
	 static  String[][] tableArray= null;
	
	public static String[][] getDataFromExcel(String xfilepath, String sheetname) throws Exception, IOException{
		
		
        String[][] tableArray= null;
        
        
        File file=new File(xfilepath);
        FileInputStream st=new FileInputStream(file);        
        Workbook workbook= new HSSFWorkbook(st);
        Sheet sheet=workbook.getSheet(sheetname);

        int totalRows= sheet.getLastRowNum();
		int totalCols= (sheet.getRow(0).getLastCellNum());
		
		tableArray=new String[totalRows][totalCols];
		
	
		//storing all data into an array
		for(int i=1;i<totalRows+1;i++){
			for(int j=0;j<totalCols;j++){
				
				tableArray[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				
				
			}
			
		}
		

workbook.close();
		
return (tableArray);




}
	
public static void main(String[] args) throws Exception, IOException {
		File file=new File("C:\\Users\\Vibha\\eclipse-workspace\\DemoGuru99Login\\TestData\\testData.xls");
		FileInputStream st=new FileInputStream(file);
		
		Workbook workbook= new HSSFWorkbook(st);
		Sheet sheet=workbook.getSheet("Data");
		
		
		System.out.println("First Row NUm is =="+sheet.getFirstRowNum());
		System.out.println("last Row NUm is =="+sheet.getLastRowNum());
		System.out.println("columns are =="+sheet.getRow(0).getLastCellNum());
		
		 int totalRows= sheet.getLastRowNum();
			int totalCols= (sheet.getRow(0).getLastCellNum());
			
			tableArray=new String[totalRows][totalCols];
			//[5][2]
			System.out.println("length of array is"+tableArray.length);
			
			//storing all data into an array
			for(int i=1;i<totalRows+1;i++){
				for(int j=0;j<totalCols;j++){
					
					tableArray[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println("Value of"+i+"and"+j+""+sheet.getRow(i).getCell(j).getStringCellValue());
					
				}
			
			}
			
			for(int m=0;m<tableArray.length;m++) {
				/*for(int n=0;n<totalCols;n++) {
				System.out.println("value of "+"["+m+"]"+"["+n+"]"+tableArray[m][n]);
								
				}*/
				
				System.out.println(tableArray[m][0]);
				System.out.println(tableArray[m][1]);
			}
		
		workbook.close();
		
	}
	

}
