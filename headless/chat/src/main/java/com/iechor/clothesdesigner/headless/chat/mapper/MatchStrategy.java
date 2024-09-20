package com.iechor.clothesdesigner.headless.chat.mapper;

import com.iechor.clothesdesigner.headless.api.pojo.response.S2Term;
import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;
import com.iechor.clothesdesigner.headless.chat.knowledge.MapResult;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * MatchStrategy encapsulates a concrete matching algorithm executed during query or search process.
 */
public interface MatchStrategy<T extends MapResult> {
    Map<MatchText, List<T>> match(
            ChatQueryContext chatQueryContext, List<S2Term> terms, Set<Long> detectDataSetIds);
}
