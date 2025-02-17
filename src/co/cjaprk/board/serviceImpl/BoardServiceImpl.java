package co.cjaprk.board.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.cjaprk.board.dto.BoardDto;
import co.cjpark.board.service.BoardService;

public class BoardServiceImpl extends BoardService {
	private PreparedStatement psmt;
	private ResultSet rs;
	private BoardDto dto;
		
	private final String ALL_SELECT = "SELECT * FROM BOARD";
	private final String SELECT = "SELECT * FROM BOARD WHERE BOARD_ID=?";
	private final String INSERT = "INSERT INTO BOARD (BOARD_ID, WRITER, TITLE, SUBJECT) VALUES (?,?,?,?)";
	private final String UPDATE = "UPDATE BOARD SET SUBJECT = ? WHERE BOARD_ID =?"; 
	private final String DELETE = "DELETE FROM BOARD WHERE BOARD_ID=?"; 
	
	@Override
	public List<BoardDto> allSelect() throws SQLException {
		List<BoardDto> list = new ArrayList<BoardDto> ();
		psmt = conn.prepareStatement(ALL_SELECT);
		rs = psmt.executeQuery();
		while(rs.next()) {
			dto = new BoardDto();
			dto.setBoard_id(rs.getInt("board_id"));
			dto.setWriter(rs.getString("writer"));
			dto.setWdate(rs.getDate("wdate"));
			dto.setTitle(rs.getString("title"));
			dto.setSubject(rs.getString("subject"));
			dto.setHit(rs.getInt("hit"));
			list.add(dto);
		}
		return list;
	}

	@Override
	public BoardDto select(BoardDto dto) throws SQLException {
		psmt = conn.prepareStatement(SELECT);
		psmt.setInt(1, dto.getBoard_id());
		rs = psmt.executeQuery();
		if(rs.next()) {
			dto.setBoard_id(rs.getInt("board_id"));
			dto.setWriter(rs.getString("writer"));
			dto.setWdate(rs.getDate("wdate"));
			dto.setTitle(rs.getString("title"));
			dto.setSubject(rs.getString("subject"));
			dto.setHit(rs.getInt("hit"));
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) throws SQLException {
		psmt=conn.prepareStatement(INSERT);
		psmt.setInt(1, dto.getBoard_id());
		psmt.setString(2, dto.getWriter());
		psmt.setString(3, dto.getTitle());
		psmt.setString(4, dto.getSubject());
		int n = psmt.executeUpdate();
				
		return n;
	}

	@Override
	public int delete(BoardDto dto) throws SQLException {
		psmt = conn.prepareStatement(DELETE);
		psmt.setInt(1, dto.getBoard_id());
		int n = psmt.executeUpdate();
				
		return n;
	}

	@Override
	public int update(BoardDto dto) throws SQLException {
		psmt=conn.prepareStatement(UPDATE);
		psmt.setString(1, dto.getSubject());
		psmt.setInt(2, dto.getBoard_id());
		int n = psmt.executeUpdate();
		
		return n;
	}

}
