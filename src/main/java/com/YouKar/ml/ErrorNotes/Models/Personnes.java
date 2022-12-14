package com.YouKar.ml.ErrorNotes.Models;


import com.YouKar.ml.ErrorNotes.Others.Roles;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

//Nous avons trois manière de faire l'héritage, soit avec InheritanceType.SINGLE_TABLE
// Dans se cas Hibernate va creer juste une table dans la base de données pour les deux entité mais
//Mais l'inconvenient de cette methode est q'elle crée des colonne vide dans la base de données si
//les deux entités ont des attribut different


//Nous AVons encore une autre manière c'est l'InheritanceType.TABLE_PER_CLASS ceci va créer deux tables dans
//la base de données et chacun aura ses propres données mais cela à un desanvatage est qu'il aura
//la rédondance dans la base de données on aura des column répétitive


//Nous avons un troisième mapper InheritanceType.JOINED_TABLE ceci va créer un vrais heritage
//les deux entités seron lié à un entité qui sera abstraite, cette stratégie est là pour comblé les
//lacunes des deux methodes ci-dessus



 //@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


//@Inheritance(strategy = InheritanceType.JOINED)




@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING, length = 6)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admins.class, name = "Admins"),
        @JsonSubTypes.Type(value = Users.class, name = "Users")
})

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personnes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idpersonnes;

    @Column(name = "nom", nullable = false, length = 25)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 25)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "contact", nullable = false, length = 20, unique = true)
    private String contact;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Roles status;


    @OneToMany(mappedBy = "personnesp")
    private Collection<Problemes> probleme;

    @OneToMany(mappedBy = "personnes")
    private Collection<Commentaires> commentaire;


}
