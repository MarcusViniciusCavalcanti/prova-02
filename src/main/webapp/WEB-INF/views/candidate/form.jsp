<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h:template title="Dashboard">
    <jsp:body>
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Atualizar Dados</h3>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_content">
                                <br/>
                                <%--@elvariable id="candidate" type="br.edu.utfpr.tsi.prova02.domain.entity.Candidate"--%>
                                <form:form modelAttribute="candidate" action="/candidato/atualizar" method="post"
                                           cssClass="form-horizontal form-label-left">
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Nome <span
                                                class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <form:input path="name" name="name" type="text"
                                                   id="name"
                                                   cssClass="form-control col-md-7 col-xs-12" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="office"
                                               class="control-label col-md-3 col-sm-3 col-xs-12">Cargo</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <form:input path="office" name="office" id="office"
                                                   cssClass="form-control col-md-7 col-xs-12" type="text" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Data de nascimento
                                            <span class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <form:input path="birthday" name="birthday"
                                                   id="birthday" class="date-picker form-control col-md-7 col-xs-12"
                                                   required="required" type="text" />
                                        </div>
                                    </div>

                                    <div>
                                        <div class="x_title row grid_slider">
                                            <h2>Habilidades
                                                <small>suas habilidades como desenvolvedor</small>
                                            </h2>
                                            <div class="clearfix"></div>
                                        </div>
                                        <p>Aplicações web</p>
                                        <form:input type="text" id="webApplicationAccuracy"
                                               path="webApplicationAccuracy"
                                               name="webApplicationAccuracy"/>

                                        <p>Designer de Web Sites</p>
                                        <form:input type="text" id="websiteDesignAccuracy"
                                               path="websiteDesignAccuracy"
                                               name="websiteDesignAccuracy"/>

                                        <p>Testes automatizados</p>
                                        <form:input type="text" id="testAccuracy"
                                               path="testAccuracy"
                                               name="testAccuracy"/>

                                        <p>Ui Uix</p>
                                        <form:input type="text" id="uiUixAccuracy"
                                               path="uiUixAccuracy"
                                               name="uiUixAccuracy"/>


                                        <div class="ln_solid"></div>
                                        <div class="form-group">
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                <a href="/candidato/dashboard" class="btn btn-primary" type="button">Cancelar</a>
                                                <button type="submit" class="btn btn-success">Enviar</button>
                                            </div>
                                        </div>
                                    </div>

                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</h:template>