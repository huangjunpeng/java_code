package com.itheima.crm.service;

import com.itheima.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
