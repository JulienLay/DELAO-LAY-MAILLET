package com.example.delaolaymaillet.produit

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
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

    //Retourne la liste

    fun getAll() = produitRepository.findAll()

    fun createProduit(nom_prod:String?, visible: Boolean?, photo: String?) : ProduitBean {
        if(nom_prod.isNullOrBlank()){
            throw Exception("nom du produit manquant")
        }
        else if(photo.isNullOrBlank()){
            throw Exception("photo manquante")
        }
        val produit = ProduitBean(null, nom_prod, visible, photo)

        produitRepository.save(produit)

        return produit
    }

    fun removeProduit(id: Long)  {
        produitRepository.deleteById(id)
    }
    fun activate(id: Long) {
        val produit : ProduitBean = produitRepository.findByIdOrNull(id) ?: throw Exception("produit non trouvé :$id")
        produit.visible = true
        produitRepository.save(produit)
    }
    fun deactivate(id: Long) {
        val produit : ProduitBean = produitRepository.findByIdOrNull(id) ?: throw Exception("produit non trouvé :$id")
        produit.visible = false
        produitRepository.save(produit)
    }
}