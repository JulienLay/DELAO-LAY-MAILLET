package com.example.delaolaymaillet.controller

import com.example.delaolaymaillet.produit.AdminBean
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("/login")
class LoginController() {
    //http://localhost:8080/login/login
    @GetMapping("/login")
    fun login(model: Model, adminBean: AdminBean): String {
        println("/login")
        return "login/login"
    }

    @PostMapping("/loginSubmit")
    fun formAdmin(adminBean: AdminBean, session: HttpSession, redirectAttributes: RedirectAttributes): String {
        println("password tapé : ${adminBean.password}")

        try {
            if (adminBean.password == "toto") {
                //si ca marche on sauvegarde la session
                return "redirect:/produit/produitsadmin"
            } else {
                throw Exception("Le password est mauvais !")
            }

        } catch (e: Exception) {
            //afficher dans la console
            e.printStackTrace()

            redirectAttributes.addFlashAttribute("errorMessage", e.message)

            return "redirect:/login/login"
        }
    }
}