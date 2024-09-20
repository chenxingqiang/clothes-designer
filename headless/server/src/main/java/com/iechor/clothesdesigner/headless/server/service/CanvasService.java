package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.CanvasReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.CanvasSchemaResp;
import com.iechor.clothesdesigner.headless.server.persistence.dataobject.CanvasDO;

import java.util.List;

public interface CanvasService {
    List<CanvasDO> getCanvasList(Long domainId);

    List<CanvasSchemaResp> getCanvasSchema(Long domainId, User user);

    CanvasDO createOrUpdateCanvas(CanvasReq canvasReq, User user);

    void deleteCanvas(Long id);
}
