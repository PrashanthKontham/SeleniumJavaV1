package frameworklibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	
	public static String getDataSetID() throws IOException {
		String tcDataset = null;

		XSSFWorkbook wrk;
		XSSFSheet shet;
		XSSFRow rww;
		XSSFCell cll;

		File fi = new File(GlobalVariables.runManagerExlPath);
		FileInputStream fin = new FileInputStream(fi);

		wrk = new XSSFWorkbook(fin);
		shet = wrk.getSheet(GlobalVariables.runManagerExlSheetName);

		// int no_of_rows=shet.getLastRowNum();
		rww = shet.getRow(1);
		// int no_of_cols=rww.getLastCellNum();

		for (int i = 0; i <= shet.getLastRowNum(); i++)

		{
			rww = shet.getRow(i + 1);
			if (rww == null)
				continue;
			cll = rww.getCell(1);
			if (cll.getStringCellValue().equals(GlobalVariables.currentMethodNameForData)) {
				cll = rww.getCell(4);
				tcDataset = cll.getStringCellValue();

			}

		}

		wrk.close();
		fin.close();

		return tcDataset;

	}
	
	public static boolean getExecuteStatus(String path, String shtName, String mthName) throws IOException {
		boolean flag = false;

		XSSFWorkbook wrk;
		XSSFSheet shet;
		XSSFRow rww;
		XSSFCell cll;

		File fi = new File(path);
		FileInputStream fin = new FileInputStream(fi);

		wrk = new XSSFWorkbook(fin);
		shet = wrk.getSheet(shtName);

		// int no_of_rows=shet.getLastRowNum();
		rww = shet.getRow(1);
		// int no_of_cols=rww.getLastCellNum();

		for (int i = 0; i <= shet.getLastRowNum(); i++)

		{
			rww = shet.getRow(i + 1);
			if (rww == null)
				continue;
			cll = rww.getCell(1);
			if (cll.getStringCellValue().equals(mthName)) {
				cll = rww.getCell(3);
				String result = cll.getStringCellValue();
				flag = Boolean.parseBoolean(result);
			}

		}

		wrk.close();
		fin.close();
		return flag;

	}

	public static int getPriority(String path, String shtName, String mthName) throws IOException {
		int priority = 0;

		XSSFWorkbook wrk;
		XSSFSheet shet;
		XSSFRow rww;
		XSSFCell cll;

		File fi = new File(path);
		FileInputStream fin = new FileInputStream(fi);

		wrk = new XSSFWorkbook(fin);
		shet = wrk.getSheet(shtName);

		// int no_of_rows=shet.getLastRowNum();
		rww = shet.getRow(1);
		// int no_of_cols=rww.getLastCellNum();

		for (int i = 0; i <= shet.getLastRowNum(); i++)

		{
			rww = shet.getRow(i + 1);
			if (rww == null)
				continue;
			cll = rww.getCell(1);
			if (cll.getStringCellValue().equals(mthName)) {
				cll = rww.getCell(0);
				String result = cll.getStringCellValue();
				priority = Integer.parseInt(result);
			}

		}

		wrk.close();
		fin.close();
		return priority;

	}

	public static String getDescription(String path, String shtName, String mthName) throws IOException {
		String tcDdescription = null;

		XSSFWorkbook wrk;
		XSSFSheet shet;
		XSSFRow rww;
		XSSFCell cll;

		File fi = new File(path);
		FileInputStream fin = new FileInputStream(fi);

		wrk = new XSSFWorkbook(fin);
		shet = wrk.getSheet(shtName);

		// int no_of_rows=shet.getLastRowNum();
		rww = shet.getRow(1);
		// int no_of_cols=rww.getLastCellNum();

		for (int i = 0; i <= shet.getLastRowNum(); i++)

		{
			rww = shet.getRow(i + 1);
			if (rww == null)
				continue;
			cll = rww.getCell(1);
			if (cll.getStringCellValue().equals(mthName)) {
				cll = rww.getCell(2);
				tcDdescription = cll.getStringCellValue();

			}

		}

		wrk.close();
		fin.close();

		return tcDdescription;

	}

	public static String getIterationType(String path, String shtName, String mthName) throws IOException {
		String tcDdescription = null;

		XSSFWorkbook wrk;
		XSSFSheet shet;
		XSSFRow rww;
		XSSFCell cll;

		File fi = new File(path);
		FileInputStream fin = new FileInputStream(fi);

		wrk = new XSSFWorkbook(fin);
		shet = wrk.getSheet(shtName);

		// int no_of_rows=shet.getLastRowNum();
		rww = shet.getRow(1);
		// int no_of_cols=rww.getLastCellNum();

		for (int i = 0; i <= shet.getLastRowNum(); i++)

		{
			rww = shet.getRow(i + 1);
			if (rww == null)
				continue;
			cll = rww.getCell(1);
			if (cll.getStringCellValue().equals(mthName)) {
				cll = rww.getCell(4);
				tcDdescription = cll.getStringCellValue();

			}

		}

		wrk.close();
		fin.close();

		return tcDdescription;

	}

	public static int getNumOfTimesTCtoRun(String path, String shtName, String mthName) throws IOException {
		// String tcDdescription=null;

		XSSFWorkbook wrk;
		XSSFSheet shet;
		XSSFRow rww;
		XSSFCell cll;

		File fi = new File(path);
		FileInputStream fin = new FileInputStream(fi);

		wrk = new XSSFWorkbook(fin);
		shet = wrk.getSheet(shtName);

		// int no_of_rows=shet.getLastRowNum();
		rww = shet.getRow(1);
		// int no_of_cols=rww.getLastCellNum();

		int count = 0;

		for (int i = 0; i <= shet.getLastRowNum(); i++)

		{
			rww = shet.getRow(i + 1);
			if (rww == null)
				continue;
			cll = rww.getCell(1);
			if (cll.getStringCellValue().equals(mthName)) {
				count = count + 1;

			}

		}

		wrk.close();
		fin.close();

		return count;

	}

	public static List<String> getTCData(String path, String shtName, String methodName, int iteration)
			throws IOException {

		List<String> sdata = new ArrayList<String>();

		XSSFWorkbook wrk;
		XSSFSheet shet;
		XSSFRow rw;
		XSSFCell cl;

		File fi = new File(path);
		FileInputStream fin = new FileInputStream(fi);

		wrk = new XSSFWorkbook(fin);
		shet = wrk.getSheet(shtName);

		rw = shet.getRow(1);

		for (int i = 0; i <= shet.getLastRowNum(); i++)

		{
			rw = shet.getRow(i + 1);
			if (rw == null)
				continue;

			int ite = Integer.parseInt(rw.getCell(2).getStringCellValue());

			if (rw.getCell(1).getStringCellValue().equals(methodName) && ite == iteration) {


				for (int j = 3; j < rw.getLastCellNum(); j++) {
					cl = rw.getCell(j);

					if (cl == null)
						continue;

					if (cl.getCellType() == XSSFCell.CELL_TYPE_STRING) {
						String val = cl.getStringCellValue();
						sdata.add(val);
					}

				}
				break;
			}

		}

		wrk.close();
		fin.close();
		
		return sdata;
	}
	
	public static Map<String,String> getTestData(int datasetid)
			throws IOException {

		Map<String, String> map=new HashMap<String, String>();

		XSSFWorkbook wrk;
		XSSFSheet shet;
		XSSFRow rw;
		XSSFRow rwHeader;
		XSSFCell cl;

		File fi = new File(GlobalVariables.testDataExlPath);
		FileInputStream fin = new FileInputStream(fi);

		wrk = new XSSFWorkbook(fin);
		shet = wrk.getSheet(GlobalVariables.testDataExlSheetName);

		rw = shet.getRow(1);

		for (int i = 0; i <= shet.getLastRowNum(); i++)

		{
			rwHeader=shet.getRow(0);
			rw = shet.getRow(i + 1);
			if (rw == null)
				continue;

			int ite = Integer.parseInt(rw.getCell(0).getStringCellValue());

			if (rw.getCell(1).getStringCellValue().equals(GlobalVariables.currentMethodNameForData) && ite == datasetid) {


				for (int j = 3; j < rw.getLastCellNum(); j++) {
					cl = rw.getCell(j);

					if (cl == null)
						continue;

					String val="";
					if (cl.getCellType() == XSSFCell.CELL_TYPE_STRING) {
						//val = cl.getStringCellValue();
						map.put(rwHeader.getCell(j).getStringCellValue(), cl.getStringCellValue());
						
					}
						else {
							val = String.valueOf((int) cl.getNumericCellValue());
							map.put(rwHeader.getCell(j).getStringCellValue(), val);
							
						//val = String.valueOf(cl.getNumericCellValue());
					}
					//map.put(rwHeader.getCell(j).getStringCellValue(), val);

				}
				break;
			}

		}

		wrk.close();
		fin.close();
		
		return map;
	}

}
