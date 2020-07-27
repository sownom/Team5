package team.t.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import team.t.dto.BoardDTO;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {

		String dbURL = "jdbc:mysql://172.30.1.1:3306/team5";
		String dbID = "team1";
		String dbPassword = "team1";
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(dbURL, dbID, dbPassword);

	}
	// 글 작성
	public int boardinsert(BoardDTO board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "insert into board(BOAR_NO,MEM_ID_BOAR_TITLE_BOAR_CONT,BOAR_TIME,BOAR_COUN) values(?,?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,board.getBOAR_NO());
			pstmt.setString(2, board.getMEM_ID());
			pstmt.setString(3, board.getBOAR_TITLE());
			pstmt.setString(4, board.getBOAR_CONT());
			pstmt.setInt(4, 0);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return result;
	}

	// 글갯수
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select count(BOAR_NO,MEM_ID,BOAR_TITLE,BOAR_CONT,BOAR_COUN) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count(BOAR_NO,MEM_ID,BOAR_TITLE,BOAR_CONT,BOAR_COUN)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;

	}

	// 글목록
	public List<BoardDTO> list(HashMap<String, Object> listOp) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String op = (String) listOp.get("op");
		String sc = (String) listOp.get("sc");
		int startpage = (Integer) listOp.get("startpage");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			if (op == null) { // 전체글
				String sql = "select BOAR_NO,MEM_ID,BOAR_TITLE,BOAR_CONT,BOAR_COUN from ";
				sql += "(select from rownum rnum, BOARD_NO, MEM_ID, BOARD_TITLE,";
				sql += ", BOARD_CONT, BOARD_TIME, BOARD_COUN";
				sql += "from";
				sql += "(select * from board order by BOARD_NO)) ";
				sql += "where rnum>=? and rnum<=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startpage);
				pstmt.setInt(2, startpage + 19);
			} else if (op.equals("0")) { // 제목으로 검색
				String sql = "select BOAR_NO,MEM_ID,BOAR_TITLE,BOAR_CONT,BOAR_COUN from ";
				sql += "(select rownum rnum, BOARD_NO, MEM_ID, BOARD_TITLE,";
				sql += ", BOARD_CONT, BOARD_TIME, BOARD_COUN";
				sql += "from";
				sql += "(select * from board where BOARD_TITLE = ? ";
				sql += "order by BOARD_NO))";
				sql += "where rnum>=? and rnum<=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sc);
				pstmt.setInt(2, startpage);
				pstmt.setInt(3, startpage + 19);

			} else if (op.equals("1")) { // 내용으로 검색
				String sql = "select BOAR_NO,MEM_ID,BOAR_TITLE,BOAR_CONT,BOAR_COUN from ";
				sql += "(select rownum rnum, BOARD_NO, MEM_ID, BOARD_TITLE,";
				sql += ", BOARD_CONT, BOARD_TIME, BOARD_COUN";
				sql += "from";
				sql += "(select * from board where BOARD_CONT = ? ";
				sql += "order by BOARD_NO))";
				sql += "where rnum>=? and rnum<=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sc);
				pstmt.setInt(2, startpage);
				pstmt.setInt(3, startpage + 19);

			} else if (op.equals("2")) { // 제목+내용으로 검색
				String sql = "select BOAR_NO,MEM_ID,BOAR_TITLE,BOAR_CONT,BOAR_COUN from ";
				sql += "(select rownum rnum, BOARD_NO, MEM_ID, BOARD_TITLE,";
				sql += ", BOARD_CONT, BOARD_TIME, BOARD_COUN";
				sql += "from";
				sql += "(select * from board where BOARD_TITLE = ? or BOARD_CONT ";
				sql += "order by BOARD_NO))";
				sql += "where rnum>=? and rnum<=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sc);
				pstmt.setString(2, sc);
				pstmt.setInt(3, startpage);
				pstmt.setInt(4, startpage + 19);

			} else if (op.equals("3")) { // 아이디로 검색
				String sql = "select BOAR_NO,MEM_ID,BOAR_TITLE,BOAR_CONT,BOAR_COUN from ";
				sql += "(select rownum rnum, BOARD_NO, MEM_ID, BOARD_TITLE,";
				sql += ", BOARD_CONT, BOARD_TIME, BOARD_COUN";
				sql += "from";
				sql += "(select * from board where MEM_ID = ? ";
				sql += "order by BOARD_NO))";
				sql += "where rnum>=? and rnum<=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sc);
				pstmt.setInt(2, startpage);
				pstmt.setInt(3, startpage + 19);

			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBOAR_NO(rs.getInt("BOAR_NO"));
				board.setMEM_ID(rs.getString("MEM_ID"));
				board.setBOAR_TITLE(rs.getString("BOAR_TITLE"));
				board.setBOAR_CONT(rs.getString("BOAR_CONT"));
				board.setBOAR_TIME(rs.getDate("BOAR_TIME"));
				board.setBOAR_COUN(rs.getInt("BOAR_COUN"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return list;

	}

	// 조회수 증가
	public void countUpdate(int BOAR_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update board set BOAR_COUN=BOAR_COUN+1 where BOAR_NO=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, BOAR_NO);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

	}

	// 상세페이지
	public BoardDTO getCont(int BOAR_NO) {
		BoardDTO board = new BoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();

			String sql = "select BOAR_NO,MEM_ID,BOAR_TITLE,BOAR_CONT,BOAR_COUN from board where BOAR_NO=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, BOAR_NO);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board.setBOAR_NO(rs.getInt("BOAR_NO"));
				board.setMEM_ID(rs.getString("MEM_ID"));
				board.setBOAR_TITLE(rs.getString("BOAR_TITLE"));
				board.setBOAR_CONT(rs.getString("BOAR_CONT"));
				board.setBOAR_TIME(rs.getDate("BOAR_TIME"));
				board.setBOAR_COUN(rs.getInt("BOAR_COUN"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return board;
	}

/*	// 댓글 작성
	public int insertReply(int BOAR_NO) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "insert into board(COMM_NO,COMM_DATE,COMM_CONT) value(?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return result;
	}

	// 댓글 갯수
	public int regetCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "select count(COMM_NO,COMM_DATE,COMM_CONT) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count(COMM_NO,COMM_DATE,COMM_CONT)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;*/
	}

	

