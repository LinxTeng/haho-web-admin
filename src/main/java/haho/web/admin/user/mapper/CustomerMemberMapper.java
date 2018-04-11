package haho.web.admin.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import haho.web.admin.user.dto.CustomerMemberDto;

public class CustomerMemberMapper implements RowMapper<CustomerMemberDto> {

    @Override
    public CustomerMemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerMemberDto customerMember = new CustomerMemberDto();
        customerMember.setId(rs.getLong("id"));
        customerMember.setMobile(rs.getString("mobile"));
        customerMember.setName(rs.getString("name"));
        customerMember.setShopId(rs.getLong("shop_id"));
        return customerMember;
    }

}
