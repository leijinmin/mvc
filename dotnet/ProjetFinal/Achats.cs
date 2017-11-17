using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using ProjetFinal.Models;

namespace ProjetFinal.DAL
{
    public class Achats : DbContext
    {
        public DbSet<Client> Clients { get; set; }
        public DbSet<Produit> Produits { get; set; }
        public DbSet<Commande> Commandes { get; set; }

        public DbSet<Panier> Paniers { get; set; }


    }
}