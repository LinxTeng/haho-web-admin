package haho.web.admin.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.TableResult;
import haho.web.admin.common.utils.DataSourceSwith;
import haho.web.admin.user.dto.CustomerMemberDto;
import haho.web.admin.user.service.UserAdminService;

@Controller
public class UserAdminController {
    @Autowired
    UserAdminService userAdminService;

    @GetMapping("/")
    public String home() {
        return "user/home";
    }

    @RequestMapping("/get/user2")
    @ResponseBody
    TableResult<CustomerMemberDto> getUserInfo(Model model, CustomerMemberDto customerMemberDto) {
        PageInfo page = new PageInfo();
        page.setPageSize(100);
        CustomerMemberDto params = new CustomerMemberDto();
        if (customerMemberDto.getId() != null) {
            params.setId(customerMemberDto.getId());
        }
        if (customerMemberDto.getMobile() != null) {
            params.setName(customerMemberDto.getMobile());
        }
        TableResult<CustomerMemberDto> listUser = userAdminService.list(customerMemberDto, page);
        model.addAttribute(listUser);
        return listUser;
    }

    @GetMapping("/get/user")
    public String getUser(Model model, CustomerMemberDto customerMemberDto, String env) {
        PageInfo page = new PageInfo();
        page.setPageSize(10);
        if (customerMemberDto == null) {
            return "user/home";
        }
        if (env == null) {
            env = "test-a";
        }
        switch (env) {
            case "test-a":
                DataSourceSwith.switchToTesta();
                break;
            case "test-b":
                DataSourceSwith.switchToTestb();
                break;
            case "dev-a":
                DataSourceSwith.switchToDeva();
                break;
            case "dev-b":
                DataSourceSwith.switchToDevb();
                break;
            case "yufabu":
                DataSourceSwith.switchToYufabu();
                break;
            default:
                break;
        }
        TableResult<CustomerMemberDto> listUser = userAdminService.list(customerMemberDto, page);
        model.addAttribute("result", listUser);
        model.addAttribute("param", customerMemberDto);
        model.addAttribute("env", env);
        return "user/clear";
    }
}
