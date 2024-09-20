package com.iechor.clothesdesigner.headless.chat.parser;

import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;

/**
 * A semantic parser understands user queries and generates semantic query statement.
 * clothesdesigner leverages a combination of rule-based and LLM-based parsers, each of which deals
 * with specific scenarios.
 */
public interface SemanticParser {
    void parse(ChatQueryContext chatQueryContext);
}
