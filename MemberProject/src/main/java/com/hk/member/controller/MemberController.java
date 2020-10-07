package com.hk.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.member.service.MemberService;

public class MemberController {
	
	@Autowired
	MemberService memberService;

	// 1) @Controller Annotation 추가 (import org.springframework.stereotype.Controller;)
	// 2) URL 설정 (Get or POST or 둘다냐.. )
	//    - Get만 지정하는 방법 @GetMapping 
	//    - Post만 지정하는 방법 @PostMapping 
	//    - 둘다 지정하는 방법은 @RequestMapping
	//    /member/list     -> Full URL은  http://localhost:9999/member/list 
	//    URL 체계가 : /member   /list    , /register  , /delete , /update 
	
	@RequestMapping(value = "/new/member/list", method = RequestMethod.GET)
	//@GetMapping("/member/list")
	public String memberList(Model model) { 
		// 3) DB접속이 필요한가? (Service 모듈 , Repository-DAO , DTO 필요)
		//    DB접속없이 화면이 필요한가?
		//    DB접속도 화면도 필요없나??  -> RestFul + Ajax (지금 대상은 아님)
		
		// DB접속이 필요... 
		// Service 모듈 : Repository에 있는 이름과 동일하게 작성.. 별도의 트랜잭션.. 테이블2개이상 사용하여 연결하는 작업이 없음.. 
		// Repository 모듈 : mybatis를 사용할까? 
		//                   - pom.xml에 관련 package를 설정 (spring-jdbc , spring-mybatis,mybatis,hikari Datasource등등..)
		//                   - root-context.xml에서 db관련 설정 
		//                   - 상세 sql logging을 보려면 별도의 package를 설정 
		//                   - Mapper interface도 만들어야하고
		//                   - Mapper.xml에 sql도 만들어야 하고 ..
		
		// DB JDBC Driver : Ojdbc6 or ojdbc8 (Oracle 11G XE)
		// Spring-JDBC (Spring 버전을 따라감..)
		// myBatis-JDBC 
		// myBatis
		// Hikari CP (JDBC 성능향상.. Datasource DBCP2)
		// log4jdbc-log4j2 (SQL실행하게 되면 log4j에 나오게 해주는 클래스) 
		
		// DTO : table하고 1:1 Mapping (getter / setter를 편하게 만들게 하기 위해서.. lombok라는 별도의 class사용.)
		
		// Service를 호출 List<MemberVO> 를 일반변수에는 담을 필요가 없다.. . DB에서 읽어온 내용은 jsp에서 출력하기 위해..
		// jsp에서 값을 꺼내가려면... sc , session , request라는 곳에 저장을 해두면 꺼낼수 있었는데... 지금 만들 controller는 
		// servlet이 아니어서.. 꺼낼수가 없음.. 그래서 spring에서는 model이라는 이름으로 저장하고 꺼낼수 있는걸 지원함.
		model.addAttribute("members", memberService.memberList());
		
		return "memberList"; // servlet-context.xml 에 있는 설정을 이용하여 파일을 찾아감..
		// "WEB-INF/views/memberList.jsp" 
		// "redirect:/member/list
	}
}
