﻿using System;

namespace Vaques.Model
{
    public class Raca
    {
        public static string Desconeguda = "Desconeguda";
        public Raca(string nom, double litres)
        {
            if (string.IsNullOrWhiteSpace(nom))
            {
                nom = Desconeguda;
            }
            Nom = nom;
            LitresPerKg = litres;
        }

        public string Nom { get; }
        public double LitresPerKg { get; }

        public override string ToString()
        {
            return Nom;
        }
    }
}
