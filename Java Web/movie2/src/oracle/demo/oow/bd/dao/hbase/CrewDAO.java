package oracle.demo.oow.bd.dao.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;

import oracle.demo.oow.bd.dao.hbase.MovieDAO;
import oracle.demo.oow.bd.to.CastCrewTO;
import oracle.demo.oow.bd.to.CastMovieTO;
import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.CrewTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.KeyUtil;
import oracle.demo.oow.bd.util.StringUtil;
import oracle.demo.oow.bd.util.hbase.ConstantsHBase;
import oracle.demo.oow.bd.util.hbase.HbaseDB;

public class CrewDAO {

	public void insertCrewInfo(CrewTO crewTO) {
		HbaseDB db=HbaseDB.getInstance();
        //crew表  movie表  
        Table table_crew=db.getTable(ConstantsHBase.TABLE_CREW);
        Table table_movie=db.getTable(ConstantsHBase.TABLE_MOVIE);
        
        //crew表   crew列族
        Put put_crew=new Put(Bytes.toBytes(crewTO.getId()));
        put_crew.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_CREW_CREW),Bytes.toBytes(ConstantsHBase.QUALIFIER_CREW_NAME), Bytes.toBytes(crewTO.getName()));
        put_crew.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_CREW_CREW),Bytes.toBytes(ConstantsHBase.QUALIFIER_CREW_JOB), Bytes.toBytes(crewTO.getJob()));
        
        List<String> movieList=crewTO.getMovieList();
        int movieId = 0;
        
        List<Put> putcrewmovie = new ArrayList<>();
        List<Put> putmoviecrew=new ArrayList<>();
        for (String movieIdStr : movieList) {
        	movieId = Integer.parseInt(movieIdStr);
        	//crew表   movie列族
        	Put put_crew_movie=new Put(Bytes.toBytes(crewTO.getId()+"_"+movieId));
        	put_crew_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_CREW_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_CREW_MOVIE_ID), Bytes.toBytes(movieId));
        	
        	putcrewmovie.add(put_crew_movie);
        	
        	//movie表 crew列族
        	Put put_movie_crew=new Put(Bytes.toBytes(movieId+"_"+crewTO.getId()));
        	put_movie_crew.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_CREW),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_CREW_ID), Bytes.toBytes(crewTO.getId()));
        	
        	putmoviecrew.add(put_movie_crew);
		}
        
        
        try {
        	table_crew.put(put_crew);
        	table_crew.put(putcrewmovie);
        	table_movie.put(putmoviecrew);
        	
        	table_crew.close();
        	table_movie.close();
        	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CrewTO getCrewById(int crewId) {
		HbaseDB db=HbaseDB.getInstance();
		Table table = db.getTable(ConstantsHBase.TABLE_CREW);
		//根据crewId获取crew信息
		Get get=new Get(Bytes.toBytes(crewId));
		Result result2=null;
		CrewTO crewTO=new CrewTO();
		try {
			result2 = table.get(get);
			crewTO.setId(crewId);
			crewTO.setName(Bytes.toString(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_CREW_CREW), Bytes.toBytes(ConstantsHBase.QUALIFIER_CREW_NAME))));
			crewTO.setJob(Bytes.toString(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_CREW_CREW), Bytes.toBytes(ConstantsHBase.QUALIFIER_CREW_JOB))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crewTO;
    } //getCastById
	
	//crew表 根据crewId获取MovieTO List
	 public List<MovieTO> getMoviesByCrew(int crewId) {
	  
		 MovieTO movieTO=null;
	    	List<MovieTO> movieList=new ArrayList<>();
	    	HbaseDB db=HbaseDB.getInstance();
	    	Table table=db.getTable(ConstantsHBase.TABLE_CREW);
	    	
	    	Filter filter=new PrefixFilter(Bytes.toBytes(crewId+"_"));

	    	Scan scan=new Scan();
	    	scan.addFamily(Bytes.toBytes(ConstantsHBase.FAMILY_CREW_MOVIE));
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
					movieId=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_CREW_MOVIE), Bytes.toBytes(ConstantsHBase.QUALIFIER_CREW_MOVIE_ID)));
					movieTO=movieDAO.getMovieById(movieId);
					movieList.add(movieTO);
	    		}
	    	}		 
		 return movieList;

	 } //getMoviesByCrew

}