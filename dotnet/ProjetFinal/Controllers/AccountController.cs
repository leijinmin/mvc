using System.Web;
using System.Web.Mvc;
using ProjetFinal.Models;
using ProjetFinal.ViewModels;
using ProjetFinal.DAL;
using System.Web.Security;

namespace ProjetFinal.Controllers
{
    public class AccountController : Controller
    {
        AchatDB db = new AchatDB();
        // GET: Account
        public ActionResult Login()
        {
            return PartialView(new LoginClient());
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult DoLogin(LoginClient c)
        {
            if(ModelState.IsValid)
            {
                if(db.Exist(c.Courriel, c.MotPasse))
                {
                    FormsAuthentication.SetAuthCookie(c.Courriel, c.IsPersistent);

                    HttpCookie cookie = new HttpCookie("username");
                    cookie.Value = c.Courriel;
                    Response.Cookies.Add(cookie);
                    return RedirectToAction("Produits", "Home");
                }
                ModelState.AddModelError("courriel", "Courriel ou mot de passe non valide.");
            }
            return PartialView("Login", c);

        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Logout()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Index", "Home");
        }

        public ActionResult Register()
        {
            return PartialView(new Client());
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Register(Client client)
        {
            var clients = db.Clients;
            
            if (ModelState.IsValid)
            {
                if(db.Contains(client.Courriel))
                    ModelState.AddModelError("Courriel", "Ce compte existe déjà !");
                else if(client.MotPasse != client.MotPasse2 )
                    ModelState.AddModelError("MotPasse", "Les deux mots de passe sont différents !");
                else
                { 
                    clients.Add(client);
                    db.SaveChanges();
                   
                    return PartialView("Login",new LoginClient() {
                        Courriel = client.Courriel,
                        MotPasse = client.MotPasse
                    });
                }
            }
            return PartialView("Register", client);          
        }
    }
}