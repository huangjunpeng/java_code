package com.itheima.crm.service;

import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    //@Value("${page.size}")
    //private  Integer pageSize;

    @Autowired
    private CustomerMapper customerMapper;

    public Page<Customer> selectPageByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<Customer>();
        vo.setSize(5);
        page.setSize(5);
        if (null != vo){
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
            }
            if (null != vo.getCustName() && !"".equals(vo.getCustName().trim())) {
                vo.setCustName(vo.getCustName().trim());
            }
            if (null != vo.getCustSource() && !"".equals(vo.getCustName().trim())) {
                vo.setCustSource(vo.getCustSource().trim());
            }
            if (null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())) {
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if (null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())) {
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            page.setTotal(customerMapper.customerCountByQueryVo(vo));
            page.setRows(customerMapper.selectCustomerListByQueryVo(vo));
        }

        return page;
    }

    public Customer selectCustomerById(Integer id) {
        return customerMapper.selectCustomerById(id);
    }
    public void updateCustomerById(Customer customer) {
        customerMapper.updateCustomerById(customer);
    }

    public void deleteCustomerById(Integer id) {
        customerMapper.deleteCustomerById(id);
    }
}
