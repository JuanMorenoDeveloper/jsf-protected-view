package com.proitc.config;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.faces.RIConstants;
import com.sun.faces.context.ExternalContextImpl;
import com.sun.faces.context.UrlBuilder;

public class CustomExternalContext extends ExternalContextImpl {

  public CustomExternalContext(ServletContext sc, ServletRequest request,
      ServletResponse response) {
    super(sc, request, response);
  }

  @Override
  public String encodeBookmarkableURL(String baseUrl, Map<String, List<String>> parameters) {
    FacesContext context = FacesContext.getCurrentInstance();
    String encodingFromContext =
        (String) context.getAttributes().get(RIConstants.FACELETS_ENCODING_KEY);
    if (null == encodingFromContext) {
      encodingFromContext =
          (String) context.getViewRoot().getAttributes().get(RIConstants.FACELETS_ENCODING_KEY);
    }
    String currentResponseEncoding =
        (null != encodingFromContext) ? encodingFromContext : getResponseCharacterEncoding();
    UrlBuilder builder = new UrlBuilder(baseUrl, currentResponseEncoding);
    builder.addParameters(parameters);
    String secureUrl = builder.createUrl();

    if (parameters.size() > 0 && baseUrl.contains("javax.faces.Token")) {
      try {
        int beginToken = secureUrl.indexOf("javax.faces.Token");
        int endToken = secureUrl.indexOf("&") - 1;
        String doubleEncodeToken = secureUrl.substring(beginToken, endToken);
        String encodeToken = URLDecoder.decode(doubleEncodeToken, currentResponseEncoding);
        secureUrl = secureUrl.replace(doubleEncodeToken, encodeToken);
      } catch (UnsupportedEncodingException e) {
        throw new RuntimeException(e);
      }
    }
    return secureUrl;
  }

  @Override
  public String encodeRedirectURL(String baseUrl, Map<String, List<String>> parameters) {
    FacesContext context = FacesContext.getCurrentInstance();
    String encodingFromContext =
        (String) context.getAttributes().get(RIConstants.FACELETS_ENCODING_KEY);
    if (null == encodingFromContext) {
      encodingFromContext =
          (String) context.getViewRoot().getAttributes().get(RIConstants.FACELETS_ENCODING_KEY);
    }

    String currentResponseEncoding =
        (null != encodingFromContext) ? encodingFromContext : getResponseCharacterEncoding();

    UrlBuilder builder = new UrlBuilder(baseUrl, currentResponseEncoding);
    builder.addParameters(parameters);
    String secureUrl = builder.createUrl();

    if (parameters.size() > 0 && baseUrl.contains("javax.faces.Token")) {
      try {
        int beginToken = secureUrl.indexOf("javax.faces.Token");
        int endToken = secureUrl.indexOf("&") - 1;
        String doubleEncodeToken = secureUrl.substring(beginToken, endToken);
        String encodeToken = URLDecoder.decode(doubleEncodeToken, currentResponseEncoding);
        secureUrl = secureUrl.replace(doubleEncodeToken, encodeToken);
      } catch (UnsupportedEncodingException e) {
        throw new RuntimeException(e);
      }
    }
    return secureUrl;
  }

}
