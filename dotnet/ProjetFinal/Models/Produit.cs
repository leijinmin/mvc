using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;


namespace ProjetFinal.Models
{
    /// <summary>
    /// Implémenter IEquatable<Produit>;
    /// Utilisé dans l'action Create de CommandeController lorsque faire Intersect des produits
    /// </summary>
    public class Produit : IEquatable<Produit>
    {
        [Key]
        public int ProduitId { get; set; }

        [Required]
        [Display(Name = "Nom")]
        [StringLength(255)]
        public string Nom { get; set; }

        [Display(Name ="Description")]
        [StringLength(5000)]
        public string Description { get; set; }

        [Display(Name = "Prix")]
        [DataType(DataType.Currency)]
        [DisplayFormat(DataFormatString = "{0:C2}")]
        public float Prix { get; set; }

        [Display(Name = "Longeur")]
        [DisplayFormat(DataFormatString = "{0:0.0}")]
        public float Longeur { get; set; }

        [Display(Name = "Langage")]
        [StringLength(50)]
        public string Langage { get; set; }

        public List<Panier> Paniers {get; set; }

        /// <summary>
        /// Utilisé dans l'action Create de CommandeController lorsque faire Intersect des produits
        /// </summary>
        /// <param name="other"></param>
        /// <returns></returns>
        public bool Equals(Produit other)
        {
            return this.ProduitId.Equals(other.ProduitId);
        }
        /// <summary>
        ///  Utilisé dans l'action Create de CommandeController lorsque faire Intersect des produits
        /// </summary>
        /// <returns></returns>
        public override int GetHashCode()
        {
            return ProduitId.GetHashCode();
        }

    }
}