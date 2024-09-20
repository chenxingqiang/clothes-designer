package com.iechor.clothesdesigner.headless.chat.parser.llm;

import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;

import java.util.Set;

public interface DataSetResolver {
    Long resolve(ChatQueryContext chatQueryContext, Set<Long> restrictiveModels);
}
