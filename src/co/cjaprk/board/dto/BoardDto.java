package co.cjaprk.board.dto;

import java.sql.Date;

public class BoardDto {
	private int board_id;
	private String writer;
	private Date wdate;
	private String title;
	private String subject;
	private int hit;
	
	public BoardDto() {				 //기본생성자

		/*생성자 2개 만드는 이유 : 기본생성자가 있어야, 밑에서 만든 값 4개 넣는 생성자 형식에 고정되지 않고 데이터 넣을수 있다
		기본생성자 안만들어 놓으면 나중에 6개 짜리 데이터를 넣을 방법이 없다 */
		
	}
	
	public BoardDto(int id, String writer, String title, String subject) {			//기본생성자2
		this.board_id = id;
		this.writer = writer;
		this.title = title;
		this.subject = subject;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String toString() {
		System.out.println("순번 : " + board_id);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일자 : " + wdate);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + subject);
		System.out.println("조회수 : " + hit);
		return null;
	}
	
	
}
