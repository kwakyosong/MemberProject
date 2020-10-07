package com.hk.member.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hk.member.dto.MemberVO;

@Repository
public interface MemberMapper {
	
	// CRUD를 구현한다. (C:Create , R:Read or Retrieve , U : Update , D : Delete)
	// 1. 전체 리스트
	//@Select("select * from members")
	public List<MemberVO> memberList();
	
	// 2. 한개만 보기
	// 3. 한개만 insert하기 
	// 4. 수정 
	// 5. 삭제
	// public int 는 register를 수행하고 난 다음에 몇 row가 insert되었는지
	// 여부를 return하는건데.. 아직 우리코드에는 처리가 안되고 있음.
	public int memberRegister(MemberVO member);

	public MemberVO memberGetOne(int mno);

	public int memberUpdate(MemberVO member);

	public int memberDelete(int mno);

	public MemberVO memberLogin(MemberVO member);

	public MemberVO checkIdDup(String email);

}
