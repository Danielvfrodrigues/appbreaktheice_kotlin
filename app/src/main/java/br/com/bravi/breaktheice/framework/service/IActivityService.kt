package br.com.bravi.breaktheice.framework.service

import br.com.bravi.breaktheice.domain.entity.ActivityModel
import br.com.bravi.breaktheice.util.constant.WebserviceConstant.WEBSERVICE_ENDPOINT_ACTIVITY
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
interface IActivityService {

    @GET(WEBSERVICE_ENDPOINT_ACTIVITY)
    fun doActivity(): Observable<ActivityModel?>

    @GET(WEBSERVICE_ENDPOINT_ACTIVITY)
    fun doActivityFiltered(@QueryMap options: MutableMap<String, String>?): Observable<ActivityModel?>
}
