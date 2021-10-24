package com.onetrillion.trip.admin;


public class BoardUpFile {


	//이 아래는 첨부된 첨부파일 내용
	private String boardFileName;
	private String boardFilePath;
	private String boardFileSize;
	private String boardFileDate;
	private String boardFileExpire;
	private Integer boardFileSeq;

	public Integer getBoardFileSeq() {
		return boardFileSeq;
	}
	public void setBoardFileSeq(Integer boardFileSeq) {
		this.boardFileSeq = boardFileSeq;
	}
	public String getBoardFileName() {
		return boardFileName;
	}
	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}
	public String getBoardFilePath() {
		return boardFilePath;
	}
	public void setBoardFilePath(String boardFilePath) {
		this.boardFilePath = boardFilePath;
	}
	public String getBoardFileSize() {
		return boardFileSize;
	}
	public void setBoardFileSize(String boardFileSize) {
		this.boardFileSize = boardFileSize;
	}
	public String getBoardFileDate() {
		return boardFileDate;
	}
	public void setBoardFileDate(String boardFileDate) {
		this.boardFileDate = boardFileDate;
	}
	public String getBoardFileExpire() {
		return boardFileExpire;
	}
	public void setBoardFileExpire(String boardFileExpire) {
		this.boardFileExpire = boardFileExpire;
	}
}


