package co.micol.test.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.test.common.Command;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리과정을 기술하고 결과페이지 설정.
		return "member/loginResult";
	}

}
