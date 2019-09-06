package com.foo.myFinalApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.foo.myFinalApp.utils.SidebarPage;
import com.foo.myFinalApp.utils.SidebarPageConfig;

public class SidebarPageConfigImpl implements SidebarPageConfig {

	HashMap<String, SidebarPage> pageMap = new LinkedHashMap<String, SidebarPage>();

	public SidebarPageConfigImpl() {
		pageMap.put("fn1", new SidebarPage("create", "Create bouquet", "/imgs/create.png", ""));
		pageMap.put("fn2", new SidebarPage("delivery", "Delivery", "/imgs/flower-delivery.png", ""));
		pageMap.put("fn3", new SidebarPage("account", "Account", "/imgs/user.png", "account.zul"));
	}

	public List<SidebarPage> getPages() {
		return new ArrayList<SidebarPage>(pageMap.values());
	}

	public SidebarPage getPage(String name) {
		return pageMap.get(name);
	}
}
