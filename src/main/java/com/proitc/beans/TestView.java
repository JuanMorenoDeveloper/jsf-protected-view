package com.proitc.beans;

import java.io.Serializable;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "testView")
@ViewScoped
public class TestView implements Serializable {

  private static final long serialVersionUID = 1L;

  public void testNavegation() {
    ConfigurableNavigationHandler navigationHandler = (ConfigurableNavigationHandler) FacesContext
        .getCurrentInstance().getApplication().getNavigationHandler();
    navigationHandler.performNavigation("test_secure_with_params.xhtml?id=5&faces-redirect=true");
  }
}
