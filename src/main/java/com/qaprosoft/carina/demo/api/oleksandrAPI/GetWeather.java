package com.qaprosoft.carina.demo.api.oleksandrAPI;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;


@Endpoint(url = "${base_url}/weather?lat=35&lon=139&appid=46ad646a46ebd0606746c40d0f19d357", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/weather/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetWeather extends AbstractApiMethodV2 {

    public GetWeather() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }

}
