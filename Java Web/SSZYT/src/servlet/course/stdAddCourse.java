package servlet.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

public class stdAddCourse extends HttpServlet
{

	public stdAddCourse()
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

		// 创建对象
		DBBean db = new DBBean();
		GetValue getV = new GetValue();
		FindInfo findInfo=new FindInfo();
		PrintWriter out = response.getWriter();
		
		String scid,scsid,scname="",sctime;
		
		scid=request.getParameter("scid");
		boolean b=findInfo.isKcExist(scid);
		//课程存在时加入
		if(b)
		{
			//查询出课程名 课程人数
			int tcnumber=0;
			String sql="select tcname,tcnumber from tcourse where tcid='"+scid+"'";
			ResultSet rs=db.executeQuery(sql);
			try
			{
				if(rs.next())
				{
					scname=rs.getString(1);
					tcnumber=rs.getInt(2);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			//获取字段值 加入课程
			scsid=(String) request.getSession().getAttribute("username");
			sctime=getV.getDate();
			//判断学生是否加入此课程
			boolean b2=findInfo.isAddCourse(scid, scsid);
			if(b2)
			{
				out.print("已经加入此课程");
				return;
			}
			
			String sql2[]=new String[2];
			//加入课程  更新 老师课程表人数 +1
			sql2[0]="insert into scourse values('"+scid+"','"+scsid+"','"+scname+"','"+sctime+"')";
			sql2[1]="update tcourse set tcnumber="+(tcnumber+1)+" where tcid='"+scid+"'";
			int ret=db.executeBatch(sql2);
			//批处理成功 则执行 更新作业未提交人数
			if(ret==1)
		 	{
				/**
				 * 首先查询出 本门课程所有作业列表
				 * 将每次作业 作业号和作业未提交人数 查询出 放入list
				 * 然后批处理更新作业未提交人数
				 */
				List<String> hid=new ArrayList<String>();
				List<Integer> hnosubmit=new ArrayList<Integer>();
				
				sql="select hid,hnosubmit from homework where hcid='"+scid+"'";
				rs=db.executeQuery(sql);
				try
				{
					while(rs.next())
					{
						hid.add(rs.getString("hid"));
						hnosubmit.add(rs.getInt("hnosubmit"));
					}
					int counts=hid.size();
					//当本门课程存在作业时执行
					if(counts>0)
					{
						String sql3[]=new String[counts];
						for(int i=0;i<counts;i++)
						{
							sql3[i]="update homework set hnosubmit="+(hnosubmit.get(i)+1)+" where hid='"+hid.get(i)+"'";
						}
						db.executeBatch(sql3);
					}
				} catch (SQLException e)
				{
					System.out.println("stdAddCourse异常 "+e);
				}
				
		 		out.print("成功");
		 	}
		 	else{
		 		out.print("失败");
		 	}
		}
		else
		{
			out.print("课程不存在");
		}
		out.flush();
		out.close();
	}

}
