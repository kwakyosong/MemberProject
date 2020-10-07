package com.hk.member;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hk.member.dto.MemberVO;
import com.hk.member.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	
	@Autowired
	MemberMapper memberMapper;
	
	@Test
	public void memberListTest() { 
		//assertNotNull(memberService); // memberService가 autowired되었는지 확인
		logger.info("--------------------------------------");
		MemberVO member = memberMapper.memberGetOne(38);
		assertNotNull(member.toString());
		logger.info(member.toString());
	}
	
}
