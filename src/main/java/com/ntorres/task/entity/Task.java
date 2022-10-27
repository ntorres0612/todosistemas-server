package com.ntorres.task.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "task")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task  implements Serializable{

    
    public Task() {}
    
    private static final long serialVersionUID = 2302196605909954340L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Column(name = "execution")
    private Date execution;
 
    //@ManyToOne(fetch = FetchType.EAGER, optional = false)
   // @JoinColumn(name = "employee_id", nullable=false) 
    //@JsonManagedReference
    //@JsonBackReference  
    //@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;
     

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getExecution() {
        return execution;
    }

    public void setExecution(Date execution) {
        this.execution = execution;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", status=" + status + ", execution=" + execution
                + ", employee=" + employee + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getId() == task.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
