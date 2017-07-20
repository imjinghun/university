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
    public partial class FrmRegister : Form
    {
        public FrmRegister()
        {
            InitializeComponent();
        }

        private void FrmRegister_Load(object sender, EventArgs e)
        {
            label1.BackColor = Color.FromArgb(100, Color.White);
            label2.BackColor = Color.FromArgb(100, Color.White);
            label3.BackColor = Color.FromArgb(100, Color.White);
            label4.BackColor = Color.FromArgb(100, Color.White);
            label5.BackColor = Color.FromArgb(100, Color.White);
            label6.BackColor = Color.FromArgb(100, Color.White);
            label7.BackColor = Color.FromArgb(100, Color.White);
            label8.BackColor = Color.FromArgb(100, Color.White);
            label10.BackColor = Color.FromArgb(100, Color.White);
            label11.BackColor = Color.FromArgb(100, Color.White);
            label12.BackColor = Color.FromArgb(100, Color.White);
            labCheck.BackColor = Color.FromArgb(100, Color.White);
            cboxIDType.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
        }


        //注册用户
        private void btnRegister_Click(object sender, EventArgs e)
        {
            bool sure=inputCheck();
            if (sure == true)
            {
                addUser();
            }
        }
       
        //回车注册
        private void FrmRegister_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == '\r') // 'r' 可以换成 13  均表示enter 键
            {
                btnRegister_Click(sender, e);
            }
        }

        //重置
        private void btnReset_Click(object sender, EventArgs e)
        {
            labCheck.Text = "";//清空提示信息
            txtID.Text = "";
            txtName.Text = "";
            txtPwd.Text = "";
            txtSPwd.Text = "";
            cboxIDType.SelectedIndex = 0;//设置身份类别 为管理员
            txtID.Focus();//使工号获得焦点 以防主键为空
        }

        #region   验证输入合法性 

        //焦点离开输入框时 进行验证
        private void txtID_Leave(object sender, EventArgs e)
        {
            bool result = userExist(txtID.Text.Trim());

            if (txtID.Text.Trim().Equals(""))
            {
                labCheck.Text = "工号不可为空！";
                txtID.Focus();
            }
            if (!txtID.Text.Trim().Equals("") && result)
            {
                labCheck.Text = "此工号已注册！";
                txtID.Focus();
            }
            if (!txtID.Text.Trim().Equals("") && !result)
            {
                labCheck.Text = "";
            }
        }

        private void txtName_Leave(object sender, EventArgs e)
        {
            if (txtName.Text.Trim().Equals(""))
            {
                labCheck.Text = "姓名不可为空！";
                txtName.Focus();
            }
            if (!txtName.Text.Trim().Equals(""))
            {
                labCheck.Text = "";
            }
        }

        private void txtPwd_Leave(object sender, EventArgs e)
        {
            if (txtPwd.Text.Trim().Equals(""))
            {
                labCheck.Text = "密码不可为空！";
                txtPwd.Focus();
            }
            if (!txtPwd.Text.Trim().Equals(""))
            {
                labCheck.Text = "";
            }
        }

        private void txtSPwd_Leave(object sender, EventArgs e)
        {
            if (txtSPwd.Text.Trim().Equals(""))
            {
                labCheck.Text = "确认密码不可为空！";
            }
            if (!txtSPwd.Text.Trim().Equals("") && !txtSPwd.Text.Trim().Equals(txtPwd.Text.Trim()))
            {
                labCheck.Text = "两次密码不一致！";
            }
            if (!txtSPwd.Text.Trim().Equals("") && txtSPwd.Text.Trim().Equals(txtPwd.Text.Trim()))
            {
                labCheck.Text = "";
            }
        }

        //点击注册时进行验证 返回 true 验证通过
        private bool inputCheck()
        {
            if (txtID.Text.Trim().Equals(""))
            {
                labCheck.Text = "工号不可为空！";
                txtID.Focus();
                return false;
            }
            if (txtName.Text.Trim().Equals(""))
            {
                labCheck.Text = "姓名不可为空！";
                txtName.Focus();
                return false;
            }
            if (txtPwd.Text.Trim().Equals(""))
            {
                labCheck.Text = "密码不可为空！";
                txtPwd.Focus();
                return false;
            }
            if (txtSPwd.Text.Trim().Equals(""))
            {
                labCheck.Text = "确认密码不可为空！";
                return false;
            }
            if (!txtSPwd.Text.Trim().Equals(txtPwd.Text.Trim()))
            {
                labCheck.Text = "两次密码不一致！";
                return false;
            }
            return true;
        }

        //查询用户是否存在 存在返回 true 不存在返回 false
        private bool userExist(string id)
        {
            using (FruitPSIContext db = new FruitPSIContext())
            {
                //管理员表中查询
                var userid = from m in db.ManagerInfoes select m.mgrid;
                foreach (var u in userid)
                {
                    if (u.Equals(id))
                    {
                        return true; //用户存在
                    }
                }
                //职员表中查询
                userid = from s in db.StaffInfoes select s.staffid;
                foreach (var u in userid)
                {
                    if (u.Equals(id))
                    {
                        return true;
                    }
                }
            }
            return false; //用户不存在
        }

        #endregion

        #region 添加用户

        private void addUser()
        {
            if (cboxIDType.Text.Equals("管理员"))
            {
                addManager();
            }
            if (cboxIDType.Text.Equals("购货员") || cboxIDType.Text.Equals("销售员"))
            {
                addStaff();
            }
        }
        //添加管理员
        private void addManager()
        {
            ManagerInfo manager = new ManagerInfo {
                mgrid = txtID.Text.Trim(), 
                mgrname = txtName.Text.Trim(), 
                password = txtPwd.Text.Trim() };
            using (FruitPSIContext db = new FruitPSIContext())
            {
                db.ManagerInfoes.Add(manager);
                try
                {
                    int result = db.SaveChanges();
                    if (result == 1)
                    {
                        this.Close();
                    }
                    else
                    {
                        MessageBox.Show("注册失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("注册失败，可能您的输入内容不符合要求，请检查");
                }
            }
        }

        //添加员工
        private void addStaff()
        {
            StaffInfo staff = new StaffInfo { 
                staffid = txtID.Text.Trim(), 
                staffname = txtName.Text.Trim(), 
                password = txtPwd.Text.Trim(), 
                stafftype = cboxIDType.Text };
            using (FruitPSIContext db = new FruitPSIContext())
            {
                db.StaffInfoes.Add(staff);
                try
                {
                    int result = db.SaveChanges();
                    if (result == 1)
                    {
                        this.Close();
                    }
                    else
                    {
                        MessageBox.Show("注册失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("注册失败，可能您的输入内容不符合要求，请检查");
                }
            }
        }

        #endregion
    }
}
