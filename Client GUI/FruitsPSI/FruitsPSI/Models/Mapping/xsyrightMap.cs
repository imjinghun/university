using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace FruitsPSI.Models.Mapping
{
    public class xsyrightMap : EntityTypeConfiguration<xsyright>
    {
        public xsyrightMap()
        {
            // Primary Key
            this.HasKey(t => t.id);

            // Properties
            this.Property(t => t.id)
                .IsRequired()
                .HasMaxLength(5);

            // Table & Column Mappings
            this.ToTable("xsyright");
            this.Property(t => t.id).HasColumnName("id");
            this.Property(t => t.ghd).HasColumnName("ghd");
            this.Property(t => t.xhd).HasColumnName("xhd");
            this.Property(t => t.yfk).HasColumnName("yfk");
            this.Property(t => t.ysk).HasColumnName("ysk");
            this.Property(t => t.cgbb).HasColumnName("cgbb");
            this.Property(t => t.xsbb).HasColumnName("xsbb");
            this.Property(t => t.lrbb).HasColumnName("lrbb");
            this.Property(t => t.khgl).HasColumnName("khgl");
            this.Property(t => t.gysgl).HasColumnName("gysgl");
            this.Property(t => t.spgl).HasColumnName("spgl");
            this.Property(t => t.zygl).HasColumnName("zygl");
            this.Property(t => t.zhgl).HasColumnName("zhgl");
            this.Property(t => t.qxgl).HasColumnName("qxgl");
        }
    }
}
