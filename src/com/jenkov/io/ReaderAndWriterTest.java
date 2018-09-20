package com.jenkov.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ReaderAndWriterTest {

	public static void main(String[] args) {
		InputStream inputStream = null;
		Reader reader = null;
		try {
			inputStream = new FileInputStream("e:/1.txt");
			reader = new InputStreamReader(inputStream);
			int data = reader.read();
			while(data != -1){
			    char theChar = (char) data;
			    System.out.print(theChar);
			    data = reader.read();
			    
			}
			
			OutputStream outputStream = new FileOutputStream("e:\\4.txt");
			Writer writer = new OutputStreamWriter(outputStream);
			writer.write("Hello World");
			writer.close();
			
			Reader fReader = new FileReader("e:\\4.txt");
			System.out.println();
			while(-1 != (data = fReader.read())) {
				System.out.print((char)data);
			    //do something with data...
			}
			 
			fReader.close();


			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		

	}
}
