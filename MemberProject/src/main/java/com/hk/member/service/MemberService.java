package com.hk.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hk.member.dto.MemberVO;
import com.hk.member.mapper.MemberMapper;
import com.hk.member.mapper.MemberMapperImpl;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	MemberMapperImpl memberMapperImpl;
	
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	public List<MemberVO> memberList() { 
		return memberMapper.memberList();
	}
	
	@Transactional
	public int  memberRegister(MemberVO member) { 
		// 기존코드 (에러처리 안됨)
		//int retVal = memberMapper.memberRegister(member);
		//System.out.println("retVal = " + retVal);
		//return retVal;
		System.out.println("Service ------------------- Start");
		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		// Transaction Test
		try { 
			memberMapper.memberRegister(member);
		} catch (Exception e) { 
			System.out.println("Service ------------------- End");
			// 비정상일때는 rollback
			transactionManager.rollback(txStatus);
			return 0;
		}
		// 정상일때는 commit (빼먹으면 안됨)
		transactionManager.commit(txStatus);
		return 1;		
	}
	
	public MemberVO memberGetOne(int mno) { 
		return memberMapper.memberGetOne(mno);
	}
	
	public int memberUpdate(MemberVO member) { 
		int retVal = memberMapper.memberUpdate(member);
		return retVal;
	}

	public int memberDelete(int mno) {
		// TODO Auto-generated method stub
		int retVal = memberMapper.memberDelete(mno);
		return retVal;
	}

	public MemberVO memberLogin(MemberVO member) {
		// TODO Auto-generated method stub
		MemberVO loginMember = null;
		loginMember = memberMapper.memberLogin(member);
		//System.out.println("loginMember = " + loginMember.toString());
		return loginMember;
	}

	public MemberVO checkIdDup(String email) {
		// TODO Auto-generated method stub
		return memberMapper.checkIdDup(email);
		
	}

}
