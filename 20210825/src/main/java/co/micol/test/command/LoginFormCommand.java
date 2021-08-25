package co.micol.test.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.test.common.Command;

public class LoginFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 폼을 호출한다.
		return "member/loginForm";
	}

}
