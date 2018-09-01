package com.ai.aso.common.param;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.aso.common.param.service.ParamLoader;

public class ParamLoadManager {

	Logger logger = LoggerFactory.getLogger(ParamLoadManager.class);

	private Map<String, ParamLoader> loaderMap;

	public void registerLoader(String loaderClass, ParamLoader loader) {
		if (this.loaderMap == null) {
			this.loaderMap = new HashMap<String, ParamLoader>();
		}
		this.loaderMap.put(loaderClass, loader);
	}

	public Map<String, ParamLoader> getLoaderMap() {
		return loaderMap;
	}

	public void setLoaderMap(Map<String, ParamLoader> loaderMap) {
		this.loaderMap = loaderMap;
	}

	/**
	 * 初始化系统参数
	 */
	public void initParam() {
		if (ensureReloderMap()) {
			Set<String> keySet = loaderMap.keySet();
			for (String loaderKey : keySet) {
				ParamLoader loader = loaderMap.get(loaderKey);
				logger.trace("初始化参数装载器：{}", loaderKey);
				if (loader != null) {
					loader.init();
				}
			}
		}
	}

	/**
	 * 重新加载某类参数的所有参数类别
	 * 
	 * @param loaderKey
	 */
	public void reloadParam(String loaderKey) {
		if (ensureReloderMap()) {
			ParamLoader loader = loaderMap.get(loaderKey);
			if (loader != null) {
				logger.trace("重新加载此装载器：", loaderKey);
				loader.reloadAll();
			} else {
				logger.error("无此装载器：{}", loaderKey);
			}
		}
	}

	/**
	 * 重新加载某参数组的某参数
	 * 
	 * @param loaderKey
	 * @param paramKey
	 */
	public void reloadParam(String loaderKey, String paramKey) {
		if (ensureReloderMap()) {
			ParamLoader loader = loaderMap.get(loaderKey);
			if (loader != null) {
				logger.trace("重新加载此装载器：", loaderKey);
				loader.reload(paramKey);
			} else {
				logger.error("无此装载器：{}", loaderKey);
			}
		}
	}

	private boolean ensureReloderMap() {
		if (loaderMap == null) {
			logger.error("ParamLoadManager is not init!");
			return false;
		}
		return true;
	}

}
