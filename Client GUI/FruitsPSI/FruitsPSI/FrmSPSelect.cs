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
using System.Data.SqlClient;

namespace FruitsPSI
{
    public partial class FrmSPSelect : Form
    {
        //创建数据库对象
        FruitPSIContext db = new FruitPSIContext();
        public FrmSPSelect()
        {
            InitializeComponent();
        }

        private void FrmSPSelect_Load(object sender, EventArgs e)
        {
            // TODO:  这行代码将数据加载到表“fruitPSIDataSet.Product”中。您可以根据需要移动或删除它。
            this.productTableAdapter.Fill(this.fruitPSIDataSet.Product);
            // TODO:  这行代码将数据加载到表“fruitPSIDataSet.Product”中。您可以根据需要移动或删除它。
            this.productTableAdapter.Fill(this.fruitPSIDataSet.Product);
            // TODO:  这行代码将数据加载到表“fruitPSIDataSet.Product”中。您可以根据需要移动或删除它。
            this.productTableAdapter.Fill(this.fruitPSIDataSet.Product);
            refreshSPSel();
            txtSPSelSec.Text = "商品编号/名称";
            txtSPSelSec.ForeColor = Color.DarkGray;
            chbSelAll.Checked = false;
            chbSelRev.Checked = false;
            for (int i = 0; i < dgvSPSelect.Rows.Count; i++)
            {
                this.dgvSPSelect.Rows[i].Cells[0].Value = false;
            }
        }
        #region 全选反选 复选框

        //选中全选
        private void chbSelAll_Click(object sender, EventArgs e)
        {
            if (chbSelAll.Checked == true)
            {
                chbSelRev.Checked = false;
                for (int i = 0; i < dgvSPSelect.Rows.Count; i++)
                {
                    this.dgvSPSelect.Rows[i].Cells[0].Value = true;
                }
            }
            if (chbSelAll.Checked == false)
            {
                chbSelRev.Checked = false;
                for (int i = 0; i < dgvSPSelect.Rows.Count; i++)
                {
                    this.dgvSPSelect.Rows[i].Cells[0].Value = false;
                }
            }
        }
        
        //选中反选
        private void chbSelRev_Click(object sender, EventArgs e)
        {
            //第二次或多次从主界面点击新增按钮时 复选框列单元格值为null
            //所以 复选框列单元格值为null时 则赋值为 false
            for (int i = 0; i < dgvSPSelect.Rows.Count; i++)
            {
                if (dgvSPSelect.Rows[i].Cells[0].Value == null)
                {
                    dgvSPSelect.Rows[i].Cells[0].Value = false;
                }
            }

            if (chbSelRev.Checked == true)
            {
                chbSelAll.Checked = false;
                for (int i = 0; i < dgvSPSelect.Rows.Count; i++)
                {
                    if (dgvSPSelect.Rows[i].Cells[0].Value.Equals(true))
                    {
                        this.dgvSPSelect.Rows[i].Cells[0].Value = false;
                    }
                    else
                    {
                        this.dgvSPSelect.Rows[i].Cells[0].Value = true;
                    }
                }
            }

            if (chbSelRev.Checked == false)
            {
                chbSelAll.Checked = false;
                for (int i = 0; i < dgvSPSelect.Rows.Count; i++)
                {
                    if (dgvSPSelect.Rows[i].Cells[0].Value.Equals(true))
                    {
                        this.dgvSPSelect.Rows[i].Cells[0].Value = false;
                    }
                    else
                    {
                        this.dgvSPSelect.Rows[i].Cells[0].Value = true;
                    }
                }
            }

        }

        #endregion

        //选择dgvSPSelect中的复选框列单元格时 全选 反选均不选
        private void dgvSPSelect_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1)
            {
                if (dgvSPSelect.Rows[e.RowIndex].Cells[0].Selected)
                {
                    chbSelAll.Checked = false;
                    chbSelRev.Checked = false;
                }
            }
        }

        //连接数据库
        private SqlConnection connectFruitPSI()
        {
            SqlConnection conn = new SqlConnection("server=Jing;database=FruitPSI;uid=sa;pwd=123456");
            conn.Open();
            return conn;
        }
       
        #region 搜索相关

        //搜索框点击事件
        private void txtSPSelSec_Click(object sender, EventArgs e)
        {
            txtSPSelSec.Text = "";
            txtSPSelSec.ForeColor = Color.Black;
        }

        //焦点离开搜索框事件
        private void txtSPSelSec_Leave(object sender, EventArgs e)
        {
            if (txtSPSelSec.Text.Trim() == "")
            {
                txtSPSelSec.ForeColor = Color.DarkGray;
                txtSPSelSec.Text = "商品编号/名称";
            }
        }
        
        //搜索按钮点击事件
        private void btnSPSelSec_Click(object sender, EventArgs e)
        {
            if (txtSPSelSec.Text.Trim().Equals("") || txtSPSelSec.Text.Equals("商品编号/名称"))
            {
                refreshSPSel();
            }
            else
            {
                serachSPSel();
            }
        }
        
        //搜索
        private void serachSPSel()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select prodid,prodname,produom,count from product where prodid like '%" + txtSPSelSec.Text.Trim() + "%' or prodname like '%" + txtSPSelSec.Text.Trim() + "%'", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvSPSelect.DataSource = dt;
            conn.Close();
        }
        
        #endregion

        #region 添加商品

        //点击添加商品按钮事件
        private void btnSPSelAdd_Click(object sender, EventArgs e)
        {
            panel1.Visible = true;
        }

        //取消按钮事件
        private void btnCancelSP_Click(object sender, EventArgs e)
        {
            //清空输入框信息
            textBoxSPClear();
            //隐藏添加商品框
            panel1.Visible = false;
        }

        //点击保存按钮事件
        private void btnSaveSP_Click(object sender, EventArgs e)
        {
            if (inputCheckSP())
            {
                if (!txtSPID.Text.Trim().Equals("") && spIDExist())
                {
                    labSPCheck.Text = "编号已存在，请换其他编号";
                    timerSP.Enabled = true;
                    return;
                }
                saveSP();
            }
        }
       
        //检验输入框是否为空 不空返回true 空返回false
        private bool inputCheckSP()
        {
            if (txtSPID.Text.Trim().Equals(""))
            {
                labSPCheck.Text = "编号不可为空";
                timerSP.Enabled = true;
                return false;
            }
            if (txtSPName.Text.Trim().Equals(""))
            {
                labSPCheck.Text = "名称不可为空";
                timerSP.Enabled = true;
                return false;
            }
            if (txtSPUom.Text.Trim().Equals(""))
            {
                labSPCheck.Text = "单位不可为空";
                timerSP.Enabled = true;
                return false;
            }
            if (txtSPInitQty.Text.Trim().Equals(""))
            {
                labSPCheck.Text = "期初数量不可为空";
                timerSP.Enabled = true;
                return false;
            }
            if (txtSPInitCost.Text.Trim().Equals(""))
            {
                labSPCheck.Text = "期初成本不可为空";
                timerSP.Enabled = true;
                return false;
            }
            return true;
        }

        //保存商品信息
        private void saveSP()
        {
            Product sp = new Product
            {
                prodid = txtSPID.Text.Trim(),
                prodname = txtSPName.Text.Trim(),
                produom = txtSPUom.Text.Trim(),
                initqty = Convert.ToDouble(txtSPInitQty.Text.Trim()),
                initcost = Convert.ToDouble(txtSPInitCost.Text.Trim()),
                count = Convert.ToDouble(txtSPInitQty.Text.Trim()) //新增时 当前数量=期初数量
            };
            db.Products.Add(sp);
            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    //清空输入框信息
                    textBoxSPClear();
                    //刷新商品信息
                    refreshSPSel();
                    //隐藏添加商品框
                    panel1.Visible = false;
                }
                else
                {
                    MessageBox.Show("保存失败");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("保存失败，可能您的输入内容不符合要求，请检查");
            }
        }

        //查询商品编号是否存在 存在返回true 不存在返回false
        private bool spIDExist()
        {
            //商品表中查询
            var spid = from sp in db.Products select sp.prodid;
            foreach (var gid in spid)
            {
                if (gid.Equals(txtSPID.Text.Trim()))
                {
                    return true; //商品编号存在
                }
            }
            return false; //编号不存在
        }

        //计时清空labSPCheck提示
        private void timerSP_Tick(object sender, EventArgs e)
        {
            timerSP.Enabled = false;
            labSPCheck.Text = "";
        }

        //清空输入框信息
        private void textBoxSPClear()
        {
            txtSPID.Text = "";
            txtSPName.Text = "";
            txtSPUom.Text = "";
            txtSPInitQty.Text = "";
            txtSPInitCost.Text = "";
        }

        #endregion

        //刷新商品信息
        private void refreshSPSel()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select prodid,prodname,produom,count from product", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvSPSelect.DataSource = dt;
            conn.Close();
        }

        public string[] spid,spname,spuom; //存储商品编号 名称 单位
        public bool result = false;

        //确定按钮点击 将选择的商品传到购货单中
        private void btnSPSelSure_Click(object sender, EventArgs e)
        {
            //如果选择列 单元格值为null 则赋值为 false
            for (int i = 0; i < dgvSPSelect.Rows.Count; i++)
            {
                if (dgvSPSelect.Rows[i].Cells[0].Value==null)
                {
                    dgvSPSelect.Rows[i].Cells[0].Value = false;
                }
            }
            
            int idL=0; //确定选中商品数量
            for (int i = 0; i < dgvSPSelect.Rows.Count; i++)
            {                
                if (dgvSPSelect.Rows[i].Cells[0].Value.Equals(true))
                {
                    idL++;
                }
            }

            spid=new string[idL];
            spname = new string[idL];
            spuom = new string[idL];

            int length=0;//spid[]里面必须用length 因为 数组长度固定 用i会出现溢出可能
            for (int i = 0; i < dgvSPSelect.Rows.Count; i++)
            {
                if (dgvSPSelect.Rows[i].Cells[0].Value.Equals(true))
                {
                    spid[length] = dgvSPSelect.Rows[i].Cells[1].Value.ToString();
                    spname[length] = dgvSPSelect.Rows[i].Cells[2].Value.ToString();
                    spuom[length] = dgvSPSelect.Rows[i].Cells[3].Value.ToString();
                    length++;
                }
            }

            result = true;
            this.Close();
        }
    }
}
