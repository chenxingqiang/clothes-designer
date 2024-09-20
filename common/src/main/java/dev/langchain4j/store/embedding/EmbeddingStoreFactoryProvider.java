package dev.langchain4j.store.embedding;

import com.iechor.clothesdesigner.common.config.EmbeddingStoreParameterConfig;
import com.iechor.clothesdesigner.common.pojo.EmbeddingStoreConfig;
import com.iechor.clothesdesigner.common.util.ContextUtils;
import dev.langchain4j.chroma.spring.ChromaEmbeddingStoreFactory;
import dev.langchain4j.inmemory.spring.InMemoryEmbeddingStoreFactory;
import dev.langchain4j.milvus.spring.MilvusEmbeddingStoreFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmbeddingStoreFactoryProvider {

    protected static final Map<EmbeddingStoreConfig, EmbeddingStoreFactory> factoryMap =
            new ConcurrentHashMap<>();

    public static EmbeddingStoreFactory getFactory() {
        EmbeddingStoreParameterConfig parameterConfig =
                ContextUtils.getBean(EmbeddingStoreParameterConfig.class);
        return getFactory(parameterConfig.convert());
    }

    public static EmbeddingStoreFactory getFactory(EmbeddingStoreConfig embeddingStoreConfig) {
        if (embeddingStoreConfig == null
                || StringUtils.isBlank(embeddingStoreConfig.getProvider())) {
            return ContextUtils.getBean(EmbeddingStoreFactory.class);
        }
        if (EmbeddingStoreType.CHROMA.name().equalsIgnoreCase(embeddingStoreConfig.getProvider())) {
            return factoryMap.computeIfAbsent(
                    embeddingStoreConfig,
                    storeConfig -> new ChromaEmbeddingStoreFactory(storeConfig));
        }
        if (EmbeddingStoreType.MILVUS.name().equalsIgnoreCase(embeddingStoreConfig.getProvider())) {
            return factoryMap.computeIfAbsent(
                    embeddingStoreConfig,
                    storeConfig -> new MilvusEmbeddingStoreFactory(storeConfig));
        }
        if (EmbeddingStoreType.IN_MEMORY
                .name()
                .equalsIgnoreCase(embeddingStoreConfig.getProvider())) {
            return factoryMap.computeIfAbsent(
                    embeddingStoreConfig,
                    storeConfig -> new InMemoryEmbeddingStoreFactory(storeConfig));
        }
        throw new RuntimeException(
                "Unsupported EmbeddingStoreFactory provider: "
                        + embeddingStoreConfig.getProvider());
    }
}
