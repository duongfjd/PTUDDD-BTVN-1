/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btvn1;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Class {
    private String className;
    private ArrayList<Student> student;

    
    public void add_student(Student a){
        student.add(a);
    }
    
    public int countRank(String rank) {
        int count = 0;
        for (Student a : student) {
            if (a.xepLoai().equals(rank)) {
                count++;
            }
        }
        return count;
    }
    public Class() {
    }

    public Class(String className) {
        this.className = className;
        this.student = new ArrayList<>();
    }
    
    public String getClassName() {
        return className;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setStudent(ArrayList<Student> students) {
        this.student = students;
    }

 
    
    
}
