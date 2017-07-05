package cn.open.boot.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Transient;

import java.util.Date;

/**
 * Mongo user entity
 * <p>
 * Created by qianlu on 2017/7/5.
 */
@Entity(value = "user", noClassnameStored = true)
public class User {

    private static final long serialVersionUID = -1655240273308365567L;

    public static final Integer SEX_NKNOWN = 0;         //未知性别
    public static final Integer SEX_M = 1;              //男性
    public static final Integer SEX_F = 2;              //女性

    public static final Integer STATUS_USING = 0;       //默认用户状态启用
    public static final Integer STATUS_UNUSE = 1;       //禁用

    @Id
    private String id;
    private String username;            //登陆名
    private String password;            //密码
    private String realName;            //显示名
    private Integer sex;                //性别
    private String email;               //邮箱
    private String phone;               //电话
    private String countryCode;         //国家编码
    private String cityCode;            //所在城市编码
    private String icon;                //头像
    private Integer status;             //状态

    private String roleId;              //角色ID
    private Date createDate;            //创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}