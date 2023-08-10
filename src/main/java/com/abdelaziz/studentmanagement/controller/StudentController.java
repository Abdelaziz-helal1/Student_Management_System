package com.abdelaziz.studentmanagement.controller;

import com.abdelaziz.studentmanagement.entity.Student;
import com.abdelaziz.studentmanagement.services.StudentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    // define a StudentService field:
    private StudentServices studentServices;

    // define constructor:
    public StudentController(StudentServices studentServices) {
        super();
        this.studentServices = studentServices;
    }

    // define a Method to handle list students and return mode and view:
    @GetMapping("/students")
    public String getStudent(Model theModel) {
        theModel.addAttribute("students", studentServices.findAll());
        return "students";
    }

    // define a method to handle create student:
    @GetMapping("/students/new")
    public String createStudentForm(Model theModel) {
        // create a student object to handle student's data:
        Student tempStudent = new Student();

        theModel.addAttribute("student", tempStudent);
        return "create-student";
    }

    // define a method to save student:
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student tempStudent) {
        studentServices.save(tempStudent);

        return "redirect:/students";
    }

    // define method to update student:
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model theModel) {
        theModel.addAttribute("student", studentServices.findStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("student") Student student,
                                Model model)
    {
        // get the student from the database:
        Student existingStudent = studentServices.findStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save new information into database:
        studentServices.updateStudent(existingStudent);

        return "redirect:/students";
    }

    // define method to delete student:
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id)
    {
        studentServices.deleteById(id);

        return "redirect:/students" ;
    }
}
