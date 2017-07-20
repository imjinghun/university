package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import dao.DBBean;

public class QueryCollect extends HttpServlet
{
	public QueryCollect()
	{
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		DBBean db=new DBBean();
		PrintWriter out=response.getWriter();
		
		String userid="";
		
		userid=request.getParameter("userid");
		
		String sql="select * from collect where userid='"+userid+"'";
		ResultSet rs=db.executeQuery(sql);
		ResultSetMetaData data;
		
	
		Map<String,Object> map2=new HashMap<String, Object>();
		List<Object> list=new ArrayList<Object>();
		try
		{
			data = rs.getMetaData();
			while(rs.next()){
				//每循环一次 new一个map 防止 list使用add方法后 所有项都一样
				Map<String,String> map=new HashMap<String, String>();
				for(int i = 1 ; i<= data.getColumnCount() ; i++){ 
					map.put(data.getColumnName(i), rs.getString(i));
				}
				list.add(map);
			}
			
			map2.put("list", list);
			JSONObject jsonObject = JSONObject.fromObject(map2);
			
			out.print(jsonObject.toString());
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(sql);
		db.close();
		
		out.flush();
		out.close();
	}

}
