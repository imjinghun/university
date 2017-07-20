package oracle.demo.oow.bd.dao.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import com.alibaba.fastjson.JSONObject;

import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.util.hbase.ConstantsHBase;
import oracle.demo.oow.bd.util.hbase.HbaseDB;

public class GenreDAO {
	
	//获取所有电影分类信息
	public List<GenreTO> getGenres() {

		HbaseDB db=HbaseDB.getInstance();
		//genre表
		Table table =db.getTable(ConstantsHBase.TABLE_GENRE);
		//查询 genre列族
		ResultScanner resultScan;
		List<GenreTO> genreList = new ArrayList<GenreTO>();
		try {
			resultScan = table.getScanner(Bytes.toBytes(ConstantsHBase.FAMILY_GENRE_GENRE));
			//Iterator<Result> iter=resultScan.iterator();
			int genreId=0;
			GenreTO genreTO = null;
			String genreTOName = null;        
			String genreTOValue = null;        
			
			for (Result result : resultScan) {
				//获取行键
				genreId=Bytes.toInt(result.getRow());
				//获取列值
				genreTOName=Bytes.toString(result.getValue((Bytes.toBytes(ConstantsHBase.FAMILY_GENRE_GENRE)), 
						Bytes.toBytes(ConstantsHBase.QUALIFIER_GENRE_NAME)));
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("cid", "GN");
				jsonObject.put("id", genreId);
				jsonObject.put("name", genreTOName);
				genreTOValue=jsonObject.toJSONString();
				
				//genre值信息
				genreTO = new GenreTO(genreTOValue);
				genreList.add(genreTO);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        return genreList;
    }

}
