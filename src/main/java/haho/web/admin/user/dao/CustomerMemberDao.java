package haho.web.admin.user.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.TableResult;
import haho.web.admin.common.resp.ResultApi;
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

    /**
     * 清除手机号
     *
     * @param customerMemberDto
     * @param env
     * @return
     * @date 2018年4月12日
     * @author linxTeng
     */
    @Transactional
    public ResultApi<Boolean> clearMobile(CustomerMemberDto customerMemberDto, String env) {
        ResultApi<Boolean> result = ResultApi.build();
        if (customerMemberDto == null) {
            return result.error("参数为null");
        }
        if (env == null) {
            return result.error("环境参数不能为空");
        }
        if (customerMemberDto.getId() == null) {
            return result.error("删除的会员id不能为空");
        }
        // 删除逻辑
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = String.copyValueOf(df.format(new Date()).toCharArray(), 3, 11);
        // 更新关联的用户信息
        String sql1 = "UPDATE customer SET mobile = ?,channel_serial=CONCAT(channel_serial,?),yunnex_open_id=CONCAT(yunnex_open_id,?),auth_applet_id=CONCAT(auth_applet_id,?) WHERE member_id =?";
        // 更新当前会员的手机号
        String sql2 = "UPDATE customer_member SET mobile = ? WHERE id=?";
        // 更新手动导入的手机号
        String sql3 = "UPDATE customer_offline SET mobile = ? WHERE member_id=?";
        DataSourceSwith.getJdbcTemplate().update(sql3, dateString, customerMemberDto.getId());
        DataSourceSwith.getJdbcTemplate().update(sql1, dateString, dateString, dateString, dateString, customerMemberDto.getId());
        DataSourceSwith.getJdbcTemplate().update(sql2, dateString, customerMemberDto.getId());
        return result;
    }
}
