package com.hk.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.member.service.MemberService;
import com.hk.member.dto.MemberVO;

@Controller
@RequestMapping("/auth")    // http://localhost:9999/auth
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	MemberService memberService;
	
	
	@GetMapping("/login")  //http://localhost:9999/auth/login 
	public String loginGet(HttpServletRequest request,Model model) { 
		// 3) 여기서 request에 담아둔거 꺼내서 
		// 4) Model에 담고.. loginGet에서 꺼내서 Client로 보냄
		HttpSession session = request.getSession();

		String url = (String) session.getAttribute("url");
		logger.info("Get Mapping login = " + url);
		model.addAttribute("url2", url);
		return "auth/loginGet";
	}
	
	@PostMapping("/login") //http://localhost:9999/auth/login
	public String loginPost(HttpSession session,MemberVO member, @RequestParam("url") String url) { 
		// @RequestParam("email") String email, @RequestParam("pwd") String pwd 
		// 사용자가 입력한 email/passwd를 member에 담아온다.
		
		// 5) Client에 보낸거 input type hidden에서 꺼내서 
		
		// 6) redirect 시킴.. 
		logger.info("사용자가 원래 요청한 URL은 ? = " + url);
		
		// 이렇게 처리하는거 말도 안되는거긴 하지만.. 절차가 이럼.
		// 이걸 request처럼 매번 접속할때 체크하는게 맞냐?
		// 아님 session처럼 로그인했다치고 체크하는게 맞냐? 
		// 아님 sc처럼 그냥 모르겠고.. 다 등록해놓으면 알아서 꺼내써가 맞냐? 
		// 이런거를 따져야함.
		

		logger.info("사용자가 입력한 email / passwd = " + member.toString());
		
		// password 체크하는 service에 넘겨서 값을 받아옴..
		// 성공이면 session에 member정보 담아두고.. ../member/list로 보내고 
		// 실패면 그냥 다시 login 페이지로 이동 
		// 아래 if문은 MemberService에서 전부 구현해서 1 or 0 이렇게 보내도됨.
		MemberVO loginMember = memberService.memberLogin(member);
		
		if( loginMember == null) { 
			// 패스워드가 틀렷음 ?
			logger.info("로그인 실패");
			return "auth/loginFail";
		} else {
			// 로그인 성공 
			// Session 등록
			// memberLogin Return이 Member Class임.
			logger.info("로그인 성공");
			session.setAttribute("loginMember", loginMember);
			// model 이라고 하는 보관소에 넣었음.. 
			// Servlet할때는 context , session , request , ...
			// -> Spring으로 넘어오면서.. model로 합쳐서 사용.. 
			// -> Spring을 쓰면서 Servlet할때 Session을 사용.. 
			//return "redirect:../member/list";  // /auth/login 에서 ../member/list 
			return "redirect:.." + url;
					
		}
		
	}
	
	@RequestMapping(value="/logout", method = { RequestMethod.GET , RequestMethod.POST})
	public String logout(HttpSession session) { 
		logger.info("Session 삭제 --- 로그아웃됨");
		session.invalidate();
		
		return "auth/logout";
	}
	
}
