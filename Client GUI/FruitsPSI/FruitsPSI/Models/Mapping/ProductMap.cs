using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace FruitsPSI.Models.Mapping
{
    public class ProductMap : EntityTypeConfiguration<Product>
    {
        public ProductMap()
        {
            // Primary Key
            this.HasKey(t => t.prodid);

            // Properties
            this.Property(t => t.prodid)
                .IsRequired()
                .HasMaxLength(20);

            this.Property(t => t.prodname)
                .HasMaxLength(20);

            this.Property(t => t.produom)
                .HasMaxLength(10);

            // Table & Column Mappings
            this.ToTable("Product");
            this.Property(t => t.prodid).HasColumnName("prodid");
            this.Property(t => t.prodname).HasColumnName("prodname");
            this.Property(t => t.produom).HasColumnName("produom");
            this.Property(t => t.initqty).HasColumnName("initqty");
            this.Property(t => t.initcost).HasColumnName("initcost");
            this.Property(t => t.count).HasColumnName("count");
        }
    }
}
