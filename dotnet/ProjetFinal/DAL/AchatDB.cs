using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using ProjetFinal.Models;

namespace ProjetFinal.DAL
{
    public class AchatDB : DbContext
    {
        public DbSet<Client> Clients { get; set; }
        public DbSet<Produit> Produits { get; set; }
        public DbSet<Commande> Commandes { get; set; }
        public DbSet<Panier> Paniers { get; set; }
       
        public AchatDB() : base("name=AchatConnectionString")
        {
            Database.SetInitializer(new MigrateDatabaseToLatestVersion<AchatDB, Migrations.Configuration>("AchatConnectionString"));
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            //Configure domain classes using Fluent API here
            modelBuilder.Properties<DateTime>()
                        .Configure(c => c.HasColumnType("datetime2"));
            modelBuilder.Entity<Client>().Ignore(i => i.MotPasse2);  // Ignorer MotPasse2 dans la base de donnée
            modelBuilder.Entity<Client>().ToTable("tblClient");
            modelBuilder.Entity<Produit>().ToTable("tblProduit");
            modelBuilder.Entity<Commande>().ToTable("tblCommande");
            modelBuilder.Entity<Panier>().ToTable("tblPanier");
            modelBuilder.Entity<Panier>()
                .HasMany<Produit>(pa => pa.Produits)
                .WithMany(pr => pr.Paniers)
                .Map(pp =>
                {
                    pp.MapLeftKey("PanierRefId");
                    pp.MapRightKey("ProduitRefId");
                    pp.ToTable("tblPaneirProduit");
                });
            base.OnModelCreating(modelBuilder);
        }

        public bool Contains(string value)
        {           
            return (Clients.Where(c => c.Courriel == value).Count() > 0);            
        }

        public bool Exist(string courriel,string motPasse)
        {
            return (Clients.Where(c => c.Courriel == courriel && c.MotPasse == motPasse).Count() > 0);
        }
    
        public Client GetClient(string name)
        {
            return Clients.Single(c => c.Courriel == name);
        }

        
    }
}