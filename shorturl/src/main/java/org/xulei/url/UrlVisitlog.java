package org.xulei.url;

import java.util.Date;

/**
 * UrlVisitlog model.
 *
 * @author Lei
 */
public class UrlVisitlog {
	
    private String code;
    private int sysId;
    private String custId; //varchar2(32)
    private String traceCode;
    private Date visitTime;
    private String ip;
    private String userAgent;
    private String cookie;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getSysId() {
		return sysId;
	}
	public void setSysId(int sysId) {
		this.sysId = sysId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getTraceCode() {
		return traceCode;
	}
	public void setTraceCode(String traceCode) {
		this.traceCode = traceCode;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
    
    
}
