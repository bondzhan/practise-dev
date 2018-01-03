package org.bond.transaction.model;

import java.util.Date;

public class User {

	private int fuid;
	private String fmobile;
	private String funame;
	private String fpasswd;
	private int fstatus;
	private String femail;
	private Date fcreateTime;
	private Date fmodifyTime;

	public int getFuid() {
		return fuid;
	}

	public void setFuid(int fuid) {
		this.fuid = fuid;
	}

	public String getFmobile() {
		return fmobile;
	}

	public void setFmobile(String fmobile) {
		this.fmobile = fmobile;
	}

	public String getFuname() {
		return funame;
	}

	public void setFuname(String funame) {
		this.funame = funame;
	}

	public String getFpasswd() {
		return fpasswd;
	}

	public void setFpasswd(String fpasswd) {
		this.fpasswd = fpasswd;
	}

	public int getFstatus() {
		return fstatus;
	}

	public void setFstatus(int fstatus) {
		this.fstatus = fstatus;
	}

	public String getFemail() {
		return femail;
	}

	public void setFemail(String femail) {
		this.femail = femail;
	}

	public Date getFcreateTime() {
		return fcreateTime;
	}

	public void setFcreateTime(Date fcreateTime) {
		this.fcreateTime = fcreateTime;
	}

	public Date getFmodifyTime() {
		return fmodifyTime;
	}

	public void setFmodifyTime(Date fmodifyTime) {
		this.fmodifyTime = fmodifyTime;
	}

}