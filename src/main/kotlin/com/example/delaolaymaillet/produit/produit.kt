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
//    fun findAllProduct() : List<ProduitBean>
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
        //Retourne la liste
        fun load() = produitRepository.findAll()
//    fun getProductList() = produitRepository.findAllProduct()
    //fun getByName(name:String) = teacherRepository.findByNameEquals(name)

    fun getAll() = produitRepository.findAll()

    fun createProduit(nom_prod:String?, visible: Boolean?, photo: String?) : ProduitBean {
        if(nom_prod.isNullOrBlank()){
            throw Exception("nom_prod manquant")
        }
        else if(photo.isNullOrBlank()){
            throw Exception("photo manquant")
        }
        val produit = ProduitBean(null, nom_prod, visible, photo)

        produitRepository.save(produit)

        return produit
    }

}