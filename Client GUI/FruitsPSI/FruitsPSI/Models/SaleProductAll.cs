using System;
using System.Collections.Generic;

namespace FruitsPSI.Models
{
    public partial class SaleProductAll
    {
        public SaleProductAll()
        {
            this.SaleProductEaches = new List<SaleProductEach>();
        }

        public string customer { get; set; }
        public string billdate { get; set; }
        public string billid { get; set; }
        public Nullable<double> totalmoney { get; set; }
        public Nullable<double> dctmoney { get; set; }
        public Nullable<double> salemoney { get; set; }
        public string account { get; set; }
        public Nullable<double> receipt { get; set; }
        public Nullable<double> arrear { get; set; }
        public string billmaker { get; set; }
        public Nullable<System.DateTime> recordtime { get; set; }
        public Nullable<System.DateTime> revisetime { get; set; }
        public string other { get; set; }
        public virtual ICollection<SaleProductEach> SaleProductEaches { get; set; }
    }
}
