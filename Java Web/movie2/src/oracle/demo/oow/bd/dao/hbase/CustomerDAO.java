package oracle.demo.oow.bd.dao.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;

import com.alibaba.fastjson.JSONObject;

import oracle.demo.oow.bd.to.ActivityTO;
import oracle.demo.oow.bd.to.CustomerGenreTO;
import oracle.demo.oow.bd.to.CustomerTO;
import oracle.demo.oow.bd.to.GenreMovieTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.to.ScoredGenreTO;
import oracle.demo.oow.bd.util.StringUtil;
import oracle.demo.oow.bd.util.hbase.ConstantsHBase;
import oracle.demo.oow.bd.util.hbase.HbaseDB;

public class CustomerDAO {

	private static int MOVIE_MAX_COUNT = 25;
	//返回电影分类信息genreMaxCount条    int custId, int movieMaxCount无用
    public List<GenreMovieTO> getMovies4Customer(int custId, int movieMaxCount, int genreMaxCount) {

    	HbaseDB db=HbaseDB.getInstance();
    	Table table = db.getTable(ConstantsHBase.TABLE_GENRE);
    	//获取N行内容
    	Filter filter = new PageFilter(genreMaxCount);
    	Scan scan = new Scan();
    	
    	GenreMovieTO genreMovieTO = null;
    	GenreTO genreTO = null;
        //List<MovieTO> movieList = null;
        
    	scan.setFilter(filter);
    	ResultScanner resultScanner;
    	List<GenreMovieTO> genreMovieList = new ArrayList<GenreMovieTO>();
		try {
			resultScanner = table.getScanner(scan);
			int genreId=0;
			String genreName=null;
			for (Result result : resultScanner) {
				//行键
				genreId=Bytes.toInt(result.getRow());
				//列值
				genreName=Bytes.toString(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_GENRE_GENRE), Bytes.toBytes(ConstantsHBase.QUALIFIER_GENRE_NAME)));
				
				genreTO = new GenreTO();
				genreTO.setId(genreId);
				genreTO.setName(genreName);
				
				genreMovieTO = new GenreMovieTO();
				genreMovieTO.setGenreTO(genreTO);
				
				genreMovieList.add(genreMovieTO);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        return genreMovieList;
    } 
    
    //genre表中 返回某类电影MOVIE_MAX_COUNT个  custId无用
    /**
     * 先使用前缀过滤器和分页过滤器，获取某类电影MOVIE_MAX_COUNT个
     * 获取movieId
     * 根据movieId获取此电影相关信息
     * @param custId
     * @param genreId
     * @return
     */
    public List<MovieTO> getMovies4CustomerByGenre(int custId, int genreId) {
    	List<MovieTO> movieList = new ArrayList<MovieTO>();
    	MovieDAO movieDAO=null;
    	MovieTO movieTO = null;
    	
    	HbaseDB db=HbaseDB.getInstance();
    	Table table_genre = db.getTable(ConstantsHBase.TABLE_GENRE);
    	//前缀
    	Filter filter_prefix = new PrefixFilter(Bytes.toBytes(genreId+"_"));
    	//分页
    	Filter filter_page = new PageFilter(MOVIE_MAX_COUNT);

    	FilterList filters=new FilterList(filter_page,filter_prefix);
    	
    	Scan scan = new Scan();
    	scan.setFilter(filters);
    	ResultScanner resultScanner=null;
    	try {
			resultScanner=table_genre.getScanner(scan);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	if(resultScanner!=null){
    		int movieId=0;
			String genre_movie=null;
			for (Result result : resultScanner) {
				movieDAO=new MovieDAO();
				movieTO=new MovieTO();
				genre_movie=Bytes.toString(result.getRow());
				//获取movieId
				movieId=Integer.parseInt(genre_movie.split("_")[1]);
				movieTO=movieDAO.getMovieById(movieId);
				if (StringUtil.isNotEmpty(movieTO.getPosterPath())) {
                    movieTO.setOrder(100);
                } else {
                    movieTO.setOrder(0);
                }
				movieList.add(movieTO);
			}
    	}
    	 Collections.sort(movieList);
        return movieList;
    }
    
    /**
     * 从activity表
     * 通过userid movieid获取activityTO的信息
     * 通过列值过滤器 得到行键 根据行键 获取activityTO信息
     */
    public ActivityTO getMovieRating(int custId, int movieId) {
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
    } //getMovieRating
    
	//向表中插入数据
	public void insertCustomerProfile(CustomerTO custTO) {
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_USER);
		
		//id --> username 映射
		Put put= new Put(Bytes.toBytes(custTO.getId()));
		
		put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_USER_USER) , Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_NAME), Bytes.toBytes(custTO.getName()));
		put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_USER_USER) , Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_EMAIL), Bytes.toBytes(custTO.getEmail()));
		put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_USER_USER) , Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_USERNAME), Bytes.toBytes(custTO.getUserName()));
		put.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_USER_USER) , Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_PASSWORD), Bytes.toBytes(custTO.getPassword()));
	
		// username-->id映射
		Put put2=new Put(Bytes.toBytes(custTO.getUserName()));
		
		put2.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_USER_ID) , Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_ID), Bytes.toBytes(custTO.getId()));
		List<Put> puts=new ArrayList<>();
		puts.add(put);
		puts.add(put2);
		
		try {
			table.put(puts);
			table.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	//验证用户身份
	public CustomerTO getCustomerByCredential(String username, String password) {

		CustomerTO customerTO = null;

        if (StringUtil.isNotEmpty(username) && StringUtil.isNotEmpty(password)) {
        	int id=getCustomerByUsername(username);
        	if(id!=0){
        		//通过id获取 此行用户信息
        		customerTO=getCustomerById(id);
        		//信息存在 密码错误返回 null
        		if(customerTO!=null){
        			if(!customerTO.getPassword().equals(password)){
        				customerTO= null;
        			}
        		}
        	}
        }
        return customerTO;
	}

	//通过id获取用户信息
	private CustomerTO getCustomerById(int id) {
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_USER);
		Get get=new Get(Bytes.toBytes(id));
		CustomerTO customerTO=new CustomerTO();
		try {
			Result result=table.get(get);
			customerTO.setId(id);
			customerTO.setName(Bytes.toString(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_USER_USER), Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_NAME))));
			customerTO.setEmail(Bytes.toString(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_USER_USER), Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_EMAIL))));
			customerTO.setPassword(Bytes.toString(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_USER_USER), Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_PASSWORD))));
			customerTO.setUserName(Bytes.toString(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_USER_USER), Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_USERNAME))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customerTO;
	}

	//通过用户名获取id
	private int getCustomerByUsername(String username) {
		int id=0;
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_USER);
		Get get=new Get(Bytes.toBytes(username));
		try {
			Result result=table.get(get);
			id=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_USER_ID), Bytes.toBytes(ConstantsHBase.QUALIFIER_USER_ID)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
	}

}