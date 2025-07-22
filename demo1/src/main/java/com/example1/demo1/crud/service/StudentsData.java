package com.example1.demo1.crud.service;

import com.example1.demo1.crud.model.StudentsDB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;


@Service
public class StudentsData {

    List<StudentsDB> data = new ArrayList<>(Arrays.asList(
            new StudentsDB(1181, "Shreyash", 22),
            new StudentsDB(1111, "kalu", 23),
            new StudentsDB( 2424, "Hrishikesh", 10)));

    public  List<StudentsDB> getAllData(){
        return data;
    }


    public StudentsDB getStudentByRollNo(int rollno){
        for (StudentsDB student1 : data) {
            if (student1.getRollno() == rollno) {
                return student1;  // Found the student
            }
        }
        return null;
    }

    public void addDataInStudent(StudentsDB student) {
        data.add(student);
    }

    public String removeDataFromStudent(int rollno){
        try {
            data.removeIf(data -> data.rollno == rollno);
            return "removed";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

}
