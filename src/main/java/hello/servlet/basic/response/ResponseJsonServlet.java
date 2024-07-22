package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ResponseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //content-type: application/json
/* application/json : application은 응용 프로그램 데이터 형식을 의미함.
여기서는 브라우저(클라이언트), 앱 어플리케이션(서버) 간에 데이터를 주고받기 위해 사용됨. */

        ObjectMapper objectMapper = new ObjectMapper();

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        /*
         * helloData의 필드를 Json 형식의 String으로 바꿔줌.
         */
        String result = objectMapper.writeValueAsString(helloData);

        /*
        * write 메서드 통해 http 응답의 바디에 Json으로 변환된 String 저장.*/
        response.getWriter().write(result);
    }
}
