package com.iechor.clothesdesigner.chat.server.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.auth.api.authentication.utils.UserHolder;
import com.iechor.clothesdesigner.chat.api.pojo.request.ChatMemoryUpdateReq;
import com.iechor.clothesdesigner.chat.api.pojo.request.PageMemoryReq;
import com.iechor.clothesdesigner.chat.server.persistence.dataobject.ChatMemoryDO;
import com.iechor.clothesdesigner.chat.server.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/chat/memory"})
public class MemoryController {

    @Autowired private MemoryService memoryService;

    @PostMapping("/updateMemory")
    public Boolean updateMemory(
            @RequestBody ChatMemoryUpdateReq chatMemoryUpdateReq,
            HttpServletRequest request,
            HttpServletResponse response) {
        User user = UserHolder.findUser(request, response);
        memoryService.updateMemory(chatMemoryUpdateReq, user);
        return true;
    }

    @RequestMapping("/pageMemories")
    public PageInfo<ChatMemoryDO> pageMemories(@RequestBody PageMemoryReq pageMemoryReq) {
        return memoryService.pageMemories(pageMemoryReq);
    }
}
