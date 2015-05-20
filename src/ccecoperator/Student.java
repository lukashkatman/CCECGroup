/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

/**
 *
 * @author Lokes
 */
public class Student {
    private int idStudent;
    private String studentName;
    private String phnumberStudent;
    private String address;
    private String email;
    private int admitted;
    private int idUniversity;
    private int idCountry;
    private int idEmployee;
    
    public Student()  {}

    public Student(int idStudent, String studentName, String phnumberStudent, String address, String email, int admitted, int idUniversity, int idCountry, int idEmployee){
        setIdStudent(idStudent);
        setStudentName(studentName);
        setPhnumberStudent(phnumberStudent);
        setAddress(address);
        setEmail(email);
        setAdmitted(admitted);
        setIdUniversity(idUniversity);
        setIdCountry(idCountry);
        setIdEmployee(idEmployee);

    }

    public void setIdStudent(int idStudent)
    {
        this.idStudent = idStudent;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public void setPhnumberStudent(String phnumberStudent)
    {
        this.phnumberStudent = phnumberStudent;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setAdmitted(int admitted)
    {
        this.admitted = admitted;
    }

    public void setIdUniversity(int idUniversity)
    {
        this.idUniversity = idUniversity;
    }

    public void setIdCountry(int idCountry)
    {
        this.idCountry = idCountry;
    }

    public void setIdEmployee(int idEmployee)
    {
        this.idEmployee = idEmployee;
    }

    public int getIdStudent()
    {
        return idStudent;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public String getPhnumberStudent()
    {
        return phnumberStudent;
    }

    public String getAddress()
    {
        return address;
    }

    public String getEmail()
    {
        return email;
    }

    public int getAdmitted()
    {
        return admitted;
    }

    public int getIdUniversity()
    {
        return idUniversity;
    }

    public int getIdCountry()
    {
        return idCountry;
    }

    public int getIdEmployee()
    {
        return idEmployee;
    }

}
