package com.manage.test;

import com.manage.pub.util.SpringUtil;
import com.manage. pub.vo.Staff;
import com.manage.spring.JdbcDao;

public class Test {
	public static void main(String arg[]){
		JdbcDao jdbcDao = (JdbcDao)SpringUtil.getInstance().getBean("jdbcDao");
		Staff staff = jdbcDao.getStaffInfo();
		System.out.println(staff.getStaffName());
	}

}
