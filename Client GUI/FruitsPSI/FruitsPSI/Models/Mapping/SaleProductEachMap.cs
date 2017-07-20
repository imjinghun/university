using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace FruitsPSI.Models.Mapping
{
    public class SaleProductEachMap : EntityTypeConfiguration<SaleProductEach>
    {
        public SaleProductEachMap()
        {
            // Primary Key
            this.HasKey(t => new { t.billid, t.prodid });

            // Properties
            this.Property(t => t.billid)
                .IsRequired()
                .HasMaxLength(30);

            this.Property(t => t.prodid)
                .IsRequired()
                .HasMaxLength(20);

            this.Property(t => t.prodname)
                .HasMaxLength(20);

            this.Property(t => t.produnit)
                .HasMaxLength(20);

            // Table & Column Mappings
            this.ToTable("SaleProductEach");
            this.Property(t => t.billid).HasColumnName("billid");
            this.Property(t => t.prodid).HasColumnName("prodid");
            this.Property(t => t.prodname).HasColumnName("prodname");
            this.Property(t => t.produnit).HasColumnName("produnit");
            this.Property(t => t.saleqty).HasColumnName("saleqty");
            this.Property(t => t.unitprice).HasColumnName("unitprice");
            this.Property(t => t.money).HasColumnName("money");

            // Relationships
            this.HasRequired(t => t.Product)
                .WithMany(t => t.SaleProductEaches)
                .HasForeignKey(d => d.prodid);
            this.HasRequired(t => t.SaleProductAll)
                .WithMany(t => t.SaleProductEaches)
                .HasForeignKey(d => d.billid);

        }
    }
}
