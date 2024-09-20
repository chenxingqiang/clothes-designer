package com.iechor.clothesdesigner.headless.server.facade.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.auth.api.authentication.utils.UserHolder;
import com.iechor.clothesdesigner.headless.api.pojo.request.QueryStructReq;
import com.iechor.clothesdesigner.headless.server.facade.service.SemanticLayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/semantic/query")
@Slf4j
public class TagQueryApiController {

    @Autowired private SemanticLayerService semanticLayerService;

    @PostMapping("/tag")
    public Object queryByTag(
            @RequestBody QueryStructReq queryStructReq,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
        User user = UserHolder.findUser(request, response);
        return semanticLayerService.queryByReq(queryStructReq.convert(), user);
    }
}
