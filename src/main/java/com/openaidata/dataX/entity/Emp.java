package com.openaidata.dataX.entity;

import java.util.Date;

public class Emp {

	private Integer empno;
	private String ename;
	private String job;
	private String mgr;
	private Date hiredate;
	private Float sal;
	private Float comm;
	private Integer deptno;
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String job) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Float getSal() {
		return sal;
	}
	public void setSal(Float sal) {
		this.sal = sal;
	}
	public Float getComm() {
		return comm;
	}
	public void setComm(Float comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer dname) {
		this.deptno = deptno;
	}

}
