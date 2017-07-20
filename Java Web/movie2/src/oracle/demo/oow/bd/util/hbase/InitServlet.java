package oracle.demo.oow.bd.util.hbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import oracle.demo.oow.bd.util.FileWriterUtil;

@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {

	@Override
	public void init(ServletConfig conf) throws ServletException {
		//读取conf.properties配置文件
		super.init(conf);
		String path;
		FileInputStream fis;
		try {
			path=InitServlet.class.getResource("/").getPath();
			fis=new FileInputStream(path+"conf.properties");
			Properties properties=new Properties();
			properties.load(fis);
			fis.close();
			
			String outputFile=properties.getProperty("output_file");
			if(outputFile!=null){
				FileWriterUtil.OUTPUT_FILE=outputFile;
			}
			
			String zookeeper=properties.getProperty("hbase.zookeeper.quorum");
			if(zookeeper!=null){
				ConstantsHBase.ZOOKEEPER=zookeeper;
			}
			
			String rootdir=properties.getProperty("hbase.rootdir");
			if(rootdir!=null){
				ConstantsHBase.HBASE_ROOT_DIR=rootdir;
			}
			
			String username=properties.getProperty("mysql.username");
			if(username!=null){
				ConstantsHBase.MYSQL_USERNAME=username;
			}
			String password=properties.getProperty("mysql.password");
			if(password!=null){
				ConstantsHBase.MYSQL_PASSWORD=password;
			}
			String url=properties.getProperty("mysql.url");
			if(url!=null){
				ConstantsHBase.MYSQL_URL=url;
			}
			String driver=properties.getProperty("mysql.driver");
			if(driver!=null){
				ConstantsHBase.MYSQL_DRIVER=driver;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
