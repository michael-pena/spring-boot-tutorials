package com.mpena.cruddemo;

import com.mpena.cruddemo.dao.StudentDAO;
import com.mpena.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count:" + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id:
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change the first name
		myStudent.setFirstName("Daffy");

		//update the student
		studentDAO.update(myStudent);

		//display the student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.FindByLastName("Doe");

		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.FindAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "Daffy@gmail.com");

		//save student object
		System.out.println("Saving new student object...");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		int studentId = tempStudent.getId();
		System.out.println("The Student id is: " + studentId);

		//retrieve the student based on the id: primary key
		Student searchedStudent = studentDAO.findById(studentId);

		//display student
		System.out.println("Found the Student: " + searchedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating new student objects...");
		Student tempStudent = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent1 = new Student("Mary", "Doe", "Mary@gmail.com");
		Student tempStudent2 = new Student("Dani", "California", "Dani@gmail.com");

		//save student object
		System.out.println("Saving new student objects...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

		//display id of saved student
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
		System.out.println("Saved Student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved Student. Generated id: " + tempStudent2.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "Paul@gmail.com");

		//save student object
		System.out.println("Saving new student object...");
		studentDAO.save(tempStudent);

		//display id of saved student
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());

	}

}
