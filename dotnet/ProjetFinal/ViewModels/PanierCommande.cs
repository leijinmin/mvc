using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ProjetFinal.Models;
using System.ComponentModel.DataAnnotations;

namespace ProjetFinal.ViewModels
{
    public class PanierCommande
    {
        [DataType(DataType.Date), DisplayFormat(DataFormatString = "{0:dd MMMM yyyy HH:mm}", ApplyFormatInEditMode = true)]
        [Display(Name = "Date créée")]
        public DateTime DateCreated { get; set; }

        [DataType(DataType.Date), DisplayFormat(DataFormatString = "{0:dd MMMM yyyy HH:mm}", ApplyFormatInEditMode = true)]
        [Display(Name = "Date finie")]
        public DateTime? DateFinie { get; set; }

        public int PanierId;
        public List<Produit> Produits { get; set; }
    }
}