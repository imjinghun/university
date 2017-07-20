package servlet.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.*;

public class upload extends HttpServlet
{
	public upload()
	{
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		HttpSession session=request.getSession();
	    session.setAttribute("progressBar",0);      //定义指定上传进度的Session变量
	    
		PrintWriter pwrite=response.getWriter();
		DBBean db=new DBBean();
		GetValue getV=new GetValue();
		
		// 文件名 文件路径 上传时间 课程号 作业号 (老师账号 学生账号 角色 在session中获取) 表名 资料号
		String filename = "", filepath = "", uptime = "", cid = "", 
				hid = "", uid = "", role = "",mtid="";
		role = (String) request.getSession().getAttribute("role");
		uid = (String) request.getSession().getAttribute("username");
		
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		// 上传时生成的临时文件保存目录
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists())
		{
			// 创建临时目录
			tmpFile.mkdir();
		}
		try
		{
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
			factory.setSizeThreshold(1024 * 1000);// 设置缓冲区的大小为1M，如果不指定，那么缓冲区的大小默认是10KB
			// 设置上传时生成的临时文件的保存目录
			factory.setRepository(tmpFile);
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request))
			{
				return;
			}
			// 设置文件最大值
			int maxSize=1024 * 1024* 1000;//1G

			/**设置upload.setFileSizeMax(maxSize)和upload.setSizeMax(maxSize)
			 * 文件超过最大值 会捕获异常 并且异常一直循环输出 
			 */
			// 设置上传单个文件的大小的最大值，目前是设置为1024*1024*1000字节，也就是1G
			//upload.setFileSizeMax(maxSize);
			// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为1G
			//upload.setSizeMax(maxSize);

			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem>  list = upload.parseRequest(request);
			for (FileItem item : list)
			{
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField())
				{
					String name = item.getFieldName();
					// 解决普通输入项的数据的中文乱码问题
					String value = item.getString("UTF-8");
					if(name.equals("cid"))
					{
						cid=value;
					}
					if(name.equals("hid"))
					{
						hid=value;
					}
				} else
				{// 如果fileitem中封装的是上传文件
					// 得到上传的文件名称，
					filename = item.getName();
					if (filename == null || filename.trim().equals(""))
					{
						pwrite.print("文件为空");
						return;
					}
					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分 如：1.txt
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					// 得到上传文件的扩展名
					String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
					// 获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					// 得到文件保存的名称 重设文件名
					filename = makeFileName(filename);
					// 得到文件的保存目录 重设保存路径
					filepath = makePath(uid,cid,savePath);
					// 创建一个文件输出流
					FileOutputStream outstream = new FileOutputStream(filepath+ "\\" + filename);
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = 0;
					//上传文件大小 
					long upFileSize=item.getSize();
					if(upFileSize>maxSize)
					{
						pwrite.print("文件过大");
						return ;
					}
					double percent=0;//上传百分比
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((len = in.read(buffer)) > 0)
					{
						percent+=len/(double)upFileSize*100D;        //计算上传文件的百分比
						outstream.write(buffer, 0, len);
						session.setAttribute("progressBar",Math.round(percent));    //将上传百分比保存到Session中
					}
					// 关闭输入流
					in.close();
					// 关闭输出流
					outstream.close();
					// 删除处理文件上传时生成的临时文件
					item.delete();
				}
			}
			// 将信息存入数据库   #################################
			mtid = getV.getMtid();
			uptime = getV.getDate();
			int bc=0; //文件上传前 smaterial表 学生账号去重后 数量
			int ac=0; //文件上传后 smaterial表 学生账号去重后 数量
			String sql = "";
			// 角色为老师
			if (role.equals("teacher"))
			{
				sql="insert into tmaterial values('"+mtid+"','"+filename+"','"+cid+"','"+uid+"','"+filepath+"','"+uptime+"')";
			}
			// 角色为学生
			if (role.equals("student"))
			{
				/**
				 * 在学生上传文件前 先查询一遍smaterial数量（学号去重） 即为提交作业人数
				 * 在学生上传文件后 再查询一遍smaterial数量（学号去重）
				 * 两次结果不等 更新homework 已提交人数
				 */
				//上传文件前查询
				String sql2="select count(distinct smsid) from smaterial where smhid='"+hid+"'";
				ResultSet rs=db.executeQuery(sql2);
				if(rs.next())
				{
					bc=rs.getInt(1);
				}
				sql="insert into smaterial values('"+mtid+"','"+filename+"','"+cid+
						"','"+uid+"','"+filepath+"','"+uptime+"','"+hid+"')";
			}
			db.executeUpdate(sql);
			
			if(role.equals("student"))
			{
				String sql2="select count(distinct smsid) from smaterial where smhid='"+hid+"'";
				ResultSet rs=db.executeQuery(sql2);
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
			}
			pwrite.print("成功");
		} 
		catch (FileUploadBase.FileSizeLimitExceededException e)
		{
			pwrite.print("文件过大");
			System.out.println("单个文件过大");
			e.printStackTrace();
		} catch (FileUploadBase.SizeLimitExceededException e)
		{
			pwrite.print("文件过大了");
			System.out.println("上传文件的总的大小超出限制的最大值！！");
			e.printStackTrace();
		} catch (Exception e)
		{
			pwrite.print("上传文件异常");
			System.out.println("最后一个异常");
			e.printStackTrace();
		}
	}

	// 重设文件名 防止同名文件覆盖
	private String makeFileName(String filename)
	{
		//为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + filename;
	}

	// 重设文件保存路径
	private String makePath(String uid, String cid,String savepath)
	{
		//老师资料目录  老师账号/课程号/
		//学生资料目录  学生账号/课程号/
		String dir="";
		dir = savepath + "\\" + uid + "\\" + cid;
		// File既可以代表文件也可以代表目录
		File file = new File(dir);
		// 如果目录不存在
		if (!file.exists())
		{
			// 创建目录
			file.mkdirs();
		}
		return dir;
	}
}
