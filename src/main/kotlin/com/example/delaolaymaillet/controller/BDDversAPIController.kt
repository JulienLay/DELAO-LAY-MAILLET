package com.example.delaolaymaillet.controller

import com.example.delaolaymaillet.produit.ProduitBean
import com.example.delaolaymaillet.produit.ProduitService
import jakarta.persistence.Id
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("APIproduit")
class BDDversAPIController(val produitService: ProduitService) {

    //http://localhost:8080/APIproduit/getAllProducts
    @GetMapping("/getAllProducts")
    fun getAllProducts(): List<ProduitBean> {
        println("/getAllProducts")
        return produitService.getAll()
    }

    //http://localhost:8080/APIproduit/add
    @GetMapping("/add")
    fun addProduct(nom_prod: String?, visible: Boolean, photo: String?): List<ProduitBean> {
        produitService.createProduit(nom_prod, visible, photo)
        return produitService.getAll()
    }
}