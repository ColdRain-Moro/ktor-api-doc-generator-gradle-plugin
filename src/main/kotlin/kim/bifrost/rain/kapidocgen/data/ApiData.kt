package kim.bifrost.rain.kapidocgen.data

import com.google.gson.JsonObject

/**
 * kim.bifrost.rain.kapidocgen.data.ApiData
 * KtorAPIDocGenerator-GradlePlugin
 *
 * @author 寒雨
 * @since 2022/5/3 11:40
 **/
data class ApiData(
    val name: String,
    val method: String,
    val route: String,
    val queryParams: List<ApiParams>,
    val bodyParamsType: String?,
    val bodyParams: List<ApiParams>,
    val response: Response
)

data class Response(
    val fields: JsonObject,
    val kotlinBean: String
)

data class ApiParams(
    val key: String,
    val valueType: String?,
    val desc: String,
    val optional: Boolean
)