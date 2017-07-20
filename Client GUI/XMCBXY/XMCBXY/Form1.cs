using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace XMCBXY
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //净利润
        private void btnNP_Click(object sender, EventArgs e)
        {
            lbShow.Text = "";
            int rowscount = dgv.Rows.Count;
            double NP = 0, year, money; //NP净利润
            //dgv肯定最后一行是空的
            for (int i = 0; i < rowscount - 1; i++)
            {
                if (dgv.Rows[i].Cells[0].Value == null || dgv.Rows[i].Cells[1].Value == null)
                {
                    MessageBox.Show("除最后一行外，其余行不可有空值");
                    return;
                }
            }
            for (int i = 0; i < rowscount - 1; i++)
            {
                try
                {
                    year = Convert.ToDouble(dgv.Rows[i].Cells[0].Value.ToString());
                    money = Convert.ToDouble(dgv.Rows[i].Cells[1].Value.ToString());
                    NP += money;
                }
                catch(Exception ex ){
                    MessageBox.Show("注意：第 "+(i+1)+" 行年份或金额输入不合法");
                    return;
                }
            }
            if (rowscount != 1)
            { 
            lbShow.Text = "净利润：" + NP; 
            }
        }


        //回收期
        private void btnPP_Click(object sender, EventArgs e)
        {
            lbShow.Text = "";
            int rowscount = dgv.Rows.Count;
            double NP = 0, year, money;
            //dgv肯定最后一行是空的
            for (int i = 0; i < rowscount - 1; i++)
            {
                if (dgv.Rows[i].Cells[0].Value == null || dgv.Rows[i].Cells[1].Value == null)
                {
                    MessageBox.Show("除最后一行外，其余行不可有空值");
                    return;
                }
            }
            for (int i = 0; i < rowscount - 1; i++)
            {
                try
                {
                    year = Convert.ToDouble(dgv.Rows[i].Cells[0].Value.ToString());
                    money = Convert.ToDouble(dgv.Rows[i].Cells[1].Value.ToString());
                    NP += money;
                    if (NP >= 0)
                    {
                        lbShow.Text = "回收期： " + year + " 年";
                        break;
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("注意：第 " + (i + 1) + " 行年份或金额输入不合法");
                    return;
                }
            }
        }

        //投资回报率
        private void btnROI_Click(object sender, EventArgs e)
        {
            lbShow.Text = "";
            int rowscount = dgv.Rows.Count;
            double NP = 0, year=0, money,ROI,totalinvest=0;//ROI投资回报率
            //dgv肯定最后一行是空的
            for (int i = 0; i < rowscount - 1; i++)
            {
                if (dgv.Rows[i].Cells[0].Value == null || dgv.Rows[i].Cells[1].Value == null)
                {
                    MessageBox.Show("除最后一行外，其余行不可有空值");
                    return;
                }
            }
            for (int i = 0; i < rowscount - 1; i++)
            {
                try
                {
                    year = Convert.ToDouble(dgv.Rows[i].Cells[0].Value.ToString());
                    money = Convert.ToDouble(dgv.Rows[i].Cells[1].Value.ToString());
                    if (money < 0)
                    {
                     totalinvest += money;
                    }
                    NP += money;
                }
                catch (Exception ex)
                {
                    MessageBox.Show("注意：第 " + (i + 1) + " 行年份或金额输入不合法");
                    return;
                }
            }
            try
            {
                ROI = (NP / year / totalinvest)*100;
                string s = String.Format("{0:F}", -ROI);
                if (rowscount != 1)
                { 
                lbShow.Text = "投资回报率："+s + "%";
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("总投资及年份是否输入异常");
                return;
            }
            
        }
        //净现值
        private void btnNVP_Click(object sender, EventArgs e)
        {
            lbShow.Text = "";
            if(txtTxl.Text.ToString()=="")
            {
                MessageBox.Show("请填写贴现率");
                return;
            }
            double txl = 0;
            //贴现率
            try
            {
                txl= Convert.ToDouble(txtTxl.Text.ToString());
            }
            catch (Exception)
            {
                MessageBox.Show("贴现率填写错误");
                return;
            }
            
            int rowscount = dgv.Rows.Count;
            double NVP = 0, year, money,temp=0; 
            //dgv肯定最后一行是空的
            for (int i = 0; i < rowscount - 1; i++)
            {
                if (dgv.Rows[i].Cells[0].Value == null || dgv.Rows[i].Cells[1].Value == null)
                {
                    MessageBox.Show("除最后一行外，其余行不可有空值");
                    return;
                }
            }
            for (int i = 0; i < rowscount - 1; i++)
            {
                try
                {
                    year = Convert.ToDouble(dgv.Rows[i].Cells[0].Value.ToString());
                    money = Convert.ToDouble(dgv.Rows[i].Cells[1].Value.ToString());

                    if (year == 0)
                    {
                        NVP += money;
                    }
                    else 
                    {
                    temp = money / Math.Pow(1 + txl, year);
                    NVP += temp;
                    }
                   
                }
                catch (Exception ex)
                {
                    MessageBox.Show("注意贴现率及其他内容输入是否合法");
                    return;
                }
            }
            if (rowscount != 1)
            {
                string s = String.Format("{0:F}", NVP);
                lbShow.Text = "净现值：" + s;
            }
        }
    }
}
