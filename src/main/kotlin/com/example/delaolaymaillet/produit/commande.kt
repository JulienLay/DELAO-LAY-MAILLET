package com.example.delaolaymaillet.produit

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Entity
@Table(name="commande")
data class CommandeBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    var nom_com: String? = null,
    var numero_tel: String? = null,
    var jour_recup: Long? = null,
    var session_id: String? = null
)

//@ManyToMany
//@JoinTable(
//    name = "produit_commande", //Nom de la table intermédiaire
//    //Clé étrangère représentant cette classe
//    joinColumns = [JoinColumn(name = "id_commande")],
//    //Clé étrangère représentant l'autre classe
//    inverseJoinColumns = [JoinColumn(name = "id_produit")]
//)
//var produit: List<ProduitBean>? = ArrayList()

@Repository
interface CommandeRepository : JpaRepository<CommandeBean, Long> {
//    fun findAllCommandes() : List<CommandeBean>
}

@Service
class CommandeService(var commandeRepository: CommandeRepository) {

    //Retourne la liste

//    fun getAll() = commandeRepository.findAll()

    fun createCommande(nom_com:String?, numero_tel: String?, jour_recup: Long?, session_id: String?) : CommandeBean {
        if(nom_com.isNullOrBlank()){
            throw Exception("nom du client manquant")
        } else if(numero_tel.isNullOrBlank()){
            throw Exception("numéro de téléphone manquant")
        } else if(jour_recup == null) {
            throw Exception("numéro de téléphone manquant")
        }
        val commande = CommandeBean(null, nom_com, numero_tel, jour_recup, session_id)

        commandeRepository.save(commande)

        return commande
    }
}