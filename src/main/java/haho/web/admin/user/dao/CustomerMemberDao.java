package haho.web.admin.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.TableResult;
import haho.web.admin.common.utils.DataSourceSwith;
import haho.web.admin.user.dto.CustomerMemberDto;
import haho.web.admin.user.mapper.CustomerMemberMapper;

@Service
public class CustomerMemberDao {

    /** 根据手机号查找用户 */
    public TableResult<CustomerMemberDto> list(CustomerMemberDto customerMemberDto, PageInfo page) {
        String sql = "select * from customer_member where 1=1";
        // 组装参数
        List<Object> params = new ArrayList<>();
        if (customerMemberDto.getId() != null) {
            sql += " and id=?";
            params.add(customerMemberDto.getId());
        }
        if (!StringUtils.isEmpty(customerMemberDto.getMobile())) {
            sql += " and mobile like ?";
            params.add("%" + customerMemberDto.getMobile() + "%");
        }
        if (!StringUtils.isEmpty(customerMemberDto.getName())) {
            sql += " and name like ?";
            params.add("%" + customerMemberDto.getName() + "%");
        }
        if (customerMemberDto.getShopId() != null) {
            sql += " and shop_id = ?";
            params.add(customerMemberDto.getShopId());
        }
        PageInfo pageInfo = this.getPage(sql, params.toArray(), page);
        // 排序
        sql += " order by id desc ";
        // 分页
        sql += " limit " + pageInfo.getPageStartRow() + "," + pageInfo.getPageEndRow();
        List<CustomerMemberDto> daoResult = DataSourceSwith.getJdbcTemplate().query(sql, new CustomerMemberMapper(), params.toArray());
        TableResult<CustomerMemberDto> result = TableResult.build();
        result.setData(daoResult);
        result.setRecordsTotal(pageInfo.getTotalRows());
        result.setRecordsFiltered(pageInfo.getPageSize());
        return result;
    }

    // 计算分页总数
    PageInfo getPage(String sql, Object[] params, PageInfo page) {
        // 查询分页
        sql = "select count(1) from (" + sql + ") aa";
        Integer count = DataSourceSwith.getJdbcTemplate().queryForObject(sql, Integer.class, params);
        page.init(count);
        return page;
    }
}
