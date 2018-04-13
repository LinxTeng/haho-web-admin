package haho.web.admin.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.TableResult;
import haho.web.admin.common.resp.ResultApi;
import haho.web.admin.common.utils.DataSourceSwith;
import haho.web.admin.user.dto.CustomerMemberDto;
import haho.web.admin.user.service.UserAdminService;

@Controller
public class UserAdminController {
    @Autowired
    UserAdminService userAdminService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/clear/mobile")
    @ResponseBody
    ResultApi<Boolean> clearMobile(Model model, CustomerMemberDto customerMemberDto, String env) {
        return userAdminService.clearMobile(customerMemberDto, env);
    }

    @GetMapping("/get/user")
    public String getUser(Model model, CustomerMemberDto customerMemberDto, String env) {
        PageInfo page = new PageInfo();
        page.setPageSize(10);
        if (customerMemberDto == null) {
            return "user/home";
        }
        if (env == null) {
            env = DataSourceSwith.TESTA;
        }
        TableResult<CustomerMemberDto> listUser = userAdminService.list(customerMemberDto, page, env);
        model.addAttribute("result", listUser);
        model.addAttribute("param", customerMemberDto);
        model.addAttribute("env", env);
        return "user/clear";
    }
}
