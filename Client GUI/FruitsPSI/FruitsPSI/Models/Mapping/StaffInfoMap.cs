using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace FruitsPSI.Models.Mapping
{
    public class StaffInfoMap : EntityTypeConfiguration<StaffInfo>
    {
        public StaffInfoMap()
        {
            // Primary Key
            this.HasKey(t => t.staffid);

            // Properties
            this.Property(t => t.staffid)
                .IsRequired()
                .HasMaxLength(20);

            this.Property(t => t.staffname)
                .HasMaxLength(20);

            this.Property(t => t.password)
                .HasMaxLength(20);

            this.Property(t => t.stafftype)
                .HasMaxLength(20);

            // Table & Column Mappings
            this.ToTable("StaffInfo");
            this.Property(t => t.staffid).HasColumnName("staffid");
            this.Property(t => t.staffname).HasColumnName("staffname");
            this.Property(t => t.password).HasColumnName("password");
            this.Property(t => t.stafftype).HasColumnName("stafftype");
        }
    }
}
