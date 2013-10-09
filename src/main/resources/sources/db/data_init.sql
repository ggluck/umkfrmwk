insert into app_user(id,user_name,nickname,password,enable,email,phone,roles) values (1,'admin','纯管理员','ceb4f32325eda6142bd65215f4c0f371',true,'test@pl.com','13579246810','ROLE_USER,ROLE_ADMIN');
insert into app_user(id,user_name,nickname,password,enable,email,phone,roles) values (2,'user','纯屌丝','47a733d60998c719cf3526ae7d106d13',true,'tt@pl.com','13579111111','ROLE_USER');
insert into category_type(id,value,name) values (1,'性别','sex');
insert into category(id,value,name,type) values (1,'先生','men',1);
insert into category(id,value,name,type) values (2,'女士','women',1);