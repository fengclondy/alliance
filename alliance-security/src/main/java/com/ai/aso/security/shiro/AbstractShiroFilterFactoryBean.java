package com.ai.aso.security.shiro;

import com.ai.aso.security.model.AccessStrategy;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public abstract class AbstractShiroFilterFactoryBean extends
		ShiroFilterFactoryBean {

	Logger logger = LoggerFactory
			.getLogger(AbstractShiroFilterFactoryBean.class);

	private AbstractShiroFilter instance;

	public AbstractShiroFilterFactoryBean() {
		super();
	}

	@Override
	public Object getObject() throws Exception {
		if (instance == null) {
			instance = createInstance();
		}
		return instance;
	}

	@Override
	protected AbstractShiroFilter createInstance() throws Exception {
		// 调用父类的创建方法
		AbstractShiroFilter shiroFilter = super.createInstance();
		PathMatchingFilterChainResolver chainResolver = (PathMatchingFilterChainResolver) shiroFilter
				.getFilterChainResolver();
		DefaultFilterChainManager chainManager = (DefaultFilterChainManager) chainResolver
				.getFilterChainManager();
		preHandleFilterChain(chainManager);
		postHandleFilterChain(chainManager);
		return shiroFilter;
	}

	/**
	 * 去除之前全匹配配置<br>
	 * 全匹配配置必须要放在最后面，否则会拦住其它配置
	 * 
	 * @param chainManager
	 */
	protected void preHandleFilterChain(DefaultFilterChainManager chainManager) {
		Map<String, NamedFilterList> filterChains = chainManager
				.getFilterChains();
		String allMatch = "/**";
		if (filterChains.containsKey(allMatch)) {
			logger.trace("去除之前加载的/**路径拦截器链");
			filterChains.remove(allMatch);
		}
	}

	/**
	 * 加载资源访问策略
	 * 
	 * @param chainManager
	 */
	protected void postHandleFilterChain(DefaultFilterChainManager chainManager) {
		// 加载权限过滤器链
		loadFilterChain(chainManager);
		// 所有URL都必须授权才允许访问
		chainManager.addToChain("/**", "perms", "unauthorized");
	}

	protected void loadFilterChain(DefaultFilterChainManager chainManager) {
		List<AccessStrategy> strategies = findAllAccessStrategy();
		if (strategies == null || strategies.isEmpty()) {
			logger.warn("AccessStrategyList is null!");
			return;
		}

		// 加载配置的过滤器
		for (AccessStrategy strategy : strategies) {
			String url = strategy.getUrl();
			if (url == null || "".equals(url)) {
				logger.warn("url in strategy is null!");
				continue;
			}
			if (!url.startsWith("/")) {
				url = "/".concat(url);
			}

			// 加载身份验证相关拦截器链
			String authc = strategy.getAuthc();
			if (!(authc == null || "".equals(authc))) {
				logger.trace("加载身份认证相关的URL拦截器配置");
				String[] authcArray = authc.split(",");
				for (String auth : authcArray) {
					chainManager.addToChain(url, auth);
				}
			}

			// 加载role filter
			String role = strategy.getRole();
			if (!(role == null || "".equals(role))) {
				logger.trace("加载配置角色的URL拦截器链");
				chainManager.addToChain(url, "roles", role);
			}

			// 加载perm filter
			String perm = strategy.getPermission();
			if (!(perm == null || "".equals(perm))) {
				logger.trace("加载配置权限的URL拦截器链");
				chainManager.addToChain(url, "perms", perm);
			}
		}
	}

	/**
	 * 查找子系统需要鉴权URL列表
	 * 
	 * @return
	 */
	protected abstract List<AccessStrategy> findAllAccessStrategy();

}
