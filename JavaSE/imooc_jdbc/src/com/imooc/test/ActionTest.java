package com.imooc.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imooc.action.GoddessAction;
import com.imooc.model.Goddess;

public class ActionTest {

	public static void main(String[] args) throws Exception {
		GoddessAction action = new GoddessAction();
		
		/*//查询
		List<Goddess> result = action.query();
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId()+":"+result.get(i).getUser_name());
		}*/
		
		/*//添加
		Goddess g = new Goddess();
		
		g.setUser_name("小青");
		g.setAge(25);
		g.setSex(1);
		g.setBirthday(new Date());
		g.setEmail("xiaoqin@163.com");
		g.setMobile("13788888888");
		g.setIsdel(0);
		
		action.add(g);*/
		
		/*//修改
		Goddess g = new Goddess();
		
		g.setUser_name("小青1");
		g.setAge(25);
		g.setSex(1);
		g.setBirthday(new Date());
		g.setEmail("xiaoqin@163.com");
		g.setMobile("13788888888");
		g.setIsdel(0);
		g.setId(5);
		
		action.edit(g);*/
		
		/*//删除
		action.del(5);*/
		
		//条件查询
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "user_name");
		map.put("relation", "=");
		map.put("value", "'小美'");
		params.add(map);
		
		List<Goddess> result = action.query(params);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId()+":"+result.get(i).getUser_name());
		}
	}

}
