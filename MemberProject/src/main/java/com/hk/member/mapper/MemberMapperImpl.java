package com.hk.member.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.member.dto.MemberVO;

@Repository
public class MemberMapperImpl implements MemberMapper {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int memberRegister(MemberVO member) {
		// TODO Auto-generated method stub
		int retVal = 0; 
		try { 
			retVal = sqlSession.insert("com.hk.member.mapper.MemberMapper" + ".memberRegister",member);
		} catch (Exception e) { 
			System.out.println("여기 들어왔음... 에러임.. ------------");
			e.getStackTrace();
		}
		return retVal;
	}

	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO memberGetOne(int mno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberUpdate(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(int mno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO memberLogin(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO checkIdDup(String email) {
		// TODO Auto-generated method stub
		return null;
	}


}
