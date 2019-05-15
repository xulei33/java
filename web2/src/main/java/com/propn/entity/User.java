package com.propn.entity;

import java.util.Date;

public class User {
    private Long id;

    private String answer;

    private String email;

    private String issue;

    private String mobile;

    private String password;

    private Long point;

    private Boolean realnameauthentication;

    private Date registrationdate;

    private String salt;

    private Integer state;

    private String username;

    private Integer userversion;

    private Long securitydigest;

    private String avatarname;

    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue == null ? null : issue.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Boolean getRealnameauthentication() {
        return realnameauthentication;
    }

    public void setRealnameauthentication(Boolean realnameauthentication) {
        this.realnameauthentication = realnameauthentication;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUserversion() {
        return userversion;
    }

    public void setUserversion(Integer userversion) {
        this.userversion = userversion;
    }

    public Long getSecuritydigest() {
        return securitydigest;
    }

    public void setSecuritydigest(Long securitydigest) {
        this.securitydigest = securitydigest;
    }

    public String getAvatarname() {
        return avatarname;
    }

    public void setAvatarname(String avatarname) {
        this.avatarname = avatarname == null ? null : avatarname.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}