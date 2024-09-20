package com.iechor.clothesdesigner.headless.server.service;

import javax.servlet.http.HttpServletResponse;

import com.iechor.clothesdesigner.auth.api.authentication.pojo.User;
import com.iechor.clothesdesigner.headless.api.pojo.request.BatchDownloadReq;
import com.iechor.clothesdesigner.headless.api.pojo.request.DownloadMetricReq;

public interface DownloadService {
    void downloadByStruct(
            DownloadMetricReq downloadStructReq, User user, HttpServletResponse response)
            throws Exception;

    void batchDownload(BatchDownloadReq batchDownloadReq, User user, HttpServletResponse response)
            throws Exception;
}
