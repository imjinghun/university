using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using FruitsPSI.Models;
namespace FruitsPSI
{
    public partial class FrmLogin : Form
    {
        public FrmLogin()
        {
            InitializeComponent();
        }
        private void FrmLogin_Load(object sender, EventArgs e)
        {
            //设置label控件透明度 20为透明度（0-255） 后面为颜色名称或RGB值
            label1.BackColor = Color.FromArgb(20, Color.MediumTurquoise);
            label2.BackColor = Color.FromArgb(20, 72, 209, 204);
            label3.BackColor = Color.FromArgb(20, 72, 209, 204);
            llblRegister.BackColor = Color.FromArgb(20, 72, 209, 204);
            llblFPwd.BackColor = Color.FromArgb(20, 72, 209, 204);
            label5.BackColor = Color.FromArgb(20, 72, 209, 204);
            labCheck.BackColor = Color.FromArgb(20, 72, 209, 204);
            btnLogin.BackColor = Color.FromArgb(20, 72, 209, 204);
            rbtnMgr.BackColor = Color.FromArgb(20, 72, 209, 204);
            rbtnStaff.BackColor = Color.FromArgb(20, 72, 209, 204);
        }

        //叉号 关闭退出系统 不写事件也可以关闭 只是关闭的不彻底 
        private void FrmLogin_FormClosing(object sender, FormClosingEventArgs e)
        {
            System.Environment.Exit(0); //最彻底的退出方式
        }

        string name="", type="";
        //获得登录者姓名 传到主界面
        public void getNameType()
        {
            using (FruitPSIContext db = new FruitPSIContext())
            {
                if (rbtnMgr.Checked)
                {
                    var user = db.ManagerInfoes.Find(txtID.Text.Trim());
                    if (user != null)
                    {
                        name = user.mgrname;
                        type = "管理员";
                    }
                }
                if (rbtnStaff.Checked)
                {
                    var user = db.StaffInfoes.Find(txtID.Text.Trim());
                    if (user != null)
                    {
                        name = user.staffname;
                        type = user.stafftype;
                    }
                }
            }
        }

        //单击登录时发生
        private void btnLogin_Click(object sender, EventArgs e)
        { 
            if (inputCheck())
            {
                labCheck.Text = "";
                getNameType();
                this.Hide(); //隐藏登录窗体
                FrmMain frmmain = new FrmMain(); //显示主界面窗体
                frmmain.userid = txtID.Text;
                frmmain.userpwd = txtPwd.Text;
                frmmain.user = name;
                frmmain.usertype = type;
                frmmain.Show(); 
            }
        }
       
        //回车登录
        private void FrmLogin_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == '\r') // 'r' 可以换成 13  均表示enter 键
            {
                btnLogin_Click(sender, e);
            }
        }
        
        //单击注册用户链接
        private void llblRegister_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            FrmRegister frmregister = new FrmRegister();
            frmregister.ShowDialog();
        }

        #region 登录验证

        //检验输入是否合法
        private bool inputCheck()
        {
            if (txtID.Text.Trim().Equals(""))
            {
                labCheck.Text = "工号不可为空！";
                return false;
            }
            if (txtPwd.Text.Trim().Equals(""))
            {
                labCheck.Text = "密码不可为空！";
                return false;
            }
            if (!userCheck())
            {
                return false;
            }
            return true;
        }

        //检查工号密码是否均正确 正确返回true 错误返回 false
        private bool userCheck()
        {
            bool resultID,resultPwd;
            //当 管理员 按钮选中时
            if (rbtnMgr.Checked == true)
            {
                resultID = managerExist();
                resultPwd = mgrPwdCorrect();
                if (resultID == false)
                {
                    labCheck.Text = "此管理员不存在！";
                    return false;
                }
                if (resultID && !resultPwd)//密码不正确
                {
                    return false;
                }
                if (resultID && resultPwd)//工号密码均正确
                {
                    return true;
                }
            }
            //当 职员 按钮选中时
            if (rbtnStaff.Checked == true)
            {
                resultID = staffExist();
                resultPwd = staffPwdCorrect();
                if (resultID == false)
                {
                    labCheck.Text = "此职员不存在！";
                    return false;
                }
                if (resultID && !resultPwd)//密码不正确
                {
                    return false;
                }
                if (resultID && resultPwd)//工号密码均正确
                {
                    return true;
                }
            }
            return true;
        }

        //查询管理员是否存在 存在返回 true 不存在返回 false
        private bool managerExist()
        {
            using (FruitPSIContext db = new FruitPSIContext())
            {
                //管理员表中查询
                var userid = from m in db.ManagerInfoes select m.mgrid;
                foreach (var u in userid)
                {
                    if (u.Equals(txtID.Text.Trim()))
                    {
                        return true; //管理员存在
                    }
                }
            }
            return false; //管理员不存在
        }
      
        //判断管理员密码是否正确 正确返回true  错误返回false
        private bool mgrPwdCorrect()
        {
            using (FruitPSIContext db = new FruitPSIContext())
            {
                var pwd = from m in db.ManagerInfoes where m.mgrid.Equals(txtID.Text.Trim()) select m.password;
                foreach (var pw in pwd)
                {
                    if (!pw.Equals(txtPwd.Text.Trim()))
                    {
                        labCheck.Text = "密码不正确！";
                        return false;
                    }
                }
            }
            return true;
        }

        //查询职员是否存在 存在返回 true 不存在返回 false
        private bool staffExist()
        {
            using (FruitPSIContext db = new FruitPSIContext())
            {
                //职员表中查询
                var userid = from s in db.StaffInfoes select s.staffid;
                foreach (var u in userid)
                {
                    if (u.Equals(txtID.Text.Trim()))
                    {
                        return true;//职员存在
                    }
                }
            }
            return false; //职员不存在
        }
        
        //判断职员密码是否正确 正确返回true  错误返回false
        private bool staffPwdCorrect()
        {
            using (FruitPSIContext db = new FruitPSIContext())
            {
                var pwd = from m in db.StaffInfoes where m.staffid.Equals(txtID.Text.Trim()) select m.password;
                foreach (var pw in pwd)
                {
                    if (!pw.Equals(txtPwd.Text.Trim()))
                    {
                        labCheck.Text = "密码不正确！";
                        return false;
                    }
                }
            }
            return true;
        }

        #endregion

        //忘记密码
        private void llblFPwd_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            MessageBox.Show("请联系管理员找回密码！");
        }
    }
}
