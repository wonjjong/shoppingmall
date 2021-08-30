package wonjjong.shoppingmall.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
HandlerInterceptorAdapter is deprecated.

preHandle: 컨트롤러 실행 전
postHandle: 컨트롤러 실행 후, 아직 뷰를 실행하기 전
afterCompletion: 뷰를 실행한 이후
 */

@Slf4j
public class SimpleInterceptor implements AsyncHandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("mi.beginTime", System.currentTimeMillis());
        System.out.println("====================start================");
        return true;
//        return AsyncHandlerInterceptor.super.preHandle(request, response, handler);
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        AsyncHandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long beginTime = (long) request.getAttribute("mi.beginTime");
        long endTime = System.currentTimeMillis();

//        System.out.println(request.getRequestURI() + " executing time : " + (endTime - beginTime));
        log.info(request.getRequestURI() + " executing time : " + (endTime - beginTime));
        System.out.println("============================end=========================");
        //        AsyncHandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
