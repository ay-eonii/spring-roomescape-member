package roomescape.global.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import roomescape.global.exception.RoomEscapeException;
import roomescape.global.jwt.JwtProvider;

import java.util.List;

@Component
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {

    private final CookieManager cookieManager = new CookieManager();
    private final JwtProvider jwtProvider;

    public LoginMemberArgumentResolver(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(AuthUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        if (request == null) {
            //todo 응답코드 변경
            throw new RoomEscapeException("[ERROR] 잘못된 요청입니다.");
        }

        List<Cookie> cookies = cookieManager.extractCookies(request);
        String token = cookieManager.extractToken(cookies);
        return jwtProvider.parse(token);
    }
}
