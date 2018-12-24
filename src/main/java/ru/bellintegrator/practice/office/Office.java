package ru.bellintegrator.practice.office;



import ru.bellintegrator.practice.Organization.Organization;
import ru.bellintegrator.practice.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "office")
public class Office {
    public Office() {
    }
public Office (Integer id, Integer org_id, String name, String address, String phone, Boolean active){
            this.id = id;
            this.org_id = org_id;
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.active = active;
        }
    public Office (Integer org_id, String name, String address, String phone, Boolean active){
            this.org_id = org_id;
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.active = active;
        }

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        private Integer id;
        @Version
        private Integer version;

        @Column(name = "org_id")
        private Integer org_id;

        @Column(name = "name", length = 50, nullable = false)
        private String name;

        @Column(name = "address", length = 100, nullable = false)
        private String address;

        @Column(name = "phone", length = 15, nullable = false)
        private String phone;

        @Column(name= "active", nullable = false)
        private Boolean active;

    @OneToMany(mappedBy = "office")
    public Set<User> user;

    @ManyToOne
    @JoinColumn(name = "org_id", insertable = false, updatable = false)
    public Organization organization;

       /* public Integer getId() {
            return id;
        }
        public Integer getOrgId(){return org_id;}
        public String getName() {
            return name;
        }
        public String getAddress() {
            return address;
        }
        public String getPhone() {
            return phone;
        }
        public Boolean isActive() { return active; }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
        public String toString() {
            return super.toString();
        }
    }

