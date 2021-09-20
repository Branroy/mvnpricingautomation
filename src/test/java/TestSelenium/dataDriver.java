package TestSelenium;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriver {

	//identify testcases colum by scanning the entire 1st row
	//once coloumn is identified then scan entire testcase coloum to identify puchase test case row
	//after you grab purchase test case row = pull all the data of that row and feed it
	
	
	public ArrayList<String> getData(String testcasesname) throws IOException {
		// TODO Auto-generated method stub
		
		//fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("D://DataDriven.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
					{
			XSSFSheet sheet=workbook.getSheetAt(i);
	 
			Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
			Row firstrow = rows.next();
			Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
			int k=0;
			int coloumn = 0;
		while (ce.hasNext()) {
			Cell value=ce.next();
			if(value.getStringCellValue().equalsIgnoreCase("TestCases")){
				coloumn=k;
			}
			k++;
			
		}
		//System.out.println(coloumn);
		//once coloumn is identified then scan entire testcase coloum to identify puchase test case row
		while(rows.hasNext()) {
			Row r=rows.next();
			if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasesname)) {
				////after you grab purchase test case row = pull all the data of that row and feed it
				Iterator<Cell> cv=r.cellIterator();
				while(cv.hasNext()) 
				{
				Cell c= cv.next();
				if (c.getCellType()==XSSFCell.CELL_TYPE_STRING) {
					a.add(c.getStringCellValue());	
				}
				else {
					a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					
				}
				
				}
			}
			
			}
					}
		}
		return a;
	}

}
