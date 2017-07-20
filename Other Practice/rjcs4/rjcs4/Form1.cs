using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace rjcs4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(radioButton1.Checked==true)
                {
                    textBox1.Text = "播放电影，食物供应";
                }
            else if(radioButton2.Checked==true)
            {
                if(radioButton3.Checked==true)
                {
                    textBox1.Text = "播放电影，食物供应";

                }
                else if(radioButton5.Checked==true)
                {
                    textBox1.Text = "食物供应";
                }
            }
            else if(radioButton4.Checked==true)
            {
                if(radioButton3.Checked==true)
                {
                    textBox1.Text = "食物供应";
                }
                else if(radioButton5.Checked==true)
                {
                    if(radioButton7.Checked==true)
                    {
                        textBox1.Text = "食物供应";
                    }
                }
            }
            
        }

        private void radioButton4_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton5_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton7_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
