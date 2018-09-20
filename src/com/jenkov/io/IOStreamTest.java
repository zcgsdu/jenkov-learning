package com.jenkov.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class IOStreamTest {

	public static void main(String[] args) {
		InputStream input = null;
		OutputStream output = null;
		RandomAccessFile raf = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			input = new FileInputStream("e:/1.txt");
			int data = input.read(); 
			while(data != -1){
				System.out.print((char)data);
				
			    data = input.read();
			}
			System.out.println();
			
			output = new FileOutputStream("e:/3.txt");
			output.write("Hello World".getBytes());

			
			raf = new RandomAccessFile("e:/3.txt", "rw");
			raf.seek(200);
			long pointer = raf.getFilePointer();
			raf.read();
			raf.write("Hello World".getBytes());
			

			File file = new File("e:/3.txt");
			System.out.println(file.exists());
			System.out.println(file.length());
			System.out.println(file.renameTo(new File("e:/4.txt")));//false 被占用
			System.out.println(file.delete());
			
			if(file.isDirectory()){
				File[] files = file.listFiles();
				System.out.println(files.length);
			}
			
			oos = new ObjectOutputStream(new FileOutputStream("object.data"));
			String str = "Hello TuTu";  
			oos.writeObject(str); //etc.
			
			ois = new ObjectInputStream(new FileInputStream("object.data"));
			String object = (String) ois.readObject(); //etc.
			System.out.println(object);
			
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("binary.data"));
			 
			dos.write(45);
			 
			//byte data output.writeInt(4545);
			 
			//int data output.writeDouble(109.123);
			 
			//double data  output.close();
			
			DataInputStream dis = new DataInputStream(new FileInputStream("binary.data"));
			 
			int aByte = dis.read();
			 
			int anInt = dis.readInt();
			 
			float aFloat = dis.readFloat();
			 
			double aDouble = dis.readDouble();//etc.
			 
			dis.close();



		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				input.close();
				output.close();
				raf.close();
				ois.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}
}
