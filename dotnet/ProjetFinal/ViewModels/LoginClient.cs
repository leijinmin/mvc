using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace ProjetFinal.ViewModels
{
    public class LoginClient
    {
        [Required]
        [DataType(DataType.EmailAddress)]
        [Display(Name = "Courriel")]
        public string Courriel { get; set; }
        [Required]
        [DataType(DataType.Password)]
        [Display(Name = "Mot de passe")]
        public string MotPasse { get; set; }

        public bool IsPersistent { get; set; }


    }
}