package com.jing.sszyt2.Json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class JsonUtil {
	public List<Map<String,String>> StringFromJson (String jsondata)
	{     
		Type listType = new TypeToken<List<Map<String,String>>>(){}.getType();
		Gson gson=new Gson();
		ArrayList<Map<String,String>> list=gson.fromJson(jsondata, listType);
		return list;

	}
}
