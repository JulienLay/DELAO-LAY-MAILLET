package com.example.delaolaymaillet.produit

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

data class AdminBean(
    var password :String? = null
)

//@Repository
//interface AdminRepository : JpaRepository<AdminBean, Long> {
//    fun findByPassword(password: String?) : AdminBean?
//    fun findBySessionId(sessionId: String) : AdminBean?
//}
//
//@Service
//class AdminService(var adminRepository: AdminRepository) {
//
//    //Sauvegarde
//    fun save(user: AdminBean) = //On regarde s'il n'est pas déjà en base
//        adminRepository.save(user)
//
//
//    //Retourne la liste
//    fun load() = adminRepository.findAll()
//
//    //Retourne l'utilisateur qui a ce login ou null
//    fun findByPassword(password: String?)  = adminRepository.findByPassword(password)
//
//
//    //Retourne l'utilisateur qui a cette session ou null
//    fun findBySessionId(sessionId: String?): AdminBean? {
//        if (sessionId == null) {
//            return null
//        }
//        else return adminRepository.findBySessionId(sessionId)
//    }
//}

//@Repository
//interface AdminRepository : JpaRepository<AdminBean, Long> {
//    fun verifierMDP() : AdminBean
//
//}
//
//@Service
//class AdminService(var adminRepository: AdminRepository) {
//
////    fun createTeacher(name:String?, code:Int) : TeacherBean {
////        if(name.isNullOrBlank()){
////            throw Exception("Name missing")
////        }
////        else if(code !in 1..10){
////            throw Exception("Code incorrecte")
////        }
////        val teacher = TeacherBean(null, name, code)
////
////        teacherRepository.save(teacher)
////
////        return teacher
////    }
//        //Retourne la liste
//        fun load() = adminRepository.verifierMDP()
////    fun getProductList() = produitRepository.findAllProduct()
//    //fun getByName(name:String) = teacherRepository.findByNameEquals(name)
//
//}