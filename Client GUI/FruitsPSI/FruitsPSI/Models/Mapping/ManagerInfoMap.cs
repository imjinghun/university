using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace FruitsPSI.Models.Mapping
{
    public class ManagerInfoMap : EntityTypeConfiguration<ManagerInfo>
    {
        public ManagerInfoMap()
        {
            // Primary Key
            this.HasKey(t => t.mgrid);

            // Properties
            this.Property(t => t.mgrid)
                .IsRequired()
                .HasMaxLength(20);

            this.Property(t => t.mgrname)
                .HasMaxLength(20);

            this.Property(t => t.password)
                .HasMaxLength(20);

            // Table & Column Mappings
            this.ToTable("ManagerInfo");
            this.Property(t => t.mgrid).HasColumnName("mgrid");
            this.Property(t => t.mgrname).HasColumnName("mgrname");
            this.Property(t => t.password).HasColumnName("password");
        }
    }
}
