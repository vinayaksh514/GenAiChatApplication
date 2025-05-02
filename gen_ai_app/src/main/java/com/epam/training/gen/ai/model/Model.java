package com.epam.training.gen.ai.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Model {

    /**
     * Represents the identifier for the AI21 J2 Grande Instruct model.
     * Typically used to specify or reference this particular model in the system.
     */
    AI21_J2_GRANDE_INSTRUCT("ai21.j2-grande-instruct"),
    /**
     * A constant representing the AI21 J2-Jumbo-Instruct model identifier.
     * This variable is used to specify or reference the AI21 J2-Jumbo-Instruct
     * language model for natural language processing tasks.
     */
    AI21_J2_JUMBO_INSTRUCT("ai21.j2-jumbo-instruct"),

    /**
     * Represents the constant configuration identifier for Amazon's Titan TG1 Large instance type.
     * This variable is typically used to specify or reference the Amazon EC2 instance type
     * "titan-tg1-large" in configuration settings or services related to cloud computing.
     */
    AMAZON_TITAN_TG1_LARGE("amazon.titan-tg1-large"),
    /**
     * A constant representing the identifier for the Amazon Titan text embedding model version 1.
     * This string can be used to reference the specific version of the Amazon Titan
     * text embedding model in applications that require text embedding functionalities.
     */
    AMAZON_TITAN_EMBED_TEXT_V1("amazon.titan-embed-text-v1"),
    /**
     * A constant string identifier representing the version 2 of the Amazon Titan embed-text model.
     * This variable is used to specify the model identifier for operations that leverage
     * Amazon Titan's embedding capabilities for textual data.
     */
    AMAZON_TITAN_EMBED_TEXT_V2("amazon.titan-embed-text-v2:0"),
    /**
     * A constant representing the identifier for the Amazon Titan Embed Image V1 model.
     * This identifier is typically used to specify or reference a particular version
     * of the Amazon Titan service for image embedding functionality.
     */
    AMAZON_TITAN_EMBED_IMAGE_V1("amazon.titan-embed-image-v1"),
    /**
     * A constant representing the identifier for the Amazon Nova Pro V1 service.
     * This string is used as a key or identifier within the application to reference
     * the Amazon Nova Pro V1 service or functionality.
     */
    AMAZON_NOVA_PRO_V1("amazon.nova-pro-v1"),
    /**
     * A constant representing the identifier for the first version of the Amazon Nova Lite service.
     * This constant is typically used to refer to or interact with Amazon's Nova Lite service API
     * version 1 within the application.
     */
    AMAZON_NOVA_LITE_V1("amazon.nova-lite-v1"),
    /**
     * A constant representing the identifier string "amazon.nova-micro-v1".
     * This variable is typically used to reference the specific version or configuration
     * of the Amazon Nova Micro system. It acts as an identifier for services, settings,
     * or features related to the "nova-micro" environment within Amazon's ecosystem.
     */
    AMAZON_NOVA_MICRO_V1("amazon.nova-micro-v1"),

    /**
     * Represents the identifier for the Anthropic Claude Instant V1 model.
     * This constant is used to specify the version of the Claude Instant AI model
     * provided by Anthropic in various integrations or API requests.
     */
    CLAUDE_INSTANT_V1("anthropic.claude-instant-v1"),
    /**
     * A constant representing the identifier for Claude version 2,
     * typically used to specify the usage of the Claude-v2 model
     * in applications or integrations with the Anthropic API.
     */
    CLAUDE_V2("anthropic.claude-v2"),
    /**
     * A constant representing the identifier for the Claude version 2.1 model
     * provided by Anthropic. This identifier is typically used to specify or
     * reference this particular version of the Claude model in relevant systems
     * or configurations.
     */
    CLAUDE_V2_1("anthropic.claude-v2-1"),
    /**
     * Represents a constant for the identifier "anthropic.claude-v3-opus".
     * This variable can be used to refer to or configure the Claude v3 Opus model.
     */
    CLAUDE_V3_OPUS("anthropic.claude-v3-opus"),
    /**
     * A variable representing the identifier for the Claude V3 Haiku model.
     * This string is used to specify the unique key or name for accessing
     * or referencing the Claude V3 Ha
     */
    CLAUDE_V3_HAIKU("anthropic.claude-v3-haiku"),
    /**
     * A constant representing the identifier for the Claude 3.5 Haiku model.
     * This model is created
     */
    CLAUDE_3_5_HAIKU("anthropic.claude-3-5-haiku-20241022-v1"),
    /**
     * A constant representing the identifier for Anthropic's Claude V3 Sonnet model.
     * This identifier is used to specify the Claude V3 Sonnet version in applications or frameworks
     * that integrate with Anthropic's AI systems.
     */
    CLAUDE_V3_SONNET("anthropic.claude-v3-sonnet"),
    /**
     * A constant representing the identifier for the Claude V3.5 Sonnet AI model.
     * This string is used to reference the specific model version provided by Anthropic.
     */
    CLAUDE_V3_5_SONNET("anthropic.claude-v3-5-sonnet"),
    /**
     * Represents a constant string identifier for the Claude 3.5 Sonnet version,
     * which is a specific version and variant of the Claude AI model.
     * <p>
     * This constant is typically used to reference or interact with the Anthropic Claude
     * API, ensuring compatibility with the designated model version.
     */
    CLAUDE_3_5_SONNET("anthropic.claude-3-5-sonnet-20241022-v2"),
    /**
     * Represents the identifier for the Claude AI system by Anthropic.
     * This variable is typically used to denote or reference the Claude AI system
     * in configurations, identifiers, or other mappings where a specific reference to
     * this AI system is required.
     */
    CLAUDE("anthropic.claude"),

    /**
     * A constant representing the identifier for the Cohere Command Text model, version 14.
     * This identifier is typically used to specify the particular version of the
     * Cohere Command Text model in various operations or configurations.
     */
    COHERE_COMMAND_TEXT_V14("cohere.command-text-v14"),

    /**
     * A constant representing the identifier for the Databricks BGE Large English model.
     * This variable is typically used to reference or configure the specific
     * Databricks model that corresponds to large-scale processing in the English
     * language context.
     */
    DATABRICKS_BGE_LARGE_EN("databricks-bge-large-en"),
    /**
     * A constant representing the Databricks Llama 2 70B Chat model identifier.
     * This identifier can be used to specify or reference the 70-billion parameter
     * conversational AI model provided by Databricks.
     */
    DATABRICKS_LLAMA_2_70B_CHAT("databricks-llama-2-70b-chat"),
    /**
     * A constant representing the identifier for the "databricks-mixtral-8x7b-instruct" model.
     * This identifier is typically used to specify or reference the particular model
     * within systems or processes that leverage Databricks machine learning models for instruction-based tasks.
     */
    DATABRICKS_MIXTRAL_8X7B_INSTRUCT("databricks-mixtral-8x7b-instruct"),
    /**
     * A constant variable representing the identifier "databricks-dbrx-instruct".
     * This identifier is typically used for configuring or referencing specific
     * Databricks-related instruction settings or services within an application.
     * The variable serves as a key or a label in contexts where such identifiers
     * are required for execution or configuration purposes.
     */
    DATABRICKS_DBRX_INSTRUCT("databricks-dbrx-instruct"),

    /**
     * Represents a specific type or configuration identified as "e5-large-v2".
     * This constant may define a version or variant for a resource, system, or architecture in the context where it's used.
     */
    E5_LARGE_V2("e5-large-v2"),

    /**
     * Represents a specific version identifier for the Chat Bison model.
     * <p>
     * This variable is used to specify the "chat-bison@001" version, which is a
     * predefined model version for handling chat-related functionalities.
     * It ensures that the system references the appropriate version of the model
     * when performing operations.
     */
    CHAT_BISON_001("chat-bison@001"),
    /**
     * A constant representing the identifier for the "chat-bison-32k@002" model.
     * This identifier is typically used to reference a specific version of the
     * "chat-bison" language model with 32k token capacity.
     */
    CHAT_BISON_32K_002("chat-bison-32k@002"),
    /**
     * This constant represents the identifier for the "chat-bison" model.
     * It is used to specify or refer to the "chat-bison" model in the application.
     */
    CHAT_BISON("chat-bison"),
    /**
     * A constant representing the identifier for the specific version of the
     * CodeChat service utilizing "bison" as its model variation, labeled with
     * the version "001". This identifier is used to specify the configuration
     * of the service for processing and interactions associated with this model.
     */
    CODECHAT_BISON_001("codechat-bison@001"),
    /**
     * A constant representing the identifier for the "codechat-bison-32k@002" model.
     * This identifier is typically used to reference or select the specific version
     * of the "codechat-bison-32k" model in a given application or system.
     */
    CODECHAT_BISON_32K_002("codechat-bison-32k@002"),
    /**
     * A constant representing the identifier for the "codechat-bison" configuration or feature.
     * This variable is typically used to specify or reference the "codechat-bison" mode or functionality
     * within the system.
     */
    CODECHAT_BISON("codechat-bison"),
    /**
     * A constant representing the identifier "gemini-pro".
     * It is typically used to recognize or differentiate a specific mode, configuration,
     * or feature set associated with the "Gemini Pro" designation.
     */
    GEMINI_PRO("gemini-pro"),
    /**
     * A constant representing the identifier for the "gemini-pro-vision" service or functionality.
     * It is typically used as a key or configuration value within the application to refer
     * to a specific feature, module, or integration named "gemini-pro-vision".
     */
    GEMINI_PRO_VISION("gemini-pro-vision"),
    /**
     * Constant representing the identifier for the "gemini-1.5-pro-preview-0409" feature.
     * Typically used as an internal reference or key for accessing related configurations,
     * settings, or system functionalities associated with the "gemini-1.5-pro-preview" version.
     */
    GEMINI_1_5_PRO_PREVIEW("gemini-1.5-pro-preview-0409"),
    /**
     * Constant representing the identifier for the "gemini-1.5-flash-001" configuration or feature.
     * This can be used as a reference for specific functionality or settings tied to this identifier.
     */
    GEMINI_1_5_FLASH_001("gemini-1.5-flash-001"),
    /**
     * Represents the Gemini 2.0 Flash Experiment identifier.
     * Used to denote the "gemini-2.0-flash-exp" configuration or feature flag.
     */
    GEMINI_2_0_FLASH_EXP("gemini-2.0-flash-exp"),
    /**
     * A constant representing the identifier "gemini-exp-1206".
     * This could be used as a configuration key, a feature flag,
     * or an experiment identifier within the application.
     */
    GEMINI_EXP_1206("gemini-exp-1206"),
    /**
     * A constant representing the identifier for the "Gemini 2.0 Flash Thinking Experiment".
     * This variable
     */
    GEMINI_2_0_FLASH_THINKING_EXP("gemini-2.0-flash-thinking-exp-1219"),
    /**
     * Constant representing the identifier for the "textembedding-gecko@001" model.
     * This model is used for text embedding purposes, providing a numerical representation
     * of text that captures semantic meaning and relationships.
     */
    TEXTEMBEDDING_GECKO_001("textembedding-gecko@001"),
    /**
     * A constant that represents the identifier or version tag for the image generation process
     * within the application. This is typically used to reference a specific implementation
     * or feature set associated with the "imagegeneration" module or functionality.
     */
    IMAGEGENERATION_005("imagegeneration@005"),

    /**
     * A constant representing the configuration identifier for the
     * Meta Llama 3 model, specifically tailored for instruction-following
     * tasks with an 8 billion parameter scale.
     * This identifier is utilized to reference the associated model configuration.
     */
    META_LLAMA3_8B_INSTRUCT_V1("meta.llama3-8b-instruct-v1"),
    /**
     * A constant representing the identifier for the Meta LLaMA3 70-billion parameter
     * instruction-tuned model version 1. This value is commonly used as a unique
     * key or reference to this specific model configuration in systems or
     * applications utilizing it.
     */
    META_LLAMA3_70B_INSTRUCT_V1("meta.llama3-70b-instruct-v1"),
    /**
     * A constant representing the configuration key for the "meta.llama3" property.
     * This key is typically used to retrieve or reference the associated configuration
     * value within the application settings or environment.
     */
    META_LLAMA3("meta.llama3"),
    /**
     * Constant variable representing the identifier for Meta LLaMA-2 13B Chat v1 model.
     * <p>
     * This variable holds the unique string identifier used to reference the Meta LLaMA-2
     * 13B Chat version 1 model in the system. It is typically used in configurations,
     * model selection, or other parts of a program requiring a reference to this specific
     * model implementation.
     */
    META_LLAMA2_13B_CHAT_V1("meta.llama2-13b-chat-v1"),
    /**
     * Represents the configuration identifier for the Meta LLaMA 2 70-billion parameter Chat model version 1.
     * This identifier can be used to reference or load the specific model configuration
     * for applications requiring advanced conversational AI functionalities.
     */
    META_LLAMA2_70B_CHAT_V1("meta.llama2-70b-chat-v1"),
    /**
     * A constant representing the identifier or name "meta.llama2".
     * This variable is typically used to reference or symbolize a
     * specific model, configuration, or entity associated with
     * the "meta.llama2" designation.
     */
    META_LLAMA2("meta.llama2"),
    /**
     * Represents a constant that holds the identifier for a specific Code Llama model configuration.
     * This configuration refers to the "CodeLlama-34b-Instruct-hf" model, which is a variation of the
     * Code Llama language model optimized for instruction-based tasks or fine-tuning.
     */
    CODELLAMA_34B_INSTRUCT_HF("CodeLlama-34b-Instruct-hf"),
    /**
     * Represents a specific configuration or model identifier for the LLAMA
     * series, version 3 with an 8-billion parameter instruct-tuned variant.
     * The instruct-tuned model is designed for tasks that require instruction
     * following capabilities, aiming to improve adherence to given guidelines
     * or directives.
     */
    LLAMA_3_8B_INSTRUCT("Llama-3-8B-Instruct"),

    /**
     * Represents the "Mistral-7B-Instruct" model, a predefined configuration
     * for utilizing the Mistral 7-billion parameter instruct-tuned language model.
     * This variable is used to reference and identify the specific model
     * configuration for processing tasks requiring instruction-following capabilities.
     */
    MISTRAL_7B_INSTRUCT("Mistral-7B-Instruct"),
    /**
     * Identifier for the Mixtral-8x7B-Instruct version 0.1.
     * This variable represents a specific version of the Mixtral instruction-based model.
     * It is used to reference the model version in applications or systems that require a
     * standardized identifier for this particular release.
     */
    MIXTRAL_8X7B_INSTRUCT_V0_1("Mixtral-8x7B-Instruct-v0.1"),
    /**
     * Represents the identifier for the "mistral-large-azure" configuration or resource.
     * This value is typically used to refer to a specific preset, model configuration,
     * or deployment within an application dealing with Mistral large-scale instances
     * on Azure infrastructure.
     */
    MISTRAL_LARGE_AZURE("mistral-large-azure"),

    /**
     * Constant representing the identifier for the OpenAI GPT-3.5-Turbo model version "0301".
     * This can be used to specify and reference this specific version of the GPT-3.5-Turbo model
     * in applications leveraging OpenAI's language models.
     */
    GPT_35_TURBO_0301("gpt-35-turbo-0301"),
    /**
     * A constant representing the identifier for the GPT-35-Turbo model with version 0613.
     * This identifier is typically used to specify and interact with the corresponding model
     * in systems or APIs that support this version.
     * <p>
     * The "0613" in the identifier likely refers to the specific release or update version
     * of the GPT-35-Turbo model.
     */
    GPT_35_TURBO_0613("gpt-35-turbo-0613"),
    /**
     * A constant representing a specific version of the GPT-3.5 Turbo model.
     * This value specifies the identifier for the "gpt-35-turbo-1106" version
     * and can be used for model selection or configuration when interacting
     * with systems or APIs that support this model.
     */
    GPT_35_TURBO_1106("gpt-35-turbo-1106"),
    /**
     * A constant representing the specific model identifier "gpt-35-turbo-0125".
     * This can be used to reference or denote the "gpt-35-turbo-0125" version
     * of the GPT-35-Turbo model in applications or systems that require specifying
     * the model version for processing or interaction.
     */
    GPT_35_TURBO_0125("gpt-35-turbo-0125"),
    /**
     * A constant representing the "gpt-35-turbo" model.
     * This variable is used to specify the GPT-35-Turbo version
     * of the model for tasks such as natural language processing
     * and conversational AI.
     */
    GPT_35_TURBO("gpt-35-turbo"),
    /**
     * A constant representing the GPT-3.5 Turbo model with a 16K token context length.
     * This model is designed to handle tasks requiring extended context and is
     * identified by the string "gpt-35-turbo-16k".
     */
    GPT_35_TURBO_16K("gpt-35-turbo-16k"),
    /**
     * The GPT_4_0613 variable represents a specific version identifier for the GPT-4 model.
     * This version may correspond to a release or update of the GPT-4 model
     * with potential improvements, features, or adjustments introduced on or around June 13, 2023.
     */
    GPT_4_0613("gpt-4-0613"),
    /**
     * Represents the identifier for the GPT-4 model.
     * <p>
     * This variable is typically used to specify the usage of the GPT-4 language model
     * in various applications or integrations where different model versions are supported.
     * The value "gpt-4" corresponds to this specific version of the model.
     */
    GPT_4("gpt-4"),
    /**
     * Represents a constant for the GPT-4 model in its 1106 preview version.
     * This constant is used to specify or identify the specific model version.
     */
    GPT_4_1106_PREVIEW("gpt-4-1106-preview"),
    /**
     * Constant representing the GPT-4 preview model identifier with the specific version "0125-preview".
     * This identifier is used to specify the model version in requests or configurations
     * for accessing or interacting with the GPT-4 model's preview release.
     */
    GPT_4_0125_PREVIEW("gpt-4-0125-preview"),
    /**
     * A constant that represents the model identifier for the GPT-4 Turbo version released on April 9, 2024.
     * This identifier is used to reference the specific model version in applications or APIs that support it.
     */
    GPT_4_TURBO_20240409("gpt-4-turbo-2024-04-09"),
    /**
     * A constant representing the identifier for the "gpt-4-turbo" model.
     * This variable is typically used to specify or reference the GPT-4 Turbo
     * version of the model in contexts where a particular model variant is required.
     */
    GPT_4_TURBO("gpt-4-turbo"),
    /**
     * A constant representing the GPT-4 model with a 32,000 token context window,
     * identified by the version string "gpt-4-32k-0314".
     * This version is associated with the specific release from 03/14 (March 14).
     * It is used to denote and initialize interactions with the specified model.
     */
    GPT_4_32K_0314("gpt-4-32k-0314"),
    /**
     * Represents the GPT-4 language model with a 32,000-token context length.
     * The "0613" suffix indicates the specific version or update date of the model,
     * released in June 2023.
     */
    GPT_4_32K_0613("gpt-4-32k-0613"),
    /**
     * A constant representing the GPT-4 model variant with a 32,000 token context window.
     * This model is optimized for handling large inputs and producing high-quality outputs
     * over extended text sequences.
     */
    GPT_4_32K("gpt-4-32k"),
    /**
     * A constant representing the GPT-4 Vision Preview model identifier.
     * This variable holds the string value "gpt-4-vision-preview", which is used
     * to specify the GPT-4 Vision model in preview mode. The model supports
     * advanced visual recognition and processing capabilities, combining
     * image analysis with natural language understanding.
     */
    GPT_4_VISION_PREVIEW("gpt-4-vision-preview"),
    /**
     * Represents a specific version identifier for the GPT model.
     * "GPT_4O_20240513" refers to the OpenAI GPT-4 optimized model released on May 13, 2024.
     * This constant is used to differentiate between various versions of the model
     * and can be employed in logic requiring version-specific behavior or configuration.
     */
    GPT_4O_20240513("gpt-4o-2024-05-13"),
    /**
     * Represents the identifier for the third version of the DALL-E model.
     * This variable is commonly used to reference or specify the DALL-E 3 model
     * in applications or systems interacting with OpenAI's generative image AI services.
     */
    DALL_E_3("dall-e-3"),
    /**
     * A constant representing a specific embedding model identifier.
     * This identifier is used for specifying the "text-embedding-ada-
     */
    TEXT_EMBEDDING_ADA_002("text-embedding-ada-002"),
    /**
     * Represents a predefined constant for a specific text embedding model identifier.
     * This identifier corresponds to the "text-embedding-3-large" model, which could be
     * used in tasks related to natural language processing, such as semantic search,
     * clustering, or other text similarity operations.
     */
    TEXT_EMBEDDING_3_LARGE("text-embedding-3-large"),
    /**
     * Represents the identifier for the small variant of the version 3
     * text embedding model. This is typically used in natural language
     * processing tasks where embeddings are required for text data.
     */
    TEXT_EMBEDDING_3_SMALL("text-embedding-3-small"),

    /**
     * Represents the key or identifier used for Stability AI's Stable Diffusion XL model.
     * This variable is typically used to reference the Stable Diffusion XL functionality
     * offered by Stability AI, such as advanced image generation or transformation
     * capabilities.
     */
    STABILITY_SD_XL("stability.stable-diffusion-xl"),
    /**
     * A constant representing the identifier for the "stability.stable-image-core-v1" feature.
     * This variable is used to denote the version 1 of the stable image core functionality
     * within the stability module. It helps in identifying and managing the corresponding
     * functionality or service in the stability-related implementations.
     */
    STABILITY_IMAGE_CORE_V1("stability.stable-image-core-v1"),
    /**
     * Constant representing the "stability.sd3-large-v1" configuration or version identifier.
     * This variable is used to specify the stability-related SD3 large version 1.
     */
    STABILITY_SD3_LARGE_V1("stability.sd3-large-v1"),
    /**
     * Represents the identifier or key for the "stability.stable-image-ultra-v1" configuration or service.
     * This variable may be used to reference a specific version or type of stability image processing service
     * or configuration setting that ensures high-quality stability or performance.
     */
    STABILITY_IMAGE_ULTRA_V1("stability.stable-image-ultra-v1");

    /**
     * Represents an immutable string value used to store data or information
     * that does not change once initialized. This variable is private,
     * ensuring it is accessible only within the class, and declared final,
     * indicating that its value cannot be modified after being assigned.
     */
    private final String value;

    /**
     * Constructs a new Model with the specified value.
     *
     * @param value the value to initialize the model
     */
    Model(String value) {
        this.value = value;
    }

    /**
     * Retrieves the value of the object.
     *
     * @return the value as a String
     */
    public String value() {
        return value;
    }

    /**
     * A static final map serving as a lookup table that associates string keys
     * with corresponding Model objects. This map is intended to provide efficient
     * access to pre-defined Model instances based on their string identifiers.
     */
    private static final Map<String, Model> LOOKUP = new HashMap<>();

    static {
        for (Model model : Model.values()) {
            LOOKUP.put(model.value, model);
        }
    }

    /**
     * Retrieves an Optional containing a Model corresponding to the given value, if present.
     *
     * @param value the string value used to look up the corresponding Model
     * @return an Optional containing the Model if found, otherwise an empty Optional
     */
    public static Optional<Model> fromValue(String value) {
        return Optional.ofNullable(LOOKUP.get(value));
    }

}
