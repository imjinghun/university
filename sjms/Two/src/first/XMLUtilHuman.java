package first;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import org.xml.sax.SAXException;

public class XMLUtilHuman {

		public static String getSex()
		{
			try
			{
				//创建文档对象
				DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = dFactory.newDocumentBuilder();
				Document doc;							
				doc = builder.parse(new File("configHuman.xml")); 
			
				//获取包含性别的文本节点
				NodeList nl = doc.getElementsByTagName("sex");
	            Node classNode=nl.item(0).getFirstChild();
	            String sex=classNode.getNodeValue().trim();
	            return sex;
	           }   
	           	catch(Exception e)
	           	{
	           		e.printStackTrace();
	           		return null;
	           	}
			}
}
