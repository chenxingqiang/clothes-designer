package com.iechor.clothesdesigner.headless.chat.corrector;

import com.iechor.clothesdesigner.headless.api.pojo.SemanticParseInfo;
import com.iechor.clothesdesigner.headless.chat.ChatQueryContext;

/**
 * A semantic corrector checks validity of extracted semantic information and performs correction
 * and optimization if needed.
 */
public interface SemanticCorrector {
    void correct(ChatQueryContext chatQueryContext, SemanticParseInfo semanticParseInfo);
}
