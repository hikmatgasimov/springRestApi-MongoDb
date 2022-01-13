package springbootmongoDbrestapi.springbootmongoDbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootmongoDbrestapi.springbootmongoDbrestapi.entity.Student;
import springbootmongoDbrestapi.springbootmongoDbrestapi.repository.StudentRepository;
import springbootmongoDbrestapi.springbootmongoDbrestapi.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
  @Autowired
  private StudentService studentService ;
  @PostMapping("/create")
  public Student createStudent(@RequestBody Student student )
  {
    return  studentService.createStudent(student);
  }
  @GetMapping("/{id}")
  public Student getStudentById(@PathVariable String id)
  {
    return  studentService.getStudentById(id);
  }
  @GetMapping("/all")
  public List<Student> getAllStudents()
  {
    return  studentService.getAllStudents();
  }
  @PutMapping("/update")
  public Student updateStudent(@RequestBody Student student)
  {
    return studentService.updateStudent(student);
  }
  @DeleteMapping("/{id}")
  public String deleteStudent(@PathVariable String id)
  {
    return studentService.deleteStudent(id);
  }
  @GetMapping("/{name}")
  public List<Student>getStudentsByName(@PathVariable  String name){
    return studentService.getStudentsByName(name);
  }
  @GetMapping("/studentsByNameAndMail")
  public List<Student>studentsByNameAndMail(@PathVariable  String name,@PathVariable  String mail){
    return studentService.studentsByNameAndMail(name,mail);
  }
  @GetMapping("/studentsByNameOrMail")
  public List<Student>studentsByNameOrMail(@PathVariable  String name,@PathVariable  String mail){
    return studentService.studentsByNameOrMail(name,mail);
  }
  @GetMapping("/allWithPagination")
  public List<Student>getAllWithPagination(@PathVariable  int pageNo,@PathVariable int pageSize){
    return studentService.getAllWithPagination(pageNo,pageSize);
  }
  @GetMapping("/allWithSorting")
  public List<Student>getAllWithPagination(){
    return studentService.allWithSorting();
  }
  @GetMapping("/byDepartmentName")
  public List<Student>byDepartmentName(@PathVariable String deptName){
    return studentService.byDepartmentName(deptName);
  }
  @GetMapping("/bySubjectName")
  public List<Student>bySubjectName(@PathVariable String subName){
    return studentService.bySubjectsName(subName);
  }
  @GetMapping("/emailLike")
  public List<Student>emailLike(@PathVariable String email){
    return studentService.emailLike(email);
  }
  @GetMapping("/nameStartWith")
  public List<Student>nameStartWith(@PathVariable String name){
    return studentService.findByNameStartWith(name);
  }


}
