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
    public partial class FrmMain : Form
    {
        //创建数据库对象
        FruitPSIContext db = new FruitPSIContext();
        string gysId, khId,spId,zyId,zhId;//在点击修改时 用于获取 修改行的编号
        public string user="",userid="",userpwd="",usertype="";//得到用户姓名 工号 密码 身份
        //定义新增商品对象
        FrmSPSelect frmGHSpSel = new FrmSPSelect();
        FrmSPSelect frmXHSpSel = new FrmSPSelect();
        public FrmMain()
        {
            InitializeComponent();
        }
        private void FrmMain_Load(object sender, EventArgs e)
        {
            //显示登录者 制单人姓名
            labUser.Text = user;
            labGHZDR.Text = user;
            labXHZDR.Text = user;

            tabControl1.TabPages.Clear();
            tabPage16.Parent = tabControl1;//显示帮助
            tabControl1.SelectedTab = tabPage16;
            setRight();
        }
        
        //初始化权限
        private void setRight()
        {
            #region 购货员权限

            var ghyRight = db.ghyrights.Find("ghy");
            if (ghyRight.ghd == true)
            {
                clbGHY.SetItemChecked(0,true);
            }
            if (ghyRight.xhd == true)
            {
                clbGHY.SetItemChecked(1, true);
            }
            if (ghyRight.yfk == true)
            {
                clbGHY.SetItemChecked(2, true);
            }
            if (ghyRight.ysk == true)
            {
                clbGHY.SetItemChecked(3, true);
            }
            if (ghyRight.cgbb == true)
            {
                clbGHY.SetItemChecked(4, true);
            }
            if (ghyRight.xsbb == true)
            {
                clbGHY.SetItemChecked(5, true);
            }
            if (ghyRight.lrbb == true)
            {
                clbGHY.SetItemChecked(6, true);
            }
            if (ghyRight.khgl == true)
            {
                clbGHY.SetItemChecked(7, true);
            }
            if (ghyRight.gysgl == true)
            {
                clbGHY.SetItemChecked(8, true);
            }
            if (ghyRight.spgl == true)
            {
                clbGHY.SetItemChecked(9, true);
            }
            if (ghyRight.zygl == true)
            {
                clbGHY.SetItemChecked(10, true);
            }
            if (ghyRight.zhgl == true)
            {
                clbGHY.SetItemChecked(11, true);
            }
            if (ghyRight.qxgl == true)
            {
                clbGHY.SetItemChecked(12, true);
            }

            #endregion

            #region 销售员权限

            var xsyRight = db.xsyrights.Find("xsy");
            if (xsyRight.ghd == true)
            {
                clbXSY.SetItemChecked(0, true);
            }
            if (xsyRight.xhd == true)
            {
                clbXSY.SetItemChecked(1, true);
            }
            if (xsyRight.yfk == true)
            {
                clbXSY.SetItemChecked(2, true);
            }
            if (xsyRight.ysk == true)
            {
                clbXSY.SetItemChecked(3, true);
            }
            if (xsyRight.cgbb == true)
            {
                clbXSY.SetItemChecked(4, true);
            }
            if (xsyRight.xsbb == true)
            {
                clbXSY.SetItemChecked(5, true);
            }
            if (xsyRight.lrbb == true)
            {
                clbXSY.SetItemChecked(6, true);
            }
            if (xsyRight.khgl == true)
            {
                clbXSY.SetItemChecked(7, true);
            }
            if (xsyRight.gysgl == true)
            {
                clbXSY.SetItemChecked(8, true);
            }
            if (xsyRight.spgl == true)
            {
                clbXSY.SetItemChecked(9, true);
            }
            if (xsyRight.zygl == true)
            {
                clbXSY.SetItemChecked(10, true);
            }
            if (xsyRight.zhgl == true)
            {
                clbXSY.SetItemChecked(11, true);
            }
            if (xsyRight.qxgl == true)
            {
                clbXSY.SetItemChecked(12, true);
            }

            #endregion
        }

        #region 菜单栏事件

        //点击 帮助
        private void HelpToolStripMenuItem_Click(object sender, EventArgs e)
        {
            tabPage16.Parent = tabControl1;//显示帮助tabPage16
            tabControl1.SelectedTab = tabPage16;
        }
        //点击修改密码
        private void ChangPwdToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FrmChangePwd fcp = new FrmChangePwd();
            fcp.id = userid;
            fcp.pwd = userpwd;
            fcp.ShowDialog();
        }
        //退出登录
        private void GoLoginFrmToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Hide();
            FrmLogin frmlogin = new FrmLogin();
            frmlogin.Show();
        }
        //退出系统
        private void ExitSysToolStripMenuItem_Click(object sender, EventArgs e)
        {
            System.Environment.Exit(0);
        }
        // 文件->关闭  关闭tabControl中的当前窗口
        private void CloseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TabPage nowPage = this.tabControl1.SelectedTab; //获取当前选项卡页
            if (nowPage != null) //当选项卡不为空
            {
                nowPage.Parent = null; //隐藏
                if (nowPage == tabPage1)
                {
                    clearGHInfo();
                }
                if (nowPage == tabPage2)
                {
                    txtGHLS.Text = "商品编号/名称/单据日期";
                    txtGHLS.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage3)
                {
                    clearXHInfo();
                }
                if (nowPage == tabPage4)
                {
                    txtXHLS.Text = "商品编号/名称/单据日期";
                    txtXHLS.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage5)
                {
                    txtYFK.Text = "供应商编号/名称/单据日期";
                    txtYFK.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage6)
                {
                    txtYSK.Text = "客户编号/名称/单据日期";
                    txtYSK.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage7)
                {
                    txtKH.Text = "客户编号/名称";
                    txtKH.ForeColor = Color.DarkGray;
                    textBoxKHClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseKH.Visible = false;
                    btnSaveKH.Visible = true;
                }
                if (nowPage == tabPage8)
                {
                    txtGYS.Text = "供应商编号/名称";
                    txtGYS.ForeColor = Color.DarkGray;
                    textBoxGYSClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseGYS.Visible = false;
                    btnSaveGYS.Visible = true;
                }
                if (nowPage == tabPage9)
                {
                    txtSP.Text = "商品编号/名称";
                    txtSP.ForeColor = Color.DarkGray;
                    textBoxSPClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseSP.Visible = false;
                    btnSaveSP.Visible = true;
                }
                if (nowPage == tabPage10)
                {
                    txtZY.Text = "职员工号/姓名";
                    txtZY.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage11)
                {
                    txtZH.Text = "账户编号/名称";
                    txtZH.ForeColor = Color.DarkGray;
                    textBoxZHClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseZH.Visible = false;
                    btnSaveZH.Visible = true;
                }
                if (nowPage == tabPage12)
                {
                    txtCG.Text = "供应商编号/名称/单据日期";
                    txtCG.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage13)
                {
                    txtXS.Text = "客户编号/名称/单据日期";
                    txtXS.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage14)
                {
                    txtLR.Text = "";
                    labCGZC.Text = "";
                    labXSSR.Text = "";
                    labLRQK.Text = "";
                }
            }
        }
        // 文件->退出 退出系统
        private void ExitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            System.Environment.Exit(0);
        }
        //叉号 关闭退出程序
        private void FrmMain_FormClosing(object sender, FormClosingEventArgs e)
        {
            System.Environment.Exit(0);
        }

        #endregion

        //treeView 单击节点显示相应tabPage选项卡
        public void treeView1_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            #region 管理员
            if (usertype.Equals("管理员"))
            {
                if (e.Node.Text == "购货单")
                {
                    tabPage1.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage1;
                    setGHBillId();
                }
                if (e.Node.Text == "销货单")
                {
                    tabPage3.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage3;
                    setXHBillId();
                }
                if (e.Node.Text == "应付款")
                {
                    refreshYFK();
                    tabPage5.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage5;
                }
                if (e.Node.Text == "应收款")
                {
                    refreshYSK();
                    tabPage6.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage6;
                }
                if (e.Node.Text == "客户管理")
                {
                    refreshKH();
                    tabPage7.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage7;
                }
                if (e.Node.Text == "供应商管理")
                {
                    refreshGYS();
                    tabPage8.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage8;
                }
                if (e.Node.Text == "商品管理")
                {
                    refreshSP();
                    tabPage9.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage9;
                }
                if (e.Node.Text == "职员管理")
                {
                    refreshZY();
                    tabPage10.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage10;
                }
                if (e.Node.Text == "账户管理")
                {
                    refreshZH();
                    tabPage11.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage11;
                }
                if (e.Node.Text == "采购报表")
                {
                    refreshCG();
                    tabPage12.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage12;
                }
                if (e.Node.Text == "销售报表")
                {
                    refreshXS();
                    tabPage13.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage13;
                }
                if (e.Node.Text == "利润报表")
                {
                    tabPage14.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage14;
                }
                if (e.Node.Text == "权限管理")
                {
                    tabPage15.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage15;
                }
            }
            #endregion

            #region 购货员
            if (usertype.Equals("购货员"))
            {
                var ghyRight = db.ghyrights.Find("ghy");

                if (e.Node.Text == "购货单" && ghyRight.ghd == true)
                {
                    tabPage1.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage1;
                    setGHBillId();
                }
                if (e.Node.Text == "销货单" && ghyRight.xhd == true)
                {
                    tabPage3.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage3;
                    setXHBillId();
                }
                if (e.Node.Text == "应付款" && ghyRight.yfk == true)
                {
                    refreshYFK();
                    tabPage5.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage5;
                }
                if (e.Node.Text == "应收款" && ghyRight.ysk == true)
                {
                    refreshYSK();
                    tabPage6.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage6;
                }
                if (e.Node.Text == "客户管理" && ghyRight.khgl == true)
                {
                    refreshKH();
                    tabPage7.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage7;
                }
                if (e.Node.Text == "供应商管理" && ghyRight.gysgl == true)
                {
                    refreshGYS();
                    tabPage8.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage8;
                }
                if (e.Node.Text == "商品管理" && ghyRight.spgl == true)
                {
                    refreshSP();
                    tabPage9.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage9;
                }
                if (e.Node.Text == "职员管理" && ghyRight.zygl == true)
                {
                    refreshZY();
                    tabPage10.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage10;
                }
                if (e.Node.Text == "账户管理" && ghyRight.zhgl == true)
                {
                    refreshZH();
                    tabPage11.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage11;
                }
                if (e.Node.Text == "采购报表" && ghyRight.cgbb == true)
                {
                    refreshCG();
                    tabPage12.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage12;
                }
                if (e.Node.Text == "销售报表" && ghyRight.xsbb == true)
                {
                    refreshXS();
                    tabPage13.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage13;
                }
                if (e.Node.Text == "利润报表" && ghyRight.lrbb == true)
                {
                    tabPage14.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage14;
                }
                if (e.Node.Text == "权限管理" && ghyRight.qxgl == true)
                {
                    tabPage15.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage15;
                }
            }
            #endregion

            #region 销售员
            if (usertype.Equals("销售员"))
            {
                var xsyRight = db.xsyrights.Find("xsy");

                if (e.Node.Text == "购货单" && xsyRight.ghd == true)
                {
                    tabPage1.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage1;
                    setGHBillId();
                }
                if (e.Node.Text == "销货单" && xsyRight.xhd == true)
                {
                    tabPage3.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage3;
                    setXHBillId();
                }
                if (e.Node.Text == "应付款" && xsyRight.yfk == true)
                {
                    refreshYFK();
                    tabPage5.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage5;
                }
                if (e.Node.Text == "应收款" && xsyRight.ysk == true)
                {
                    refreshYSK();
                    tabPage6.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage6;
                }
                if (e.Node.Text == "客户管理" && xsyRight.khgl == true)
                {
                    refreshKH();
                    tabPage7.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage7;
                }
                if (e.Node.Text == "供应商管理" && xsyRight.gysgl == true)
                {
                    refreshGYS();
                    tabPage8.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage8;
                }
                if (e.Node.Text == "商品管理" && xsyRight.spgl == true)
                {
                    refreshSP();
                    tabPage9.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage9;
                }
                if (e.Node.Text == "职员管理" && xsyRight.zygl == true)
                {
                    refreshZY();
                    tabPage10.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage10;
                }
                if (e.Node.Text == "账户管理" && xsyRight.zhgl == true)
                {
                    refreshZH();
                    tabPage11.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage11;
                }
                if (e.Node.Text == "采购报表" && xsyRight.cgbb == true)
                {
                    refreshCG();
                    tabPage12.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage12;
                }
                if (e.Node.Text == "销售报表" && xsyRight.xsbb == true)
                {
                    refreshXS();
                    tabPage13.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage13;
                }
                if (e.Node.Text == "利润报表" && xsyRight.lrbb == true)
                {
                    tabPage14.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage14;
                }
                if (e.Node.Text == "权限管理" && xsyRight.qxgl == true)
                {
                    tabPage15.Parent = tabControl1;//显示
                    tabControl1.SelectedTab = tabPage15;
                }
            }
            #endregion
        }
       

        #region 关闭选项卡事件

        //关闭当前选项卡
        private void btnCloseOne_Click(object sender, EventArgs e)
        {
            TabPage nowPage = this.tabControl1.SelectedTab; //获取当前选项卡页
            if (nowPage != null) //当选项卡不为空
            {
                nowPage.Parent = null; //隐藏
                if (nowPage == tabPage1)
                {
                    clearGHInfo();
                    btnGHGYSHide.Visible = false;
                    dgvGHGYS.Visible = false;
                    btnGHJSZHHide.Visible = false;
                    dgvGHJSZH.Visible = false;
                }
                if (nowPage == tabPage2)
                {
                    txtGHLS.Text = "商品编号/名称/单据日期";
                    txtGHLS.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage3)
                {
                    clearXHInfo();
                    btnXHKHHide.Visible = false;
                    dgvXHKH.Visible = false;
                    btnXHJSZHHide.Visible = false;
                    dgvXHJSZH.Visible = false;
                }
                if (nowPage == tabPage4)
                {
                    txtXHLS.Text = "商品编号/名称/单据日期";
                    txtXHLS.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage5)
                {
                    txtYFK.Text = "供应商编号/名称/单据日期";
                    txtYFK.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage6)
                {
                    txtYSK.Text = "客户编号/名称/单据日期";
                    txtYSK.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage7)
                {
                    txtKH.Text = "客户编号/名称";
                    txtKH.ForeColor = Color.DarkGray;
                    textBoxKHClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseKH.Visible = false;
                    btnSaveKH.Visible = true;
                }
                if (nowPage == tabPage8)
                {
                    txtGYS.Text = "供应商编号/名称";
                    txtGYS.ForeColor = Color.DarkGray;
                    textBoxGYSClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseGYS.Visible = false;
                    btnSaveGYS.Visible = true;
                }
                if (nowPage == tabPage9)
                {
                    txtSP.Text = "商品编号/名称";
                    txtSP.ForeColor = Color.DarkGray;
                    textBoxSPClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseSP.Visible = false;
                    btnSaveSP.Visible = true;
                }
                if (nowPage == tabPage10)
                {
                    txtZY.Text = "职员工号/姓名";
                    txtZY.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage11)
                {
                    txtZH.Text = "账户编号/名称";
                    txtZH.ForeColor = Color.DarkGray;
                    textBoxZHClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseZH.Visible = false;
                    btnSaveZH.Visible = true;
                }
                if (nowPage == tabPage12)
                {
                    txtCG.Text = "供应商编号/名称/单据日期";
                    txtCG.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage13)
                {
                    txtXS.Text = "客户编号/名称/单据日期";
                    txtXS.ForeColor = Color.DarkGray;
                }
                if (nowPage == tabPage14)
                {
                    txtLR.Text = "";
                    labCGZC.Text = "";
                    labXSSR.Text = "";
                    labLRQK.Text = "";
                }
            }
        }
        //关闭其它选项卡
        private void btnCloseOther_Click(object sender, EventArgs e)
        {
            TabPage nowPage = this.tabControl1.SelectedTab;
            TabPage nowPage1 = nowPage; //将当前选项卡页复制
            tabControl1.TabPages.Clear();//清空所有选项卡

            if (nowPage1 != tabPage1)
            {
                clearGHInfo();
                btnGHGYSHide.Visible = false;
                dgvGHGYS.Visible = false;
                btnGHJSZHHide.Visible = false;
                dgvGHJSZH.Visible = false;
            }
            if (nowPage1 != tabPage2)
            {
                txtGHLS.Text = "商品编号/名称/单据日期";
                txtGHLS.ForeColor = Color.DarkGray;
            }
            if (nowPage1 != tabPage3)
            {
                clearXHInfo();
                btnXHKHHide.Visible = false;
                dgvXHKH.Visible = false;
                btnXHJSZHHide.Visible = false;
                dgvXHJSZH.Visible = false;
            }
            if (nowPage1 != tabPage4)
            {
                txtXHLS.Text = "商品编号/名称/单据日期";
                txtXHLS.ForeColor = Color.DarkGray;
            }
            if (nowPage1 != tabPage5)
            {
                txtYFK.Text = "供应商编号/名称/单据日期";
                txtYFK.ForeColor = Color.DarkGray;
            }
            if (nowPage1 != tabPage6)
            {
                txtYSK.Text = "客户编号/名称/单据日期";
                txtYSK.ForeColor = Color.DarkGray;
            }
            if (nowPage1 != tabPage7)
            {
                txtKH.Text = "客户编号/名称";
                txtKH.ForeColor = Color.DarkGray;
                textBoxKHClear();
                //显示保存按钮 隐藏修改按钮
                btnReviseKH.Visible = false;
                btnSaveKH.Visible = true;
            }
            if (nowPage1 != tabPage8)
            {
                txtGYS.Text = "供应商编号/名称";
                txtGYS.ForeColor = Color.DarkGray;
                textBoxGYSClear();
                //显示保存按钮 隐藏修改按钮
                btnReviseGYS.Visible = false;
                btnSaveGYS.Visible = true;
            }
            if (nowPage1 != tabPage9)
            {
                txtSP.Text = "商品编号/名称";
                txtSP.ForeColor = Color.DarkGray;
                textBoxSPClear();
                //显示保存按钮 隐藏修改按钮
                btnReviseSP.Visible = false;
                btnSaveSP.Visible = true;
            }
            if (nowPage1 != tabPage10)
            {
                txtZY.Text = "职员工号/姓名";
                txtZY.ForeColor = Color.DarkGray;
            }
            if (nowPage1 != tabPage11)
            {
                txtZH.Text = "账户编号/名称";
                txtZH.ForeColor = Color.DarkGray;
                textBoxZHClear();
                //显示保存按钮 隐藏修改按钮
                btnReviseZH.Visible = false;
                btnSaveZH.Visible = true;
            }
            if (nowPage1 != tabPage12)
            {
                txtCG.Text = "供应商编号/名称/单据日期";
                txtCG.ForeColor = Color.DarkGray;
            }
            if (nowPage1 != tabPage13)
            {
                txtXS.Text = "客户编号/名称/单据日期";
                txtXS.ForeColor = Color.DarkGray;
            }
            if (nowPage1 != tabPage14)
            {
                txtLR.Text = "";
                labCGZC.Text = "";
                labXSSR.Text = "";
                labLRQK.Text = "";
            }
            if (nowPage1!=null)
            {
                nowPage1.Parent = tabControl1; //显示当前选项卡
            }
        }
        //关闭所有选项卡
        private void btnCloseAll_Click(object sender, EventArgs e)
        {
            tabControl1.TabPages.Clear();

            //清空内容
            clearGHInfo();
            btnGHGYSHide.Visible = false;
            dgvGHGYS.Visible = false;
            btnGHJSZHHide.Visible = false;
            dgvGHJSZH.Visible = false;
            txtGHLS.Text = "商品编号/名称/单据日期";
            txtGHLS.ForeColor = Color.DarkGray;
            clearXHInfo();
            btnXHKHHide.Visible = false;
            dgvXHKH.Visible = false;
            btnXHJSZHHide.Visible = false;
            dgvXHJSZH.Visible = false;
            txtXHLS.Text = "商品编号/名称/单据日期";
            txtXHLS.ForeColor = Color.DarkGray;
            txtYFK.Text = "供应商编号/名称/单据日期";
            txtYFK.ForeColor = Color.DarkGray;
            txtYSK.Text = "客户编号/名称/单据日期";
            txtYSK.ForeColor = Color.DarkGray;
            txtKH.Text = "客户编号/名称";
            txtKH.ForeColor = Color.DarkGray;
            textBoxKHClear();
            //显示保存按钮 隐藏修改按钮
            btnReviseKH.Visible = false;
            btnSaveKH.Visible = true;
            txtGYS.Text = "供应商编号/名称";
            txtGYS.ForeColor = Color.DarkGray;
            textBoxGYSClear();
            //显示保存按钮 隐藏修改按钮
            btnReviseGYS.Visible = false;
            btnSaveGYS.Visible = true;
            txtSP.Text = "商品编号/名称";
            txtSP.ForeColor = Color.DarkGray;
            textBoxSPClear();
            //显示保存按钮 隐藏修改按钮
            btnReviseSP.Visible = false;
            btnSaveSP.Visible = true;
            txtZY.Text = "职员工号/姓名";
            txtZY.ForeColor = Color.DarkGray;
            txtZH.Text = "账户编号/名称";
            txtZH.ForeColor = Color.DarkGray;
            textBoxZHClear();
            //显示保存按钮 隐藏修改按钮
            btnReviseZH.Visible = false;
            btnSaveZH.Visible = true;
            txtCG.Text = "供应商编号/名称/单据日期";
            txtCG.ForeColor = Color.DarkGray;
            txtXS.Text = "客户编号/名称/单据日期";
            txtXS.ForeColor = Color.DarkGray;
            txtLR.Text = "";
            labCGZC.Text = "";
            labXSSR.Text = "";
            labLRQK.Text = "";
        }

        #endregion

        #region  搜索框 默认文字的隐藏与显示
        //应付款
        private void txtYFK_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtYFK);
        }
        private void txtYFK_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtYFK, "供应商编号/名称/单据日期");
        }
        //应收款
        private void txtYSK_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtYSK);
        }
        private void txtYSK_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtYSK, "客户编号/名称/单据日期");
        }
        //采购报表
        private void txtCG_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtCG);
        }
        private void txtCG_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtCG, "供应商编号/名称/单据日期");
        }
        //销售报表
        private void txtXS_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtXS);
        }
        private void txtXS_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtXS, "客户编号/名称/单据日期");
        }
        //客户管理
        private void txtKH_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtKH);
        }
        private void txtKH_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtKH, "客户编号/名称");
        }
        //供应商管理
        private void txtGYS_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtGYS);
        }
        private void txtGYS_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtGYS, "供应商编号/名称");
        }
        //商品管理
        private void txtSP_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtSP);
        }
        private void txtSP_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtSP, "商品编号/名称");
        }
        //职员管理
        private void txtZY_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtZY);
        }
        private void txtZY_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtZY, "职员工号/姓名");
        }
        //账户管理
        private void txtZH_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtZH);
        }
        private void txtZH_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtZH, "账户编号/名称");
        }
        //购货单
        private void txtGHLS_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtGHLS);
        }
        private void txtGHLS_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtGHLS, "商品编号/名称/单据日期");
        }
        //销货单
        private void txtXHLS_MouseClick(object sender, MouseEventArgs e)
        {
            textboxMouseClick(txtXHLS);
        }
        private void txtXHLS_Leave(object sender, EventArgs e)
        {
            textboxLeave(txtXHLS, "商品编号/名称/单据日期");
        }

        //鼠标点击控件时 隐藏默认文字
        private void textboxMouseClick(TextBox txtName)
        {
            txtName.Text = "";
            txtName.ForeColor = Color.Black;
        }
        //鼠标点击其他控件时 若无输入内容 显示默认文字
        private void textboxLeave(TextBox txtName,string strText)
        {
            if (txtName.Text.Trim() == "")
            {
                txtName.ForeColor = Color.DarkGray;
                txtName.Text = strText;
            }
        }

        #endregion
       
        #region 连接FruitPSI数据库
        private SqlConnection connectFruitPSI()
        {
            SqlConnection conn = new SqlConnection("server=Jing;database=FruitPSI;uid=sa;pwd=123456");
            conn.Open();
            return conn;
        }

        #endregion

        #region 供应商管理

        #region 保存供应商信息

        //保存按钮事件
        private void btnSaveGYS_Click(object sender, EventArgs e)
        {
            if (inputCheckGYS())
            {
                if (!txtGYSID.Text.Trim().Equals("") && gysIDExist())
                {
                    labGYSCheck.Text = "编号已存在，请换其他编号";
                    timerGYS.Enabled = true;
                    return;
                }
                saveGYS();
            }
        }
        
        //保存供应商信息
        private void saveGYS()
        {
            Supplier gys = new Supplier
            {
                splrid = txtGYSID.Text.Trim(),
                splrname = txtGYSName.Text.Trim(),
                contacts = txtGYSContacts.Text.Trim(),
                contacttel = txtGYSTel.Text.Trim(),
                contactaddr = txtGYSAddr.Text.Trim()
            };
            db.Suppliers.Add(gys);
            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    //清空输入框信息
                    textBoxGYSClear();
                    //刷新供应商信息
                    refreshGYS();
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

        #endregion

        #region 修改和删除操作

        //点击dgvGYS单元格事件
        private void dgvGYS_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1) //当行数不是标题行时执行
            {
                gysId = dgvGYS.Rows[e.RowIndex].Cells[2].Value.ToString();//所选行的编号
                if (dgvGYS.Rows[e.RowIndex].Cells[0].Selected) //选中修改
                {
                    getGYS();
                }
                if (dgvGYS.Rows[e.RowIndex].Cells[1].Selected) //选中删除
                {
                    deleteGYS();
                }
            }
        }

        //获得某一行供应商信息，放入textbox输入框
        private void getGYS()
        {
            if (inputCheckGYS1()) //存在输入框不为空时
            {
                DialogResult dr=MessageBox.Show("输入框有信息未保存，确定执行此操作？", "注意", 
                    MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
                if (dr == DialogResult.Yes)
                {
                    var gysInfo = db.Suppliers.Find(gysId);
                    txtGYSID.Text = gysInfo.splrid;
                    txtGYSName.Text = gysInfo.splrname;
                    txtGYSContacts.Text = gysInfo.contacts;
                    txtGYSTel.Text = gysInfo.contacttel;
                    txtGYSAddr.Text = gysInfo.contactaddr;
                    //显示修改按钮 隐藏保存按钮
                    btnReviseGYS.Visible = true;
                    btnSaveGYS.Visible = false;
                }
            }
            else //输入框为空 直接执行
            {
                var gysInfo = db.Suppliers.Find(gysId);
                txtGYSID.Text = gysInfo.splrid;
                txtGYSName.Text = gysInfo.splrname;
                txtGYSContacts.Text = gysInfo.contacts;
                txtGYSTel.Text = gysInfo.contacttel;
                txtGYSAddr.Text = gysInfo.contactaddr;
                //显示修改按钮 隐藏保存按钮
                btnReviseGYS.Visible = true;
                btnSaveGYS.Visible = false;
            }
        }

        //删除某一行供应商信息
        private void deleteGYS()
        {
            DialogResult dr = MessageBox.Show("删除时将清空输入框所有内容，是否删除？", "删除", 
                 MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
            
            if (dr == DialogResult.Yes)
            {
                Supplier delGYS = db.Suppliers.Where(gys => gys.splrid == gysId).FirstOrDefault();
                db.Suppliers.Remove(delGYS);
                try
                {
                    int result = db.SaveChanges();
                    if (result == 1)
                    {
                        textBoxGYSClear();
                        //显示保存按钮 隐藏修改按钮
                        btnReviseGYS.Visible = false;
                        btnSaveGYS.Visible = true;
                        refreshGYS();
                    }
                    else
                    {
                        MessageBox.Show("删除失败");
                    }
                 }
                 catch (Exception ex)
                 {
                     MessageBox.Show("删除失败，可能您的操作不符合要求，请检查");
                 }
            }
        }

        //修改并保存按钮事件
        private void btnReviseGYS_Click(object sender, EventArgs e)
        { 
            //将编号改为其他编号时 如果和已存在的编号冲突 则提示换其他编号
            var gysid = from gys in db.Suppliers select gys.splrid;
            foreach (var gid in gysid)
            {
                if (gid.Equals(txtGYSID.Text.Trim())&&!txtGYSID.Text.Trim().Equals(gysId))
                {
                    labGYSCheck.Text = "编号已存在，请换其他编号";
                    timerGYS.Enabled = true;
                    return;
                }
            }
            //修改后的编号不存在 则先删除原编号信息 新增修改后的编号信息
            if (!gysIDExist()&&inputCheckGYS())
            {
                //labGYSCheck.Text = "";

                Supplier delGYS = db.Suppliers.Where(gys => gys.splrid == gysId).FirstOrDefault();
                db.Suppliers.Remove(delGYS);

                Supplier saveGYS = new Supplier
                {
                    splrid = txtGYSID.Text.Trim(),
                    splrname = txtGYSName.Text.Trim(),
                    contacts = txtGYSContacts.Text.Trim(),
                    contacttel = txtGYSTel.Text.Trim(),
                    contactaddr = txtGYSAddr.Text.Trim()
                };
                db.Suppliers.Add(saveGYS);

                try
                {
                    int result = db.SaveChanges();//因为删除 和 新增 是两步 所以result值为2
                    if (result == 2)
                    {
                        //清空输入框信息
                        textBoxGYSClear();
                        //刷新供应商信息
                        refreshGYS();
                    }
                    else
                    {
                        MessageBox.Show("修改并保存失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("修改并保存失败，可能您的输入内容不符合要求，请检查");
                }

                //显示保存按钮 隐藏修改按钮
                btnReviseGYS.Visible = false;
                btnSaveGYS.Visible = true;
                return;
            }
            if (inputCheckGYS())//输入框全不为空
            {
                reviseGYS();
            }
        }

        //修改供应商信息
        private void reviseGYS()
        {
            var gysInfo = db.Suppliers.Find(txtGYSID.Text.Trim());
            gysInfo.splrid = txtGYSID.Text.Trim();
            gysInfo.splrname = txtGYSName.Text.Trim();
            gysInfo.contacts = txtGYSContacts.Text.Trim();
            gysInfo.contacttel = txtGYSTel.Text.Trim();
            gysInfo.contactaddr = txtGYSAddr.Text.Trim();
         
            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    //清空输入框信息
                    textBoxGYSClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseGYS.Visible = false;
                    btnSaveGYS.Visible = true;
                    //刷新供应商信息
                    refreshGYS();
                }
                else
                {
                    DialogResult dr = MessageBox.Show("您没有做任何修改，是否清空输入框内信息？", "提示", MessageBoxButtons.YesNo,
                MessageBoxIcon.Question, MessageBoxDefaultButton.Button1);
                    if (dr == DialogResult.Yes)
                    {
                        textBoxGYSClear();
                        //显示保存按钮 隐藏修改按钮
                        btnReviseGYS.Visible = false;
                        btnSaveGYS.Visible = true;
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("修改失败，可能您的操作不符合要求，请检查");
            }
        }
        
        #endregion 

        #region 查询供应商信息

        //查询供应商按钮事件
        private void btnSearchGYS_Click(object sender, EventArgs e)
        {
            if (txtGYS.Text.Trim().Equals("") || txtGYS.Text.Equals("供应商编号/名称"))
            {
                refreshGYS();
            }
            else
            {
                searchGYS();
            }
        }

        //查询指定供应商
        private void searchGYS()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from supplier where splrid like '%" + txtGYS.Text.Trim() + "%' or splrname like '%" + txtGYS.Text.Trim() + "%'", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvGYS.DataSource = dt;
            conn.Close();
        }

        #endregion

        #region 输入验证 清空输入框 刷新供应商信息

        //检验输入框是否为空 不空返回true 空返回false
        private bool inputCheckGYS()
        {
            if (txtGYSID.Text.Trim().Equals(""))
            {
                labGYSCheck.Text = "编号不可为空";
                timerGYS.Enabled = true;
                return false;
            }
            if (txtGYSName.Text.Trim().Equals(""))
            {
                labGYSCheck.Text = "名称不可为空";
                timerGYS.Enabled = true;
                return false;
            }
            if (txtGYSContacts.Text.Trim().Equals(""))
            {
                labGYSCheck.Text = "联系人不可为空";
                timerGYS.Enabled = true;
                return false;
            }
            if (txtGYSTel.Text.Trim().Equals(""))
            {
                labGYSCheck.Text = "联系方式不可为空";
                timerGYS.Enabled = true;
                return false;
            }
            if (txtGYSAddr.Text.Trim().Equals(""))
            {
                labGYSCheck.Text = "地址不可为空";
                timerGYS.Enabled = true;
                return false;
            }
            return true;
        }

        //在修改时检查 输入框是否有数据 有返回true 没有返回false
        private bool inputCheckGYS1()
        {
            if (!txtGYSID.Text.Trim().Equals("") || !txtGYSName.Text.Trim().Equals("")
                || !txtGYSContacts.Text.Trim().Equals("")
                || !txtGYSTel.Text.Trim().Equals("") || !txtGYSAddr.Text.Trim().Equals(""))
            {
                return true;
            }
            return false;
        }

        //查询供应商编号是否存在 存在返回true 不存在返回false
        private bool gysIDExist()
        {
            //供应商表中查询
            var gysid = from gys in db.Suppliers select gys.splrid;
            foreach (var gid in gysid)
            {
                if (gid.Equals(txtGYSID.Text.Trim()))
                {
                    return true; //供应商编号存在
                }
            }
            return false; //编号不存在
        }

        //清空输入框信息
        private void textBoxGYSClear()
        {
            txtGYSID.Text = "";
            txtGYSName.Text = "";
            txtGYSContacts.Text = "";
            txtGYSTel.Text = "";
            txtGYSAddr.Text = "";
        }

        //刷新供应商信息
        private void refreshGYS()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from supplier", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvGYS.DataSource = dt;
            conn.Close();
        }
       
        //计时清空labGYSCheck提示
        private void timerGYS_Tick(object sender, EventArgs e)
        {
            timerGYS.Enabled = false;
            labGYSCheck.Text = "";
        }
       
        #endregion

        #endregion

        #region 客户管理

        #region 保存客户信息

        //保存按钮事件
        private void btnSaveKH_Click(object sender, EventArgs e)
        {
            if (inputCheckKH())
            {
                if (!txtKHID.Text.Trim().Equals("") && khIDExist())
                {
                    labKHCheck.Text = "编号已存在，请换其他编号";
                    timerKH.Enabled = true;
                    return;
                }
                saveKH();
            }
        }

        //保存客户信息
        private void saveKH()
        {
            Customer kh = new Customer
            {
                custid = txtKHID.Text.Trim(),
                custname = txtKHName.Text.Trim(),
                contacts = txtKHContacts.Text.Trim(),
                contacttel = txtKHTel.Text.Trim(),
                contactaddr = txtKHAddr.Text.Trim()
            };
            db.Customers.Add(kh);
            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    //清空输入框信息
                    textBoxKHClear();
                    //刷新客户信息
                    refreshKH();
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

        #endregion

        #region 修改和删除操作

        //点击dgvKH单元格事件
        private void dgvKH_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >-1) //当行数不是标题行时执行
            {
                khId = dgvKH.Rows[e.RowIndex].Cells[2].Value.ToString();//所选行的编号
                if (dgvKH.Rows[e.RowIndex].Cells[0].Selected) //选中修改
                {
                    getKH();
                }
                if (dgvKH.Rows[e.RowIndex].Cells[1].Selected) //选中删除
                {
                    deleteKH();
                }
            }
        }

        //获得某一行客户信息，放入textbox输入框
        private void getKH()
        {
            if (inputCheckKH1()) //存在输入框不为空时
            {
                DialogResult dr = MessageBox.Show("输入框有信息未保存，确定执行此操作？", "注意",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
                if (dr == DialogResult.Yes)
                {
                    var khInfo = db.Customers.Find(khId);
                    txtKHID.Text = khInfo.custid;
                    txtKHName.Text = khInfo.custname;
                    txtKHContacts.Text = khInfo.contacts;
                    txtKHTel.Text = khInfo.contacttel;
                    txtKHAddr.Text = khInfo.contactaddr;
                    //显示修改按钮 隐藏保存按钮
                    btnReviseKH.Visible = true;
                    btnSaveKH.Visible = false;
                }
            }
            else //输入框为空 直接执行
            {
                var khInfo = db.Customers.Find(khId);
                txtKHID.Text = khInfo.custid;
                txtKHName.Text = khInfo.custname;
                txtKHContacts.Text = khInfo.contacts;
                txtKHTel.Text = khInfo.contacttel;
                txtKHAddr.Text = khInfo.contactaddr;
                //显示修改按钮 隐藏保存按钮
                btnReviseKH.Visible = true;
                btnSaveKH.Visible = false;
            }
        }

        //删除某一行客户信息
        private void deleteKH()
        {
            DialogResult dr = MessageBox.Show("删除时将清空输入框所有内容，是否删除？", "删除",
                 MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);

            if (dr == DialogResult.Yes)
            {
                Customer delKH = db.Customers.Where(kh => kh.custid == khId).FirstOrDefault();
                db.Customers.Remove(delKH);
                try
                {
                    int result = db.SaveChanges();
                    if (result == 1)
                    {
                        textBoxKHClear();
                        //显示保存按钮 隐藏修改按钮
                        btnReviseKH.Visible = false;
                        btnSaveKH.Visible = true;
                        refreshKH();
                    }
                    else
                    {
                        MessageBox.Show("删除失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("删除失败，可能您的操作不符合要求，请检查");
                }
            }
        }

        //修改并保存按钮事件
        private void btnReviseKH_Click(object sender, EventArgs e)
        {
            //将编号改为其他编号时 如果和已存在的编号冲突 则提示换其他编号
            var khid = from kh in db.Customers select kh.custid;
            foreach (var gid in khid)
            {
                if (gid.Equals(txtKHID.Text.Trim()) && !txtKHID.Text.Trim().Equals(khId))
                {
                    labKHCheck.Text = "编号已存在，请换其他编号";
                    timerKH.Enabled = true;
                    return;
                }
            }
            //修改后的编号不存在 则先删除原编号信息 新增修改后的编号信息
            if (!khIDExist() && inputCheckKH())
            {
                Customer delKH = db.Customers.Where(kh => kh.custid == khId).FirstOrDefault();
                db.Customers.Remove(delKH);

                Customer saveKH = new Customer
                {
                    custid = txtKHID.Text.Trim(),
                    custname = txtKHName.Text.Trim(),
                    contacts = txtKHContacts.Text.Trim(),
                    contacttel = txtKHTel.Text.Trim(),
                    contactaddr = txtKHAddr.Text.Trim()
                };
                db.Customers.Add(saveKH);

                try
                {
                    int result = db.SaveChanges();//因为删除 和 新增 是两步 所以result值为2
                    if (result == 2)
                    {
                        //清空输入框信息
                        textBoxKHClear();
                        //刷新客户信息
                        refreshKH();
                    }
                    else
                    {
                        MessageBox.Show("修改并保存失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("修改并保存失败，可能您的输入内容不符合要求，请检查");
                }

                //显示保存按钮 隐藏修改按钮
                btnReviseKH.Visible = false;
                btnSaveKH.Visible = true;
                return;
            }
            if (inputCheckKH())//输入框全不为空
            {
                reviseKH();
            }
        }

        //修改客户信息
        private void reviseKH()
        {
            var khInfo = db.Customers.Find(txtKHID.Text.Trim());
            khInfo.custid = txtKHID.Text.Trim();
            khInfo.custname = txtKHName.Text.Trim();
            khInfo.contacts = txtKHContacts.Text.Trim();
            khInfo.contacttel = txtKHTel.Text.Trim();
            khInfo.contactaddr = txtKHAddr.Text.Trim();

            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    //清空输入框信息
                    textBoxKHClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseKH.Visible = false;
                    btnSaveKH.Visible = true;
                    //刷新客户信息
                    refreshKH();
                }
                else
                {
                    DialogResult dr = MessageBox.Show("您没有做任何修改，是否清空输入框内信息？", "提示", MessageBoxButtons.YesNo,
                MessageBoxIcon.Question, MessageBoxDefaultButton.Button1);
                    if (dr == DialogResult.Yes)
                    {
                        textBoxKHClear();
                        //显示保存按钮 隐藏修改按钮
                        btnReviseKH.Visible = false;
                        btnSaveKH.Visible = true;
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("修改失败，可能您的操作不符合要求，请检查");
            }
        }

        #endregion

        #region 查询客户信息

        //查询客户按钮事件
        private void btnSearchKH_Click(object sender, EventArgs e)
        {
            if (txtKH.Text.Trim().Equals("") || txtKH.Text.Equals("客户编号/名称"))
            {
                refreshKH();
            }
            else
            {
                searchKH();
            }
        }
        //查询指定客户
        private void searchKH()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from customer where custid like '%" + txtKH.Text.Trim() + "%' or custname like '%" + txtKH.Text.Trim() + "%'", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvKH.DataSource = dt;
            conn.Close();
        }

        #endregion

        #region 输入验证 清空输入框 刷新客户信息

        //检验输入框是否为空 不空返回true 空返回false
        private bool inputCheckKH()
        {
            if (txtKHID.Text.Trim().Equals(""))
            {
                labKHCheck.Text = "编号不可为空";
                timerKH.Enabled = true;
                return false;
            }
            if (txtKHName.Text.Trim().Equals(""))
            {
                labKHCheck.Text = "名称不可为空";
                timerKH.Enabled = true;
                return false;
            }
            if (txtKHContacts.Text.Trim().Equals(""))
            {
                labKHCheck.Text = "联系人不可为空";
                timerKH.Enabled = true;
                return false;
            }
            if (txtKHTel.Text.Trim().Equals(""))
            {
                labKHCheck.Text = "联系方式不可为空";
                timerKH.Enabled = true;
                return false;
            }
            if (txtKHAddr.Text.Trim().Equals(""))
            {
                labKHCheck.Text = "地址不可为空";
                timerKH.Enabled = true;
                return false;
            }
            return true;
        }

        //在修改时检查 输入框是否有数据 有返回true 没有返回false
        private bool inputCheckKH1()
        {
            if (!txtKHID.Text.Trim().Equals("") || !txtKHName.Text.Trim().Equals("")
                || !txtKHContacts.Text.Trim().Equals("")
                || !txtKHTel.Text.Trim().Equals("") || !txtKHAddr.Text.Trim().Equals(""))
            {
                return true;
            }
            return false;
        }

        //查询客户编号是否存在 存在返回true 不存在返回false
        private bool khIDExist()
        {
            //客户表中查询
            var khid = from kh in db.Customers select kh.custid;
            foreach (var gid in khid)
            {
                if (gid.Equals(txtKHID.Text.Trim()))
                {
                    return true; //客户编号存在
                }
            }
            return false; //编号不存在
        }

        //清空输入框信息
        private void textBoxKHClear()
        {
            txtKHID.Text = "";
            txtKHName.Text = "";
            txtKHContacts.Text = "";
            txtKHTel.Text = "";
            txtKHAddr.Text = "";
        }

        //刷新客户信息
        private void refreshKH()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from customer", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvKH.DataSource = dt;
            conn.Close();
        }
        
        //计时清空labKHCheck提示
        private void timerKH_Tick(object sender, EventArgs e)
        {
            timerKH.Enabled = false;
            labKHCheck.Text = "";
        }

        #endregion

        #endregion

        #region 职员管理

        #region 刷新职员表

        //刷新职员表
        private void refreshZY()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select staffid,staffname,stafftype from staffInfo", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvZY.DataSource = dt;
            conn.Close();
        }
        #endregion

        #region  修改删除职员信息
        
        //删除职员信息操作
        private void dgvZY_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            zyId = dgvZY.Rows[e.RowIndex].Cells[1].Value.ToString();
            //选中删除
            if (e.RowIndex > -1 && dgvZY.Rows[e.RowIndex].Cells[0].Selected)
            {
                DialogResult dr = MessageBox.Show("确认删除？", "删除", MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
                if (dr == DialogResult.Yes)
                {
                    StaffInfo delZY = db.StaffInfoes.Where(zy => zy.staffid == zyId).FirstOrDefault();
                    db.StaffInfoes.Remove(delZY);
                    try
                    {
                        int result = db.SaveChanges();
                        if (result == 1)
                        {
                            refreshZY(); 
                        }
                        else
                        {
                            MessageBox.Show("删除失败");
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("删除失败，可能您的操作不符合要求，请检查");
                    }
                }
            }
        }
        
        //修改类别列
        private void dgvZY_CellEndEdit(object sender, DataGridViewCellEventArgs e)
        {
            zyId = dgvZY.Rows[e.RowIndex].Cells[1].Value.ToString();
            if (e.RowIndex > -1)
            {
                string zyType = dgvZY.Rows[e.RowIndex].Cells[3].Value.ToString();
                SqlConnection conn = connectFruitPSI();
                string str = "update staffinfo set stafftype='" + zyType + "' where staffid='" + zyId + "'";
                SqlCommand sqlcom = new SqlCommand(str, conn);
                try
                {
                    if (sqlcom.ExecuteNonQuery() > 0)
                    {
                        labZYCheck.Text = "修改成功";
                        timerZY.Enabled = true;
                      //  refreshZY(); 加上此句有异常
                    }
                    else
                    {
                        MessageBox.Show("修改失败!");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("修改失败，可能您的操作不符合要求，请检查");
                }
                finally
                {
                    conn.Close();
                }
            }
        }

        #endregion

        #region 查询职员信息

        //查询职员按钮事件
        private void btnSearchZY_Click(object sender, EventArgs e)
        {
            if (txtZY.Text.Trim().Equals("") || txtZY.Text.Equals("职员工号/姓名"))
            {
                refreshZY();
            }
            else
            {
                searchZY();
            }
        }
        //查询指定职员
        private void searchZY()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select staffid,staffname,stafftype from staffinfo where staffid like '%" + txtZY.Text.Trim() + "%' or staffname like '%" + txtZY.Text.Trim() + "%'", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvZY.DataSource = dt;
            conn.Close();
        }

        #endregion

        #region 计时 清空labZYCheck 提示

        private void timerZY_Tick(object sender, EventArgs e)
        {
            timerZY.Enabled = false;
            labZYCheck.Text = "";
        }

        #endregion

        #endregion

        #region 商品管理

        #region 保存商品信息

        //保存按钮事件
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
                    refreshSP();
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

        #endregion

        #region 修改和删除操作

        //点击dgvSP单元格事件
        private void dgvSP_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1) //当行数不是标题行时执行
            {
                spId = dgvSP.Rows[e.RowIndex].Cells[2].Value.ToString();//所选行的编号
                if (dgvSP.Rows[e.RowIndex].Cells[0].Selected) //选中修改
                {
                    getSP();
                }
                if (dgvSP.Rows[e.RowIndex].Cells[1].Selected) //选中删除
                {
                    deleteSP();
                }
            }
        }

        //获得某一行商品信息，放入textbox输入框
        private void getSP()
        {
            if (inputCheckSP1()) //存在输入框不为空时
            {
                DialogResult dr = MessageBox.Show("输入框有信息未保存，确定执行此操作？", "注意",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
                if (dr == DialogResult.Yes)
                {
                    var spInfo = db.Products.Find(spId);
                    txtSPID.Text = spInfo.prodid;
                    txtSPName.Text = spInfo.prodname;
                    txtSPUom.Text = spInfo.produom;
                    txtSPInitQty.Text = Convert.ToString(spInfo.initqty) ;
                    txtSPInitCost.Text = Convert.ToString(spInfo.initcost); 
                    //显示修改按钮 隐藏保存按钮
                    btnReviseSP.Visible = true;
                    btnSaveSP.Visible = false;
                }
            }
            else //输入框为空 直接执行
            {
                var spInfo = db.Products.Find(spId);
                txtSPID.Text = spInfo.prodid;
                txtSPName.Text = spInfo.prodname;
                txtSPUom.Text = spInfo.produom;
                txtSPInitQty.Text = Convert.ToString(spInfo.initqty);
                txtSPInitCost.Text = Convert.ToString(spInfo.initcost); 
                //显示修改按钮 隐藏保存按钮
                btnReviseSP.Visible = true;
                btnSaveSP.Visible = false;
            }
        }

        //删除某一行商品信息
        private void deleteSP()
        {
            DialogResult dr = MessageBox.Show("删除时将清空输入框所有内容，是否删除？", "删除",
                 MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);

            if (dr == DialogResult.Yes)
            {
                Product delSP = db.Products.Where(sp => sp.prodid == spId).FirstOrDefault();
                db.Products.Remove(delSP);
                try
                {
                    int result = db.SaveChanges();
                    if (result == 1)
                    {
                        textBoxSPClear();
                        //显示保存按钮 隐藏修改按钮
                        btnReviseSP.Visible = false;
                        btnSaveSP.Visible = true;
                        refreshSP();
                    }
                    else
                    {
                        MessageBox.Show("删除失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("删除失败，可能您的操作不符合要求，请检查");
                }
            }
        }

        //修改并保存按钮事件
        private void btnReviseSP_Click(object sender, EventArgs e)
        {
            //将编号改为其他编号时 如果和已存在的编号冲突 则提示换其他编号
            var spid = from sp in db.Products select sp.prodid;
            foreach (var gid in spid)
            {
                if (gid.Equals(txtSPID.Text.Trim()) && !txtSPID.Text.Trim().Equals(spId))
                {
                    labSPCheck.Text = "编号已存在，请换其他编号";
                    timerSP.Enabled = true;
                    return;
                }
            }
            //修改后的编号不存在 则先删除原编号信息 新增修改后的编号信息
            if (!spIDExist() && inputCheckSP())
            {
                //将数据表中原有的期初数量qc和当前数量dq保存下来
                var spInfo = db.Products.Find(spId);
                double qc = Convert.ToDouble(spInfo.initqty), dq = Convert.ToDouble(spInfo.count);

                Product delSP = db.Products.Where(sp => sp.prodid == spId).FirstOrDefault();
                db.Products.Remove(delSP);

                Product saveSP = new Product
                {
                    prodid = txtSPID.Text.Trim(),
                    prodname = txtSPName.Text.Trim(),
                    produom = txtSPUom.Text.Trim(),
                    initqty = Convert.ToDouble(txtSPInitQty.Text.Trim()),
                    initcost = Convert.ToDouble(txtSPInitCost.Text.Trim()),
                    count = dq - qc + Convert.ToDouble(txtSPInitQty.Text.Trim())//数据表中的总数-数据表中的期初+修改的期初
                };
                db.Products.Add(saveSP);

                try
                {
                    int result = db.SaveChanges();//因为删除 和 新增 是两步 所以result值为2
                    if (result == 2)
                    {
                        //清空输入框信息
                        textBoxSPClear();
                        //刷新商品信息
                        refreshSP();
                    }
                    else
                    {
                        MessageBox.Show("修改并保存失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("修改并保存失败，可能您的输入内容不符合要求，请检查");
                }

                //显示保存按钮 隐藏修改按钮
                btnReviseSP.Visible = false;
                btnSaveSP.Visible = true;
                return;
            }
            if (inputCheckSP())//输入框全不为空
            {
                reviseSP();
            }
        }

        //修改商品信息
        private void reviseSP()
        {
            var spInfo = db.Products.Find(spId);
            double qc=Convert.ToDouble(spInfo.initqty),dq = Convert.ToDouble(spInfo.count);

            spInfo.prodid = txtSPID.Text.Trim();
            spInfo.prodname = txtSPName.Text.Trim();
            spInfo.produom = txtSPUom.Text.Trim();
            spInfo.initqty = Convert.ToDouble(txtSPInitQty.Text.Trim());
            spInfo.initcost = Convert.ToDouble(txtSPInitCost.Text.Trim());
            spInfo.count = dq - qc + Convert.ToDouble(txtSPInitQty.Text.Trim());//数据表中的总数-数据表中的期初+修改的期初

            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    //清空输入框信息
                    textBoxSPClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseSP.Visible = false;
                    btnSaveSP.Visible = true;
                    //刷新商品信息
                    refreshSP();
                }
                else
                {
                    DialogResult dr = MessageBox.Show("您没有做任何修改，是否清空输入框内信息？", "提示", MessageBoxButtons.YesNo,
                MessageBoxIcon.Question, MessageBoxDefaultButton.Button1);
                    if (dr == DialogResult.Yes)
                    {
                        textBoxSPClear();
                        //显示保存按钮 隐藏修改按钮
                        btnReviseSP.Visible = false;
                        btnSaveSP.Visible = true;
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("修改失败，可能您的操作不符合要求，请检查");
            }
        }

        #endregion

        #region 查询商品信息

        //查询商品按钮事件
        private void btnSearchSP_Click(object sender, EventArgs e)
        {
            if (txtSP.Text.Trim().Equals("") || txtSP.Text.Equals("商品编号/名称"))
            {
                refreshSP();
            }
            else
            {
                searchSP();
            }
        }
        //查询指定商品
        private void searchSP()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from product where prodid like '%" + txtSP.Text.Trim() + "%' or prodname like '%" + txtSP.Text.Trim() + "%'", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvSP.DataSource = dt;
            conn.Close();
        }

        #endregion

        #region 输入验证 清空输入框 刷新商品信息

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

        //在修改时检查 输入框是否有数据 有返回true 没有返回false
        private bool inputCheckSP1()
        {
            if (!txtSPID.Text.Trim().Equals("") || !txtSPName.Text.Trim().Equals("")
                || !txtSPUom.Text.Trim().Equals("")
                || !txtSPInitQty.Text.Trim().Equals("") || !txtSPInitCost.Text.Trim().Equals(""))
            {
                return true;
            }
            return false;
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

        //清空输入框信息
        private void textBoxSPClear()
        {
            txtSPID.Text = "";
            txtSPName.Text = "";
            txtSPUom.Text = "";
            txtSPInitQty.Text = "";
            txtSPInitCost.Text = "";
        }

        //刷新商品信息
        private void refreshSP()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from product", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvSP.DataSource = dt;
            conn.Close();
        }

        //计时清空labSPCheck提示
        private void timerSP_Tick(object sender, EventArgs e)
        {
            timerSP.Enabled = false;
            labSPCheck.Text = "";
        }
        #endregion

        #endregion

        #region 账户管理

        #region 保存账户信息

        //保存按钮事件
        private void btnSaveZH_Click(object sender, EventArgs e)
        {
            if (inputCheckZH())
            {
                if (!txtZHID.Text.Trim().Equals("") && zhIDExist())
                {
                    labZHCheck.Text = "编号已存在，请换其他编号";
                    timerZH.Enabled = true;
                    return;
                }
                saveZH();
            }
        }

        //保存账户信息
        private void saveZH()
        {
            Account zh = new Account
            {
                accid = txtZHID.Text.Trim(),
                accname = txtZHName.Text.Trim(),
                initbalance = Convert.ToDouble(txtZHInitBalance.Text.Trim()),
                curbalance = Convert.ToDouble(txtZHInitBalance.Text.Trim()) //新增时 当前余额=期初余额
            };
            db.Accounts.Add(zh);
            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    //清空输入框信息
                    textBoxZHClear();
                    //刷新账户信息
                    refreshZH();
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

        #endregion

        #region 修改和删除操作

        //点击dgvZH单元格事件
        private void dgvZH_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1) //当行数不是标题行时执行
            {
                zhId = dgvZH.Rows[e.RowIndex].Cells[2].Value.ToString();//所选行的编号
                if (dgvZH.Rows[e.RowIndex].Cells[0].Selected) //选中修改
                {
                    getZH();
                }
                if (dgvZH.Rows[e.RowIndex].Cells[1].Selected) //选中删除
                {
                    deleteZH();
                }
            }
        }

        //获得某一行账户信息，放入textbox输入框
        private void getZH()
        {
            if (inputCheckZH1()) //存在输入框不为空时
            {
                DialogResult dr = MessageBox.Show("输入框有信息未保存，确定执行此操作？", "注意",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
                if (dr == DialogResult.Yes)
                {
                    var zhInfo = db.Accounts.Find(zhId);
                    txtZHID.Text = zhInfo.accid;
                    txtZHName.Text = zhInfo.accname;
                    txtZHInitBalance.Text = Convert.ToString(zhInfo.initbalance);
                    //显示修改按钮 隐藏保存按钮
                    btnReviseZH.Visible = true;
                    btnSaveZH.Visible = false;
                }
            }
            else //输入框为空 直接执行
            {
                var zhInfo = db.Accounts.Find(zhId);
                txtZHID.Text = zhInfo.accid;
                txtZHName.Text = zhInfo.accname;
                txtZHInitBalance.Text = Convert.ToString(zhInfo.initbalance);
                //显示修改按钮 隐藏保存按钮
                btnReviseZH.Visible = true;
                btnSaveZH.Visible = false;
            }
        }

        //删除某一行账户信息
        private void deleteZH()
        {
            DialogResult dr = MessageBox.Show("删除时将清空输入框所有内容，是否删除？", "删除",
                 MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);

            if (dr == DialogResult.Yes)
            {
                Account delZH = db.Accounts.Where(zh => zh.accid == zhId).FirstOrDefault();
                db.Accounts.Remove(delZH);
                try
                {
                    int result = db.SaveChanges();
                    if (result == 1)
                    {
                        textBoxZHClear();
                        //显示保存按钮 隐藏修改按钮
                        btnReviseZH.Visible = false;
                        btnSaveZH.Visible = true;
                        refreshZH();
                    }
                    else
                    {
                        MessageBox.Show("删除失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("删除失败，可能您的操作不符合要求，请检查");
                }
            }
        }

        //修改并保存按钮事件
        private void btnReviseZH_Click(object sender, EventArgs e)
        {
            //将编号改为其他编号时 如果和已存在的编号冲突 则提示换其他编号
            var zhid = from zh in db.Accounts select zh.accid;
            foreach (var gid in zhid)
            {
                if (gid.Equals(txtZHID.Text.Trim()) && !txtZHID.Text.Trim().Equals(zhId))
                {
                    labZHCheck.Text = "编号已存在，请换其他编号";
                    timerZH.Enabled = true;
                    return;
                }
            }
            //修改后的编号不存在 则先删除原编号信息 新增修改后的编号信息
            if (!zhIDExist() && inputCheckZH())
            {
                //将数据表中原有的期初余额qc和当前余额dq保存下来
                var zhInfo = db.Accounts.Find(zhId);
                double qc = Convert.ToDouble(zhInfo.initbalance), dq = Convert.ToDouble(zhInfo.curbalance);

                Account delZH = db.Accounts.Where(zh => zh.accid == zhId).FirstOrDefault();
                db.Accounts.Remove(delZH);

                Account saveZH = new Account
                {
                    accid = txtZHID.Text.Trim(),
                    accname = txtZHName.Text.Trim(),
                    initbalance = Convert.ToDouble(txtZHInitBalance.Text.Trim()),
                    curbalance = dq - qc + Convert.ToDouble(txtZHInitBalance.Text.Trim())//数据表中的当前余额-数据表中的期初+修改的期初
                };
                db.Accounts.Add(saveZH);

                try
                {
                    int result = db.SaveChanges();//因为删除 和 新增 是两步 所以result值为2
                    if (result == 2)
                    {
                        //清空输入框信息
                        textBoxZHClear();
                        //刷新账户信息
                        refreshZH();
                    }
                    else
                    {
                        MessageBox.Show("修改并保存失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("修改并保存失败，可能您的输入内容不符合要求，请检查");
                }

                //显示保存按钮 隐藏修改按钮
                btnReviseZH.Visible = false;
                btnSaveZH.Visible = true;
                return;
            }
            if (inputCheckZH())//输入框全不为空
            {
                reviseZH();
            }
        }

        //修改账户信息
        private void reviseZH()
        {
            var zhInfo = db.Accounts.Find(zhId);
            double qc = Convert.ToDouble(zhInfo.initbalance), dq = Convert.ToDouble(zhInfo.curbalance);

            zhInfo.accid = txtZHID.Text.Trim();
            zhInfo.accname = txtZHName.Text.Trim();
            zhInfo.initbalance = Convert.ToDouble(txtZHInitBalance.Text.Trim());
            zhInfo.curbalance = dq - qc + Convert.ToDouble(txtZHInitBalance.Text.Trim());//数据表中的总数-数据表中的期初+修改的期初

            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    //清空输入框信息
                    textBoxZHClear();
                    //显示保存按钮 隐藏修改按钮
                    btnReviseZH.Visible = false;
                    btnSaveZH.Visible = true;
                    //刷新账户信息
                    refreshZH();
                }
                else
                {
                    DialogResult dr = MessageBox.Show("您没有做任何修改，是否清空输入框内信息？", "提示", MessageBoxButtons.YesNo,
                MessageBoxIcon.Question, MessageBoxDefaultButton.Button1);
                    if (dr == DialogResult.Yes)
                    {
                        textBoxZHClear();
                        //显示保存按钮 隐藏修改按钮
                        btnReviseZH.Visible = false;
                        btnSaveZH.Visible = true;
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("修改失败，可能您的操作不符合要求，请检查");
            }
        }

        #endregion

        #region 查询账户信息

        //查询账户按钮事件
        private void btnSearchZH_Click(object sender, EventArgs e)
        {
            if (txtZH.Text.Trim().Equals("") || txtZH.Text.Equals("账户编号/名称"))
            {
                refreshZH();
            }
            else
            {
                searchZH();
            }
        }
        //查询指定账户
        private void searchZH()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from account where accid like '%" + txtZH.Text.Trim() + "%' or accname like '%" + txtZH.Text.Trim() + "%'", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvZH.DataSource = dt;
            conn.Close();
        }

        #endregion

        #region 输入验证 清空输入框 刷新账户信息

        //检验输入框是否为空 不空返回true 空返回false
        private bool inputCheckZH()
        {
            if (txtZHID.Text.Trim().Equals(""))
            {
                labZHCheck.Text = "编号不可为空";
                timerZH.Enabled = true;
                return false;
            }
            if (txtZHName.Text.Trim().Equals(""))
            {
                labZHCheck.Text = "名称不可为空";
                timerZH.Enabled = true;
                return false;
            }
            if (txtZHInitBalance.Text.Trim().Equals(""))
            {
                labZHCheck.Text = "期初余额不可为空";
                timerZH.Enabled = true;
                return false;
            }
            return true;
        }

        //在修改时检查 输入框是否有数据 有返回true 没有返回false
        private bool inputCheckZH1()
        {
            if (!txtZHID.Text.Trim().Equals("") || !txtZHName.Text.Trim().Equals("")|| !txtZHInitBalance.Text.Trim().Equals("") )
            {
                return true;
            }
            return false;
        }

        //查询账户编号是否存在 存在返回true 不存在返回false
        private bool zhIDExist()
        {
            //账户表中查询
            var zhid = from zh in db.Accounts select zh.accid;
            foreach (var gid in zhid)
            {
                if (gid.Equals(txtZHID.Text.Trim()))
                {
                    return true; //账户编号存在
                }
            }
            return false; //编号不存在
        }

        //清空输入框信息
        private void textBoxZHClear()
        {
            txtZHID.Text = "";
            txtZHName.Text = "";
            txtZHInitBalance.Text = "";
        }

        //刷新账户信息
        private void refreshZH()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from account", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvZH.DataSource = dt;
            conn.Close();
        }

        //计时清空labZHCheck提示
        private void timerZH_Tick(object sender, EventArgs e)
        {
            timerZH.Enabled = false;
            labZHCheck.Text = "";
        }
        #endregion

        #endregion

        #region 购货单

        #region 供应商相关

        //点击供应商输入框
        private void txtGHGYS_Click(object sender, EventArgs e)
        {
            refreshGHGYS();
            btnGHGYSHide.Visible = true;
            dgvGHGYS.Visible = true;
        }
        
        //选择供应商
        private void dgvGHGYS_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1)
            {
                if (dgvGHGYS.Rows[e.RowIndex].Cells[0].Selected || dgvGHGYS.Rows[e.RowIndex].Cells[1].Selected) //选中
                {
                    txtGHGYS.Text = dgvGHGYS.Rows[e.RowIndex].Cells[0].Value.ToString() + " "
                        + dgvGHGYS.Rows[e.RowIndex].Cells[1].Value.ToString();
                    btnGHGYSHide.Visible = false;
                    dgvGHGYS.Visible = false;
                }
            }
        }
        //隐藏购货供应商信息
        private void btnGHGYSHide_Click(object sender, EventArgs e)
        {
            btnGHGYSHide.Visible = false;
            dgvGHGYS.Visible = false;
        }
        
        //添加供应商按钮事件
        private void btnAddGHGYS_Click(object sender, EventArgs e)
        {
            refreshGYS();
            tabPage8.Parent = tabControl1;//显示
            tabControl1.SelectedTab = tabPage8;
        }

        //刷新购货单的供应商信息
        private void refreshGHGYS()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select splrid,splrname from supplier", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvGHGYS.DataSource = dt;
            conn.Close();
        }

        #endregion

        #region 账户相关

        //点击结算账户输入框
        private void txtGHJSZH_Click(object sender, EventArgs e)
        {
            refreshGHJSZH();
            btnGHJSZHHide.Visible = true;
            dgvGHJSZH.Visible = true;
        }
        
        string ghJszhId = ""; //获取结算账户id
        //选择结算账户
        private void dgvGHJSZH_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1)
            {
                if (dgvGHJSZH.Rows[e.RowIndex].Cells[0].Selected || dgvGHJSZH.Rows[e.RowIndex].Cells[1].Selected) //选中
                {
                    txtGHJSZH.Text = dgvGHJSZH.Rows[e.RowIndex].Cells[0].Value.ToString() + " "
                        + dgvGHJSZH.Rows[e.RowIndex].Cells[1].Value.ToString();

                    ghJszhId = dgvGHJSZH.Rows[e.RowIndex].Cells[0].Value.ToString();
                    btnGHJSZHHide.Visible = false;
                    dgvGHJSZH.Visible = false;
                }
            }
        }
        //隐藏购货结算账户信息
        private void btnGHJSZHHide_Click(object sender, EventArgs e)
        {
            btnGHJSZHHide.Visible = false;
            dgvGHJSZH.Visible = false;
        }
        //添加结算账户按钮事件
        private void btnAddGHJSZH_Click(object sender, EventArgs e)
        {
            refreshZH();
            tabPage11.Parent = tabControl1;//显示
            tabControl1.SelectedTab = tabPage11;
        }
        //刷新购货单的结算账户信息
        private void refreshGHJSZH()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select accid,accname from account", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvGHJSZH.DataSource = dt;
            conn.Close();
        }
        #endregion

        #region 单据日期 单据编号

        string dtpGHYear, dtpGHMonth, dtpGHDay, ghDate, ghBillId, ghBillDate;
       
        //购货单据日期改变时 重新设置单据编号
        private void dtpGH_ValueChanged(object sender, EventArgs e)
        {
            setGHBillId();
        }
        
        //获得购货 年月日 单据日期
        private void getGHDateInfo()
        {
            dtpGHYear = dtpGH.Value.Year.ToString();
            dtpGHMonth = dtpGH.Value.Month.ToString();
            if (int.Parse(dtpGHMonth) < 10)
            {
                dtpGHMonth = "0" + dtpGHMonth;
            }
            dtpGHDay = dtpGH.Value.Day.ToString();
            if (int.Parse(dtpGHDay) < 10)
            {
                dtpGHDay = "0" + dtpGHDay;
            }
            ghDate = dtpGHYear + dtpGHMonth + dtpGHDay;
            ghBillDate = dtpGHYear + "/" + dtpGHMonth + "/" + dtpGHDay;
        }
       
        //查找 购货单中是否存在 所选日期的单据编号
        private void searchGHBillId()
        {
            getGHDateInfo();
            SqlConnection conn = connectFruitPSI();
            string strSql = "select billid from PurProductAll where billid like '%" + ghDate + "%' order by billid desc";
            SqlDataAdapter sda = new SqlDataAdapter(strSql, conn);
            DataSet ds = new DataSet();
            int temp = sda.Fill(ds);
            if (temp == 0)
            {
                ghBillId = "";
            }
            else
            {
                ghBillId = ds.Tables[0].Rows[0][0].ToString();
            }
            conn.Close();
        }
        
        //设置购货单据编号
        private void setGHBillId()
        {
            searchGHBillId();
            if (ghBillId.Equals(""))
            {
                ghBillId = "GHD" + ghDate + "001";
            }
            else
            {
                int num = int.Parse(ghBillId.Substring(ghBillId.Length - 3)) + 1;
                string strnum;
                if (num < 10)
                {
                    strnum = "00" + num;
                }
                else if (num > 99)
                {
                    strnum = "" + num;
                }
                else
                {
                    strnum = "0" + num;
                }
                ghBillId = "GHD" + ghDate + strnum;
            }
            labGHBillID.Text = ghBillId;
        }

        #endregion

        #region 录单时间 修改时间
        
        //新增商品时 获得录单修改时间
        DateTime ghtime = DateTime.Now;
        private void getGHLDXGTime()
        {
            
            labGHLD.Text = ghtime.ToString();
            labGHXG.Text = ghtime.ToString();
        }

        #endregion

        #region dgvGHSP数据网格视图相关

        //购货单商品单元格结束编辑时事件
        private void dgvGHSP_CellEndEdit(object sender, DataGridViewCellEventArgs e)
        {
            double ghSum = 0, qty = 0, unitprice = 0, price = 0;//总金额 数量 单价 金额

            if (dgvGHSP.CurrentRow.Cells[4].Value != null)
            {
                try
                {
                    qty = double.Parse(dgvGHSP.CurrentRow.Cells[4].Value.ToString());
                }
                catch (Exception ex)
                {
                    MessageBox.Show("输入格式有误，请按照正常情况输入");
                    dgvGHSP.CurrentRow.Cells[4].Value = 0.00;
                }

            }
            if (dgvGHSP.CurrentRow.Cells[5].Value != null)
            {
                try
                {
                    unitprice = double.Parse(dgvGHSP.CurrentRow.Cells[5].Value.ToString());
                }
                catch (Exception ex)
                {
                    MessageBox.Show("输入格式有误，请按照正常情况输入");
                    dgvGHSP.CurrentRow.Cells[5].Value = 0.00;
                }
            }
            if (dgvGHSP.CurrentRow.Cells[4].Value != null && dgvGHSP.CurrentRow.Cells[5].Value != null)
            {
                price = qty * unitprice;
                dgvGHSP.CurrentRow.Cells[6].Value = price;
            }
  
            for (int i = 0; i < dgvGHSP.RowCount; i++)
            {
                if (dgvGHSP.Rows[i].Cells[6].Value != null)
                {
                    ghSum += double.Parse(dgvGHSP.Rows[i].Cells[6].Value.ToString());
                }
            }
            txtGHZJE.Text = ghSum.ToString("#0.00");
            ghTongBu();
        }

        //设置 数量和单价列 单元格只能输入数字和小数点
        private void dgvGHSP_EditingControlShowing(object sender, DataGridViewEditingControlShowingEventArgs e)
        {
            if (this.dgvGHSP.CurrentCell.ColumnIndex == 4 ||
                this.dgvGHSP.CurrentCell.ColumnIndex == 5)
            {
                e.Control.KeyPress += new KeyPressEventHandler(cells_KeyPress);
            }
        }
        private void cells_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != 8 && !Char.IsDigit(e.KeyChar) && e.KeyChar != '.')
            {
                e.Handled = true;
            }
        }

        //购货单 删除某一行商品
        private void dgvGHSP_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1)
            {
                if (dgvGHSP.Rows[e.RowIndex].Cells[0].Selected)
                {
                    dgvGHSP.Rows.RemoveAt(e.RowIndex);
                }
            }
        }

        #endregion

        #region 下方输入框 各种事件

        //焦点离开优惠金额输入框事件
        private void txtGHYHJE_Leave(object sender, EventArgs e)
        {
            if (txtGHYHJE.Text != null && txtGHYHJE.Text != "")
            {
                double doub = double.Parse(txtGHYHJE.Text);
                txtGHYHJE.Text = doub.ToString("#0.00");
                ghTongBu();
            }
        }

        //焦点离开本次付款输入框事件
        private void txtGHBCFK_Leave(object sender, EventArgs e)
        {
            if (txtGHBCFK.Text != null && txtGHBCFK.Text != "")
            {
                double doub = double.Parse(txtGHBCFK.Text);
                txtGHBCFK.Text = doub.ToString("#0.00");
                ghTongBu();
            }
        }

        //设置优惠金额 只能输入数字和一个小数点
        private void txtGHYHJE_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != 8 && !Char.IsDigit(e.KeyChar) && e.KeyChar != '.')
            {
                e.Handled = true;
            }
            if (txtGHYHJE.Text.Contains(".") && e.KeyChar == 46)
            {
                e.Handled = true;
            }
        }

        //设置本次付款 只能输入数字和一个小数点
        private void txtGHBCFK_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != 8 && !Char.IsDigit(e.KeyChar) && e.KeyChar != '.')
            {
                e.Handled = true;
            }
            if (txtGHBCFK.Text.Contains(".") && e.KeyChar == 46)
            {
                e.Handled = true;
            }
        }

        #endregion

        //使 需付款和本次欠款 随着优惠金额和本次付款的输入的变化而改变
        private void ghTongBu()
        {
            if (txtGHZJE.Text != null && txtGHZJE.Text != "")
            {
                if (txtGHYHJE.Text == null || txtGHYHJE.Text == "")
                {
                    txtGHYHJE.Text = "0.00";
                }
                txtGHXFK.Text = (double.Parse(txtGHZJE.Text) - double.Parse(txtGHYHJE.Text)).ToString("#0.00");
            }

            if (txtGHXFK.Text != null && txtGHXFK.Text != "")
            {
                if (txtGHBCFK.Text == null || txtGHBCFK.Text == "")
                {
                    txtGHBCFK.Text = "0.00";
                }
                txtGHBCQK.Text = (double.Parse(txtGHXFK.Text) - double.Parse(txtGHBCFK.Text)).ToString("#0.00");
            }
        }

        //新增按钮事件
        private void btnAddGHSP_Click(object sender, EventArgs e)
        {
            frmGHSpSel.ShowDialog();
        }

        //历史单据事件
        private void btnGHLS_Click(object sender, EventArgs e)
        {
            refreshGHLS();
            tabPage2.Parent = tabControl1;//显示
            tabControl1.SelectedTab = tabPage2;
        }

        //保存按钮事件
        private void btnSaveGH_Click(object sender, EventArgs e)
        {
            if (!ghCheck())
            {
                return;
            }
            DialogResult dr = MessageBox.Show("保存后，便不可更改，请确认无误。是否保存", "注意",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
            if (dr == DialogResult.Yes)
            {
                //获得录单 修改时间
                getGHLDXGTime();

                //相关信息 存入数据库
                savePurProductAll();
                savePurProductEach();

                //刷新 单据编号
                setGHBillId();

                //刷新商品管理信息
                refreshSP();

                //刷新账户信息
                refreshZH();

                //刷新购货历史单据
                refreshGHLS();

                //刷新应付款
                refreshYFK();

                //刷新采购报表
                refreshCG();

                MessageBox.Show("保存成功！");

                //清空所有输入框信息 dgv表格信息
                clearGHInfo();
            }
        }

        #region 存入购货单表 PurProductAll PurProductEach

        //保存dgvGHSP以外的信息
        private void savePurProductAll()
        {
            PurProductAll ghAll = new PurProductAll
            {
                supplier = txtGHGYS.Text,
                billdate = ghBillDate,
                billid = labGHBillID.Text,
                totalmoney = double.Parse(txtGHZJE.Text),
                dctmoney = double.Parse(txtGHYHJE.Text),
                purmoney = double.Parse(txtGHXFK.Text),
                account = txtGHJSZH.Text,
                payment = double.Parse(txtGHBCFK.Text),
                arrear = double.Parse(txtGHBCQK.Text),
                billmaker = labGHZDR.Text,
                recordtime = ghtime,
                revisetime = ghtime,
                other = rtxtGHBZ.Text
            };
            db.PurProductAlls.Add(ghAll);
            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    updateGHAccount(ghJszhId, double.Parse(txtGHBCFK.Text));
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
       
        //dgvGHSP信息保存
        private void savePurProductEach()
        {
            for (int i = 0; i < dgvGHSP.RowCount; i++)
            {
                PurProductEach ghEach = new PurProductEach
                {
                    billid = labGHBillID.Text,
                    prodid = this.dgvGHSP.Rows[i].Cells[1].Value.ToString(),
                    prodname = this.dgvGHSP.Rows[i].Cells[2].Value.ToString(),
                    produnit = this.dgvGHSP.Rows[i].Cells[3].Value.ToString(),
                    purqty = double.Parse(this.dgvGHSP.Rows[i].Cells[4].Value.ToString()),
                    unitprice = double.Parse(this.dgvGHSP.Rows[i].Cells[5].Value.ToString()),
                    money = double.Parse(this.dgvGHSP.Rows[i].Cells[6].Value.ToString())
                };
                db.PurProductEaches.Add(ghEach);
                try
                {
                    int result = db.SaveChanges();
                    if (result == 1)
                    {
                        updateGHCount(this.dgvGHSP.Rows[i].Cells[1].Value.ToString(), 
                            double.Parse(this.dgvGHSP.Rows[i].Cells[4].Value.ToString()));
                    }
                    else
                    {
                        MessageBox.Show("商品保存失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("商品保存失败，可能您的输入内容不符合要求，请检查");
                }
            }
        }

        //清空购货单信息
        private void clearGHInfo()
        {
            txtGHGYS.Text = "";
            txtGHJSZH.Text = "";
            txtGHZJE.Text = "";
            txtGHYHJE.Text = "";
            txtGHXFK.Text = "";
            txtGHBCFK.Text = "";
            txtGHBCQK.Text = "";
            rtxtGHBZ.Text = "";
            dgvGHSP.Rows.Clear();
        }

        //检查是否有空值 没有空值true 有空值false 
        private bool ghCheck()
        {
            if (txtGHGYS.Text.Equals(""))
            {
                MessageBox.Show("请选择供应商");
                return false;
            }
            if (dgvGHSP.RowCount == 0)
            {
                MessageBox.Show("请添加商品");
                return false;
            }
            //检验 dgvGHSP 是否有空值
            int j = 0;
            for (int i = 0; i < dgvGHSP.RowCount; i++)
            {
                if (this.dgvGHSP.Rows[i].Cells[4].Value != null && this.dgvGHSP.Rows[i].Cells[5].Value != null)
                {
                    j++;
                }
            }
            if (j != dgvGHSP.RowCount)
            {
                MessageBox.Show("请确保商品数量、单价信息已经填写！");
                return false;
            }
            if (txtGHYHJE.Text.Equals(""))
            {
                MessageBox.Show("请填写优惠金额");
                return false;
            }
            if (txtGHBCFK.Text.Equals(""))
            {
                MessageBox.Show("请填写本次付款");
                return false;
            }
            if (txtGHJSZH.Text.Equals(""))
            {
                MessageBox.Show("请选择结算账户");
                return false;
            }
            return true;
        }

        //购货时更新商品当前数量 
        private void updateGHCount(string id,double d)
        {
            var spInfo = db.Products.Find(id);
            double dq = Convert.ToDouble(spInfo.count);
            spInfo.count = dq + d;

            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                  // MessageBox.Show("当前数量更新成功");
                }
                else
                {
                  //  MessageBox.Show("当前数量更新出错");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("当前数量更新失败，可能您的操作不符合要求，请检查");
            }
        }
        //购货时更新账户当前余额
        private void updateGHAccount(string id,double d)
        {
            var zhInfo = db.Accounts.Find(id);
            double dq = Convert.ToDouble(zhInfo.curbalance);
            zhInfo.curbalance = dq - d;

            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                     //MessageBox.Show("当前余额更新成功");
                }
                else
                {
                   // MessageBox.Show("当前余额更新出错");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("当前余额更新失败，可能您的操作不符合要求，请检查");
            }
        }

        #endregion

        #endregion

        #region 购货单 销货单 共用

        //每当窗体激活时发生 **************************************************
        private void FrmMain_Activated(object sender, EventArgs e)
        {
            //购货单添加商品 主窗体激活后 
            if (frmGHSpSel.result == true)
            {
                string[] id = frmGHSpSel.spid, name = frmGHSpSel.spname, uom = frmGHSpSel.spuom;
                int length = id.Length;

                //如果添加重复的商品则去除 即防止添加商品重复
                //每次让一个已存在的 商品编号和新添加的所有的商品编号比较 重复则去除
                if (dgvGHSP.RowCount > 0)
                {
                    for (int i = 0; i < dgvGHSP.RowCount; i++)
                    {
                        for (int j = 0; j < length; j++)
                        {
                            if (dgvGHSP.Rows[i].Cells[1].Value.ToString().Equals(id[j]))
                            {
                                if (j != length - 1)
                                {
                                    for (int k = j; k < length - 1; k++)
                                    {
                                        id[k] = id[k + 1];
                                        name[k] = name[k + 1];
                                        uom[k] = uom[k + 1];
                                    }
                                    length--;
                                }
                                else
                                {
                                    length--;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < length; i++)
                {
                    int addRow = this.dgvGHSP.Rows.Add();
                    this.dgvGHSP.Rows[addRow].Cells[1].Value = frmGHSpSel.spid[i];
                    this.dgvGHSP.Rows[addRow].Cells[2].Value = frmGHSpSel.spname[i];
                    this.dgvGHSP.Rows[addRow].Cells[3].Value = frmGHSpSel.spuom[i];
                }
                frmGHSpSel.result = false;
            }

            //销货单添加商品 主窗体激活后 
            if (frmXHSpSel.result == true)
            {
                string[] id = frmXHSpSel.spid, name = frmXHSpSel.spname, uom = frmXHSpSel.spuom;
                int length = id.Length;

                //如果添加重复的商品则去除 即防止添加商品重复
                //每次让一个已存在的 商品编号和新添加的所有的商品编号比较 重复则去除
                if (dgvXHSP.RowCount > 0)
                {
                    for (int i = 0; i < dgvXHSP.RowCount; i++)
                    {
                        for (int j = 0; j < length; j++)
                        {
                            if (dgvXHSP.Rows[i].Cells[1].Value.ToString().Equals(id[j]))
                            {
                                if (j != length - 1)
                                {
                                    for (int k = j; k < length - 1; k++)
                                    {
                                        id[k] = id[k + 1];
                                        name[k] = name[k + 1];
                                        uom[k] = uom[k + 1];
                                    }
                                    length--;
                                }
                                else
                                {
                                    length--;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < length; i++)
                {
                    int addRow = this.dgvXHSP.Rows.Add();
                    this.dgvXHSP.Rows[addRow].Cells[1].Value = frmXHSpSel.spid[i];
                    this.dgvXHSP.Rows[addRow].Cells[2].Value = frmXHSpSel.spname[i];
                    this.dgvXHSP.Rows[addRow].Cells[3].Value = frmXHSpSel.spuom[i];
                }
                frmXHSpSel.result = false;
            }
        }

        #endregion

        #region 销货单

        #region 客户相关

        //点击客户输入框
        private void txtXHKH_Click(object sender, EventArgs e)
        {
            refreshXHKH();
            btnXHKHHide.Visible = true;
            dgvXHKH.Visible = true;
        }
        //选择客户
        private void dgvXHKH_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1)
            {
                if (dgvXHKH.Rows[e.RowIndex].Cells[0].Selected || dgvXHKH.Rows[e.RowIndex].Cells[1].Selected) //选中
                {
                    txtXHKH.Text = dgvXHKH.Rows[e.RowIndex].Cells[0].Value.ToString() + " "
                        + dgvXHKH.Rows[e.RowIndex].Cells[1].Value.ToString();
                    btnXHKHHide.Visible = false;
                    dgvXHKH.Visible = false;
                }
            }
        }
        //隐藏销货客户信息
        private void btnXHKHHide_Click(object sender, EventArgs e)
        {
            btnXHKHHide.Visible = false;
            dgvXHKH.Visible = false;
        }
        //添加客户按钮事件
        private void btnAddXHKH_Click(object sender, EventArgs e)
        {
            refreshKH();
            tabPage7.Parent = tabControl1;//显示
            tabControl1.SelectedTab = tabPage7;
        }
        //刷新销货单的客户信息
        private void refreshXHKH()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select custid,custname from customer", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvXHKH.DataSource = dt;
            conn.Close();
        }

        #endregion

        #region 账户相关

        //点击结算账户输入框
        private void txtXHJSZH_Click(object sender, EventArgs e)
        {
            refreshXHJSZH();
            btnXHJSZHHide.Visible = true;
            dgvXHJSZH.Visible = true;
        }
        string xhJszhId = ""; //获取销货结算账户id
        //选择结算账户
        private void dgvXHJSZH_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1)
            {
                if (dgvXHJSZH.Rows[e.RowIndex].Cells[0].Selected || dgvXHJSZH.Rows[e.RowIndex].Cells[1].Selected) //选中
                {
                    txtXHJSZH.Text = dgvXHJSZH.Rows[e.RowIndex].Cells[0].Value.ToString() + " "
                        + dgvXHJSZH.Rows[e.RowIndex].Cells[1].Value.ToString();
                    xhJszhId = dgvXHJSZH.Rows[e.RowIndex].Cells[0].Value.ToString();
                    btnXHJSZHHide.Visible = false;
                    dgvXHJSZH.Visible = false;
                }
            }
        }
        //隐藏销货结算账户信息
        private void btnXHJSZHHide_Click(object sender, EventArgs e)
        {
            btnXHJSZHHide.Visible = false;
            dgvXHJSZH.Visible = false;
        }
        //添加结算账户按钮事件
        private void btnAddXHJSZH_Click(object sender, EventArgs e)
        {
            refreshZH();
            tabPage11.Parent = tabControl1;//显示
            tabControl1.SelectedTab = tabPage11;
        }
        //刷新销货单的结算账户信息
        private void refreshXHJSZH()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select accid,accname from account", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvXHJSZH.DataSource = dt;
            conn.Close();
        }

        #endregion

        #region 单据日期 单据编号

        string dtpXHYear, dtpXHMonth, dtpXHDay, xhDate, xhBillId, xhBillDate;
       
        //销货单据日期改变时 重新设置单据编号
        private void dtpXH_ValueChanged(object sender, EventArgs e)
        {
            setXHBillId();
        }
        //获得销货 年月日 单据日期
        private void getXHDateInfo()
        {
            dtpXHYear = dtpXH.Value.Year.ToString();
            dtpXHMonth = dtpXH.Value.Month.ToString();
            if (int.Parse(dtpXHMonth) < 10)
            {
                dtpXHMonth = "0" + dtpXHMonth;
            }
            dtpXHDay = dtpXH.Value.Day.ToString();
            if (int.Parse(dtpXHDay) < 10)
            {
                dtpXHDay = "0" + dtpXHDay;
            }
            xhDate = dtpXHYear + dtpXHMonth + dtpXHDay;
            xhBillDate = dtpXHYear + "/" + dtpXHMonth + "/" + dtpXHDay;
        }
        //查找 销货单中是否存在 所选日期的单据编号
        private void searchXHBillId()
        {
            getXHDateInfo();
            SqlConnection conn = connectFruitPSI();
            string strSql = "select billid from SaleProductAll where billid like '%" + xhDate + "%' order by billid desc";
            SqlDataAdapter sda = new SqlDataAdapter(strSql, conn);
            DataSet ds = new DataSet();
            int temp = sda.Fill(ds);
            if (temp == 0)
            {
                xhBillId = "";
            }
            else
            {
                xhBillId = ds.Tables[0].Rows[0][0].ToString();
            }
            conn.Close();
        }
        //设置销货单据编号
        private void setXHBillId()
        {
            searchXHBillId();
            if (xhBillId.Equals(""))
            {
                xhBillId = "GHD" + xhDate + "001";
            }
            else
            {
                int num = int.Parse(xhBillId.Substring(xhBillId.Length - 3)) + 1;
                string strnum;
                if (num < 10)
                {
                    strnum = "00" + num;
                }
                else if (num > 99)
                {
                    strnum = "" + num;
                }
                else
                {
                    strnum = "0" + num;
                }
                xhBillId = "GHD" + xhDate + strnum;
            }
            labXHBillID.Text = xhBillId;
        }

        #endregion

        #region 录单时间 修改时间

        //新增商品时 获得录单修改时间
        DateTime xhtime = DateTime.Now;
        private void getXHLDXGTime()
        {

            labXHLD.Text = xhtime.ToString();
            labXHXG.Text = xhtime.ToString();
        }

        #endregion

        #region dgvXHSP数据网格视图相关

        //销货单商品单元格结束编辑时事件
        private void dgvXHSP_CellEndEdit(object sender, DataGridViewCellEventArgs e)
        {
            double xhSum = 0, qty = 0, unitprice = 0, price = 0;//总金额 数量 单价 金额

            if (dgvXHSP.CurrentRow.Cells[4].Value != null)
            {
                try
                {
                    qty = double.Parse(dgvXHSP.CurrentRow.Cells[4].Value.ToString());
                }
                catch (Exception ex)
                {
                    MessageBox.Show("输入格式有误，请按照正常情况输入");
                    dgvXHSP.CurrentRow.Cells[4].Value = 0.00;
                }

            }
            if (dgvXHSP.CurrentRow.Cells[5].Value != null)
            {
                try
                {
                    unitprice = double.Parse(dgvXHSP.CurrentRow.Cells[5].Value.ToString());
                }
                catch (Exception ex)
                {
                    MessageBox.Show("输入格式有误，请按照正常情况输入");
                    dgvXHSP.CurrentRow.Cells[5].Value = 0.00;
                }
            }
            if (dgvXHSP.CurrentRow.Cells[4].Value != null && dgvXHSP.CurrentRow.Cells[5].Value != null)
            {
                price = qty * unitprice;
                dgvXHSP.CurrentRow.Cells[6].Value = price;
            }

            for (int i = 0; i < dgvXHSP.RowCount; i++)
            {
                if (dgvXHSP.Rows[i].Cells[6].Value != null)
                {
                    xhSum += double.Parse(dgvXHSP.Rows[i].Cells[6].Value.ToString());
                }
            }
            txtXHZJE.Text = xhSum.ToString("#0.00");
            xhTongBu();
        }

        //设置 数量和单价列 单元格只能输入数字和小数点
        private void dgvXHSP_EditingControlShowing(object sender, DataGridViewEditingControlShowingEventArgs e)
        {
            if (this.dgvXHSP.CurrentCell.ColumnIndex == 4 ||
                this.dgvXHSP.CurrentCell.ColumnIndex == 5)
            {
                e.Control.KeyPress += new KeyPressEventHandler(cells_KeyPress);
            }
        }

        //销货单 删除某一行商品
        private void dgvXHSP_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex > -1)
            {
                if (dgvXHSP.Rows[e.RowIndex].Cells[0].Selected)
                {
                    dgvXHSP.Rows.RemoveAt(e.RowIndex);
                }
            }
        }

        #endregion

        #region 下方输入框 各种事件

        //焦点离开优惠金额输入框事件
        private void txtXHYHJE_Leave(object sender, EventArgs e)
        {
            if (txtXHYHJE.Text != null && txtXHYHJE.Text != "")
            {
                double doub = double.Parse(txtXHYHJE.Text);
                txtXHYHJE.Text = doub.ToString("#0.00");
                xhTongBu();
            }
        }

        //焦点离开本次收款输入框事件
        private void txtXHBCSK_Leave(object sender, EventArgs e)
        {
            if(txtXHBCSK.Text!=null && txtXHBCSK.Text!="")
            {
                double doub = double.Parse(txtXHBCSK.Text);
                txtXHBCSK.Text = doub.ToString("#0.00");
                xhTongBu();
            }
        }

        //设置优惠金额 只能输入数字和一个小数点
        private void txtXHYHJE_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != 8 && !Char.IsDigit(e.KeyChar) && e.KeyChar != '.')
            {
                e.Handled = true;
            }
            if (txtXHYHJE.Text.Contains(".") && e.KeyChar == 46)
            {
                e.Handled = true;
            }
        }

        //设置本次收款 只能输入数字和一个小数点
        private void txtXHBCSK_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != 8 && !Char.IsDigit(e.KeyChar) && e.KeyChar != '.')
            {
                e.Handled = true;
            }
            if (txtXHBCSK.Text.Contains(".") && e.KeyChar == 46)
            {
                e.Handled = true;
            }
        }

        #endregion

        //使 需收款和本次欠款 随着优惠金额和本次收款的输入的变化而改变
        private void xhTongBu()
        {
            if (txtXHZJE.Text != null && txtXHZJE.Text != "")
            {
                if (txtXHYHJE.Text == null || txtXHYHJE.Text == "")
                {
                    txtXHYHJE.Text = "0.00";
                }
                txtXHXSK.Text = (double.Parse(txtXHZJE.Text) - double.Parse(txtXHYHJE.Text)).ToString("#0.00");
            }

            if (txtXHXSK.Text != null && txtXHXSK.Text != "")
            {
                if (txtXHBCSK.Text == null || txtXHBCSK.Text == "")
                {
                    txtXHBCSK.Text = "0.00";
                }
                txtXHBCQK.Text = (double.Parse(txtXHXSK.Text) - double.Parse(txtXHBCSK.Text)).ToString("#0.00");
            }
        }
       
        //新增商品按钮事件
        private void btnAddXHSP_Click(object sender, EventArgs e)
        {
            frmXHSpSel.ShowDialog();
        }
       
        //历史单据事件
        private void btnXHLS_Click(object sender, EventArgs e)
        {
            refreshXHLS();
            tabPage4.Parent = tabControl1;//显示
            tabControl1.SelectedTab = tabPage4;
        }
       
        //保存按钮事件
        private void btnSaveXH_Click(object sender, EventArgs e)
        {
            if (!xhCheck())
            {
                return;
            }
            DialogResult dr = MessageBox.Show("保存后，便不可更改，请确认无误。是否保存", "注意",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
            if (dr == DialogResult.Yes)
            {
                //获得录单 修改时间
                getXHLDXGTime();

                //相关信息 存入数据库
                saveSaleProductAll();
                saveSaleProductEach();

                //刷新 单据编号
                setXHBillId();

                //刷新商品管理信息
                refreshSP();

                //刷新账户信息
                refreshZH();

                //刷新销货历史单据
                refreshXHLS();

                //刷新应收款
                refreshYSK();

                //刷新销售报表
                refreshXS();
                
                MessageBox.Show("保存成功！");

                //清空所有输入框信息 dgv表格信息
                clearXHInfo();
            } 
        }

        #region 存入销货单表 SaleProductAll SaleProductEach

        //保存dgvXHSP以外的信息
        private void saveSaleProductAll()
        {
            SaleProductAll xhAll = new SaleProductAll
            {
                customer = txtXHKH.Text,
                billdate = xhBillDate,
                billid = labXHBillID.Text,
                totalmoney = double.Parse(txtXHZJE.Text),
                dctmoney = double.Parse(txtXHYHJE.Text),
                salemoney = double.Parse(txtXHXSK.Text),
                account = txtXHJSZH.Text,
                receipt = double.Parse(txtXHBCSK.Text),
                arrear = double.Parse(txtXHBCQK.Text),
                billmaker = labXHZDR.Text,
                recordtime = xhtime,
                revisetime = xhtime,
                other = rtxtXHBZ.Text
            };
            db.SaleProductAlls.Add(xhAll);
            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    updateXHAccount(xhJszhId, double.Parse(txtXHBCSK.Text));
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

        //dgvGHSP信息保存
        private void saveSaleProductEach()
        {
            for (int i = 0; i < dgvXHSP.RowCount; i++)
            {
                SaleProductEach xhEach = new SaleProductEach
                {
                    billid = labXHBillID.Text,
                    prodid = this.dgvXHSP.Rows[i].Cells[1].Value.ToString(),
                    prodname = this.dgvXHSP.Rows[i].Cells[2].Value.ToString(),
                    produnit = this.dgvXHSP.Rows[i].Cells[3].Value.ToString(),
                    saleqty = double.Parse(this.dgvXHSP.Rows[i].Cells[4].Value.ToString()),
                    unitprice = double.Parse(this.dgvXHSP.Rows[i].Cells[5].Value.ToString()),
                    money = double.Parse(this.dgvXHSP.Rows[i].Cells[6].Value.ToString())
                };
                db.SaleProductEaches.Add(xhEach);
                try
                {
                    int result = db.SaveChanges();
                    if (result == 1)
                    {
                        updateXHCount(this.dgvXHSP.Rows[i].Cells[1].Value.ToString(),
                            double.Parse(this.dgvXHSP.Rows[i].Cells[4].Value.ToString()));
                    }
                    else
                    {
                        MessageBox.Show("商品保存失败");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("商品保存失败，可能您的输入内容不符合要求，请检查");
                }
            }
        }

        //清空购货单信息
        private void clearXHInfo()
        {
            txtXHKH.Text = "";
            txtXHJSZH.Text = "";
            txtXHZJE.Text = "";
            txtXHYHJE.Text = "";
            txtXHXSK.Text = "";
            txtXHBCSK.Text = "";
            txtXHBCQK.Text = "";
            rtxtXHBZ.Text = "";
            dgvXHSP.Rows.Clear();
        }

        //检查是否有空值 没有空值true 有空值false 
        private bool xhCheck()
        {
            if (txtXHKH.Text.Equals(""))
            {
                MessageBox.Show("请选择客户");
                return false;
            }
            if (dgvXHSP.RowCount == 0)
            {
                MessageBox.Show("请添加商品");
                return false;
            }
            //检验 dgvGHSP 是否有空值
            int j = 0;
            for (int i = 0; i < dgvXHSP.RowCount; i++)
            {
                if (this.dgvXHSP.Rows[i].Cells[4].Value != null && this.dgvXHSP.Rows[i].Cells[5].Value != null)
                {
                    j++;
                }
            }
            if (j != dgvXHSP.RowCount)
            {
                MessageBox.Show("请确保商品数量、单价信息已经填写！");
                return false;
            }
            if (txtXHYHJE.Text.Equals(""))
            {
                MessageBox.Show("请填写优惠金额");
                return false;
            }
            if (txtXHBCSK.Text.Equals(""))
            {
                MessageBox.Show("请填写本次收款");
                return false;
            }
            if (txtXHJSZH.Text.Equals(""))
            {
                MessageBox.Show("请选择结算账户");
                return false;
            }
            return true;
        }

        //销货时更新商品当前数量 
        private void updateXHCount(string id, double d)
        {
            var spInfo = db.Products.Find(id);
            double dq = Convert.ToDouble(spInfo.count);
            spInfo.count = dq - d;

            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    // MessageBox.Show("当前数量更新成功");
                }
                else
                {
                    //MessageBox.Show("当前数量更新出错");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("当前数量更新失败，可能您的操作不符合要求，请检查");
            }
        }
        //销货时更新账户当前余额
        private void updateXHAccount(string id, double d)
        {
            var zhInfo = db.Accounts.Find(id);
            double dq = Convert.ToDouble(zhInfo.curbalance);
            zhInfo.curbalance = dq + d;

            try
            {
                int result = db.SaveChanges();
                if (result == 1)
                {
                    //MessageBox.Show("当前余额更新成功");
                }
                else
                {
                    // MessageBox.Show("当前余额更新出错");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("当前余额更新失败，可能您的操作不符合要求，请检查");
            }
        }

        #endregion

        #endregion

        #region 购货历史

        //刷新购货历史
        private void refreshGHLS()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from PurProductEach", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvGHLS.DataSource = dt;
            conn.Close();
        }

        //查询按钮事件
        private void btnSearchGHLS_Click(object sender, EventArgs e)
        {
            if (txtGHLS.Text.Trim().Equals("") || txtGHLS.Text.Equals("商品编号/名称/单据日期"))
            {
                refreshGHLS();
            }
            else
            {
                searchGHLS();
            }
        }
        //查询历史
        private void searchGHLS()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from PurProductEach where prodid like '%" + txtGHLS.Text.Trim()
                + "%' or prodname like '%" + txtGHLS.Text.Trim() + "%' or billid like '%" + txtGHLS.Text.Trim() + "%'", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvGHLS.DataSource = dt;
            conn.Close();
        }

        //删除 操作
        private void dgvGHLS_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            //选中删除
            if (e.RowIndex > -1 && dgvGHLS.Rows[e.RowIndex].Cells[0].Selected)
            {
                string djId = dgvGHLS.Rows[e.RowIndex].Cells[1].Value.ToString();
                DialogResult dr = MessageBox.Show("将删除所有与此单据有关的信息。确认删除？", "删除", MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
                if (dr == DialogResult.Yes)
                {
                    //先删除 PurProductEach 中单据信息
                    var list = db.PurProductEaches.Where(ghEach => ghEach.billid == djId).ToList();
                    list.ForEach(ghEach => db.PurProductEaches.Remove(ghEach));
                    int i = db.SaveChanges();
                    MessageBox.Show("已删除 "+i+" 条购货单信息");
                 
                    PurProductAll delAll = db.PurProductAlls.Where(ghAll => ghAll.billid == djId).FirstOrDefault();
                    db.PurProductAlls.Remove(delAll);
                    try
                    {
                        int result = db.SaveChanges();
                        if (result == 1)
                        {
                            //MessageBox.Show("单据cg");
                        }
                        else
                        {
                            MessageBox.Show("单据删除失败");
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("单据删除失败，可能您的操作不符合要求，请检查"+ex);
                    }
                }
                refreshGHLS();
                refreshYFK();
                refreshCG();
                setGHBillId();
            }
        }

        #endregion

        #region 销货历史

        //刷新销货历史
        private void refreshXHLS()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from SaleProductEach", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvXHLS.DataSource = dt;
            conn.Close();
        }

        //查询按钮事件
        private void btnSearchXHLS_Click(object sender, EventArgs e)
        {
            if (txtXHLS.Text.Trim().Equals("") || txtXHLS.Text.Equals("商品编号/名称/单据日期"))
            {
                refreshXHLS();
            }
            else
            {
                searchXHLS();
            }
        }
        //查询历史
        private void searchXHLS()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select * from SaleProductEach where prodid like '%" + txtXHLS.Text.Trim()
                + "%' or prodname like '%" + txtXHLS.Text.Trim() + "%' or billid like '%" + txtXHLS.Text.Trim() + "%'", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvXHLS.DataSource = dt;
            conn.Close();
        }

        //删除 操作
        private void dgvXHLS_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            //选中删除
            if (e.RowIndex > -1 && dgvXHLS.Rows[e.RowIndex].Cells[0].Selected)
            {
                string djId = dgvXHLS.Rows[e.RowIndex].Cells[1].Value.ToString();
                DialogResult dr = MessageBox.Show("将删除所有与此单据有关的信息。确认删除？", "删除", MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
                if (dr == DialogResult.Yes)
                {
                    //先删除 SaleProductEach 中单据信息
                    var list = db.SaleProductEaches.Where(xhEach => xhEach.billid == djId).ToList();
                    list.ForEach(xhEach => db.SaleProductEaches.Remove(xhEach));
                    int i = db.SaveChanges();
                    MessageBox.Show("已删除 " + i + " 条销货单信息");

                    SaleProductAll delAll = db.SaleProductAlls.Where(xhAll => xhAll.billid == djId).FirstOrDefault();
                    db.SaleProductAlls.Remove(delAll);
                    try
                    {
                        int result = db.SaveChanges();
                        if (result == 1)
                        {
                            //MessageBox.Show("单据cg");
                        }
                        else
                        {
                            MessageBox.Show("单据删除失败");
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("单据删除失败，可能您的操作不符合要求，请检查" + ex);
                    }
                }
                refreshXHLS();
                refreshYSK();
                refreshXS();
                setXHBillId();
            }
        }
        #endregion

        #region 应付款

        //查询按钮事件
        private void btnSearchYFK_Click(object sender, EventArgs e)
        {
            if (txtYFK.Text.Trim().Equals("") || txtYFK.Text.Equals("供应商编号/名称/单据日期"))
            {
                refreshYFK();
            }
            else
            {
                searchYFK();
            }
        }
        //查询
        private void searchYFK()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select supplier,billdate,billid,arrear from PurProductAll where arrear>0 and (billid like '%" + txtYFK.Text.Trim()
                + "%' or supplier like '%" + txtYFK.Text.Trim() + "%')", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvYFK.DataSource = dt;
            conn.Close();
        }
      
        //刷新
        private void refreshYFK()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select supplier,billdate,billid,arrear from PurProductAll where arrear>0", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvYFK.DataSource = dt;
            conn.Close();
        }

        // 付清
        private void dgvYFK_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            //选中付清
            if (e.RowIndex > -1 && dgvYFK.Rows[e.RowIndex].Cells[0].Selected)
            {
                string djId = dgvYFK.Rows[e.RowIndex].Cells[3].Value.ToString();
                DialogResult dr = MessageBox.Show("确认已付清？", "提示", MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
                if (dr == DialogResult.Yes)
                {
                    var ghAll = db.PurProductAlls.Find(djId);
                    double xfk = Convert.ToDouble(ghAll.purmoney);
                    ghAll.payment = xfk;
                    ghAll.arrear = 0;

                    try
                    {
                        int i = db.SaveChanges();
                        if (i == 1)
                        {
                            refreshYFK();
                            refreshCG();
                            refreshGHLS();
                           // MessageBox.Show("已付清");
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("已付清出错");
                    }
                }
            }
        }

        #endregion

        #region 应收款

        //查询按钮事件
        private void btnSearchYSK_Click(object sender, EventArgs e)
        {
            if (txtYSK.Text.Trim().Equals("") || txtYSK.Text.Equals("客户编号/名称/单据日期"))
            {
                refreshYSK();
            }
            else
            {
                searchYSK();
            }
        }
        //查询
        private void searchYSK()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select customer,billdate,billid,arrear from SaleProductAll where arrear>0 and (billid like '%" + txtYSK.Text.Trim()
                + "%' or customer like '%" + txtYSK.Text.Trim() + "%')", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvYSK.DataSource = dt;
            conn.Close();
        }

        //刷新
        private void refreshYSK()
        {
            SqlConnection conn = connectFruitPSI();
            SqlDataAdapter sda = new SqlDataAdapter("select customer,billdate,billid,arrear from SaleProductAll where arrear>0", conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvYSK.DataSource = dt;
            conn.Close();
        }

        // 收清
        private void dgvYSK_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            //选中收清
            if (e.RowIndex > -1 && dgvYSK.Rows[e.RowIndex].Cells[0].Selected)
            {
                string djId = dgvYSK.Rows[e.RowIndex].Cells[3].Value.ToString();
                DialogResult dr = MessageBox.Show("确认已收清？", "提示", MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning, MessageBoxDefaultButton.Button1);
                if (dr == DialogResult.Yes)
                {
                    var xhAll = db.SaleProductAlls.Find(djId);
                    double xsk = Convert.ToDouble(xhAll.salemoney);
                    xhAll.receipt = xsk;
                    xhAll.arrear = 0;

                    try
                    {
                        int i = db.SaveChanges();
                        if (i == 1)
                        {
                            refreshYSK();
                            refreshXHLS();
                            refreshXS();
                            // MessageBox.Show("已付清");
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("已付清出错");
                    }
                }
            }
        }

        #endregion

        #region  采购报表

        //查询按钮事件
        private void btnSearchCG_Click(object sender, EventArgs e)
        {
            if (txtCG.Text.Trim().Equals("") || txtCG.Text.Equals("供应商编号/名称/单据日期"))
            {
                refreshCG();
            }
            else
            {
                searchCG();
            }
        }
        //查询
        private void searchCG()
        {
            SqlConnection conn = connectFruitPSI();
            string strSql = "SELECT   supplier, billdate, billid, totalmoney, dctmoney, purmoney," +
            "account, payment, arrear, billmaker, other from PurProductAll where billid like '%" + txtCG.Text.Trim()
                + "%' or supplier like '%" + txtCG.Text.Trim() + "%'";
            SqlDataAdapter sda = new SqlDataAdapter(strSql, conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvCG.DataSource = dt;
            conn.Close();
        }
        //刷新
        private void refreshCG()
        {
            SqlConnection conn = connectFruitPSI();
            string strSql = "SELECT   supplier, billdate, billid, totalmoney, dctmoney, purmoney,"+ 
            "account, payment, arrear, billmaker, other from PurProductAll";
            SqlDataAdapter sda = new SqlDataAdapter(strSql, conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvCG.DataSource = dt;
            conn.Close();
        }
        //详情
        private void dgvCG_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            //点击详情 转到购货历史界面
            if (e.RowIndex > -1 && dgvCG.Rows[e.RowIndex].Cells[0].Selected)
            {
                string djId = dgvCG.Rows[e.RowIndex].Cells[3].Value.ToString();
                txtGHLS.Text = djId;
                searchGHLS();
                tabPage2.Parent = tabControl1;//显示
                tabControl1.SelectedTab = tabPage2;
            }
        }
        #endregion
        
        #region  销售报表

        //查询按钮事件
        private void btnSearchXS_Click(object sender, EventArgs e)
        {
            if (txtXS.Text.Trim().Equals("") || txtXS.Text.Equals("客户编号/名称/单据日期"))
            {
                refreshXS();
            }
            else
            {
                searchXS();
            }
        }
        //查询
        private void searchXS()
        {
            SqlConnection conn = connectFruitPSI();
            string strSql = "SELECT   customer, billdate, totalmoney, billid, dctmoney, salemoney, " +
            "account, receipt, arrear, billmaker, other from SaleProductAll where billid like '%" + txtXS.Text.Trim()
                + "%' or customer like '%" + txtXS.Text.Trim() + "%'";
            SqlDataAdapter sda = new SqlDataAdapter(strSql, conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvXS.DataSource = dt;
            conn.Close();
        }
        //刷新
        private void refreshXS()
        {
            SqlConnection conn = connectFruitPSI();
            string strSql = "SELECT   customer, billdate, totalmoney, billid, dctmoney, salemoney," +
            "account, receipt, arrear, billmaker, other from SaleProductAll";
            SqlDataAdapter sda = new SqlDataAdapter(strSql, conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dgvXS.DataSource = dt;
            conn.Close();
        }
        //详情
        private void dgvXS_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            //点击详情 转到销货历史界面
            if (e.RowIndex > -1 && dgvXS.Rows[e.RowIndex].Cells[0].Selected)
            {
                string djId = dgvXS.Rows[e.RowIndex].Cells[3].Value.ToString();
                txtXHLS.Text = djId;
                searchXHLS();
                tabPage4.Parent = tabControl1;//显示
                tabControl1.SelectedTab = tabPage4;
            }
        }

        #endregion

        #region 利润报表
        //设置利润只能输入数字
        private void txtLR_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != 8 && !Char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
            }
        }
        //搜索
        private void btnSearchLR_Click(object sender, EventArgs e)
        {
            if (txtLR.Text == "")
            {
                labLRCheck.Visible = true;
                timerLR.Enabled = true;
                return;
            }
            searchLRCG();
            searchLRXS();
          
            if (labXSSR.Text == "" && labCGZC.Text != "")
            {
                labXSSR.Text = "0.00";
                labLRQK.Text = (double.Parse(labXSSR.Text) - double.Parse(labCGZC.Text)).ToString("#0.00");
            }
            if (labXSSR.Text != "" && labCGZC.Text == "")
            {
                labCGZC.Text = "0.00";
                labLRQK.Text = (double.Parse(labXSSR.Text) - double.Parse(labCGZC.Text)).ToString("#0.00");
            }
            if (labXSSR.Text != "" && labCGZC.Text != "")
            {
                labLRQK.Text = (double.Parse(labXSSR.Text) - double.Parse(labCGZC.Text)).ToString("#0.00");
            }

            if (labXSSR.Text == "" && labCGZC.Text == "")
            {
                labLRQK.Text = "";
            }
        }
       
        //搜索销售收入金额
        private void searchLRXS()
        {
            SqlConnection conn = connectFruitPSI();
            string strSql = "SELECT sum(salemoney) from SaleProductAll where billid like '%" + txtLR.Text.Trim() + "%'";

            SqlDataAdapter sda = new SqlDataAdapter(strSql, conn);
            DataSet ds = new DataSet();
            int temp = sda.Fill(ds);

            if (temp == 0)//有点问题 temp问题 labXSSR.Text 不显示********************************
            {
                labXSSR.Text = "0.00";
            }
            else
            {
                labXSSR.Text = ds.Tables[0].Rows[0][0].ToString();
            }
            conn.Close();
        }
        
        //搜索采购支出金额
        private void searchLRCG()
        {
            SqlConnection conn = connectFruitPSI();
            string strSql = "SELECT sum(purmoney) from PurProductAll where billid like '%" + txtLR.Text.Trim() + "%'";
            SqlDataAdapter sda = new SqlDataAdapter(strSql, conn);
            DataSet ds = new DataSet();
            int temp = sda.Fill(ds);

            if (temp == 0)//有点问题 temp问题 labCGZC.Text 不显示********************************
            {
                labCGZC.Text = "0.00";
            }
            else
            {
                labCGZC.Text = ds.Tables[0].Rows[0][0].ToString();
            }
            conn.Close();
        }

        //计时清空labSPCheck提示
        private void timerLR_Tick(object sender, EventArgs e)
        {
            timerLR.Enabled = false;
            labLRCheck.Visible = false;
        }
        
        //点击清空输入框
        private void txtLR_Click(object sender, EventArgs e)
        {
            txtLR.Text = "";
        }

        #endregion

        #region 权限管理

        //购货员权限设置
        private void clbGHY_SelectedIndexChanged(object sender, EventArgs e)
        {
            var ghyRight = db.ghyrights.Find("ghy");
            int i = clbGHY.SelectedIndex;

            #region 设置具有权限

            if (clbGHY.GetItemChecked(i) == true)
            {
                if (i == 0)
                {
                    ghyRight.ghd = true;
                    db.SaveChanges();
                }
                if (i == 1)
                {
                    ghyRight.xhd = true;
                    db.SaveChanges();
                }
                if (i == 2)
                {
                    ghyRight.yfk = true;
                    db.SaveChanges();
                }
                if (i == 3)
                {
                    ghyRight.ysk = true;
                    db.SaveChanges();
                }
                if (i == 4)
                {
                    ghyRight.cgbb = true;
                    db.SaveChanges();
                }
                if (i == 5)
                {
                    ghyRight.xsbb = true;
                    db.SaveChanges();
                }
                if (i == 6)
                {
                    ghyRight.lrbb = true;
                    db.SaveChanges();
                }
                if (i == 7)
                {
                    ghyRight.khgl = true;
                    db.SaveChanges();
                }
                if (i == 8)
                {
                    ghyRight.gysgl = true;
                    db.SaveChanges();
                }
                if (i == 9)
                {
                    ghyRight.spgl = true;
                    db.SaveChanges();
                }
                if (i == 10)
                {
                    ghyRight.zygl = true;
                    db.SaveChanges();
                }
                if (i == 11)
                {
                    ghyRight.zhgl = true;
                    db.SaveChanges();
                }
                if (i == 12)
                {
                    ghyRight.qxgl = true;
                    db.SaveChanges();
                }
            }

            #endregion

            #region 设置没有权限

            if (clbGHY.GetItemChecked(i) == false)
            {
                if (i == 0)
                {
                    ghyRight.ghd = false;
                    db.SaveChanges();
                }
                if (i == 1)
                {
                    ghyRight.xhd = false;
                    db.SaveChanges();
                }
                if (i == 2)
                {
                    ghyRight.yfk = false;
                    db.SaveChanges();
                }
                if (i == 3)
                {
                    ghyRight.ysk = false;
                    db.SaveChanges();
                }
                if (i == 4)
                {
                    ghyRight.cgbb = false;
                    db.SaveChanges();
                }
                if (i == 5)
                {
                    ghyRight.xsbb = false;
                    db.SaveChanges();
                }
                if (i == 6)
                {
                    ghyRight.lrbb = false;
                    db.SaveChanges();
                }
                if (i == 7)
                {
                    ghyRight.khgl = false;
                    db.SaveChanges();
                }
                if (i == 8)
                {
                    ghyRight.gysgl = false;
                    db.SaveChanges();
                }
                if (i == 9)
                {
                    ghyRight.spgl = false;
                    db.SaveChanges();
                }
                if (i == 10)
                {
                    ghyRight.zygl = false;
                    db.SaveChanges();
                }
                if (i == 11)
                {
                    ghyRight.zhgl = false;
                    db.SaveChanges();
                }
                if (i == 12)
                {
                    ghyRight.qxgl = false;
                    db.SaveChanges();
                }
            }

            #endregion
        }

        //销售员权限设置
        private void clbXSY_SelectedIndexChanged(object sender, EventArgs e)
        {
            var xsyRight = db.xsyrights.Find("xsy");
            int i = clbXSY.SelectedIndex;

            #region 设置具有权限

            if (clbXSY.GetItemChecked(i) == true)
            {
                if (i == 0)
                {
                    xsyRight.ghd = true;
                    db.SaveChanges();
                }
                if (i == 1)
                {
                    xsyRight.xhd = true;
                    db.SaveChanges();
                }
                if (i == 2)
                {
                    xsyRight.yfk = true;
                    db.SaveChanges();
                }
                if (i == 3)
                {
                    xsyRight.ysk = true;
                    db.SaveChanges();
                }
                if (i == 4)
                {
                    xsyRight.cgbb = true;
                    db.SaveChanges();
                }
                if (i == 5)
                {
                    xsyRight.xsbb = true;
                    db.SaveChanges();
                }
                if (i == 6)
                {
                    xsyRight.lrbb = true;
                    db.SaveChanges();
                }
                if (i == 7)
                {
                    xsyRight.khgl = true;
                    db.SaveChanges();
                }
                if (i == 8)
                {
                    xsyRight.gysgl = true;
                    db.SaveChanges();
                }
                if (i == 9)
                {
                    xsyRight.spgl = true;
                    db.SaveChanges();
                }
                if (i == 10)
                {
                    xsyRight.zygl = true;
                    db.SaveChanges();
                }
                if (i == 11)
                {
                    xsyRight.zhgl = true;
                    db.SaveChanges();
                }
                if (i == 12)
                {
                    xsyRight.qxgl = true;
                    db.SaveChanges();
                }
            }

            #endregion

            #region 设置没有权限

            if (clbXSY.GetItemChecked(i) == false)
            {
                if (i == 0)
                {
                    xsyRight.ghd = false;
                    db.SaveChanges();
                }
                if (i == 1)
                {
                    xsyRight.xhd = false;
                    db.SaveChanges();
                }
                if (i == 2)
                {
                    xsyRight.yfk = false;
                    db.SaveChanges();
                }
                if (i == 3)
                {
                    xsyRight.ysk = false;
                    db.SaveChanges();
                }
                if (i == 4)
                {
                    xsyRight.cgbb = false;
                    db.SaveChanges();
                }
                if (i == 5)
                {
                    xsyRight.xsbb = false;
                    db.SaveChanges();
                }
                if (i == 6)
                {
                    xsyRight.lrbb = false;
                    db.SaveChanges();
                }
                if (i == 7)
                {
                    xsyRight.khgl = false;
                    db.SaveChanges();
                }
                if (i == 8)
                {
                    xsyRight.gysgl = false;
                    db.SaveChanges();
                }
                if (i == 9)
                {
                    xsyRight.spgl = false;
                    db.SaveChanges();
                }
                if (i == 10)
                {
                    xsyRight.zygl = false;
                    db.SaveChanges();
                }
                if (i == 11)
                {
                    xsyRight.zhgl = false;
                    db.SaveChanges();
                }
                if (i == 12)
                {
                    xsyRight.qxgl = false;
                    db.SaveChanges();
                }
            }

            #endregion
        }

        #endregion
    }
}
