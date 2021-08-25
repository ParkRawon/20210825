package co.micol.test.member.service;

import java.util.List;

import co.micol.test.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);  //한사람의 리스트 가져오기 
	MemberVO memberLoginCheck(MemberVO vo); //로그인체크
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	

}
