using System;
using System.Collections.Generic;

namespace FruitsPSI.Models
{
    public partial class PurProductAll
    {
        public PurProductAll()
        {
            this.PurProductEaches = new List<PurProductEach>();
        }

        public string supplier { get; set; }
        public string billdate { get; set; }
        public string billid { get; set; }
        public Nullable<double> totalmoney { get; set; }
        public Nullable<double> dctmoney { get; set; }
        public Nullable<double> purmoney { get; set; }
        public string account { get; set; }
        public Nullable<double> payment { get; set; }
        public Nullable<double> arrear { get; set; }
        public string billmaker { get; set; }
        public Nullable<System.DateTime> recordtime { get; set; }
        public Nullable<System.DateTime> revisetime { get; set; }
        public string other { get; set; }
        public virtual ICollection<PurProductEach> PurProductEaches { get; set; }
    }
}
