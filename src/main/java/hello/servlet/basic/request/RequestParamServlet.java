package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 * 2. 하나의 파라미터에 여러 값
 * http://localhost:8080/request-param?username=hello1&age=20&username=hello2
 *
 */
@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println();
        System.out.println("[전체 파라미터 조회] - start");
//        Enumeration<String> parameterNames = request.getParameterNames();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println("paramName: " + paramName + " / value: " + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        System.out.println("request.getParameter(\"username\") = " + request.getParameter("username"));
        System.out.println("request.getParameter(\"age\") = " + request.getParameter("age"));
        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

//        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
//        System.out.println("request.getParameter(\"username\") = " + Arrays.stream(request.getParameterValues("username")).toList());
//        System.out.println("request.getParameter(\"age\") = " + request.getParameter("age"));
//        System.out.println("[이름이 같은 복수 파라미터 조회] - end");
//        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        String[] usernames = request.getParameterValues("username");
        for (String username : usernames) {
            System.out.println("username = " + username);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] - end");

        response.getWriter().write("OK");
    }
}
