using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using FruitsPSI.Models.Mapping;

namespace FruitsPSI.Models
{
    public partial class FruitPSIContext : DbContext
    {
        static FruitPSIContext()
        {
            Database.SetInitializer<FruitPSIContext>(null);
        }

        public FruitPSIContext()
            : base("Name=FruitPSIContext")
        {
        }

        public DbSet<Account> Accounts { get; set; }
        public DbSet<Customer> Customers { get; set; }
        public DbSet<ghyright> ghyrights { get; set; }
        public DbSet<ManagerInfo> ManagerInfoes { get; set; }
        public DbSet<Product> Products { get; set; }
        public DbSet<PurProductAll> PurProductAlls { get; set; }
        public DbSet<PurProductEach> PurProductEaches { get; set; }
        public DbSet<SaleProductAll> SaleProductAlls { get; set; }
        public DbSet<SaleProductEach> SaleProductEaches { get; set; }
        public DbSet<StaffInfo> StaffInfoes { get; set; }
        public DbSet<Supplier> Suppliers { get; set; }
        public DbSet<xsyright> xsyrights { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AccountMap());
            modelBuilder.Configurations.Add(new CustomerMap());
            modelBuilder.Configurations.Add(new ghyrightMap());
            modelBuilder.Configurations.Add(new ManagerInfoMap());
            modelBuilder.Configurations.Add(new ProductMap());
            modelBuilder.Configurations.Add(new PurProductAllMap());
            modelBuilder.Configurations.Add(new PurProductEachMap());
            modelBuilder.Configurations.Add(new SaleProductAllMap());
            modelBuilder.Configurations.Add(new SaleProductEachMap());
            modelBuilder.Configurations.Add(new StaffInfoMap());
            modelBuilder.Configurations.Add(new SupplierMap());
            modelBuilder.Configurations.Add(new xsyrightMap());
        }
    }
}
