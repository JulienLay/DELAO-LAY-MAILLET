package com.example.delaolaymaillet.controller

import com.example.delaolaymaillet.produit.ProduitBean
import com.example.delaolaymaillet.produit.ProduitService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("produit")
class ProduitController(val produitService: ProduitService) {

    //http://localhost:8080/produit/getAllProducts
    @GetMapping("/getAllProducts")
    fun getAllProducts(): List<ProduitBean> {
        println("/getAllProducts")
        return produitService.getAll()
    }
}