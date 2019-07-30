package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

public class CsvDataProviders {
	
	//Method to create a file path (long string)
	private static String getFilePath(Method method) {
		StringBuilder str = new StringBuilder();
		str.append("src")
		   .append(File.separator)
		   .append("test")
		   .append(File.separator)
		   .append("resources")
		   .append(File.separator)
		   .append("dataProviders")
		   .append(File.separator)
		   .append(method.getDeclaringClass().getSimpleName())
		   .append(File.separator)
		   .append(method.getName())
		   .append(".csv");
		return str.toString();
	}

	@DataProvider(name = "csvReader")
	public static Iterator<Object[]> csvReader(Method getFilePath) {
		List<Object[]> list = new ArrayList<Object[]>();
		String pathName = getFilePath(getFilePath);
		File file = new File(pathName);
	try {
		CSVReader reader = new CSVReader(new FileReader(file));
		String[] keys = reader.readNext();
		if (keys != null) {
			String[] dataParts;
			while ((dataParts = reader.readNext()) != null) {
				Map<String, String> testData = new HashMap<String, String>();
				for (int i = 0; i < keys.length; i++) {
					testData.put(keys[i], dataParts[i]);
				}
				list.add(new Object[] { testData });
					
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathName + " was not found. \n" + e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathName + " file.\n"  + e.getStackTrace().toString());
		}
	return list.iterator();
	}

}
