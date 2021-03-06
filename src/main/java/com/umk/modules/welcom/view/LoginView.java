package com.umk.modules.welcom.view;


import com.umk.base.vaadin.BaseCustomComponent;
import com.umk.modules.sys.entity.User;
import com.umk.modules.sys.service.UserService;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginView extends BaseCustomComponent {

	@AutoGenerated
	private VerticalLayout mainLayout;
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	public final static int LOGIN_SUCESS = 0; 
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public LoginView() {
//		super(null);
		buildMainLayout();
		setCompositionRoot(mainLayout);

		final CssLayout loginPanel = new CssLayout();
		loginPanel.addStyleName("login-panel");

		HorizontalLayout labels = new HorizontalLayout();
		labels.setWidth("100%");
		labels.setMargin(true);
		labels.addStyleName("labels");
		loginPanel.addComponent(labels);

		Label welcome = new Label("Welcome");
		welcome.setSizeUndefined();
		welcome.addStyleName("h4");
		labels.addComponent(welcome);
		labels.setComponentAlignment(welcome, Alignment.MIDDLE_LEFT);

		Label title = new Label("Umk FrameWork");
		title.setSizeUndefined();
		title.addStyleName("h2");
		title.addStyleName("light");
		labels.addComponent(title);
		labels.setComponentAlignment(title, Alignment.MIDDLE_RIGHT);

		HorizontalLayout fields = new HorizontalLayout();
		fields.setSpacing(true);
		fields.setMargin(true);
		fields.addStyleName("fields");

		final TextField username = new TextField("用户名");
		username.setValue("admin");
		username.focus();
		fields.addComponent(username);

		final PasswordField password = new PasswordField("密   码");
		password.setValue("111");
		fields.addComponent(password);


		final Button signin = new Button("登   录");
		signin.addStyleName("default");
		fields.addComponent(signin);
		fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);

		
		final ShortcutListener enter = new ShortcutListener("登   录",KeyCode.ENTER, null) {
			@Override
			public void handleAction(Object sender, Object target) {
				signin.click();
			}
		};
		signin.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				
				User u = $(UserService.class).login(username.getValue(), password.getValue());
				if(u!=null){
					if(callBack != null){
						callBack.onCallBack(LOGIN_SUCESS,u);
					}	
				}else{
					Notification.show("用户名或密码错误。", Type.WARNING_MESSAGE);
				}
			}
		});
		signin.addShortcutListener(enter);
		password.addShortcutListener(enter);
		loginPanel.addComponent(fields);
		mainLayout.addComponent(loginPanel);
		mainLayout.setComponentAlignment(loginPanel,Alignment.MIDDLE_CENTER);
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setStyleName("login-layout");
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		return mainLayout;
	}
	
}
