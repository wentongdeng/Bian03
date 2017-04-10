package com.it.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.springframework.transaction.annotation.Transactional;

import com.it.entity.Massage;
import com.it.entity.MassageDAO;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Transactional
public class MassageAction extends ActionSupport {
		/**
	 * 
	 */
	private static final long serialVersionUID = -1001489269019679562L;
		MassageDAO massageDao;
		
		public MassageDAO getMassageDao() {
			return massageDao;
		}
		public void setMassageDao(MassageDAO massageDao) {
			this.massageDao = massageDao;
		}
		public String queryJson(){
			HashMap<String, Object> pageMap = new HashMap<String, Object>();  
			//JsonConfig jsonConfig = new JsonConfig();
			//jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			List<Massage> massageList=massageDao.findAll();
			System.out.println(massageList);
			//JSONArray jsonArray = JSONArray.fromObject(massageList);
			String json;
			try {
				json = listToJson(massageList);
				pageMap.put("massage", json);
				return "jsonMap";
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "faile";
		}
		public String listToJson(List<Massage> list) throws JSONException  
		{  
		   // json数组  
		   JSONArray array = new JSONArray();  
		    
		   // 获取列数  
		   JSONArray json = new JSONArray();
           for(Massage a : list){
               JSONObject jo = new JSONObject();
               jo.put("id", a.getId());
               jo.put("title", a.getTitle());
               jo.put("desc", a.getText());
               jo.put("like", a.getLike());
               jo.put("time", a.getTime());
               jo.put("user", a.getUser().getName());
               json.add(jo);
           }
           System.out.println(json.toString());
           return json.toString();
		}  
}
