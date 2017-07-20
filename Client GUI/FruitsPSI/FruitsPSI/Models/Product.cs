using System;
using System.Collections.Generic;

namespace FruitsPSI.Models
{
    public partial class Product
    {
        public Product()
        {
            this.PurProductEaches = new List<PurProductEach>();
            this.SaleProductEaches = new List<SaleProductEach>();
        }

        public string prodid { get; set; }
        public string prodname { get; set; }
        public string produom { get; set; }
        public Nullable<double> initqty { get; set; }
        public Nullable<double> initcost { get; set; }
        public Nullable<double> count { get; set; }
        public virtual ICollection<PurProductEach> PurProductEaches { get; set; }
        public virtual ICollection<SaleProductEach> SaleProductEaches { get; set; }
    }
}
