package com.example.delaolaymaillet.controller

import com.example.delaolaymaillet.produit.AdminBean
//import com.example.delaolaymaillet.produit.AdminService
import com.example.delaolaymaillet.produit.ProduitService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("produit")
class APIversViewController(val produitService: ProduitService) {

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

    //http://localhost:8080/produit/login
    @GetMapping("/login")
    fun login(model: Model): String {
        println("/login")
        return "login/login"
    }

    @PostMapping("/loginSubmit")
    fun formAdmin(password: String, adminBean: AdminBean,redirectAttributes: RedirectAttributes): String  {
        println("password : $password")

        try {
            //Controle
            if (password.isNullOrBlank()) {
                throw Exception("Le password est manquant")
            } else if (password == adminBean.password) {
                //redirige sur une url
                return "redirect:/produit/produitsadmin";
            }

        }
        catch (e: Exception) {
            //afficher dans la console
            e.printStackTrace()

            redirectAttributes.addFlashAttribute("errorMessage", e.message)

            return "redirect:/produit/login"
        }

        return "redirect:/produit/login"
    }
}