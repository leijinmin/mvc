using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ProjetFinal.Models
{
    public class Commande
    {
 
        [Key]
        [Column(Order = 1)]
        public int ClientId { get; set; }
        [Key]
        [Column(Order = 2)]
        public int PanierId { get; set; }

        [DataType(DataType.DateTime)]
        [DisplayFormat(DataFormatString = "{0:dd MMMM yyyy HH:mm}")]
        public DateTime? DateFinie { get; set; }

        [ForeignKey("PanierId")]
        public Panier Panier { get; set; }
        [ForeignKey("ClientId")]
        public Client Client { get; set; }

    }
}