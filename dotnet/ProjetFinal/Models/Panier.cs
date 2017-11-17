using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ProjetFinal.Models
{
    public class Panier
    {
        [Key]
        public int PanierId { get; set; }

        [Display(Name = "Date créée")]
        [DataType(DataType.DateTime)]
        [DisplayFormat(DataFormatString = "{0:dd MMMM yyyy HH:mm}")]
        public DateTime DateCreated { get; set; }

        public List<Produit> Produits { get; set; }

    }
}