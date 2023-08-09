package com.example.delaolaymaillet.controller

import com.example.delaolaymaillet.produit.ProduitService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("produit")
class ProduitController(val produitService: ProduitService) {

    //http://localhost:8080/produit/produits
    @GetMapping("/produits")
    fun getAllProducts(model: Model): String {
        println("/produits")
        model.addAttribute("productList", produitService.load())
        return "pageproduit"
    }

    //http://localhost:8080/produit/produitsadmin
    @GetMapping("/produitsadmin")
    fun getAllProductsAdmin(model: Model): String {
        println("/produitsadmin")
        model.addAttribute("productList", produitService.load())
        return "pageproduitadmin"
    }
}