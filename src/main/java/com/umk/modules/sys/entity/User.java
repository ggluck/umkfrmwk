package com.umk.modules.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.umk.base.repository.IEntity;

@Entity
@Table(name="sys_user")
public class User extends IEntity{
	private static final long serialVersionUID = -7442180959544101750L;
	//用户名
    @NotBlank @Length(max=20)
    private String username;
    //用户昵称（姓名）
    @Length(max=20)
    private String nickname;
    //用户密码，这里是真密码，加密后存入数据库
    @Length(max=40)
    private String password;
    //性别，1表示男，2表示女，就两种类型，不是男就是女，所以不用关联到Category了，为了方便，category中ID为1设为男，ID为2的设为女
    private Integer sex;
    //用户邮箱
    @Length(max=20)
    private String email;
    //手机号码
     @Length(max=20)
    private String phone;
    //备注
    @Length(max=200)
    private String comment;
    //用户权限，用“，”号分隔的权限（角色）列表
    @Length(max=100)
    private String roles;
    //是否可用账号
    private Boolean enable;
    //注册日期
    private java.util.Date registerDate;
    //是否认证
    private Boolean isreal = false;
    @Column(name = "USER_NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 20)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String value) {
        this.username = value;
    }
    @Column(name = "NICKNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String value) {
        this.nickname = value;
    }
    @Column(name = "PASSWORD", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password = value;
    }
    @Column(name = "SEX", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer value) {
        this.sex = value;
    }
    @Column(name = "EMAIL", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String value) {
        this.email = value;
    }
    @Column(name = "PHONE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }
    @Column(name = "COMMENT", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
    public String getComment() {
        return this.comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }
    @Column(name = "ROLES", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
    public String getRoles() {
        return this.roles;
    }

    public void setRoles(String value) {
        this.roles = value;
       // genAuthorities();
    }
    @Column(name = "ENABLE", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean value) {
        this.enable = value;
    }

    @Column(name = "REGISTER_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 8)
    public java.util.Date getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(java.util.Date value) {
        this.registerDate = value;
    }
    @Column(name = "isreal", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
    public Boolean getIsreal() {
        return this.isreal;
    }
    public void setIsreal(Boolean value) {
        this.isreal = value;
    }
}
