package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
         return runner -> {
//			 createStudent(studentDAO);
    		 createMultipleStudents(studentDAO);
//			 readStudent(studentDAO);
//			 queryForStudents(studentDAO);
//			 queryForStudentByLastName(studentDAO);
//			 updateStudent(studentDAO);
//			 deleteStudent(studentDAO);
//			 deleteAllStudent(studentDAO);
		 };
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all Students");

		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted row count: "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: "+ studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: "+ studentId);

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");

		myStudent.setFirstName("maniteja");
		studentDAO.update(myStudent);

		System.out.println("Updated student: "+ myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("chikkala");


		//display that list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get list of students

		List<Student> theStudents = studentDAO.findAll();

		for(Student tempStudent : theStudents)  {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating the new Student");
		Student tempStudent = new Student("suresh","palla","suresh@gmail.com");

		// save the student object
		System.out.println("Saving the student ..");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student . Generate id: " + tempStudent.getId());
		 //retrive student based on the id: primary key
		System.out.println("\nRetrieving student with id: " + tempStudent.getId());

		Student myStudent = studentDAO.findById(tempStudent.getId());

		System.out.println("Found the student: "+ myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating the 3 Students object..");
		Student tempStudent1 = new Student("Nani","Yes","nani@Yes.com");
		Student tempStudent2 = new Student("Swaroop","Chikkala","swaroop@gmail.com");
		Student tempStudent3 = new Student("prasad","marip","pmp@gmail.com");

		System.out.println("Saving the 3 students ..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating the new Student");
		Student tempStudent = new Student("Mani","Chikkala","maniteja@gmail.com");
		// save the student object
		System.out.println("Saving the student ..");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student . Generate id: " + tempStudent.getId());
	}

}
