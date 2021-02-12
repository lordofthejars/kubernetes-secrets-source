package org.acme;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Welcome extends PanacheEntity {
   public String message;

   public Welcome(){}
   
   public Welcome(String message) {
       this.message = message;
   }
}
