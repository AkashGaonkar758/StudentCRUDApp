package com.Akash.Student.Repository;
import jakarta.annotation.PostConstruct;
import org.hibernate.dialect.function.DB2SubstringFunction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;




import com.Akash.Student.Model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class Repo {


    @Autowired
    private JdbcTemplate jdbcTemplate;



    @PostConstruct
    public String CreateTable(){
       String sql = "CREATE TABLE IF NOT EXISTS student("
               +  "id INT AUTO_INCREMENT PRIMARY KEY, "
               +  "name VARCHAR(30) NOT NULL,"
               +" grade INT NOT NULL )";

       jdbcTemplate.execute(sql);

       return"added table";



    }

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGrade(rs.getInt("grade"));
            return student;
        }
    }

    public List<Student> findAll() {
        String str = "SELECT id, name, grade FROM student";
        return jdbcTemplate.query(str, new StudentRowMapper());
    }

    public void addStudent(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        System.out.println(student.getName());
        String str = "INSERT INTO student (id ,name, grade) VALUES (?,?, ?)";
        jdbcTemplate.update(str,student.getId(), student.getName(), student.getGrade());
    }


    public void deleteStudent(int ID){
        String str = "delete from Student where id = ?";
        jdbcTemplate.update(str, ID);
    }

    public void updateStudent(Student student){
        String str =  "UPDATE student SET name =? , grade=? WHERE id = ? ";
        jdbcTemplate.update(str,student.getName(),student.getGrade(),student.getId());
    }









}
