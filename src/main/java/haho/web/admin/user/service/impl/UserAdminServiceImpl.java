package haho.web.admin.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.TableResult;
import haho.web.admin.common.resp.ResultApi;
import haho.web.admin.common.utils.DataSourceSwith;
import haho.web.admin.user.dao.CustomerMemberDao;
import haho.web.admin.user.dto.CustomerMemberDto;
import haho.web.admin.user.service.UserAdminService;

@Service
public class UserAdminServiceImpl implements UserAdminService {
    private static Logger logger = LoggerFactory.getLogger(UserAdminServiceImpl.class);

    @Autowired
    private CustomerMemberDao customerMemberDao;

    @Override
    public TableResult<CustomerMemberDto> list(CustomerMemberDto customerDto, PageInfo page, String env) {
        TableResult<CustomerMemberDto> result = TableResult.build();
        logger.debug("查询参数:{}", customerDto);
        try {
            DataSourceSwith.swithenv(env);// 切换环境
            result = customerMemberDao.list(customerDto, page);
        } catch (Exception e) {
            logger.error("服务器错误,错误日志:", e);
        }
        return result;
    }

    @Override
    public ResultApi<Boolean> clearMobile(CustomerMemberDto customerDto, String env) {
        logger.info("清除参数：{},环境:{}", customerDto, env);
        ResultApi<Boolean> result = ResultApi.build();
        try {
            DataSourceSwith.swithenv(env);// 切换环境
            result = customerMemberDao.clearMobile(customerDto);
        } catch (Exception e) {
            logger.error("服务器错误,错误日志:", e);
            return result.error("服务端出错");
        }
        return result;
    }
}
