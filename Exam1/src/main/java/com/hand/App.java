package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App 
{
    public static void main( String[] args )
    {
    	try {
			URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
			URLConnection conn = url.openConnection();
		 	InputStream is = conn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			//输出文件
			File file = new File("new.pdf");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte input[] = new byte[1000];
			int l = 0;
			while((l = bis.read(input)) != -1){
				bos.write(input,0,l);
			}
			bos.close();
			fos.close();
			bis.close();
			is.close();
			

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
        
    }
}
