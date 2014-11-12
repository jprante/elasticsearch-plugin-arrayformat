package org.xbib.elasticsearch.rest.arrayformat

import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.common.xcontent.XContentBuilder
import org.elasticsearch.rest.BytesRestResponse
import org.elasticsearch.rest.RestChannel
import org.elasticsearch.rest.RestResponse
import org.elasticsearch.rest.action.support.RestResponseListener

class ArrayformatToXContentListener extends RestResponseListener<SearchResponse> {

    protected ArrayformatToXContentListener(RestChannel channel) {
        super(channel)
    }

    @Override
    RestResponse buildResponse(SearchResponse searchResponse) throws Exception {
        return buildResponse(searchResponse, channel.newBuilder())
    }

    static RestResponse buildResponse(SearchResponse response, XContentBuilder builder) {
        builder.startArray()
        response.hits?.each { h -> builder.map(h.source)}
        builder.endArray()
        return new BytesRestResponse(response.status(), builder)
    }

}
