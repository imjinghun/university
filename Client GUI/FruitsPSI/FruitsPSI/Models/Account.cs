using System;
using System.Collections.Generic;

namespace FruitsPSI.Models
{
    public partial class Account
    {
        public string accid { get; set; }
        public string accname { get; set; }
        public Nullable<double> initbalance { get; set; }
        public Nullable<double> curbalance { get; set; }
    }
}
