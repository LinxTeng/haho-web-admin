package haho.web.admin.user.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.PageResult;
import haho.web.admin.common.utils.DataSourceSwith;
import haho.web.admin.user.dao.CustomerMemberDao;
import haho.web.admin.user.dto.CustomerMemberDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAdminServiceTest {
    @Autowired
    private CustomerMemberDao customerMemberDao;

    @Test
    public void testList() {
        DataSourceSwith.switchToTesta();
        CustomerMemberDto customerMemberDto = new CustomerMemberDto();
        customerMemberDto.setId(1L);
        PageInfo page = new PageInfo();
        PageResult<List<CustomerMemberDto>> list = customerMemberDao.list(customerMemberDto, page);
        System.out.println("结果" + list);
    }
}
