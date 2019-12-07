package com.itheima.crm.controller;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @Value(value = "${dict.from}")
    private String dictFrom;

    @Value(value = "${dict.industry}")
    private String dictIndustry;

    @Value(value = "${dict.level}")
    private String dictLevel;

    @RequestMapping("/list.action")
    public String getItem(QueryVo vo, Model model) {
        // 客户来源
        List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode(dictFrom);
        // 所属行业
        List<BaseDict> industryType = this.baseDictService.queryBaseDictByDictTypeCode(dictIndustry);
        // 客户级别
        List<BaseDict> levelType = this.baseDictService.queryBaseDictByDictTypeCode(dictLevel);

        // 把前端页面需要显示的数据放到模型中
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        Page<Customer> page = customerService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("custName", vo.getCustName());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevel", vo.getCustLevel());


        return "customer";
    }


    @RequestMapping(value = "edit.action")
    public @ResponseBody Customer edit(Integer id) {
        return customerService.selectCustomerById(id);
    }

    @RequestMapping(value = "update.action")
    public @ResponseBody String update(Customer customer) {
        customerService.updateCustomerById(customer);
        return "OK";
    }

    @RequestMapping(value = "delete.action")
    public @ResponseBody String delete(@RequestParam(value = "id") Integer cust_id) {
        customerService.deleteCustomerById(cust_id);
        return "OK";
    }
}
