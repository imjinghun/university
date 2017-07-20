using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace FruitsPSI.Models.Mapping
{
    public class SupplierMap : EntityTypeConfiguration<Supplier>
    {
        public SupplierMap()
        {
            // Primary Key
            this.HasKey(t => t.splrid);

            // Properties
            this.Property(t => t.splrid)
                .IsRequired()
                .HasMaxLength(20);

            this.Property(t => t.splrname)
                .HasMaxLength(20);

            this.Property(t => t.contacts)
                .HasMaxLength(20);

            this.Property(t => t.contacttel)
                .HasMaxLength(20);

            this.Property(t => t.contactaddr)
                .HasMaxLength(30);

            // Table & Column Mappings
            this.ToTable("Supplier");
            this.Property(t => t.splrid).HasColumnName("splrid");
            this.Property(t => t.splrname).HasColumnName("splrname");
            this.Property(t => t.contacts).HasColumnName("contacts");
            this.Property(t => t.contacttel).HasColumnName("contacttel");
            this.Property(t => t.contactaddr).HasColumnName("contactaddr");
        }
    }
}
