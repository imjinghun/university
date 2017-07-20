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
    public partial class FrmChangePwd : Form
    {
        FruitPSIContext db = new FruitPSIContext();
        public string id="1",pwd="1";
        public FrmChangePwd()
        {
            InitializeComponent();
        }

        //检查输入框是否为空
        private bool inputCheck()
        {
            if (txtYSMM.Text.Trim() == "")
            {
                labCheck.Text = "原始密码不可为空";
                timer1.Enabled = true;
                return false;
            }
            if (!txtYSMM.Text.Trim().Equals(pwd))
            {
                labCheck.Text = "原始密码输入错误";
                timer1.Enabled = true;
                return false;
            }
            if (txtXMM.Text.Trim() == "")
            {
                labCheck.Text = "新密码不可为空";
                timer1.Enabled = true;
                return false;
            }
            if (txtQRMM.Text.Trim() == "")
            {
                labCheck.Text = "确认密码不可为空";
                timer1.Enabled = true;
                return false;
            }
            if (!txtXMM.Text.Trim().Equals(txtQRMM.Text.Trim()))
            {
                labCheck.Text = "两次密码不一致";
                timer1.Enabled=true;
                return false;
            }
            return true;
        }

        private void btnOk_Click(object sender, EventArgs e)
        {
            if (inputCheck())
            {
                saveChange();
                this.Close();
            }
        }

        private void saveChange()
        {
            var user = db.ManagerInfoes.Find(id);
            if (user != null)
            {
                user.password = txtXMM.Text.Trim();
                try
                {
                    int i = db.SaveChanges();
                    if (i == 1)
                    {
                        MessageBox.Show("密码修改成功");
                    }
                    else
                    {
                        MessageBox.Show("您没有做任何修改");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("密码修改失败，可能不允许修改密码");
                }
                return;
            }
            var user1 = db.StaffInfoes.Find(id);
            if (user1 != null)
            {
                user1.password = txtXMM.Text.Trim();
                try
                {
                    int i = db.SaveChanges();
                    if (i == 1)
                    {
                        MessageBox.Show("密码修改成功");
                    }
                    else
                    {
                        MessageBox.Show("您没有做任何修改");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("密码修改失败，可能不允许修改密码");
                }
                return;
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            timer1.Enabled = false;
            labCheck.Text = "";
        }
    }
}
