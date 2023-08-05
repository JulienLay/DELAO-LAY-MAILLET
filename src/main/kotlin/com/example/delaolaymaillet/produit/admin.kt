package com.example.delaolaymaillet.produit

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

data class AdminBean(
    var password :String? = "toto",
)

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