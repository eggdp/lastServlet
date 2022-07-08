package dao;

import java.util.List;

import dto.Menu;

public interface MenuDao {
	// 데이터 넣기
	public void insert(Menu menu); // 가져온 데이터 입력
	// 데이터 전체 검색
	public List<Menu> selectAll(); // 여러 데이터 리스트값
	// 데이터 메뉴 검색
	public Menu selectOne(); // 하나의 데이터
	// 데이터 업데이트
	public void update(Menu menu); // 가져 온 데이터 변경
	// 데이터 랜덤 추첨 검색
	public Menu selectBest();
	// 데이터 삭제
	public void delete(int id);

}
