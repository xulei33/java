package org.xulei.url;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Url model.
 *
 * @author Lei
 */
@XmlRootElement(name = "url")
@XmlAccessorType(XmlAccessType.FIELD)
public class Url {
	
	 @XmlTransient
    private long urlId;
	 
	 @XmlElement(name = "code")
    private String code;
    
    private String longUrl;
    
    @XmlTransient
    private Date createTime;
    
    private int sysId;
    
    private String custId; //varchar2(32)
    
    private String traceCode;
    
    public int getSysId() {
		return sysId;
	}
	public void setSysId(int sysId) {
		this.sysId = sysId;
	}
	
	public long getUrlId() {
		return urlId;
	}
	public void setUrlId(long urlId) {
		this.urlId = urlId;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
   
}
