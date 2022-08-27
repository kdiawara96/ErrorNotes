package com.YouKar.ml.ErrorNotes.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@DiscriminatorValue("USER")
public class Users extends Personnes{

}
