package com.imooc.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

public class GoddessAction {

	public void add(Goddess goddess) throws Exception {
		GoddessDao dao = new GoddessDao();
		goddess.setSex(1);
		goddess.setIsdel(0);
		dao.addGoddess(goddess);
	}
	
	public Goddess get(Integer id) throws SQLException {
		GoddessDao dao = new GoddessDao();
		return dao.get(id);
	}
	
	public void edit(Goddess goddess) throws Exception {
		GoddessDao dao = new GoddessDao();
		dao.updateGoddess(goddess);
	}
	
	public void del(Integer id) throws SQLException {
		GoddessDao dao = new GoddessDao();
		dao.deleteGoddess(id);
	}
	
	public List<Goddess> query() throws Exception {//查询全部
		GoddessDao dao = new GoddessDao();
		return dao.query();
	}
	
	public List<Goddess> query(List<Map<String, Object>> params) throws Exception {
		GoddessDao dao = new GoddessDao();
		return dao.query(params);
	}
	
	public static void main(String[] args) throws Exception {
		
		GoddessDao g = new GoddessDao();
		
//		List<Goddess> result = g.query("小美","18712345678","xiao");
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "user_name");
		param.put("relation", "LIKE");
		param.put("value", "'%小美%'");//注意这里的单引号‘’，小美是以字符串的形式给到sql语句中的
		params.add(param);//这里List中只添加了一个Map，若有多个查询条件，就需要添加多个Map
		param = new HashMap<String, Object>();
		param.put("name", "mobile");
		param.put("relation", "=");
		param.put("value", "'18712345678'");//注意这里的单引号‘’
		params.add(param);
		param = new HashMap<String, Object>();
		param.put("name", "birthday");
		param.put("relation", "=");
		param.put("value", "'2017-05-01'");//注意这里的单引号‘’
		params.add(param);
		
		List<Goddess> result = g.query(params);
		
		for (Goddess goddess : result) {
			System.out.println(goddess.toString());
		}
		
//		Goddess g1 = new Goddess();
//		g1.setUser_name("小美");
//		g1.setSex(1);
//		g1.setAge(22);
//		g1.setBirthday(new Date());
//		g1.setEmail("xiaomei@imooc.com");
//		g1.setMobile("18712345678");
//		g1.setCreate_user("admin");
//		g1.setUpdate_user("admin");
//		g1.setIsdel(1);
		
//		g.deleteGoddess(2);
//		Goddess g2 = g.get(3);
//		System.out.println(g2.toString());
//		g.updateGoddess(g1);
//		g.addGoddess(g1);
		
//		List<Goddess> gs= g.query();
//		
//		for (Goddess goddess : gs) {
//			System.out.println(goddess.getUser_name()+","+goddess.getAge());
//		}
	}
}
