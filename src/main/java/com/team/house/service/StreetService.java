package com.team.house.service;

import com.team.house.domain.Street;

import java.util.List;

public interface StreetService {
   List<Street> getStreet(Integer districtId);
}
