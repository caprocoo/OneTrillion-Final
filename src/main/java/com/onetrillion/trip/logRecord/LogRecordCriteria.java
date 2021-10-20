package com.onetrillion.trip.logRecord;



public class LogRecordCriteria  {

	private int pageNum;
	private int amount;
	private String keyword;
	private String type;
	private String[] typeArr;
	public LogRecordCriteria() {
		this(1,5);
	}
	public LogRecordCriteria(int pageNum, int amount) {
		
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
		this.typeArr = type.split("");
	}
	public String[] getTypeArr() {
		return typeArr;
	}
	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}
	@Override
	public String toString() {
		return "LogRecordCriteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type="
				+ type + ", typeArr=" + typeArr + "]";
	}

	

}
