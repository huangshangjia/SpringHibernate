package com.manage.spring;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.manage.pub.vo.Staff;

public class JdbcDao {
	private JdbcTemplate jdbcTemplate;

	public Staff getStaffInfo() {
		String sql = "select staff_id,staff_code,staff_name,staff_pwd,department_id from staff where 1=1";
		List<Map<String, Object>> returnList = jdbcTemplate.queryForList(sql);
		if (returnList.size() == 0) {
			return null;
		} else {
			Staff staff = new Staff();
			Map<String, Object> map = returnList.get(0);
			staff.setStaffCode((String)map.get("staff_code"));
			staff.setStaffName((String)map.get("staff_name"));
			staff.setStaffPwd((String)map.get("staff_pwd"));

			return staff;
		}
	}

    public void init(){
        System.out.println("===========================DAO INIT===========================================");
    }

    public void cleanup(){
        System.out.println("===========================DAO DESTROY===========================================");
    }

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
