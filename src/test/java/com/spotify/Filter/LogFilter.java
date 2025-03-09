package com.spotify.Filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LogFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
        logResponse(response);
        return response;
    }

    private void logRequest(FilterableRequestSpecification filterableRequestSpecification){
        logger.info("Current Request Specifications are ->");
        logger.info("Headers : {}", filterableRequestSpecification.getHeaders());
        logger.info("Content-Type :{}", filterableRequestSpecification.getContentType());
        logger.info("Query Params :{}", filterableRequestSpecification.getQueryParams());
        logger.info("Path Params :{}", filterableRequestSpecification.getPathParams());
        logger.info("Body : " + filterableRequestSpecification.getBody());
    }

    private void logResponse(Response response){
        logger.info("Response is ->");
        logger.info("Status Code : {}", response.getStatusCode());
//        logger.info("Response Body :{}", response.getBody().prettyPrint());
    }
}
