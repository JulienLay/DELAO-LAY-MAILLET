package com.example.delaolaymaillet.produit

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Entity
@Table(name="produit")
data class ProduitBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    var nom_prod:String? = null,
    var visible: Boolean? = false,
    var photo:String?= null
)

@Repository
interface ProduitRepository : JpaRepository<ProduitBean, Long> {
    //fun findAll() : List<produitBean>
}

@Service
class ProduitService(var produitRepository: ProduitRepository) {

//    fun createTeacher(name:String?, code:Int) : TeacherBean {
//        if(name.isNullOrBlank()){
//            throw Exception("Name missing")
//        }
//        else if(code !in 1..10){
//            throw Exception("Code incorrecte")
//        }
//        val teacher = TeacherBean(null, name, code)
//
//        teacherRepository.save(teacher)
//
//        return teacher
//    }

    fun getAll() = produitRepository.findAll()
    //fun getByName(name:String) = teacherRepository.findByNameEquals(name)

}