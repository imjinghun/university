using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 实验一_客房预订
{
    public partial class mainForm : Form
    {
        public mainForm()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int i = excute();
            if (i == 1)
            {
                MessageBox.Show("单人间客房开启");
            }
            else if (i == 2)
            {
                MessageBox.Show("单人间客房开，房款不足");
            }
            else
            {
                MessageBox.Show("请选择支付方式！");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int i = excute();
            if (i == 1)
            {
                MessageBox.Show("双人间客房开启");
            }
            else if (i == 2)
            {
                MessageBox.Show("双人间客房开启，房款不足");
            }
            else
            {
                MessageBox.Show("请选择支付方式！");
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int i = excute();
            if (i == 1)
            {
                MessageBox.Show("豪华间客房开启");
            }
            else if (i == 2)
            {
                MessageBox.Show("豪华间客房开启，房款不足");
            }
            else
            {
                MessageBox.Show("请选择支付方式！");
            }
        }

        public int excute()
        {
            bool result1 = this.radioButton1.Checked;
            bool result2 = this.radioButton2.Checked;
            if (result1 == true)
            {
                return 1;
            }
            else
            {
                if (result2 == true)
                {
                    return 2;
                }
                else
                {
                    return 0;
                }
            }
        }

        private void mainForm_Load(object sender, EventArgs e)
        {

        }
    }
}
