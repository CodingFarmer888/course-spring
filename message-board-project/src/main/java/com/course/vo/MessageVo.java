package com.course.vo;

import java.util.Date;

public class MessageVo {
	
	/** 留言者 */
	private String name;
	
	/** 主題 */
	private String subTitle;
	
	/** 序號 */
	private Integer seq;
	
	/** 內容 */
	private String content;
	
	/** 更新時間 */
	private Date updateTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
