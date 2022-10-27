package com.ntorres.task.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
 

@Entity
@Table(name = "employee")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee implements Serializable {

    private static final long serialVersionUID = 2302196605909954340L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
     
    
    //@JsonManagedReference
    //@OneToMany(mappedBy = "employee", cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
    //@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    //private Set<Task> tasks = new HashSet<>();
    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = false, mappedBy = "employee")
    private Set<Task> tasks;
    
    public Employee() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", tasks=" + tasks + "]";
    }
    
}
