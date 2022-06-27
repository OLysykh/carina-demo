package com.qaprosoft.carina.demo.api.oleksandrAPI;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;


// DOES NOT WORK!
@Endpoint(url = "${base_url}/users/2", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/reqres/delete/rq.json")
@ResponseTemplatePath(path = "api/reqres/delete/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.NO_CONTENT_204)
public class DeleteReqresUserMethod extends AbstractApiMethodV2 {

    public DeleteReqresUserMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}