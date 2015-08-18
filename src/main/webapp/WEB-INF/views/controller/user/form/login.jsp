<%--
  Created by IntelliJ IDEA.
  User: Mateusz Brycki
  Date: 27/05/2015
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>


  <form id='user-login-form' action="${pageContext.request.contextPath}/user/login" method='POST' class="form-horizontal">

      <div class="form-group">
        <label class="control-label col-sm-3" for="userLogin">Login: </label>
        <div class="col-sm-5">
          <input type="text" name="mail" class="form-control"/>
        </div>
      </div>

      <div class="form-group">
        <label class="control-label col-sm-3" for="userPassword">Password: </label>
        <div class="col-sm-5">
          <input type="password" name="password" class="form-control"/>
        </div>
      </div>


    <input type="submit" id="login-user" name="submit" value="Login" class="btn btn-primary"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

  </form>
