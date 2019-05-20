package frameworklibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;


public class TestDataClass {

	@DataProvider(name = "setData")
	public static Object[][] testDataGen() {

		Object data[][] = new Object[1][1];
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
	
		try {
			
			
			String iterations = ExcelUtility.getDataSetID();

			for (String eachIt : iterations.split(",")) {
				map=ExcelUtility.getTestData(Integer.parseInt(eachIt));
				list.add(map);
			}
			

		} catch (Exception e) {
				e.printStackTrace();
			}

		finally {
			
			System.out.println("code to close connections....!!!!");
		}

		data[0][0] = list;

		return data;

	}

}
