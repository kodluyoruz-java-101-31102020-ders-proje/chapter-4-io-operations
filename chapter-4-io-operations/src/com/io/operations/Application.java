package com.io.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class Application {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {

		// readWriteResourceFile();
		
		readWriteExternalFile();
	}
	
	private static void readWriteExternalFile() throws FileNotFoundException, URISyntaxException {
		
		// Section 2
		
		// read operation from external resource
		String externalFilePath = "/Users/batuhan.duzgun/Documents/context.txt";
		InputStream externalInputStream = FileOperations.getInputStream(externalFilePath, false);
		String externalFileContent = FileOperations.read(externalInputStream);
		System.out.println("External Original File:");
		System.out.println(externalFileContent);
		
		
		// write operation from external resource
		
		File externalFile = new File(externalFilePath);
		FileOperations.write(externalFile, "1=2\n 2=2\n 3=4 \n");
		
		FileInputStream inputStream = new FileInputStream(externalFile);
		String externalModifiedFileContent = FileOperations.read(inputStream);
		System.out.println("External Modified File:");
		System.out.println(externalModifiedFileContent);
	}
	
	private static void readWriteResourceFile() throws FileNotFoundException, URISyntaxException {
		// Section 1
		String resourceFilePath = "app/context.properties";
		
		// read operation from resource file
		InputStream inputStream = FileOperations.getInputStream(resourceFilePath, true);
		String fileContent = FileOperations.read(inputStream);
		System.out.println("Original File Content:");
		System.out.println(fileContent);

		
		// write operation from resource file
		
		File resourceFileOrg = FileOperations.getFile(resourceFilePath);
		FileOperations.write(resourceFileOrg, "kodluyoruz=2020\n");
		File resourceFile = FileOperations.getFile(resourceFilePath);
		
		String modifiedFileContent = FileOperations.read(new FileInputStream(resourceFile));
		System.out.println("Modified File Content:");
		System.out.println(modifiedFileContent);
	}
}
