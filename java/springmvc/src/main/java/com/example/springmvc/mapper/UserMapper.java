package com.example.springmvc.mapper;

import com.example.springmvc.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserDTO> {
    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDTO item = new UserDTO();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setAge(rs.getInt("age"));
        item.setAddress(rs.getString("address"));
        return item;
    }
}
