package com.umk.modules.welcom;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.umk.base.exception.UConverterFactory;
import com.umk.base.exception.UErrorHandler;
import com.umk.base.vaadin.BaseCustomComponent;
import com.umk.base.vaadin.BaseUI;
import com.umk.modules.welcom.view.LoginView;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
//import org.springframework.context.annotation.Scope;
@Theme("dashboard")
@Component
//@Scope("request")
@PreserveOnRefresh
@SuppressWarnings("serial")
public class WelcomUI extends BaseUI{
	
	CssLayout root = new CssLayout();
	@Override
	protected void init(VaadinRequest request) {
		Page.getCurrent().setTitle("umk后台管理系统");
		getSession().setConverterFactory(new UConverterFactory());
		getSession().setErrorHandler(new UErrorHandler());
		
		setLocale(Locale.CHINESE);
		setContent(root);
		root.addStyleName("root");
		root.setSizeFull();

		// Unfortunate to use an actual widget here, but since CSS generated
		// elements can't be transitioned yet, we must
		Label bg = new Label();
		bg.setSizeUndefined();
		bg.addStyleName("login-bg");
		root.addComponent(bg);
		//创建登录视图。
		LoginView loginView = new LoginView();
		loginView.setCallBack(new BaseCustomComponent.CallBack() {
			@Override
			public void onCallBack(int type,Object obj) {
				if(type == LoginView.LOGIN_SUCESS){
					Notification.show("登录成功。", Type.WARNING_MESSAGE);
				}
			}
		});
		root.addComponent(loginView);
	}
	@PostConstruct
	void initService(){
		//this.getClass().
		//SpringApplicationContext.getApplicationContext().getBean(arg0)
	}
}
