package co.micol.test.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.test.common.Command;

public class MainCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {	
		//main.do가 호출되면 동작하는 부분
		return "main/main";  //돌려줄 페이지 (main폴더-main.jsp)
	}

}
