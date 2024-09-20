package com.iechor.clothesdesigner.headless.chat.query.llm.s2sql;

import com.iechor.clothesdesigner.common.pojo.Text2SQLExemplar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LLMSqlResp {

    private double sqlWeight;

    private List<Text2SQLExemplar> fewShots;
}
