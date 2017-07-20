package oracle.demo.oow.bd.dao.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import oracle.demo.oow.bd.pojo.ActivityType;
import oracle.demo.oow.bd.pojo.BooleanType;
import oracle.demo.oow.bd.pojo.RatingType;
import oracle.demo.oow.bd.to.ActivityTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.FileWriterUtil;
import oracle.demo.oow.bd.util.KeyUtil;
import oracle.demo.oow.bd.util.hbase.ConstantsHBase;
import oracle.demo.oow.bd.util.hbase.HbaseDB;
import oracle.kv.table.PrimaryKey;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;


public class ActivityDAO {

	//存入用户活动
	public void insertCustomerActivity(ActivityTO activityTO) {
        int custId = 0;
        int movieId = 0;
        //ActivityType activityType = null;
        String jsonTxt = null;

        //CustomerDAO customerDAO = new CustomerDAO();

        if (activityTO != null) {
            jsonTxt = activityTO.getJsonTxt();
            System.out.println("User Activity| " + jsonTxt);
            /**
             * This system out should write the content to the application log
             * file.
             */
            FileWriterUtil.writeOnFile(activityTO.getActivityJsonOriginal().toString());
            
            custId = activityTO.getCustId();
            movieId = activityTO.getMovieId();

            //当用户 电影都存在时 存入数据库
            if (custId > 0 && movieId > 0) {
                //activityType = activityTO.getActivity();

                HbaseDB db = HbaseDB.getInstance();
                Long id = db.getId(ConstantsHBase.TABLE_GID,ConstantsHBase.FAMILY_GID_GID,ConstantsHBase.QUALIFIER_GID_ACTIVITY_ID);
                
                Table table=db.getTable(ConstantsHBase.TABLE_ACTIVITY);
                Put put= new Put(Bytes.toBytes(id));
                put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_ACTIVITY), Bytes.toBytes(activityTO.getActivity().getValue()));
                put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_GENRE_ID), Bytes.toBytes(activityTO.getGenreId()));
                put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_MOVIE_ID), Bytes.toBytes(activityTO.getMovieId()));
                put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_POSITION), Bytes.toBytes(activityTO.getPosition()));
                put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_PRICE), Bytes.toBytes(activityTO.getPrice()));
                put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_RATING), Bytes.toBytes(activityTO.getRating().getValue()));
                put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_RECOMMENDED), Bytes.toBytes(activityTO.isRecommended().getValue()));
                put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_USER_ID), Bytes.toBytes(activityTO.getCustId()));
                put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_TIME), Bytes.toBytes(activityTO.getTimeStamp()));
               
                try {
					table.put(put);
					table.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
                
            } //if (custId > 0 && movieId > 0)

        } //if (activityTO != null)

    } //insetCustomerActivity

	//根据custId和movieId获取activityTO
	public ActivityTO getActivityTO(int custId, int movieId) {
		ActivityTO activityTO = null;
    	ActivityDAO activityDAO=new ActivityDAO();
    	
    	HbaseDB db=HbaseDB.getInstance();
        Table table = db.getTable(ConstantsHBase.TABLE_ACTIVITY);
        
        Filter filter=new SingleColumnValueFilter(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY),
				Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_USER_ID), CompareOp.EQUAL, Bytes.toBytes(custId));
        Filter filter2=new SingleColumnValueFilter(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY),
        		Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_MOVIE_ID), CompareOp.EQUAL, Bytes.toBytes(movieId));
        
        FilterList filters=new FilterList(filter,filter2);
        
        Scan scan=new Scan();
        scan.setFilter(filters);
        ResultScanner resultScanner=null;
        try {
			resultScanner=table.getScanner(scan);
		} catch (IOException e) {
			e.printStackTrace();
		}
        if(resultScanner!=null){
        	//System.out.println("resultScanner "+resultScanner);
        	Long activityId=0l;
			//int i=0;
			for (Result result : resultScanner) {
				activityId=Bytes.toLong(result.getRow());
				///////////////////
				//System.out.println(i++ +" "+activityId);
				activityTO=activityDAO.getActivityById(activityId);
			}
        }
        return activityTO;
    } //getActivityTO
	
    //通过activityId 获取activityTO
	public ActivityTO getActivityById(Long activityId) {
		System.out.println(" 活动 id "+activityId);
		ActivityTO activityTO=null;
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_ACTIVITY);
		Get get=new Get(Bytes.toBytes(activityId));
		Result result=null;
		try {
			result=table.get(get);
			if(result!=null){
				activityTO=new ActivityTO();
				
				String recommended=Bytes.toString(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY),  Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_RECOMMENDED)));
				BooleanType booleanType=BooleanType.getType(recommended);
				activityTO.setRecommended(booleanType);
				
				int rating=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_RATING)));
				RatingType ratingType=RatingType.getType(rating);
				activityTO.setRating(ratingType);
				
				int activity=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_ACTIVITY)));
				ActivityType activityType = ActivityType.getType(activity);
				activityTO.setActivity(activityType);
				
				activityTO.setCustId(Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY),  Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_USER_ID))));
				activityTO.setMovieId(Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY),  Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_MOVIE_ID))));
				activityTO.setGenreId(Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY),  Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_GENRE_ID))));
				activityTO.setTimeStamp(Bytes.toLong(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY),  Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_TIME))));
				activityTO.setPrice(Bytes.toDouble(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY),  Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_PRICE))));
				activityTO.setPosition(Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY),  Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_POSITION))));
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return activityTO;
	}

	//用户观看列表
	// 根据activity 类型为 PAUSED_MOVIE 3
	public List<MovieTO> getCustomerCurrentWatchList(int custId) {
		//从activity表中获取 MovieId
		List<MovieTO> movieList = new ArrayList<>();
		MovieTO movieTO=null;
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_ACTIVITY);
		
		Filter filter=new SingleColumnValueFilter(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), 
				Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_USER_ID), 
				CompareOp.EQUAL, Bytes.toBytes(custId));
		
		Filter filter2=new SingleColumnValueFilter(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), 
				Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_ACTIVITY), 
				CompareOp.EQUAL, Bytes.toBytes(3));
		
		FilterList filters=new FilterList(filter,filter2);
		
		Scan scan=new Scan();
		scan.setFilter(filters);
		
		ResultScanner resultScanner=null;
		
		try {
			resultScanner=table.getScanner(scan);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(resultScanner!=null){
			int movieId;
			MovieDAO movieDAO=new MovieDAO();
			for (Result result : resultScanner) {
				movieId=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_MOVIE_ID)));
			
				movieTO=movieDAO.getMovieById(movieId);
				
				movieList.add(movieTO);
			}
		}
		Collections.sort(movieList);
        return movieList;
    }
	//用户浏览列表
	 /* 根据activity 类型为 BROWSED_MOVIE 5
	 * 根据activity进行过滤
	 */
	public List<MovieTO> getCustomerBrowseList(int custId) {
		
		List<MovieTO> movieList = new ArrayList<>();
		MovieTO movieTO=null;
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_ACTIVITY);
		
		Filter filter=new SingleColumnValueFilter(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), 
				Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_USER_ID), 
				CompareOp.EQUAL, Bytes.toBytes(custId));
		
		Filter filter2=new SingleColumnValueFilter(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), 
				Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_ACTIVITY), 
				CompareOp.EQUAL, Bytes.toBytes(5));
		
		FilterList filters=new FilterList(filter,filter2);
		
		Scan scan=new Scan();
		scan.setFilter(filters);
		
		ResultScanner resultScanner=null;
		
		try {
			resultScanner=table.getScanner(scan);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(resultScanner!=null){
			int movieId;
			MovieDAO movieDAO=new MovieDAO();
			for (Result result : resultScanner) {
				movieId=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_MOVIE_ID)));
			
				movieTO=movieDAO.getMovieById(movieId);
				
				movieList.add(movieTO);
			}
		}
		Collections.sort(movieList);
        return movieList;
    }

	//commonplaylist
	public List<MovieTO> getCommonPlayList(){
		List<MovieTO> movieList = new ArrayList<>();
		MovieTO movieTO=null;
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_ACTIVITY);
		
		Filter filter=new SingleColumnValueFilter(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), 
				Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_ACTIVITY), 
				CompareOp.EQUAL, Bytes.toBytes(6));
		
		Scan scan=new Scan();
		scan.setFilter(filter);
		
		ResultScanner resultScanner=null;
		
		try {
			resultScanner=table.getScanner(scan);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(resultScanner!=null){
			int movieId;
			MovieDAO movieDAO=new MovieDAO();
			for (Result result : resultScanner) {
				movieId=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_MOVIE_ID)));
				
				movieTO=movieDAO.getMovieById(movieId);
				
				movieList.add(movieTO);
			}
		}
		Collections.sort(movieList);
		return movieList;
	}
	//观看历史
	public List<MovieTO> getCustomerHistoricWatchList(int custId){
		List<MovieTO> movieList = new ArrayList<>();
		MovieTO movieTO=null;
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_ACTIVITY);
		
		Filter filter=new SingleColumnValueFilter(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), 
				Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_USER_ID), 
				CompareOp.EQUAL, Bytes.toBytes(custId));
		
		Filter filter2=new SingleColumnValueFilter(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), 
				Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_ACTIVITY), 
				CompareOp.EQUAL, Bytes.toBytes(2));
		
		FilterList filters=new FilterList(filter,filter2);
		
		Scan scan=new Scan();
		scan.setFilter(filters);
		
		ResultScanner resultScanner=null;
		
		try {
			resultScanner=table.getScanner(scan);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(resultScanner!=null){
			int movieId;
			MovieDAO movieDAO=new MovieDAO();
			for (Result result : resultScanner) {
				movieId=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_ACTIVITY_ACTIVITY), Bytes.toBytes(ConstantsHBase.QUALIFIER_ACTIVITY_MOVIE_ID)));
			
				movieTO=movieDAO.getMovieById(movieId);
				
				movieList.add(movieTO);
			}
		}
		Collections.sort(movieList);
        return movieList;
	}

}//ActivityDAO
