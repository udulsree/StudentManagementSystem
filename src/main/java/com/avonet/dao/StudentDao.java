package com.avonet.dao;

import com.avonet.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int save(Student p){
        String sql="insert into studentinfo(name,age,school) values('"+p.getName()+"',"+p.getAge()+",'"+p.getSchool()+"')";
        return template.update(sql);
    }
    public int update(Student p){
        String sql="update studentinfo set name='"+p.getName()+"', age="+p.getAge()+",school='"+p.getSchool()+"' where id="+p.getId()+"";
        return template.update(sql);
    }
    public int delete(int id){
        String sql="delete from studentinfo where id="+id+"";
        return template.update(sql);
    }
    public Student getEmpById(int id){
        String sql="select * from studentinfo where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));
    }
    public List<Student> getEmployees(){
        return template.query("select * from studentinfo",new RowMapper<Student>(){
            public Student mapRow(ResultSet rs, int row) throws SQLException {
                Student e=new Student();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setAge(rs.getInt(3));
                e.setSchool(rs.getString(4));
                return e;
            }
        });
    }
}