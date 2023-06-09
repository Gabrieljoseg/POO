package com.api.poo.apicomspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public Cliente (Long id, String name, String email, String password) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
    }
   
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

  
    public boolean equals(Object obj) {
        if (this ==obj)
            return true;
        else if (obj== null)
            return false;
        else if (getClass() !=obj.getClass())
            return false;
        Cliente other = (Cliente)obj;
        if (id == null)
            return other.id == null;
        else return id.equals(other.id);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email =email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =password;
    }
    

    
}
