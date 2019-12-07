package com.itheima.crm.mapper;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {
    public Integer customerCountByQueryVo(QueryVo vo);
    public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
    public Customer selectCustomerById(Integer id);
    public void updateCustomerById(Customer customer);
    public void deleteCustomerById(Integer id);
}
