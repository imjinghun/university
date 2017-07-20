package servlet.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBBean;
/**
 * 个人资料删除
 * @author jing
 *
 */
public class delete extends HttpServlet
{
	public delete()
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
		// 设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String role,mtid,hid = "",cid="",filename="",filepath="",sql="";
		
		role=(String)request.getSession().getAttribute("role");
		mtid=request.getParameter("mtid");
		DBBean db = new DBBean();
		PrintWriter out=response.getWriter();
		
		//查询出文件路径及名称
		if(role.equals("teacher"))
		{
			sql="select * from tmaterial where tmid='"+mtid+"'";
		}
		if(role.equals("student"))
		{
			sql="select * from smaterial where smid='"+mtid+"'";
		}
		try
		{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next())
			{
				filename=rs.getString(2);
				filepath=rs.getString(5);
				if(role.equals("student"))
				{
					cid=rs.getString("smcid");
					hid=rs.getString("smhid");
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		//数据库中删除记录
		if(role.equals("teacher"))
		{
			sql="delete from tmaterial where tmid='"+mtid+"'";
		}
		/**
		 * 如果是学生 更新 未提交 已提交人数
		 */
		int bc=0; //文件删除前 smaterial表 学生账号去重后 数量
		int ac=0; //文件删除后 smaterial表 学生账号去重后 数量
		if(role.equals("student"))
		{
			//删除文件前查询
			String sql2="select count(distinct smsid) from smaterial where smhid='"+hid+"'";
			ResultSet rs=db.executeQuery(sql2);
			try
			{
				if(rs.next())
				{
					bc=rs.getInt(1);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			sql="delete from smaterial where smid='"+mtid+"'";
		}
		db.executeUpdate(sql);
		if(role.equals("student"))
		{
			String sql2="select count(distinct smsid) from smaterial where smhid='"+hid+"'";
			ResultSet rs=db.executeQuery(sql2);
			try
			{
				if(rs.next())
				{
					ac=rs.getInt(1);
				}
				if(ac!=bc)
				{
					//查询课程总人数 未交为总人数-已交
					int tcnumber=0;
					sql2="select tcnumber from tcourse where tcid='"+cid+"'";
					rs=db.executeQuery(sql2);
					if(rs.next())
					{
						tcnumber=rs.getInt(1);
					}
					//更新 已交 未交人数
					sql2="update homework set hsubmit="+ac+",hnosubmit="+(tcnumber-ac)+" where hid='"+hid+"'";
					db.executeUpdate(sql2);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		//服务器中删除文件
        //得到要删除的文件
        File file = new File(filepath + "\\" + filename);
        //如果文件不存在
        if(!file.exists()){
        	out.print("文件不存在");
            return;
        }
        boolean b=file.delete();
        if(b)
        {
        	out.print("删除成功");
        }
	}
}

