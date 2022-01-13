package springbootmongoDbrestapi.springbootmongoDbrestapi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Document(collection = "student")
public class Student {
    @Id
    public String id;
    public String name;
    @Field(name="mail")
    public String email;
    public Department departments;
    public List<Subject> subjects;
    @Transient
    public double percentage;

    public double getPercentage() {
        if(subjects!=null && subjects.size()>0){
            int total=0;
            for(Subject subject :subjects){
                total+=subject.getMarksObtained();
            }
            return total/subjects.size();
        }
        return 0.00;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
/* public Student(String id, Department departments) {
        this.id = id;
        this.departments = departments;
    }
     @PersistenceConstructor // apply only more than 1 constructor otherwise will face error
     Student(String id, String name, String email, Department departments, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departments = departments;
        this.subjects = subjects;
    }*/


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department departments) {
        this.departments = departments;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
