namespace ProjetFinal.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using ProjetFinal.Models;

    internal sealed class Configuration : DbMigrationsConfiguration<ProjetFinal.DAL.AchatDB>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
            AutomaticMigrationDataLossAllowed = true; 

        }

        protected override void Seed(ProjetFinal.DAL.AchatDB context)
        {
            //  This method will be called after migrating to the latest version.

            if(context.Produits.Count() == 0)
            {            
                context.Produits.AddOrUpdate(
                    x => x.ProduitId,
                    new Produit()
                    {
                        Prix = 99f,
                        Nom = "Développez vos applications web avec AngularJS",
                        Description = "<p><strong>Objectifs</strong><p>" +
                                      "<p>Être en mesure de démarrer un nouveau projet avec Angular et de l’utiliser efficacement.</p>" +
                                      "<p><strong>Clientèle visée</strong></p>" +
                                      "<p>Développeurs Web.</p>" + 
                                      "<p><strong>Préalable</strong><p>" +
                                      "<p>Connaissance d’Angular 1.x est souhaitable, mais n’est pas requise</p>",
                        Longeur = 22.5f,
                        Langage = "Anglais"
                    },
                    new Produit()
                    {
                        Prix = 99f,
                        Nom = "Un site web dynamique avec jQuery",
                        Description = "<p><strong>Les prérequis pour suivre ce cours :</strong></p>" +
                                      "Des bases solides en JavaScript.Plus vous maîtriserez JavaScript,plus vite vous assimilerez jQuery. " +
                                      "(mise à niveau) Maîtriser un langage server - side comme PHP est un plus indéniable.Cependant," +
                                      "cela ne sera nécessaire que lorsque nous aborderons AJAX. (mise à niveau PHP)",
                        Longeur = 22.5f,
                        Langage = "Anglais"
                    },
                    new Produit()
                    {
                        Prix = 99f,
                        Nom = "Apprenez à créer votre site web avec HTML5 et CSS3",
                        Description = "<p><strong>Objectifs pédagogiques : </strong></p>" +
                                      "<p>À la fin de ce cours, vous saurez...</p>" +
                                      "<li>Maîtriser les langages HTML et CSS</li>" +
                                      "<li>Créer des pages web en HTML et CSS</li>" +
                                      "<li>Structurer une page web</li>" +
                                      "<li>Transformer une maquette en page web</li>" +
                                      "<li>Envoyer un site en ligne</li>" +
                                      "<li>Aucun pré - requis.</li>",
                        Longeur = 22.5f,
                        Langage = "Anglais"
                    }
                 );

            }
        }
    }
}
