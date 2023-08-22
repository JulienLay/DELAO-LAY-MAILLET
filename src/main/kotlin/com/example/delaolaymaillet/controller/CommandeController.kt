package com.example.delaolaymaillet.controller

import com.example.delaolaymaillet.produit.CommandeService
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDate
import java.time.ZoneOffset

@Controller
@RequestMapping("commande")
class CommandeController (val commandeService: CommandeService) {
    @GetMapping("/enregistrer")
    fun enregistrerCommande(nom_com: String?, numero_tel: String?, jour_recup: String?, session_id: HttpSession, model: Model, nb_produits: Int?): String {
        println("/enregistrer")
        val date: LocalDate = LocalDate.parse(jour_recup)
        val timestamp: Long = date.atStartOfDay(ZoneOffset.UTC).toEpochSecond()

        commandeService.createCommande(nom_com, numero_tel, timestamp, session_id.id.toString())

        return "redirect:/produit/produits"

//        produitCommandeService.createProduitCommande(null,null,nb_produits)


        // Afficher un message de confirmation ou d'erreur quand on veut enregistrer la commande
//        try {
//            commandeService.createCommande(nom_com, numero_tel, timestamp, session_id.id.toString())
//            model.addAttribute("message", "La commande est bien enregistrée !")
//            return "redirect:/produit/produits"
//        } catch (e:Exception) {
//            model.addAttribute("message", e.message)
//
//        }
    }
}