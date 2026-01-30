package sagan.site.support;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("currentRequest")
    public HttpServletRequest request(HttpServletRequest request) {
        return request;
    }

}
