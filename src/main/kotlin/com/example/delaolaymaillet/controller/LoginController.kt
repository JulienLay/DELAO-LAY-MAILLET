package com.example.delaolaymaillet.controller

//import com.example.delaolaymaillet.produit.AdminBean
//import com.example.delaolaymaillet.produit.AdminService
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
class LoginController () {
    //http://localhost:8080/login/login
    @GetMapping("/login")
    fun login(model: Model, adminBean: AdminBean): String {
        println("/login")
        return "login/login"
    }

    @PostMapping("/loginSubmit")
    fun formAdmin(adminBean: AdminBean, session: HttpSession, redirectAttributes: RedirectAttributes): String  {
        println("password tapé : ${adminBean.password}")

        try {
            //Controle
//            if (adminBean.password.isNullOrBlank()) {
//
//            }

            if (adminBean.password == "toto") {
                //si ca marche on sauvegarde la session
                return "redirect:/produit/produitsadmin"
            } else {
                throw Exception("Le password est mauvais !")
            }

//            val adminBDD = adminService.findByPassword(adminBean.password)
//            //Existe déjà
//            if (adminBDD != null) {
//                if (adminBDD.password != adminBean.password) {
//                    throw Exception("Password incorrect")
//                }
//                //si ca marche on sauvegarde la session
//                adminBDD.sessionId = session.id
//                adminService.save(adminBDD)
//            }
//            else {
//                //S'il n'existe pas je le crée
//                adminBean.sessionId = session.id
//                adminService.save(adminBean)
//            }
//
//            //redirige sur une url
//            return "redirect:/produit/produitsadmin"
        }
        catch (e: Exception) {
            //afficher dans la console
            e.printStackTrace()

            redirectAttributes.addFlashAttribute("errorMessage", e.message)

            return "redirect:/login/login"
        }

//        return "redirect:/produit/login"
    }
}