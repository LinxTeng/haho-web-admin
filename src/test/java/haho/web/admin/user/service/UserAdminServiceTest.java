package haho.web.admin.user.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.TableResult;
import haho.web.admin.common.utils.DataSourceSwith;
import haho.web.admin.user.dto.CustomerMemberDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAdminServiceTest {
    @Autowired
    private UserAdminService userAdminService;

    @Test
    public void testList() {
        CustomerMemberDto customerMemberDto = new CustomerMemberDto();
        customerMemberDto.setId(1L);
        PageInfo page = new PageInfo();
        TableResult<CustomerMemberDto> list = userAdminService.list(customerMemberDto, page, DataSourceSwith.DEVA);
        System.out.println("结果" + list);
    }
}
