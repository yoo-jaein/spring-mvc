package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, // inputStream으로 데이터를 읽을 수 있다.
			StandardCharsets.UTF_8);// Spring이 제공하는 유틸리티 클래스, 바이트를 문자열로 인코딩할때 어떤 문자를 쓸지 정해야 함.

		System.out.println("messageBody = " + messageBody); // http body의 메시지가 그대로 나온다.

		response.getWriter().write("ok");
	}
}
