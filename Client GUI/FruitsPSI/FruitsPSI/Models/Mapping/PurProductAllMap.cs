using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace FruitsPSI.Models.Mapping
{
    public class PurProductAllMap : EntityTypeConfiguration<PurProductAll>
    {
        public PurProductAllMap()
        {
            // Primary Key
            this.HasKey(t => t.billid);

            // Properties
            this.Property(t => t.supplier)
                .HasMaxLength(40);

            this.Property(t => t.billdate)
                .HasMaxLength(15);

            this.Property(t => t.billid)
                .IsRequired()
                .HasMaxLength(30);

            this.Property(t => t.account)
                .HasMaxLength(40);

            this.Property(t => t.billmaker)
                .HasMaxLength(20);

            // Table & Column Mappings
            this.ToTable("PurProductAll");
            this.Property(t => t.supplier).HasColumnName("supplier");
            this.Property(t => t.billdate).HasColumnName("billdate");
            this.Property(t => t.billid).HasColumnName("billid");
            this.Property(t => t.totalmoney).HasColumnName("totalmoney");
            this.Property(t => t.dctmoney).HasColumnName("dctmoney");
            this.Property(t => t.purmoney).HasColumnName("purmoney");
            this.Property(t => t.account).HasColumnName("account");
            this.Property(t => t.payment).HasColumnName("payment");
            this.Property(t => t.arrear).HasColumnName("arrear");
            this.Property(t => t.billmaker).HasColumnName("billmaker");
            this.Property(t => t.recordtime).HasColumnName("recordtime");
            this.Property(t => t.revisetime).HasColumnName("revisetime");
            this.Property(t => t.other).HasColumnName("other");
        }
    }
}