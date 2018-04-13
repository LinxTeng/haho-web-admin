package haho.web.admin.user.service;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.TableResult;
import haho.web.admin.common.resp.ResultApi;
import haho.web.admin.user.dto.CustomerMemberDto;

public interface UserAdminService {
    /**
     * 查找会员
     *
     * @param customerDto
     * @param page
     * @return
     * @date 2018年3月27日
     * @author linxTeng
     */
    public TableResult<CustomerMemberDto> list(CustomerMemberDto customerDto, PageInfo page, String env);

    /**
     * 清除手机号
     *
     * @param customerDto
     * @param env
     * @return
     * @date 2018年4月12日
     * @author linxTeng
     */
    public ResultApi<Boolean> clearMobile(CustomerMemberDto customerDto, String env);
}
