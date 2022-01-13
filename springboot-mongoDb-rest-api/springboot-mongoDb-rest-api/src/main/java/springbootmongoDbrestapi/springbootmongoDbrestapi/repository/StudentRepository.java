package springbootmongoDbrestapi.springbootmongoDbrestapi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import springbootmongoDbrestapi.springbootmongoDbrestapi.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    //Spring data MongoDb provides all this methods , not MongoRepository
    List<Student> findByName(String name);
    List<Student> findByNameAndEmail(String name,String email);
    List<Student> findByNameOrEmail(String name,String email);
    List<Student> findByDepartmentDepartmentName(String deptname);
    List<Student> findBySubjectsSubjectName(String subName);//Array
    List<Student> findByEmailIsLike(String email);
    List<Student> findByNameStartWith(String name);
    @Query("{ \"name\":\"?0\" }") //whatever name we want to get
    List<Student> getByName(String name);
}
