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

@NoArgsConstructor
@AllArgsConstructor
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

    public Customer(Longid, String name, String email, String password) {
        this.id =id;
        this.name =name;
        this.email =email;
        this.password =password;
    }

@Override
public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

@Override
public boolean equals(Objectobj) {
        if (this ==obj)
            return true;
        else if (obj== null)
            return false;
        else if (getClass() !=obj.getClass())
            return false;
        Customer other = (Customer)obj;
        if (id == null)
            return other.id == null;
        else return id.equals(other.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Longid) {
        this.id =id;
    }

    public String getName() {
        return name;
    }

    public void setName(Stringname) {
        this.name =name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(Stringemail) {
        this.email =email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(Stringpassword) {
        this.password =password;
    }
    

    
}
