package com.openaidata.dataX.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.openaidata.dataX.entity.Emp;
import com.openaidata.dataX.mapper.EmpMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmpService {
	@Resource
	private EmpMapper empMapper = null;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true )
	public Emp findById(Integer empno) {
		return empMapper.findById(empno);
		
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true )
	public List<LinkedHashMap> findDepts(String dname, Float sal) {
		Map param = new HashMap();
		param.put("pdname", dname);
		param.put("psal", sal);
		
		return empMapper.findDepts(param);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void create(Emp emp) {
		empMapper.create(emp);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void update(Emp emp) {
		empMapper.update(emp);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer empno) {
		empMapper.delete(empno);
	}
	

}
