//package com.example.delaolaymaillet.produit
//
//import jakarta.persistence.*
//import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.stereotype.Repository
//import org.springframework.stereotype.Service
//
//@Entity
//@Table(name="produit_commande")
//data class ProduitCommandeBean(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long? = null,
//    val id_commande: Long? = null,
//    val id_produit: Long? = null,
//    val nb_produit: Int? = null,
//)
//
//@ManyToMany(mappedBy = "produit_commande", fetch = FetchType.LAZY)
//var produits: ProduitBean? = null
//
//@ManyToMany(mappedBy = "produit_commande", fetch = FetchType.LAZY)
//var commandes: CommandeBean? = null
//
//@Repository
//interface ProduitCommandeRepository : JpaRepository<ProduitCommandeBean, Long> {
////    fun findAllCommandes() : List<CommandeBean>
//}
//
//@Service
//class ProduitCommandeService(var produitCommandeRepository: ProduitCommandeRepository) {
//
//    //Retourne la liste
//
////    fun getAll() = commandeRepository.findAll()
//
//    fun createProduitCommande(id_commande: Long?, id_produit: Long?, nb_produit: Int?) : ProduitCommandeBean {
//        if(id_commande == null){
//            throw Exception("id de commande manquant")
//        } else if(id_produit == null){
//            throw Exception("id de produit manquant")
//        } else if(nb_produit == null) {
//            throw Exception("nombre de commande manquant")
//        }
//        val produitCommande = ProduitCommandeBean(null, id_commande, id_produit, nb_produit)
//
//        produitCommandeRepository.save(produitCommande)
//
//        return produitCommande
//    }
//}