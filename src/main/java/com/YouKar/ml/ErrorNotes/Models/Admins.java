package com.YouKar.ml.ErrorNotes.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data

@DiscriminatorValue("ADMIN")
public class Admins extends Personnes{

}
