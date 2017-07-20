using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace FruitsPSI.Models.Mapping
{
    public class AccountMap : EntityTypeConfiguration<Account>
    {
        public AccountMap()
        {
            // Primary Key
            this.HasKey(t => t.accid);

            // Properties
            this.Property(t => t.accid)
                .IsRequired()
                .HasMaxLength(20);

            this.Property(t => t.accname)
                .HasMaxLength(20);

            // Table & Column Mappings
            this.ToTable("Account");
            this.Property(t => t.accid).HasColumnName("accid");
            this.Property(t => t.accname).HasColumnName("accname");
            this.Property(t => t.initbalance).HasColumnName("initbalance");
            this.Property(t => t.curbalance).HasColumnName("curbalance");
        }
    }
}
