<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:template title="${title}">

    <div class="right_col" role="main" style="height: 100%">
        <div class="">
            <div class="page-title">
                <div class="title_left">
                    <h3>${title}</h3>
                </div>

            <div class="clearfix"></div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>${action}</h2>
                        <div class="x_content">
                            <spring:url value="${job.id == null ? '/vagas/save' : '/vagas/update' }" var="save"/>
                            <%--@elvariable id="job" type="br.edu.utfpr.tsi.prova02.domain.entity.Job"--%>
                            <form:form modelAttribute="job" action="${save}" method="post" cssClass="form-horizontal form-label-left">
                                <form:hidden path="id" />
                                <span class="section">Informações da vaga</span>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="title">Title <span class="required">*</span></label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:input path="title" id="title" cssClass="form-control col-md-7 col-xs-12" />
                                        <form:errors path="title" cssClass="label-danger"/>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="description">Descrição <span class="required">*</span></label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:textarea path="description" cssClass="form-control col-md-7 col-xs-12" id="description" />
                                        <form:errors path="description" cssClass="label-danger"/>
                                    </div>
                                </div>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-md-offset-3">
                                        <a class="btn btn-primary" href="/vagas">Cancelar</a>
                                        <button id="send" type="submit" class="btn btn-success">Enviar</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${!empty error}">
        <div class=".error" role="errors" hidden>${error}</div>
    </c:if>

    <c:if test="${!empty success}">
        <div class=".success" role="success" hidden>${success}</div>
    </c:if>
</t:template>
