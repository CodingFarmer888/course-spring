package com.course.model;

public class TodoVo {

	/** 鍵值 */
	private Integer id;;
	
	/** 標題 */
	private String title;
	
	/** 到期日 */
	private String dueDate;
	
	/** 狀態 */
	private Integer status;
	
	/** 狀態 */
	private String statusDisp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusDisp() {
		return statusDisp;
	}

	public void setStatusDisp(String statusDisp) {
		this.statusDisp = statusDisp;
	}
}
