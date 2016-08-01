package com.hand;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class App {
	public static void main(String[] args) {
		//--------生成xml文件--------
		HttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://hq.sinajs.cn/list=sz300170");
		try {

			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, "UTF-8");
			result = result.substring(result.indexOf("\"")+1);
			//以逗号将result字符创分隔为字符串数组
			String resultStr[] = result.split(",");
			String name = resultStr[0];
			String open = resultStr[1];
			String close = resultStr[2];
			String current = resultStr[3];
			String high = resultStr[4];
			String low = resultStr[5];
			
			//创建根节点  
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

			Element root = document.createElement("xml");
			Element stock = document.createElement("stock");

			Element name1 = document.createElement("name");
			name1.setTextContent(name);
			Element open1 = document.createElement("open");
			open1.setTextContent(open);
			Element close1 = document.createElement("close");
			close1.setTextContent(close);
			Element current1 = document.createElement("current");
			current1.setTextContent(current);
			Element high1 = document.createElement("high");
			high1.setTextContent(high);
			Element low1 = document.createElement("low");
			low1.setTextContent(low);

			stock.appendChild(name1);
			stock.appendChild(open1);
			stock.appendChild(close1);
			stock.appendChild(current1);
			stock.appendChild(high1);
			stock.appendChild(low1);
			root.appendChild(stock);
			document.appendChild(root);

			//将document写入xml文件
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(new File("hand.xml")));

			//-----------生成json文件----------
			


		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} 
	}
}

