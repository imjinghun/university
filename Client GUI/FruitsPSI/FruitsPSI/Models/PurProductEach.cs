using System;
using System.Collections.Generic;

namespace FruitsPSI.Models
{
    public partial class PurProductEach
    {
        public string billid { get; set; }
        public string prodid { get; set; }
        public string prodname { get; set; }
        public string produnit { get; set; }
        public Nullable<double> purqty { get; set; }
        public Nullable<double> unitprice { get; set; }
        public Nullable<double> money { get; set; }
        public virtual Product Product { get; set; }
        public virtual PurProductAll PurProductAll { get; set; }
    }
}
