package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {  
	   
	   public static void main(String args[]){  

	     try {
			Socket client = new Socket("127.0.0.1", 12345);  
			 //建立文件用于存储从服务器传出来的数据
			 File file = new File("exam.pdf");
			 FileOutputStream fos = new FileOutputStream(file);
			 BufferedOutputStream bos = new BufferedOutputStream(fos);
			 //获取服务器端数据
			 InputStream is = client.getInputStream();
			 BufferedInputStream bis = new BufferedInputStream(is);
			 
			 byte input[] = new byte[10000];
			 int line = 0;
			 while((line = bis.read(input)) != -1){
				 bos.write(input,0,line);
			 }
			 bis.close();
			 is.close();
			 bos.close();
			 fos.close();
			 client.close();
			 
			 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	     
	   }  
	     
	}  