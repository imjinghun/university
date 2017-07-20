using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace FruitsPSI.Models.Mapping
{
    public class CustomerMap : EntityTypeConfiguration<Customer>
    {
        public CustomerMap()
        {
            // Primary Key
            this.HasKey(t => t.custid);

            // Properties
            this.Property(t => t.custid)
                .IsRequired()
                .HasMaxLength(20);

            this.Property(t => t.custname)
                .HasMaxLength(20);

            this.Property(t => t.contacts)
                .HasMaxLength(20);

            this.Property(t => t.contacttel)
                .HasMaxLength(20);

            this.Property(t => t.contactaddr)
                .HasMaxLength(30);

            // Table & Column Mappings
            this.ToTable("Customer");
            this.Property(t => t.custid).HasColumnName("custid");
            this.Property(t => t.custname).HasColumnName("custname");
            this.Property(t => t.contacts).HasColumnName("contacts");
            this.Property(t => t.contacttel).HasColumnName("contacttel");
            this.Property(t => t.contactaddr).HasColumnName("contactaddr");
        }
    }
}
