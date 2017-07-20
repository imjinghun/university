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

import dao.DBBean;
import dao.FindInfo;
import dao.GetValue;

public class stdDelCourse extends HttpServlet
{
	public stdDelCourse()
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
		PrintWriter out = response.getWriter();
		
		String scid,scsid;
		
		//获取字段值
		scid=request.getParameter("scid");
		scsid=(String) request.getSession().getAttribute("username");
		
		//查询出课程人数
		int tcnumber=0;
		String sql="select tcnumber from tcourse where tcid='"+scid+"'";
		ResultSet rs=db.executeQuery(sql);
		try
		{
			if(rs.next())
			{
				tcnumber=rs.getInt(1);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		String sql2[]=new String[4];
		/**
		 * 学生退课 
		 * 根据学生账号 删除 学生课程表 学生资料表  留言表 
		 * 更新本门课程 课程人数 课程下作业已交 未交人数
		 */
		/**
		 * 先查询出 本门课所有作业号
		 * 在退课之前
		 * 根据作业号 在学生资料表查询各个作业下 作业提交数量bc[i]
		 * 在退课之后
		 * 根据作业号 在学生资料表查询各个作业下 作业提交数量ac[i]
		 * 如果bc[i]!=ac[i] 说明此学生本门课程作业曾提交过
		 * 
		 * 则更新hid[i]下的hsubmit-1即为ac[i] hnosubmit=tcnumber-ac[i]
		 * 无论 bc[i]和ac[i]等不等 未交人数 都等于hnosubmit=tcnumber-ac[i]
		 * 将上述所有更新的语句 存入数组 批量更新
		 */
		//根据课程号 查询所有作业号
		List<String> hid=new ArrayList<String>();
		sql="select hid from homework where hcid='"+scid+"'"; 
		rs=db.executeQuery(sql);
		try
		{
			while(rs.next())
			{
				hid.add(rs.getString("hid"));
			}
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		int counts=hid.size();
		int bc[]=new int[counts];
		int ac[]=new int[counts];
		//说明本门课程下有作业
		//退课之前
		if(counts>0)
		{
			for(int i=0;i<counts;i++)
			{
				//根据作业号 在学生资料表查询各个作业下 作业提交数量bc[i]
				sql="select count(distinct smsid) from smaterial where smhid='"+hid.get(i)+"'";
				rs=db.executeQuery(sql);
				try
				{
					if(rs.next())
					{
						bc[i]=rs.getInt(1);
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		//开始退课
		//根据学生账号 删除学生课程表 
		sql2[0]="delete from scourse where scid='"+scid+"' and scsid='"+scsid+"'";
		//根据学生账号 删除学生资料表 
		sql2[1]="delete from smaterial where smcid='"+scid+"' and smsid='"+scsid+"'";
		//根据学生账号 删除留言表 
		sql2[2]="delete from message where mcid='"+scid+"' and msid='"+scsid+"'";
		//更新课程人数
		sql2[3]="update tcourse set tcnumber="+(tcnumber-1)+" where tcid='"+scid+"'";
		int ret=db.executeBatch(sql2);
		
		//退课之后 更新未交已交人数
		if(ret==1&&counts>0)
	 	{
			String sql3[]=new String[counts];
			
			for(int i=0;i<counts;i++)
			{
				//根据作业号 在学生资料表查询各个作业下 作业提交数量ac[i]
				sql="select count(distinct smsid) from smaterial where smhid='"+hid.get(i)+"'";
				rs=db.executeQuery(sql);
				try
				{
					if(rs.next())
					{
						ac[i]=rs.getInt(1);
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			for(int i=0;i<counts;i++)
			{
				sql3[i]= "update homework set hsubmit="+ac[i]+
						",hnosubmit="+(tcnumber-1-ac[i])+" where hid='"+hid.get(i)+"'";
			}
			db.executeBatch(sql3);
	 		out.print("成功");
	 	}
	 	else{
	 		out.print("失败");
	 	}
		out.print("<script>window.location='../Course/stdIndex.jsp';</script>");
		out.flush();
		out.close();
	}

}
