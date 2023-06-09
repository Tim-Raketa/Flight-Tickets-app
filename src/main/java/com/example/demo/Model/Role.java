package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
@Document("roles")
public class Role implements GrantedAuthority {

    @Id
    private int id;
    private String name;

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role(){}
    @Override
    public String getAuthority() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
