package hello.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") //name: 서블릿 이름. urlPatterns: URL 매핑
public class HelloServlet extends HttpServlet {

	//HTTP 요청을 통해 매핑된 URL이 호출되면 서블릿 컨테이너는 다음 메서드를 실행한다.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("HelloServlet.service");
		System.out.println("request = " + request); //request = org.apache.catalina.connector.RequestFacade@f43160e : tomcat(was)의 HttpServletRequest 인터페이스 구현체
		System.out.println("response = " + response); //response = org.apache.catalina.connector.ResponseFacade@3507b240 : 동일

		String username = request.getParameter("username"); //쿼리 파라미터 조회하기 /hello?username=xx의 xx
		System.out.println("username = " + username);

		//HttpServletResponse에 값을 넣으면 HTTP response 메시지에 담겨서 나가게 된다.
		response.setContentType("text/plain"); //header Content-Type 설정
		response.setCharacterEncoding("utf-8"); //header Content-Type 설정. 문자 인코딩은 utf-8을 쓰자
		response.getWriter().write("hello " + username);

	}
}
