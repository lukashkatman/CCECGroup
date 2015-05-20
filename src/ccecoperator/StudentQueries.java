/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lokes
 */
public class StudentQueries {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/ccec?user=root&password=root";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    private Connection connection;
    private PreparedStatement selectAllStudent;
    private PreparedStatement insertNewStudent;
    
    public StudentQueries()
    {
        try
        {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            selectAllStudent = connection.prepareStatement("SELECT * FROM student");
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.out.println("Something went wrong with our database!");
        }
    }
    
    public boolean insertStudent(Student s){
        try{
            String stmt;
            stmt = "INSERT INTO student" + 
                    "(idStudent, studentName, phnumberStudent, address, email, admitted, idUniversity, idCountry, idEmployee ) " +
                    "VALUES (" + s.getIdStudent() + ", '" + s.getStudentName() + "', '" + s.getPhnumberStudent() + "', '" + s.getAddress() + "', '" + s.getEmail() + "', " + s.getAdmitted() + ", " + s.getIdUniversity() + ", " + s.getIdCountry() + ", " + s.getIdEmployee() + ")";
//            String URL = "jdbc:mysql://127.0.0.1:3306/ccec?user=root&password=root";
                Connection c = DriverManager.getConnection(URL); 
                Statement st = c.createStatement();
                if (st.executeUpdate(stmt)>0){
                    return true;
                }
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            insertNewStudent = connection.prepareStatement(stmt);
                return false;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean delStudent(int studentID){
        try{
            String stmt;
            stmt = "delete from student where idStudent = " + studentID; 
                Connection c = DriverManager.getConnection(URL); 
                Statement st = c.createStatement();
                if (st.executeUpdate(stmt)>0){
                    return true;
                }
                return false;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public List<Student> getAllStudent()
    {
       List< Student > results = null;
       ResultSet resultSet = null;
       
       try
       {
           resultSet = selectAllStudent.executeQuery();
           results = new ArrayList< Student >();
           
           while (resultSet.next())
           {
               results.add(new Student(
               resultSet.getInt("IdStudent"),  resultSet.getString("StudentName"),  resultSet.getString("PhnumberStudent"),
                 resultSet.getString("Address"),  resultSet.getString("Email"),  resultSet.getInt("Admitted"), 
                 resultSet.getInt("IdUniversity"),  resultSet.getInt("IdCountry"),  resultSet.getInt("IdEmployee")));
           }
       }
       catch (SQLException sqlException)
       {
           sqlException.printStackTrace();
           }
       return results;
    }
    
    //Below need to change String to int on some attributes as I got trouble inserting ints'
//    public int addStudent(
//    int addidStudent, String addstudentName, String addphnumberStudent, String addaddress, String addemail, int addadmitted, int addidUniversity, int addidCountry, int addidEmployee )
//    {
//        int result = 0;
//        
//        try
//        {
//            insertNewStudent.setInt(1, addidStudent);
//            insertNewStudent.setString(2, addstudentName);
//            insertNewStudent.setString(3, addphnumberStudent);
//            insertNewStudent.setString(4, addaddress);
//            insertNewStudent.setString(5, addemail);
//            insertNewStudent.setInt(6, addadmitted);
//            insertNewStudent.setInt(7, addidUniversity);
//            insertNewStudent.setInt(8, addidCountry);
//            insertNewStudent.setInt(9, addidEmployee);
//            
//            result = insertNewStudent.executeUpdate();
//        }
//        catch (SQLException sqlException)
//        {
//            sqlException.printStackTrace();
//            System.out.println("Something wrong with our database");
//        }
//        return result;
    }


            
            
            
      