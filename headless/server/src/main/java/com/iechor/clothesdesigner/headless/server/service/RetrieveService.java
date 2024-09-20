package com.iechor.clothesdesigner.headless.server.service;

import com.iechor.clothesdesigner.headless.api.pojo.request.QueryNLReq;
import com.iechor.clothesdesigner.headless.api.pojo.response.SearchResult;

import java.util.List;

public interface RetrieveService {
    List<SearchResult> retrieve(QueryNLReq queryNLReq);
}
