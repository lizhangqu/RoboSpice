package cn.edu.zafu.robospicedemo.webservice;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.jackson2.JacksonFactory;

import cn.edu.zafu.robospicedemo.webservice.json.PersonJson;

/**
 * Created by lizhangqu on 2015/4/15.
 */
public class PersonRequest extends BaseGoogleHttpClientSpiceRequest<PersonJson> {

    public PersonRequest() {
        super(PersonJson.class);
    }

    @Override
    public PersonJson loadDataFromNetwork() throws Exception {

        HttpRequest request = null;
        GenericUrl genericUrl = new GenericUrl(url);

        if (postParameters == null) {
            request = getHttpRequestFactory().buildGetRequest(genericUrl);
        } else {
            HttpContent content = new UrlEncodedContent(postParameters);
            request = buildPostRequest(genericUrl, content);
        }
        request.setParser(new JacksonFactory().createJsonObjectParser());

        return request.execute().parseAs(getResultType());
    }

}
