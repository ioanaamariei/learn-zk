package com.foo.myFinalApp;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

import com.foo.myFinalApp.utils.SidebarPage;
import com.foo.myFinalApp.utils.SidebarPageConfig;

public class SidebarViewModel {

	private SidebarPageConfig pageConfig = new SidebarPageConfigImpl();

	public List<SidebarPage> getSidebarPages() {
		return pageConfig.getPages();
	}

	@Command
	public void navigate(@BindingParam("page") SidebarPage page) {
		Executions.getCurrent().sendRedirect(page.getUri());
	}
}