namespace FruitsPSI
{
    partial class FrmSPSelect
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmSPSelect));
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            this.panel11 = new System.Windows.Forms.Panel();
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnCancelSP = new System.Windows.Forms.Button();
            this.labSPCheck = new System.Windows.Forms.Label();
            this.txtSPInitCost = new System.Windows.Forms.TextBox();
            this.btnSaveSP = new System.Windows.Forms.Button();
            this.label52 = new System.Windows.Forms.Label();
            this.txtSPInitQty = new System.Windows.Forms.TextBox();
            this.label53 = new System.Windows.Forms.Label();
            this.label56 = new System.Windows.Forms.Label();
            this.txtSPID = new System.Windows.Forms.TextBox();
            this.txtSPUom = new System.Windows.Forms.TextBox();
            this.label54 = new System.Windows.Forms.Label();
            this.label55 = new System.Windows.Forms.Label();
            this.txtSPName = new System.Windows.Forms.TextBox();
            this.panel13 = new System.Windows.Forms.Panel();
            this.chbSelRev = new System.Windows.Forms.CheckBox();
            this.chbSelAll = new System.Windows.Forms.CheckBox();
            this.btnSPSelAdd = new System.Windows.Forms.Button();
            this.btnSPSelSec = new System.Windows.Forms.Button();
            this.txtSPSelSec = new System.Windows.Forms.TextBox();
            this.btnSPSelSure = new System.Windows.Forms.Button();
            this.dgvSPSelect = new System.Windows.Forms.DataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.prodidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.prodnameDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.produomDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.countDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.productBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.fruitPSIDataSet = new FruitsPSI.FruitPSIDataSet();
            this.timerSP = new System.Windows.Forms.Timer(this.components);
            this.productTableAdapter = new FruitsPSI.FruitPSIDataSetTableAdapters.ProductTableAdapter();
            this.toolTip1 = new System.Windows.Forms.ToolTip(this.components);
            this.panel11.SuspendLayout();
            this.panel1.SuspendLayout();
            this.panel13.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvSPSelect)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.productBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.fruitPSIDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // panel11
            // 
            this.panel11.Controls.Add(this.panel1);
            this.panel11.Controls.Add(this.panel13);
            this.panel11.Controls.Add(this.dgvSPSelect);
            this.panel11.Location = new System.Drawing.Point(2, 3);
            this.panel11.Name = "panel11";
            this.panel11.Size = new System.Drawing.Size(580, 402);
            this.panel11.TabIndex = 21;
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.YellowGreen;
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Controls.Add(this.btnCancelSP);
            this.panel1.Controls.Add(this.labSPCheck);
            this.panel1.Controls.Add(this.txtSPInitCost);
            this.panel1.Controls.Add(this.btnSaveSP);
            this.panel1.Controls.Add(this.label52);
            this.panel1.Controls.Add(this.txtSPInitQty);
            this.panel1.Controls.Add(this.label53);
            this.panel1.Controls.Add(this.label56);
            this.panel1.Controls.Add(this.txtSPID);
            this.panel1.Controls.Add(this.txtSPUom);
            this.panel1.Controls.Add(this.label54);
            this.panel1.Controls.Add(this.label55);
            this.panel1.Controls.Add(this.txtSPName);
            this.panel1.Font = new System.Drawing.Font("宋体", 12F);
            this.panel1.Location = new System.Drawing.Point(0, 48);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(580, 128);
            this.panel1.TabIndex = 25;
            this.panel1.Visible = false;
            // 
            // btnCancelSP
            // 
            this.btnCancelSP.BackColor = System.Drawing.Color.Silver;
            this.btnCancelSP.FlatAppearance.BorderSize = 0;
            this.btnCancelSP.FlatAppearance.MouseDownBackColor = System.Drawing.Color.DarkGray;
            this.btnCancelSP.FlatAppearance.MouseOverBackColor = System.Drawing.Color.LightGray;
            this.btnCancelSP.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnCancelSP.Location = new System.Drawing.Point(513, 74);
            this.btnCancelSP.Name = "btnCancelSP";
            this.btnCancelSP.Size = new System.Drawing.Size(55, 33);
            this.btnCancelSP.TabIndex = 14;
            this.btnCancelSP.Text = "取消";
            this.btnCancelSP.UseVisualStyleBackColor = false;
            this.btnCancelSP.Click += new System.EventHandler(this.btnCancelSP_Click);
            // 
            // labSPCheck
            // 
            this.labSPCheck.ForeColor = System.Drawing.Color.Red;
            this.labSPCheck.Location = new System.Drawing.Point(253, 91);
            this.labSPCheck.Name = "labSPCheck";
            this.labSPCheck.Size = new System.Drawing.Size(234, 26);
            this.labSPCheck.TabIndex = 13;
            this.labSPCheck.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // txtSPInitCost
            // 
            this.txtSPInitCost.Location = new System.Drawing.Point(328, 54);
            this.txtSPInitCost.MaxLength = 20;
            this.txtSPInitCost.Name = "txtSPInitCost";
            this.txtSPInitCost.Size = new System.Drawing.Size(159, 26);
            this.txtSPInitCost.TabIndex = 12;
            // 
            // btnSaveSP
            // 
            this.btnSaveSP.BackColor = System.Drawing.Color.Gold;
            this.btnSaveSP.FlatAppearance.BorderSize = 0;
            this.btnSaveSP.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSaveSP.Location = new System.Drawing.Point(513, 17);
            this.btnSaveSP.Name = "btnSaveSP";
            this.btnSaveSP.Size = new System.Drawing.Size(55, 33);
            this.btnSaveSP.TabIndex = 11;
            this.btnSaveSP.Text = "保存";
            this.btnSaveSP.UseVisualStyleBackColor = false;
            this.btnSaveSP.Click += new System.EventHandler(this.btnSaveSP_Click);
            // 
            // label52
            // 
            this.label52.AutoSize = true;
            this.label52.Location = new System.Drawing.Point(250, 57);
            this.label52.Name = "label52";
            this.label52.Size = new System.Drawing.Size(72, 16);
            this.label52.TabIndex = 10;
            this.label52.Text = "期初成本";
            this.label52.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // txtSPInitQty
            // 
            this.txtSPInitQty.Location = new System.Drawing.Point(328, 17);
            this.txtSPInitQty.MaxLength = 20;
            this.txtSPInitQty.Name = "txtSPInitQty";
            this.txtSPInitQty.Size = new System.Drawing.Size(159, 26);
            this.txtSPInitQty.TabIndex = 9;
            // 
            // label53
            // 
            this.label53.AutoSize = true;
            this.label53.Location = new System.Drawing.Point(250, 20);
            this.label53.Name = "label53";
            this.label53.Size = new System.Drawing.Size(72, 16);
            this.label53.TabIndex = 8;
            this.label53.Text = "期初数量";
            this.label53.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // label56
            // 
            this.label56.AutoSize = true;
            this.label56.Location = new System.Drawing.Point(19, 20);
            this.label56.Name = "label56";
            this.label56.Size = new System.Drawing.Size(40, 16);
            this.label56.TabIndex = 0;
            this.label56.Text = "编号";
            this.label56.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // txtSPID
            // 
            this.txtSPID.Location = new System.Drawing.Point(65, 17);
            this.txtSPID.MaxLength = 20;
            this.txtSPID.Name = "txtSPID";
            this.txtSPID.Size = new System.Drawing.Size(159, 26);
            this.txtSPID.TabIndex = 2;
            // 
            // txtSPUom
            // 
            this.txtSPUom.Location = new System.Drawing.Point(65, 88);
            this.txtSPUom.MaxLength = 10;
            this.txtSPUom.Name = "txtSPUom";
            this.txtSPUom.Size = new System.Drawing.Size(159, 26);
            this.txtSPUom.TabIndex = 7;
            // 
            // label54
            // 
            this.label54.AutoSize = true;
            this.label54.Location = new System.Drawing.Point(19, 91);
            this.label54.Name = "label54";
            this.label54.Size = new System.Drawing.Size(40, 16);
            this.label54.TabIndex = 4;
            this.label54.Text = "单位";
            this.label54.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // label55
            // 
            this.label55.AutoSize = true;
            this.label55.Location = new System.Drawing.Point(19, 57);
            this.label55.Name = "label55";
            this.label55.Size = new System.Drawing.Size(40, 16);
            this.label55.TabIndex = 1;
            this.label55.Text = "名称";
            this.label55.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // txtSPName
            // 
            this.txtSPName.Location = new System.Drawing.Point(65, 54);
            this.txtSPName.MaxLength = 20;
            this.txtSPName.Name = "txtSPName";
            this.txtSPName.Size = new System.Drawing.Size(159, 26);
            this.txtSPName.TabIndex = 3;
            // 
            // panel13
            // 
            this.panel13.BackColor = System.Drawing.Color.White;
            this.panel13.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel13.Controls.Add(this.chbSelRev);
            this.panel13.Controls.Add(this.chbSelAll);
            this.panel13.Controls.Add(this.btnSPSelAdd);
            this.panel13.Controls.Add(this.btnSPSelSec);
            this.panel13.Controls.Add(this.txtSPSelSec);
            this.panel13.Controls.Add(this.btnSPSelSure);
            this.panel13.Location = new System.Drawing.Point(0, 4);
            this.panel13.Name = "panel13";
            this.panel13.Size = new System.Drawing.Size(580, 41);
            this.panel13.TabIndex = 21;
            // 
            // chbSelRev
            // 
            this.chbSelRev.AutoSize = true;
            this.chbSelRev.Font = new System.Drawing.Font("宋体", 12F);
            this.chbSelRev.Location = new System.Drawing.Point(360, 11);
            this.chbSelRev.Name = "chbSelRev";
            this.chbSelRev.Size = new System.Drawing.Size(59, 20);
            this.chbSelRev.TabIndex = 28;
            this.chbSelRev.Text = "反选";
            this.chbSelRev.UseVisualStyleBackColor = true;
            this.chbSelRev.Click += new System.EventHandler(this.chbSelRev_Click);
            // 
            // chbSelAll
            // 
            this.chbSelAll.AutoSize = true;
            this.chbSelAll.Font = new System.Drawing.Font("宋体", 12F);
            this.chbSelAll.Location = new System.Drawing.Point(277, 11);
            this.chbSelAll.Name = "chbSelAll";
            this.chbSelAll.Size = new System.Drawing.Size(59, 20);
            this.chbSelAll.TabIndex = 27;
            this.chbSelAll.Text = "全选";
            this.chbSelAll.UseVisualStyleBackColor = true;
            this.chbSelAll.Click += new System.EventHandler(this.chbSelAll_Click);
            // 
            // btnSPSelAdd
            // 
            this.btnSPSelAdd.BackColor = System.Drawing.Color.LightGreen;
            this.btnSPSelAdd.Font = new System.Drawing.Font("宋体", 12F);
            this.btnSPSelAdd.ForeColor = System.Drawing.SystemColors.ControlText;
            this.btnSPSelAdd.Location = new System.Drawing.Point(211, 6);
            this.btnSPSelAdd.Name = "btnSPSelAdd";
            this.btnSPSelAdd.Size = new System.Drawing.Size(28, 28);
            this.btnSPSelAdd.TabIndex = 24;
            this.btnSPSelAdd.Text = "+";
            this.toolTip1.SetToolTip(this.btnSPSelAdd, "增加新商品");
            this.btnSPSelAdd.UseVisualStyleBackColor = false;
            this.btnSPSelAdd.Click += new System.EventHandler(this.btnSPSelAdd_Click);
            // 
            // btnSPSelSec
            // 
            this.btnSPSelSec.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("btnSPSelSec.BackgroundImage")));
            this.btnSPSelSec.FlatAppearance.BorderSize = 0;
            this.btnSPSelSec.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Blue;
            this.btnSPSelSec.FlatAppearance.MouseOverBackColor = System.Drawing.Color.SteelBlue;
            this.btnSPSelSec.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSPSelSec.Font = new System.Drawing.Font("宋体", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btnSPSelSec.Location = new System.Drawing.Point(168, 7);
            this.btnSPSelSec.Name = "btnSPSelSec";
            this.btnSPSelSec.Size = new System.Drawing.Size(26, 26);
            this.btnSPSelSec.TabIndex = 21;
            this.btnSPSelSec.UseVisualStyleBackColor = true;
            this.btnSPSelSec.Click += new System.EventHandler(this.btnSPSelSec_Click);
            // 
            // txtSPSelSec
            // 
            this.txtSPSelSec.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.txtSPSelSec.ForeColor = System.Drawing.Color.DarkGray;
            this.txtSPSelSec.Location = new System.Drawing.Point(3, 7);
            this.txtSPSelSec.MaxLength = 20;
            this.txtSPSelSec.Name = "txtSPSelSec";
            this.txtSPSelSec.Size = new System.Drawing.Size(159, 26);
            this.txtSPSelSec.TabIndex = 20;
            this.txtSPSelSec.Text = "商品编号/名称";
            this.txtSPSelSec.Click += new System.EventHandler(this.txtSPSelSec_Click);
            this.txtSPSelSec.Leave += new System.EventHandler(this.txtSPSelSec_Leave);
            // 
            // btnSPSelSure
            // 
            this.btnSPSelSure.BackColor = System.Drawing.Color.Green;
            this.btnSPSelSure.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Lime;
            this.btnSPSelSure.Font = new System.Drawing.Font("宋体", 12F);
            this.btnSPSelSure.ForeColor = System.Drawing.SystemColors.Control;
            this.btnSPSelSure.Location = new System.Drawing.Point(477, 3);
            this.btnSPSelSure.Name = "btnSPSelSure";
            this.btnSPSelSure.Size = new System.Drawing.Size(66, 34);
            this.btnSPSelSure.TabIndex = 19;
            this.btnSPSelSure.Text = "确定";
            this.btnSPSelSure.UseVisualStyleBackColor = false;
            this.btnSPSelSure.Click += new System.EventHandler(this.btnSPSelSure_Click);
            // 
            // dgvSPSelect
            // 
            this.dgvSPSelect.AllowUserToAddRows = false;
            this.dgvSPSelect.AutoGenerateColumns = false;
            this.dgvSPSelect.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvSPSelect.BackgroundColor = System.Drawing.Color.White;
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle1.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle1.Font = new System.Drawing.Font("宋体", 12F);
            dataGridViewCellStyle1.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.Color.MediumAquamarine;
            dataGridViewCellStyle1.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dgvSPSelect.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle1;
            this.dgvSPSelect.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvSPSelect.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.prodidDataGridViewTextBoxColumn,
            this.prodnameDataGridViewTextBoxColumn,
            this.produomDataGridViewTextBoxColumn,
            this.countDataGridViewTextBoxColumn});
            this.dgvSPSelect.DataSource = this.productBindingSource;
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = System.Drawing.SystemColors.Window;
            dataGridViewCellStyle2.Font = new System.Drawing.Font("宋体", 12F);
            dataGridViewCellStyle2.ForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.Color.LightCyan;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.Desktop;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.dgvSPSelect.DefaultCellStyle = dataGridViewCellStyle2;
            this.dgvSPSelect.Location = new System.Drawing.Point(0, 48);
            this.dgvSPSelect.Name = "dgvSPSelect";
            this.dgvSPSelect.RowHeadersVisible = false;
            this.dgvSPSelect.RowTemplate.Height = 23;
            this.dgvSPSelect.Size = new System.Drawing.Size(580, 354);
            this.dgvSPSelect.TabIndex = 22;
            this.dgvSPSelect.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvSPSelect_CellContentClick);
            // 
            // Column1
            // 
            this.Column1.FillWeight = 25.38071F;
            this.Column1.HeaderText = "选择";
            this.Column1.Name = "Column1";
            // 
            // prodidDataGridViewTextBoxColumn
            // 
            this.prodidDataGridViewTextBoxColumn.DataPropertyName = "prodid";
            this.prodidDataGridViewTextBoxColumn.FillWeight = 118.6548F;
            this.prodidDataGridViewTextBoxColumn.HeaderText = "编号";
            this.prodidDataGridViewTextBoxColumn.Name = "prodidDataGridViewTextBoxColumn";
            this.prodidDataGridViewTextBoxColumn.ReadOnly = true;
            this.prodidDataGridViewTextBoxColumn.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            // 
            // prodnameDataGridViewTextBoxColumn
            // 
            this.prodnameDataGridViewTextBoxColumn.DataPropertyName = "prodname";
            this.prodnameDataGridViewTextBoxColumn.FillWeight = 118.6548F;
            this.prodnameDataGridViewTextBoxColumn.HeaderText = "名称";
            this.prodnameDataGridViewTextBoxColumn.Name = "prodnameDataGridViewTextBoxColumn";
            this.prodnameDataGridViewTextBoxColumn.ReadOnly = true;
            this.prodnameDataGridViewTextBoxColumn.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            // 
            // produomDataGridViewTextBoxColumn
            // 
            this.produomDataGridViewTextBoxColumn.DataPropertyName = "produom";
            this.produomDataGridViewTextBoxColumn.FillWeight = 118.6548F;
            this.produomDataGridViewTextBoxColumn.HeaderText = "单位";
            this.produomDataGridViewTextBoxColumn.Name = "produomDataGridViewTextBoxColumn";
            this.produomDataGridViewTextBoxColumn.ReadOnly = true;
            this.produomDataGridViewTextBoxColumn.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            // 
            // countDataGridViewTextBoxColumn
            // 
            this.countDataGridViewTextBoxColumn.DataPropertyName = "count";
            this.countDataGridViewTextBoxColumn.FillWeight = 118.6548F;
            this.countDataGridViewTextBoxColumn.HeaderText = "当前数量";
            this.countDataGridViewTextBoxColumn.Name = "countDataGridViewTextBoxColumn";
            this.countDataGridViewTextBoxColumn.ReadOnly = true;
            this.countDataGridViewTextBoxColumn.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            // 
            // productBindingSource
            // 
            this.productBindingSource.DataMember = "Product";
            this.productBindingSource.DataSource = this.fruitPSIDataSet;
            // 
            // fruitPSIDataSet
            // 
            this.fruitPSIDataSet.DataSetName = "FruitPSIDataSet";
            this.fruitPSIDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // timerSP
            // 
            this.timerSP.Interval = 1000;
            this.timerSP.Tick += new System.EventHandler(this.timerSP_Tick);
            // 
            // productTableAdapter
            // 
            this.productTableAdapter.ClearBeforeFill = true;
            // 
            // toolTip1
            // 
            this.toolTip1.AutoPopDelay = 5000;
            this.toolTip1.InitialDelay = 200;
            this.toolTip1.ReshowDelay = 100;
            // 
            // FrmSPSelect
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(583, 405);
            this.Controls.Add(this.panel11);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "FrmSPSelect";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "商品选择";
            this.Load += new System.EventHandler(this.FrmSPSelect_Load);
            this.panel11.ResumeLayout(false);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel13.ResumeLayout(false);
            this.panel13.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvSPSelect)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.productBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.fruitPSIDataSet)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel11;
        private System.Windows.Forms.Panel panel13;
        private System.Windows.Forms.Button btnSPSelSure;
        private FruitPSIDataSet fruitPSIDataSet;
        private System.Windows.Forms.TextBox txtSPSelSec;
        private System.Windows.Forms.Button btnSPSelSec;
        private System.Windows.Forms.Button btnSPSelAdd;
        private System.Windows.Forms.TextBox txtSPUom;
        private System.Windows.Forms.Label label54;
        private System.Windows.Forms.TextBox txtSPName;
        private System.Windows.Forms.TextBox txtSPID;
        private System.Windows.Forms.Label label55;
        private System.Windows.Forms.Label label56;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label label53;
        private System.Windows.Forms.TextBox txtSPInitQty;
        private System.Windows.Forms.Label label52;
        private System.Windows.Forms.Button btnSaveSP;
        private System.Windows.Forms.TextBox txtSPInitCost;
        private System.Windows.Forms.Label labSPCheck;
        private System.Windows.Forms.Timer timerSP;
        private System.Windows.Forms.Button btnCancelSP;
        private System.Windows.Forms.CheckBox chbSelAll;
        private System.Windows.Forms.CheckBox chbSelRev;
        private System.Windows.Forms.DataGridView dgvSPSelect;
        private System.Windows.Forms.BindingSource productBindingSource;
        private FruitPSIDataSetTableAdapters.ProductTableAdapter productTableAdapter;
        private System.Windows.Forms.DataGridViewCheckBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn prodidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn prodnameDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn produomDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn countDataGridViewTextBoxColumn;
        private System.Windows.Forms.ToolTip toolTip1;
    }
}