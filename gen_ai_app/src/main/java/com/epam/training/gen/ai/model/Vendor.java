package com.epam.training.gen.ai.model;

import lombok.Getter;

import java.util.List;

/**
 * The {@code Vendor} enum represents a collection of vendors, each associated with a list of models.
 * A vendor refers to a provider of machine learning models, and each vendor encompasses a specific set of available models.
 */
@Getter
public enum Vendor {

    /**
     * The `AI21` variable is a list of AI model configurations provided by the AI21 systems.
     * It includes specific models typically used for tasks like text generation and instruction following.
     * <p>
     * The models included in this list are:
     * - `AI21_J2_GRANDE_INSTRUCT`: Represents a model variant optimized for instruction following tasks at a grande scale.
     * - `AI21_J2_JUMBO_INSTRUCT`: Represents a larger model variant optimized for instruction following tasks.
     * <p>
     * These models are part of the `AI21` suite and are identified using the constants defined in the `Model` enum.
     */
    AI21(List.of(
            Model.AI21_J2_GRANDE_INSTRUCT,
            Model.AI21_J2_JUMBO_INSTRUCT
    )),

    /**
     * Represents a predefined list of AI models provided by Amazon.
     * The variable includes multiple models covering various capabilities
     * such as text generation, text embedding, image embedding, and general-purpose
     * AI model features designed by Amazon.
     * <p>
     * Models included:
     * - AMAZON_TITAN_TG1_LARGE: A large-scale AI model by Amazon Titan.
     * - AMAZON_TITAN_EMBED_TEXT_V1: Version 1 of Amazon Titan's text embedding model.
     * - AMAZON_TITAN_EMBED_TEXT_V2: Version 2 of Amazon Titan's text embedding model.
     * - AMAZON_TITAN_EMBED_IMAGE_V1: Amazon Titan's model for image embedding.
     * - AMAZON_NOVA_PRO_V1: Nova Pro general-purpose model by Amazon.
     * - AMAZON_NOVA_LITE_V1: Lite version of the Nova model by Amazon.
     * - AMAZON_NOVA_MICRO_V1: Micro version of the Nova model by Amazon.
     */
    AMAZON(List.of(
            Model.AMAZON_TITAN_TG1_LARGE,
            Model.AMAZON_TITAN_EMBED_TEXT_V1,
            Model.AMAZON_TITAN_EMBED_TEXT_V2,
            Model.AMAZON_TITAN_EMBED_IMAGE_V1,
            Model.AMAZON_NOVA_PRO_V1,
            Model.AMAZON_NOVA_LITE_V1,
            Model.AMAZON_NOVA_MICRO_V1
    )),

    /**
     * ANTHROPIC is a predefined list of `Model` enum constants representing various models
     * provided by the Anthropic vendor. It includes versions for multiple Claude models, such
     * as Claude Instant, Claude V2, Claude V3 Opus, Claude V3 Haiku, and others.
     * <p>
     * This list is used to group Anthropic's AI model offerings for easy reference and categorization.
     */
    ANTHROPIC(List.of(
            Model.CLAUDE_INSTANT_V1,
            Model.CLAUDE_V2,
            Model.CLAUDE_V2_1,
            Model.CLAUDE_V3_OPUS,
            Model.CLAUDE_V3_HAIKU,
            Model.CLAUDE_3_5_HAIKU,
            Model.CLAUDE_V3_SONNET,
            Model.CLAUDE_V3_5_SONNET,
            Model.CLAUDE_3_5_SONNET,
            Model.CLAUDE
    )),

    /**
     * Variable COHERE represents a predefined configuration for utilizing the Cohere AI model.
     * It is initialized with a list containing the specific model {@link Model#COHERE_COMMAND_TEXT_V14}.
     * <p>
     * This variable can be used to reference and integrate with the Cohere Command Text model,
     * which is designed to handle a specific set of natural language processing tasks offered by Cohere's services.
     */
    COHERE(List.of(
            Model.COHERE_COMMAND_TEXT_V14
    )),

    /**
     * A constant representing a list of Databricks model instances.
     * <p>
     * This list includes the following models:
     * - DATABRICKS_BGE_LARGE_EN: A Databricks BGE large English language model.
     * - DATABRICKS_LLAMA_2_70B_CHAT: A Llama 2 model optimized for chat functionality with 70 billion parameters.
     * - DATABRICKS_MIXTRAL_8X7B_INSTRUCT: A Mixtral model designed for instructional tasks.
     * - DATABRICKS_DBRX_INSTRUCT: A Databricks-specific instructional model.
     */
    DATABRICKS(List.of(
            Model.DATABRICKS_BGE_LARGE_EN,
            Model.DATABRICKS_LLAMA_2_70B_CHAT,
            Model.DATABRICKS_MIXTRAL_8X7B_INSTRUCT,
            Model.DATABRICKS_DBRX_INSTRUCT
    )),

    /**
     * Represents a list of AI models specific to the E5 category, initialized with the model variant E5_LARGE_V2.
     * This variable is used to group and define the associated E5 model(s).
     */
    E5(List.of(
            Model.E5_LARGE_V2
    )),

    /**
     * The {@code GOOGLE} variable represents a list of AI model instances provided by Google.
     * It includes various models from different categories such as language generation,
     * code understanding, image generation, and advanced AI capabilities.
     * <p>
     * This list can be useful to reference all Google-supported models in the context
     * of AI processing, model selection, or integrations.
     */
    GOOGLE(List.of(
            Model.CHAT_BISON_001,
            Model.CHAT_BISON_32K_002,
            Model.CHAT_BISON,
            Model.CODECHAT_BISON_001,
            Model.CODECHAT_BISON_32K_002,
            Model.CODECHAT_BISON,
            Model.GEMINI_PRO,
            Model.GEMINI_PRO_VISION,
            Model.GEMINI_1_5_PRO_PREVIEW,
            Model.GEMINI_1_5_FLASH_001,
            Model.GEMINI_2_0_FLASH_EXP,
            Model.GEMINI_EXP_1206,
            Model.GEMINI_2_0_FLASH_THINKING_EXP,
            Model.TEXTEMBEDDING_GECKO_001,
            Model.IMAGEGENERATION_005
    )),

    /**
     * A constant list containing a predefined selection of AI models from Meta.
     * These models include various versions of Llama and CodeLlama as part of Meta's AI lineup.
     * The list is immutable and provides easy reference to supported Meta AI models.
     */
    META(List.of(
            Model.META_LLAMA3_8B_INSTRUCT_V1,
            Model.META_LLAMA3_70B_INSTRUCT_V1,
            Model.META_LLAMA3,
            Model.META_LLAMA2_13B_CHAT_V1,
            Model.META_LLAMA2_70B_CHAT_V1,
            Model.META_LLAMA2,
            Model.CODELLAMA_34B_INSTRUCT_HF,
            Model.LLAMA_3_8B_INSTRUCT
    )),

    /**
     * The MISTRAL variable represents a collection of three specific AI models
     * provided within the "Mistral" family. These models are designed for
     * advanced natural language and computational tasks, serving different levels
     * of capabilities depending on the specific use case. The models included are:
     * <p>
     * - MISTRAL_7B_INSTRUCT: A 7 billion parameter model tailored for instruction-based tasks.
     * - MIXTRAL_8X7B_INSTRUCT_V0_1: A cluster of eight 7 billion parameter models designed for extensive instruction-following tasks.
     * - MISTRAL_LARGE_AZURE: A large-scale Azure-optimized variant of the Mistral model.
     */
    MISTRAL(List.of(
            Model.MISTRAL_7B_INSTRUCT,
            Model.MIXTRAL_8X7B_INSTRUCT_V0_1,
            Model.MISTRAL_LARGE_AZURE
    )),

    /**
     * The OPENAI variable represents a predefined collection of AI models from the OpenAI ecosystem.
     * These models include various versions of GPT-3.5, GPT-4, DALL-E, and text embedding models,
     * among others.
     * <p>
     * The list provides access to state-of-the-art AI capabilities for natural language processing,
     * image generation, and embedding operations.
     * <p>
     * Each model in the list corresponds to a specific implementation or release of an AI model,
     * uniquely identified by a versioned or descriptive name.
     */
    OPENAI(List.of(
            Model.GPT_35_TURBO_0301,
            Model.GPT_35_TURBO_0613,
            Model.GPT_35_TURBO_1106,
            Model.GPT_35_TURBO_0125,
            Model.GPT_35_TURBO,
            Model.GPT_35_TURBO_16K,
            Model.GPT_4_0613,
            Model.GPT_4,
            Model.GPT_4_1106_PREVIEW,
            Model.GPT_4_0125_PREVIEW,
            Model.GPT_4_TURBO_20240409,
            Model.GPT_4_TURBO,
            Model.GPT_4_32K_0314,
            Model.GPT_4_32K_0613,
            Model.GPT_4_32K,
            Model.GPT_4_VISION_PREVIEW,
            Model.GPT_4O_20240513,
            Model.DALL_E_3,
            Model.TEXT_EMBEDDING_ADA_002,
            Model.TEXT_EMBEDDING_3_LARGE,
            Model.TEXT_EMBEDDING_3_SMALL
    )),

    /**
     * Represents a collection of Stability AI models. These models leverage advanced generative AI
     * capabilities provided by Stability AI, focusing primarily on image generation and enhancement.
     * <p>
     * This list includes the following models:
     * - `STABILITY_SD_XL`: Stability AI's Stable Diffusion XL model for generative image tasks.
     * - `STABILITY_IMAGE_CORE_V1`: A core version of Stability AI's image generation algorithm.
     * - `STABILITY_SD3_LARGE_V1`: Stability AI's third-generation Stable Diffusion model designed for large-scale tasks.
     * - `STABILITY_IMAGE_ULTRA_V1`: An advanced version of Stability AI's ultra-detailed image generation model.
     */
    STABILITY_AI(List.of(
            Model.STABILITY_SD_XL,
            Model.STABILITY_IMAGE_CORE_V1,
            Model.STABILITY_SD3_LARGE_V1,
            Model.STABILITY_IMAGE_ULTRA_V1
    ));

    /**
     * A list of predefined supported AI model configurations.
     * Each model represents a specific AI implementation provided by various vendors such as OpenAI, Amazon, Google, Meta, etc.
     * These models serve different purposes, including natural language processing, image generation, text embedding, and more.
     * This immutable list maintains references to the available {@link Model} instances.
     */
    private final List<Model> models;

    /**
     * Constructs a Vendor instance with the provided list of models.
     *
     * @param models the list of models associated with this vendor
     */
    Vendor(List<Model> models) {
        this.models = models;
    }

    /**
     * Converts a string representation of a vendor's name to its corresponding {@code Vendor} enum instance.
     * The input string is converted to uppercase before determining the {@code Vendor}.
     *
     * @param vendorName the name of the vendor to be converted; it must match a valid {@code Vendor} enum name, ignoring case
     * @return the {@code Vendor} instance corresponding to the specified name
     * @throws IllegalArgumentException if the specified vendor name does not match any {@code Vendor} enum
     */
    public static Vendor fromString(String vendorName) {
        return Vendor.valueOf(vendorName.toUpperCase());
    }
}
