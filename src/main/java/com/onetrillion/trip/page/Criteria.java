package com.onetrillion.trip.page;

public interface Criteria {

	void setPage(int page);

	void setPerPageNum(int perPageNum);

	int getPage();

	int getPageStart();

	int getPerPageNum();

	String toString();

	int getRowStart();

	int getRowEnd();

}