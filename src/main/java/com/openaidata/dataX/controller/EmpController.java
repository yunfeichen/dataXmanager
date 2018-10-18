package com.openaidata.dataX.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openaidata.dataX.entity.Emp;
import com.openaidata.dataX.service.EmpService;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin;

@RestController
public class EmpController {
	@Resource
	private EmpService empService = null;
	
	@RequestMapping("/emp/{id}")
	public Emp findById(@PathVariable("id") Integer id) {
		return empService.findById(id);
		
	}
	
	@RequestMapping("/emp/list")
	public List<LinkedHashMap> findDepts(String dname, Float sal) {
		List<LinkedHashMap> list = empService.findDepts(dname,sal);
		return list;
	}
	
	@RequestMapping("/emp/create")
	public Emp create() {
		Emp emp = new Emp();
		emp.setSal(1000f);
		emp.setComm(0f);
		emp.setDeptno(30);
		emp.setEname("chenyunfei");
		emp.setHiredate(new Date());
		emp.setJob("Engineer");
		emp.setMgr(null);
		empService.create(emp);
		return emp;
	}
	
	@RequestMapping("/emp/imp")
	@Transactional(rollbackFor = Exception.class)
	public void imp() {
		for (int i = 0; i < 10; i++) {
			Emp emp = new Emp();
			if (i == 3) {
				throw new RuntimeException("鎴戝嚭閿欎簡锛�");
				
			}
			emp.setSal(i * 1000f);
			emp.setComm(0f);
			emp.setDeptno(30);
			emp.setEname("chenyunfei" + i);
			emp.setHiredate(new Date());
			emp.setJob("Engineer");
			emp.setMgr(null);
			empService.create(emp);
		}
	}
	
	@RequestMapping("/emp/update")
	public Emp update() {
		Emp emp = empService.findById(1);
		emp.setSal(emp.getSal() * 2);
		empService.update(emp);
		return emp;
	}
	
	@RequestMapping("/emp/delete/{empno}")
	public String delete(@PathVariable("empno") Integer empno) {
		empService.delete(empno);
		return "Delete success";
	}

}
