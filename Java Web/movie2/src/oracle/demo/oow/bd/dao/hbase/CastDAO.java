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
import oracle.demo.oow.bd.to.CastMovieTO;
import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.CrewTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.KeyUtil;
import oracle.demo.oow.bd.util.hbase.ConstantsHBase;
import oracle.demo.oow.bd.util.hbase.HbaseDB;

public class CastDAO {

	public void insertCastInfo(CastTO castTO) {
		HbaseDB db=HbaseDB.getInstance();
        //cast表  movie表  
        Table table_cast=db.getTable(ConstantsHBase.TABLE_CAST);
        Table table_movie=db.getTable(ConstantsHBase.TABLE_MOVIE);
        
        //cast表   cast列族
        Put put_cast=new Put(Bytes.toBytes(castTO.getId()));
        put_cast.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_CAST_CAST),Bytes.toBytes(ConstantsHBase.QUALIFIER_CAST_NAME), Bytes.toBytes(castTO.getName()));
        
        List<CastMovieTO> movieTOList=castTO.getCastMovieList();
        
        List<Put> putcastmovie = new ArrayList<>();
        List<Put> putmoviecast=new ArrayList<>();
        
        for (CastMovieTO castMovieTO : movieTOList) {
        	//cast表   movie列族
        	Put put_cast_movie=new Put(Bytes.toBytes(castTO.getId()+"_"+castMovieTO.getId()));
        	put_cast_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_CAST_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_CAST_MOVIE_ID), Bytes.toBytes(castMovieTO.getId()));
        	put_cast_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_CAST_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_CAST_CHARACTER), Bytes.toBytes(castMovieTO.getCharacter()));
        	put_cast_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_CAST_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_CAST_ORDER), Bytes.toBytes(castMovieTO.getOrder()));
        	
        	putcastmovie.add(put_cast_movie);
        	
        	//movie表  cast列族
        	Put put_movie_cast=new Put(Bytes.toBytes(castMovieTO.getId()+"_"+castTO.getId()));
        	put_movie_cast.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_CAST),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_CAST_ID), Bytes.toBytes(castTO.getId()));
        	
        	putmoviecast.add(put_movie_cast);
		}
        try {
        	table_cast.put(put_cast);
        	table_cast.put(putcastmovie);
        	table_movie.put(putmoviecast);
        	
        	table_cast.close();
        	table_movie.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//根据castID获取CastTO
	public CastTO getCastById(int castId) {
		HbaseDB db=HbaseDB.getInstance();
		Table table = db.getTable(ConstantsHBase.TABLE_CAST);
		//根据castId获取cast信息
		Get get=new Get(Bytes.toBytes(castId));
		Result result2=null;
		//在cast表 movie列族获取order等信息 并返回castTO
//		CastTO castTO=getCastTOById(castId);
		CastTO castTO=new CastTO();
		try {
			result2 = table.get(get);
			castTO.setId(castId);
			castTO.setName(Bytes.toString(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_CAST_CAST), Bytes.toBytes(ConstantsHBase.QUALIFIER_CAST_NAME))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return castTO;
    } //getCastById

	/*private CastTO getCastTOById(int castId) {
		return null;
	}*/

	/**
     * This method returns all the movies that Cast worked in.
     * @param castId
     * @return List of MovieTO
     */
    public List<MovieTO> getMoviesByCast(int castId) {

    	MovieTO movieTO=null;
    	List<MovieTO> movieList=new ArrayList<>();
    	HbaseDB db=HbaseDB.getInstance();
    	Table table=db.getTable(ConstantsHBase.TABLE_CAST);
    	
    	Filter filter=new PrefixFilter(Bytes.toBytes(castId+"_"));

    	Scan scan=new Scan();
    	scan.addFamily(Bytes.toBytes(ConstantsHBase.FAMILY_CAST_MOVIE));
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
				movieId=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_CAST_MOVIE), Bytes.toBytes(ConstantsHBase.QUALIFIER_CAST_MOVIE_ID)));
				movieTO=movieDAO.getMovieById(movieId);
				
				movieList.add(movieTO);
    		}
    	}
        return movieList;
    }

}
