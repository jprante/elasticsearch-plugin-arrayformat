package org.xbib.elasticsearch.rest.arrayformat

import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.client.Client
import org.elasticsearch.common.inject.Inject
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.rest.BaseRestHandler
import org.elasticsearch.rest.RestChannel
import org.elasticsearch.rest.RestController
import org.elasticsearch.rest.RestRequest
import org.elasticsearch.rest.action.search.RestSearchAction

class ArrayformatRestSearchAction extends BaseRestHandler {

    @Inject
    public ArrayformatRestSearchAction(Settings settings, RestController controller, Client client) {
        super(settings, controller, client)

        controller.registerHandler(RestRequest.Method.GET, "/_search_arrayformat", this)
        controller.registerHandler(RestRequest.Method.POST, "/_search_arrayformat", this)
        controller.registerHandler(RestRequest.Method.GET, "/{index}/_search_arrayformat", this)
        controller.registerHandler(RestRequest.Method.POST, "/{index}/_search_arrayformat", this)
        controller.registerHandler(RestRequest.Method.GET, "/{index}/{type}/_search_arrayformat", this)
        controller.registerHandler(RestRequest.Method.POST, "/{index}/{type}/_search_arrayformat", this)

        controller.registerHandler(RestRequest.Method.GET, "/_search_arrayformat/template", this)
        controller.registerHandler(RestRequest.Method.POST, "/_search_arrayformat/template", this)
        controller.registerHandler(RestRequest.Method.GET, "/{index}/_search_arrayformat/template", this)
        controller.registerHandler(RestRequest.Method.POST, "/{index}/_search_arrayformat/template", this)
        controller.registerHandler(RestRequest.Method.GET, "/{index}/{type}/_search_arrayformat/template", this)
        controller.registerHandler(RestRequest.Method.POST, "/{index}/{type}/_search_arrayformat/template", this)
    }

    @Override
    public void handleRequest(RestRequest request, RestChannel channel, Client client) throws Exception {
        SearchRequest searchRequest = RestSearchAction.parseSearchRequest(request)
        searchRequest.listenerThreaded(false)
        client.search(searchRequest, new ArrayformatToXContentListener(channel))
    }
}
