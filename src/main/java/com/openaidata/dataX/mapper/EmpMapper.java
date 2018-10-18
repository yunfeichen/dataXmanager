package com.openaidata.dataX.mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.openaidata.dataX.entity.Emp;

@Mapper
public interface EmpMapper {
	
	public Emp findById(Integer empno);
	
	public List<LinkedHashMap> findDepts(Map param);
	
	public void create(Emp emp);
	
	public void update(Emp emp);
	
	public void delete(Integer empno);
	

}
