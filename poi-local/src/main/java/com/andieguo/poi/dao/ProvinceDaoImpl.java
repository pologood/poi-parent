package com.andieguo.poi.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.andieguo.poi.util.FileUtil;

public class ProvinceDaoImpl implements ProvinceDao {

	public List<String> findAll() throws JSONException {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		String result = FileUtil.readFile(getClass().getClassLoader().getResourceAsStream("province.json"));
		JSONObject jsonObj = new JSONObject(result);
		JSONArray array = jsonObj.getJSONArray("provinces");
		for(int i=0;i<array.length();i++){
			JSONObject obj = array.getJSONObject(i);
			list.add(obj.getString("name"));
		}
		return list;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProvinceDao provinceDao = (ProvinceDao) context.getBean("provinceDao");
		System.out.println(provinceDao.findAll().size());
	}

}
