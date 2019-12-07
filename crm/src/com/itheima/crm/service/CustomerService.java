package com.itheima.crm.service;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.utils.Page;

public interface CustomerService {
    public Page<Customer> selectPageByQueryVo(QueryVo vo);
    public Customer selectCustomerById(Integer id);
    public void updateCustomerById(Customer customer);
    public void deleteCustomerById(Integer id);
}
