package common;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class Utils {
	public String[][] readDataFormCSV(String dataFileName) {
		String[][] dataTable = null;
		String csvFilePath = System.getProperty("user.dir")+"\\testcase\\"+"testdata\\"+ dataFileName;
		FileReader fileReader;
		try {
			fileReader = new FileReader(csvFilePath);
			CSVReader reader = new CSVReader(fileReader);
//			List<String[]> rows = reader.readAll();
			reader.skip(1);
			List<String[]> rows = new ArrayList<String[]>();
			String[] line;
			while((line = reader.readNext())!=null) {
				rows.add(line);
			}
			if (rows.size()< 1) {
				System.out.println("Data is not found");
			}
			dataTable= rows.toArray(new String[0][]);
			
		} catch (Exception e) {
			System.out.println("csv file not found");
			e.printStackTrace();
		}


		return dataTable;
	}

}
