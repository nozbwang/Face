package com.zbwang.face.dao.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.zbwang.face.dao.IParamDao;
import com.zbwang.face.domain.Parameter;

@Component
public class ParamCache implements InitializingBean {

	@Autowired
	private IParamDao faceBaseParameterDAO;

	private static LoadingCache<String, List<Parameter>> cacheBuilder;

	private static Map<String, List<Parameter>> baseParameterTypeMap = new HashMap<String, List<Parameter>>();

	private static Map<Integer, Parameter> baseParameterMap = new HashMap<Integer, Parameter>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		cacheBuilder = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES)
				.build(new CacheLoader<String, List<Parameter>>() {
					@Override
					public List<Parameter> load(String key) throws Exception {
						return faceBaseParameterDAO.getAllBaseParameter();
					}
				});
	}

	private static void clear() {
		baseParameterTypeMap.clear();
		baseParameterMap.clear();
	}

	public static List<Parameter> getBaseParameter(String t) throws ExecutionException {
		List<Parameter> baseParameterGroup = cacheBuilder.get("");
		clear();
		if (CollectionUtils.isNotEmpty(baseParameterGroup)) {
			for (Parameter baseParameter : baseParameterGroup) {
				baseParameterMap.put(baseParameter.getId(), baseParameter);
				String type = baseParameter.getType();
				if (baseParameterTypeMap.containsKey(type)) {
					baseParameterTypeMap.get(type).add(baseParameter);
				} else {
					List temp = new ArrayList<Parameter>();
					temp.add(baseParameter);
					baseParameterTypeMap.put(type, temp);
				}
			}
		}
		return baseParameterTypeMap.get(t);
	}

	public static Parameter getBaseParameter(String type, String nameEn) throws ExecutionException {
		List<Parameter> baseParameters = getBaseParameter(type);
		if (CollectionUtils.isNotEmpty(baseParameters)) {
			for (Parameter baseParameter : baseParameters) {
				if (baseParameter.getNameEn().equals(nameEn)) {
					return baseParameter;
				}
			}
		}
		return null;
	}

	public static Integer getBaseParameterId(String type, String nameEn) throws ExecutionException {
		Parameter faceBaseParameter = getBaseParameter(type, nameEn);
		if (faceBaseParameter != null) {
			return faceBaseParameter.getId();
		}
		return null;
	}

}