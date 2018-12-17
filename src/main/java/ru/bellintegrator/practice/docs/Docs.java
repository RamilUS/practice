package ru.bellintegrator.practice.docs;



import ru.bellintegrator.practice.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "docs")
public class Docs {
    public Docs(){

    }
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
   /* @Version
    private Integer version;*/
    @Column(name = "name",length = 50,nullable = false)
    private String name;
    @Column(name = "code",  nullable = false)
    private Integer code;


    @OneToMany(mappedBy = "docs")
    public Set<User> user;
    
    public String getName(){return name;}
    public Long getId (){return id;}
    public Integer getCode() {return code;}

}
