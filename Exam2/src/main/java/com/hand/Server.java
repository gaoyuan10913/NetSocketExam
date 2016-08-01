package com.hand;

import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {  
	   
	   public static void main(String args[]){  

	      try {
			ServerSocket server = new ServerSocket(12345);  
			  Socket socket = server.accept();
			  JOptionPane.showMessageDialog(null, "有用户连接到了12345端口");
			  //将题一的pdf文件写入字节流
			  File file = new File("../Exam1/new.pdf");
			  FileInputStream fis = new FileInputStream(file);
			  BufferedInputStream bis = new BufferedInputStream(fis);
			  
			  OutputStream os = socket.getOutputStream();  
			  BufferedOutputStream bos = new BufferedOutputStream(os);
			  
			  byte input[] = new byte[10000];
			  int line = 0;
			  while((line = bis.read(input)) != -1){
				  bos.write(input,0,line);
			  }
			  
			  bos.close();
			  os.close();
			  bis.close();
			  fis.close();
			  server.close();
			  
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	   }  
	     
	}  