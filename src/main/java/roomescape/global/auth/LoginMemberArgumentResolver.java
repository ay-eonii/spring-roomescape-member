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

@Component
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String TOKEN = "token";

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
        String token = extractTokenFromCookie(request.getCookies());
        return jwtProvider.parse(token);
    }

    private String extractTokenFromCookie(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (TOKEN.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        throw new RoomEscapeException("[ERROR] 토큰이 존재하지 않습니다.");
    }
}
