package co.ckpark.board.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.cjaprk.board.dto.BoardDto;
import co.cjaprk.board.serviceImpl.BoardServiceImpl;
import co.cjpark.board.service.BoardService;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	}
	public void mainMenu() {
		int choice;
		boolean b = true;
		do {
			System.out.println("==========ERP==========");
			System.out.println("       1.     전체목록보기      ");
//			System.out.println("       2.     게시글 보기    ");
//			System.out.println("       3.     게시글 작성    ");
//			System.out.println("       4.     게시글 수정    ");
//			System.out.println("       5.     게시글 삭제    ");
			System.out.println("       2.     종        료      ");
			System.out.println("=======================");
			System.out.println("원하는 메뉴 번호를 입력하세요.  ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				boardList();
				break;
			
			case 2:
				b = false;
				System.out.println("프로그램이 종료 되었습니다.");
				break;
			}
		} while (b);
	
	}
	private void boardDelete() {
		// TODO Auto-generated method stub
		
	}
	private void boardEdit() {
		// TODO Auto-generated method stub
		
	}
	private void boardWrite() {
		// TODO Auto-generated method stub
		
	}
	private void boardSearch(int key) {
		BoardService service = new BoardServiceImpl();
		BoardDto dto = new BoardDto();
		dto.setBoard_id(key);
		try {
			dto = service.select(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dto.toString();
		System.out.println("===============");
		System.out.println("돌아가려면 아무키나 입력하세요.");
		System.out.println("===============");
		String str = sc.nextLine();
		sc.nextLine();
	}
	private void boardList() {
		BoardService service = new BoardServiceImpl();
		List<BoardDto> list = new ArrayList<BoardDto>();
//		BoardDto sdto;
		try {
			list = service.allSelect();
			System.out.println("==순번====작성자=====작성일자====제   목====내   용===조회수==");
			for(BoardDto dto : list) {
				System.out.print(dto.getBoard_id() + " ");
				System.out.print(dto.getWriter() + " ");
				System.out.print(dto.getWdate() + " ");
				System.out.print(dto.getTitle() + " ");
//				System.out.print(dto.getSubject() + " ");
				System.out.println(dto.getHit() + " ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("===============");
		System.out.println("내용을 볼 순번을 입력하세요.");
		System.out.println("===============");
		int key = sc.nextInt();
		boardSearch(key);
		
		
//		sdto = new BoardDto();
//		sdto.setBoard_id(key);
//		try {
//			sdto = service.select(sdto);
//			sdto.toString();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("===============");
//		System.out.println("돌아가려면 아무키나 눌러...");
//		System.out.println("===============");
//		String str = sc.nextLine();
		
	}
	
}
