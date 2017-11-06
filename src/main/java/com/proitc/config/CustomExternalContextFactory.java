package com.proitc.config;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextFactory;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExternalContextFactory extends ExternalContextFactory {

  private ExternalContextFactory externalContextFactory;

  public CustomExternalContextFactory() {}

  public CustomExternalContextFactory(ExternalContextFactory externalContextFactory) {
    this.externalContextFactory = externalContextFactory;
  }

  @Override
  public ExternalContext getExternalContext(Object context, Object request, Object response)
      throws FacesException {

    ExternalContext handler = new CustomExternalContext((ServletContext) context,
        (HttpServletRequest) request, (HttpServletResponse) response);

    return handler;
  }

}
