package br.com.bravi.breaktheice.util.constant

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
object WebserviceConstant {

    const val WEBSERVICE_BASEURL: String = "http://www.boredapi.com"
    private const val WEBSERVICE_PATH_SEGMENT: String = "/api"
    const val WEBSERVICE_ENDPOINT_ACTIVITY: String = "$WEBSERVICE_PATH_SEGMENT/activity"
    const val WEBSERVICE_QUERY_TYPE: String = "type"
}
