package com.iechor.clothesdesigner.headless.chat.mapper;

import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;

/**
 * A schema mapper identifies references to schema elements(metrics/dimensions/entities/values) in
 * user queries. It matches the query text against the knowledge base.
 */
public interface SchemaMapper {
    void map(ChatQueryContext chatQueryContext);
}
