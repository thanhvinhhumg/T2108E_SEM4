package com.example.springmvc.dao.impl;

import com.example.springmvc.dao.UserDAO;
import com.example.springmvc.dto.UserDTO;
import com.example.springmvc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

    public UserDAOImpl(@Autowired DataSource dataSource){
        setDataSource(dataSource);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> data = new ArrayList<>();
        try {
            String sql = "Select * from users";
            data = getJdbcTemplate().query(sql, new UserMapper());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return data;
    }

    @Override
    public String createUser(UserDTO userDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        try {
            String sql = "insert into users (name, age, address) values (:name, :age, :address)";
            params.addValue("name", userDTO.getName());
            params.addValue("age", userDTO.getAge());
            params.addValue("address", userDTO.getAddress());
            namedParameterJdbcTemplate.update(sql, params);
            return "Success";
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return "Error";
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        try {
            String sql = "UPDATE users set name = :name, age= :age, address=:address where id = :id";
            params.addValue("name", userDTO.getName());
            params.addValue("age", userDTO.getAge());
            params.addValue("address", userDTO.getAddress());
            params.addValue("id", userDTO.getId());
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public UserDTO getUserById(Integer id) {
        List<UserDTO> userDTOS = new ArrayList<>();
        MapSqlParameterSource params = new MapSqlParameterSource();
        try {
            String sql  = "select * from users where id = :id";
            params.addValue("id", id);
            userDTOS = namedParameterJdbcTemplate.query(sql,params, new UserMapper());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return ( userDTOS.size() > 0 ) ? userDTOS.get(0) : new UserDTO();
    }


}
