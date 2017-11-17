using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.Reflection;

namespace ProjetFinal.Models
{
    public class Client
    {
        [Key]
        public int ClientId { get; set; }

        [Required]
        [Display(Name ="Prénom")]
        [StringLength(100)]
        [RegularExpression(@"^[A-Z]+[a-zA-Z''-'\s]*$")]
        public string Prenom { get; set; }

        [Required]
        [Display(Name ="Nom")]
        [StringLength(100)]
        [RegularExpression(@"^[A-Z]+[a-zA-Z''-'\s]*$")]
        public string Nom { get; set; }

        [Display(Name ="Téléphone")]
        [DataType(DataType.PhoneNumber)]
        [StringLength(8, MinimumLength = 8)]
        [DisplayFormat(DataFormatString = "{0:###-####}")]
        [RegularExpression("^([0-9]{3})-([0-9]{4})$",ErrorMessage = "Respecter le format 123-4567 !")]
        public string Tel { get; set; }

        [Required]
        [Display(Name ="Adresse courriel")]
        [DataType(DataType.EmailAddress)]
        [EmailAddress(ErrorMessage = "L'Adresse de courriel n'est pas valide ! ")]
        [StringLength(200)]
        public string Courriel { get; set; }

        [Required]
        [DataType(DataType.Password)]
        [StringLength(20, MinimumLength = 6)]
        [Display(Name="Mot de passe")]
        public string MotPasse { get; set; }

        [Required]
        [DataType(DataType.Password)]
        [StringLength(20, MinimumLength = 6)]
        [Display(Name = "Rentrer le mot de passe")]
        public string MotPasse2 { get; set; }
    }
}