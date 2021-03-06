package com.team.house.service.impl;

import com.team.house.domain.Street;
import com.team.house.domain.StreetExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.StreetService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;
    @Override
    public List<Street> getStreet(Integer districtId) {
        StreetExample streetExample=new StreetExample();
        //添加查询条件
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(districtId);
        List<Street> list = streetMapper.selectByExample(streetExample);
        return list;
    }
}
