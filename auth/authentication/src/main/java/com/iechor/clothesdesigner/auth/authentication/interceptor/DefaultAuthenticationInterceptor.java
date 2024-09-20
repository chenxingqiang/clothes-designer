package com.iechor.clothesdesigner.auth.authentication.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iechor.clothesdesigner.auth.api.authentication.annotation.AuthenticationIgnore;
import com.iechor.clothesdesigner.auth.api.authentication.config.AuthenticationConfig;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.UserWithPassword;
import com.iechor.clothesdesigner.auth.authentication.service.UserServiceImpl;
import com.iechor.clothesdesigner.auth.authentication.utils.UserTokenUtils;
import com.iechor.clothesdesigner.common.pojo.exception.AccessException;
import com.iechor.clothesdesigner.common.util.ContextUtils;
import com.iechor.clothesdesigner.common.util.S2ThreadContext;
import com.iechor.clothesdesigner.common.util.ThreadContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

@Slf4j
public class DefaultAuthenticationInterceptor extends AuthenticationInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws AccessException {
        authenticationConfig = ContextUtils.getBean(AuthenticationConfig.class);
        userServiceImpl = ContextUtils.getBean(UserServiceImpl.class);
        userTokenUtils = ContextUtils.getBean(UserTokenUtils.class);
        s2ThreadContext = ContextUtils.getBean(S2ThreadContext.class);
        if (!authenticationConfig.isEnabled()) {
            setFakerUser(request);
            return true;
        }
        if (isInternalRequest(request)) {
            setFakerUser(request);
            return true;
        }
        if (isAppRequest(request)) {
            setFakerUser(request);
            return true;
        }
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            AuthenticationIgnore ignore = method.getAnnotation(AuthenticationIgnore.class);
            if (ignore != null) {
                return true;
            }
        }

        String uri = request.getServletPath();
        if (!isIncludedUri(uri)) {
            return true;
        }

        if (isExcludedUri(uri)) {
            return true;
        }

        UserWithPassword user = userTokenUtils.getUserWithPassword(request);
        if (user != null) {
            setContext(user.getName(), request);
            return true;
        }
        throw new AccessException("authentication failed, please login");
    }

    private void setFakerUser(HttpServletRequest request) {
        String token = userTokenUtils.generateAdminToken(request);
        reflectSetParam(request, authenticationConfig.getTokenHttpHeaderKey(), token);
        setContext(User.getFakeUser().getName(), request);
    }

    private void setContext(String userName, HttpServletRequest request) {
        ThreadContext threadContext =
                ThreadContext.builder()
                        .token(request.getHeader(authenticationConfig.getTokenHttpHeaderKey()))
                        .userName(userName)
                        .build();
        s2ThreadContext.set(threadContext);
    }
}
