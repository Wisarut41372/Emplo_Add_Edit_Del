package nvc.bcit.soi5shopstart.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;

    @ManyToOne
    @JoinColumn(name= "projecttId", nullable = false)
    private Projectt projectt;

    @ManyToOne
    @JoinColumn(name="departmentId ", nullable = false)
    private Department department;

 
 



    // @ManyToOne
    // @JoinColumn(name="projectsId", nullable = false)
    // private Projects projects;

 

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
}
