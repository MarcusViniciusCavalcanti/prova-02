<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h:template title="Vagas">
    <div class="right_col" role="main">
    <div class="">
    <div class="page-title">
        <div class="title_left">
            <h3>Vagas
                <small>Lista de todas as Vagas</small>
            </h3>
        </div>
    </div>

    <div class="clearfix"></div>

    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title"></div>
                <div class="x_content">
                    <table id="datatable-buttons" class="table table-striped table-bordered">
                        <thead>
                        <td>Titulo</td>
                        <td>Descrição</td>
                        <security:authorize access="hasRole('ROLE_USER')">
                            <td>Ações</td>
                        </security:authorize>
                        </thead>

                        <tbody>
                        <c:forEach items="${jobs}" var="job">
                            <tr>
                                <td>${job.title}</td>
                                <td>${job.description}</td>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <td>
                                        <a class="btn btn-default" href="/vagas/atualizar/${job.id}">Editar</a>
                                        <a class="btn btn-danger" href="/vagas/deletar/${job.id}">Deletar</a>
                                        <a class="btn btn-success" href="/vagas/candidatos/${job.id}">Candidatos</a>
                                    </td>
                                </security:authorize>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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
</h:template>
