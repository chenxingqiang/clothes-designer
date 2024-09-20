package com.iechor.clothesdesigner.chat.server.agent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NL2SQLTool extends AgentTool {

    protected List<Long> dataSetIds;
}
