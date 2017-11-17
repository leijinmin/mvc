using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using ProjetFinal.Models;
using ProjetFinal.DAL;

namespace ProjetFinal.Controllers
{
    public class HomeController : Controller
    {
        private AchatDB db = new AchatDB();
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Search(FormCollection fc)
        {
            string keyvalue = fc["keyvalue"];
            if(keyvalue == null)
                return RedirectToAction("Produits");

            keyvalue = keyvalue.ToLower();
            var products = db.Produits;
            var searchResults = products.Where(x => x.Nom.ToLower().Contains(keyvalue) || x.Description.ToLower().Contains(keyvalue)).ToList();

            Session["Link"] = "/Home/Produits";
            return PartialView("Produits",searchResults);

        }
        public ActionResult Produits()
        {
            return PartialView(db.Produits.ToList());
        }

        public ActionResult Details(int id)
        {
            return PartialView(db.Produits.Single(x => x.ProduitId == id));
        }

        public ActionResult About()
        {
            return PartialView();
        }
    }
}