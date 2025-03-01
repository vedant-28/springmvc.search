package springmvc.search.interceptor;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class MyInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest request) throws Exception {
        System.out.println("This is pre-handler....");
    }

    @Override
    public void postHandle(WebRequest request, org.springframework.ui.ModelMap model) throws Exception {
        System.out.println("This is post-handler....");
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        System.out.println("This is after completion....");
    }
}
