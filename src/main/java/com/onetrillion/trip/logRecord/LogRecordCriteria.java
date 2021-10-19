package com.onetrillion.trip.logRecord;

import com.onetrillion.trip.page.Criteria;

public class LogRecordCriteria implements Criteria {
	
	private int page;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	
	
	 public LogRecordCriteria()
	 {
	  this.page = 1;
	  this.perPageNum = 10;
	 }

	 @Override
	public void setPage(int page)
	 {
	  if (page <= 0)
	  {
	   this.page = 1;
	   return;
	  }
	  this.page = page;
	 }

	 @Override
	public void setPerPageNum(int perPageNum)
	 {
	  if (perPageNum <= 0 || perPageNum > 100)
	  {
	   this.perPageNum = 10;
	   return;
	  }
	  this.perPageNum = perPageNum;
	 }

	 @Override
	public int getPage()
	 {
	  return page;
	 }

	 @Override
	public int getPageStart()
	 {
	  return (this.page - 1) * perPageNum;
	 }

	 @Override
	public int getPerPageNum()
	 {
	  return this.perPageNum;
	 }

	 @Override
	 public String toString() {
	  return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ""
	    + ", rowStart=" +  getRowStart() + ", rowEnd=" + getRowEnd()
	    + "]";
	 }

	 @Override
	public int getRowStart() {
	  rowStart = ((page - 1) * perPageNum) + 1;
	  return rowStart;
	 }

	 @Override
	public int getRowEnd() {
	  rowEnd = rowStart + perPageNum - 1;
	  return rowEnd;
	 }
	
}
