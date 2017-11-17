using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using ProjetFinal.Models;
using ProjetFinal.DAL;
using System.Web.Security;
using ProjetFinal.ViewModels;

namespace ProjetFinal.Controllers
{
    [Authorize]
    public class CommandeController : Controller
    {
        AchatDB db = new AchatDB();
   
        public ActionResult Panier()
        {
            return PartialView("Panier",(Panier)Session["Panier"]);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(FormCollection fc)
        {
            var produits = fc.AllKeys.Where(x => x != "__RequestVerificationToken")
                                     .Select(key => int.Parse(fc[key]))
                                     .Select(x => db.Produits.Find(x));
            if (!produits.Any())
            {
                ViewBag.Error = "Rien n'est choisi !";
                return PartialView("../Home/Produits", db.Produits.ToList());
            }

            if (Session["Panier"] == null)
                Session["Panier"] = new Panier()
                {
                    DateCreated = DateTime.Now,
                    Produits = produits.ToList()
                };
            else
            {
                var panier = (Panier)Session["Panier"];

                if (panier.Produits.Intersect(produits).Count()>0)
                {
                    ViewBag.Error = "Assurez-vous que le panier ne contient pas les cours choisis !";
                    return PartialView("../Home/Produits",db.Produits.ToList());
                }

                Session["Panier"] = new Panier()
                {
                    DateCreated = panier.DateCreated,
                    Produits = panier.Produits.Concat(produits).ToList()
                };
            }                             

            return PartialView("Panier",(Panier)Session["Panier"]);
        }

        /// <summary>
        /// Liste des commandes
        /// </summary>
        /// <returns></returns>
        public ActionResult List()
        {
            return PartialView(getPanierCommandeViewModel());
        }
        /// <summary>
        /// Détail de la commande
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public ActionResult Details(int id)
        {
            Session["Link"] = "/Commande/Details/" + id.ToString();
            return PartialView(getPanierCommandeViewModel().Single(x => x.PanierId == id));
        }
        /// <summary>
        /// Liste de la combination  panier-commande
        /// </summary>
        /// <returns></returns>
        private List<PanierCommande> getPanierCommandeViewModel()
        {
            Client client = db.GetClient(User.Identity.Name);

            var paniers = (from panier in db.Paniers
                           join commande in db.Commandes on panier.PanierId equals commande.PanierId
                           where commande.ClientId == client.ClientId
                           select new { panier.DateCreated, commande.DateFinie, panier.PanierId }).ToList();

            List<PanierCommande> pc = new List<PanierCommande>();
            foreach (var p in paniers)
            {
                pc.Add(new PanierCommande()
                {
                    DateCreated = p.DateCreated,
                    DateFinie = p.DateFinie,
                    PanierId = p.PanierId,
                    Produits = db.Paniers.Include("Produits").Single(x => x.PanierId == p.PanierId).Produits
                });
            }
            return pc;
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Commander()
        {
            var p = new Panier()
            {
                DateCreated = ((Panier)Session["Panier"]).DateCreated,
                Produits = ((Panier)Session["Panier"]).Produits.Select(x => x.ProduitId).Select(x => db.Produits.Find(x)).ToList()
            };
            // Sauvegarder le panier
            db.Paniers.Add(p);
            db.SaveChanges();

            // Sauvegarder la commande
            db.Commandes.Add(new Commande()
            {
                PanierId = p.PanierId,
                DateFinie = DateTime.Now,
                Client = db.GetClient(User.Identity.Name)
            });
            db.SaveChanges();
            // Vider la session
            Session["Panier"] = null;
            return RedirectToAction("Details", new { id = p.PanierId });
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Enlever(FormCollection fc)
        {
            var produits = fc.AllKeys.Where(x => x != "__RequestVerificationToken")
                                     .Select(key => int.Parse(fc[key]))
                                     .Select(x => db.Produits.Find(x));

            var panier = (Panier)Session["Panier"];
            var test = panier.Produits.Except(produits);
            Session["Panier"] = new Panier()
            {
                DateCreated = panier.DateCreated,
                Produits = panier.Produits.Except(produits).ToList()
            };
            // Si tous sont enlevés, affecter null à la session
            if (((Panier)Session["Panier"]).Produits.Count() == 0)
                Session["Panier"] = null;
                
            return PartialView("Panier",(Panier)Session["Panier"]);
        }

    }
}