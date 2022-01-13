package springbootmongoDbrestapi.springbootmongoDbrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import springbootmongoDbrestapi.springbootmongoDbrestapi.entity.Student;
import springbootmongoDbrestapi.springbootmongoDbrestapi.repository.StudentRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class StudentService {
   private StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public Student getStudentById(String id){
        return studentRepository.findById(id).get();
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }
    public String deleteStudent(String id){
         studentRepository.deleteById(id);
         return "Student has been deleted";
    }
    public List<Student>getStudentsByName(String name){
       return studentRepository.getByName(name);
    }
    public List<Student> studentsByNameAndMail(String name,String email)
    {
        return studentRepository.findByNameAndEmail(name,email);
    }
    public List<Student> studentsByNameOrMail(String name,String email)
    {
        return studentRepository.findByNameOrEmail(name,email);
    }
    public List<Student> getAllWithPagination (int pageNo,
    int pageSize)
    {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return studentRepository.findAll(pageable).getContent();
    }
    public List<Student> allWithSorting()
    {
        Sort sort= Sort.by(Sort.Direction.ASC,"name");
        return studentRepository.findAll(sort);
    }
    public List<Student> byDepartmentName(String deptname){
         return studentRepository.findByDepartmentDepartmentName(deptname);
    }
    public  List<Student> bySubjectsName(String subName){
        return studentRepository.findBySubjectsSubjectName(subName);
    }
    public  List<Student> emailLike(String email){
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> findByNameStartWith(String name){
        return studentRepository.findByNameStartWith(name);
    }
}
