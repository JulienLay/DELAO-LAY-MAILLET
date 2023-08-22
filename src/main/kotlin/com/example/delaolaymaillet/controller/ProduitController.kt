package com.example.delaolaymaillet.controller

import com.example.delaolaymaillet.produit.ProduitService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("produit")
class ProduitController(val produitService: ProduitService) {

    //http://localhost:8080/produit/produits
    @GetMapping("/produits")
    fun getAllProducts(model: Model): String {
        println("/produits")
        model.addAttribute("productList", produitService.getAll())
        return "pageproduit"
    }

    @GetMapping("/remove/{myId}")
    fun removeProduct(@PathVariable myId: Int?): String {
        println("/remove $myId")
        if(myId != null) {
            produitService.removeProduit(myId.toLong())
        }

        return "redirect:/produit/produitsadmin"
    }

    @GetMapping("/activate/{myId}")
    fun activate(@PathVariable myId: Int?): String {
        if (myId != null) {
            produitService.activate(myId.toLong())
        }
        return "redirect:/produit/produitsadmin"
    }
    @GetMapping("/deactivate/{myId}")
    fun deactivate(@PathVariable myId: Int?): String {
        if (myId != null) {
            produitService.deactivate(myId.toLong())
        }
        return "redirect:/produit/produitsadmin"
    }

    //http://localhost:8080/produit/produitsadmin
    @GetMapping("/produitsadmin")
    fun getAllProductsAdmin(model: Model): String {
        println("/produitsadmin")
        model.addAttribute("productList", produitService.getAll())
        return "pageproduitadmin"
    }
}