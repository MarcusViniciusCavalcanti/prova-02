<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>

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
                            <%--<td>Ações</td>--%>
                        </thead>

                        <tbody>
                            <c:forEach items="${jobs}" var="job">
                                <tr>
                                    <td>${job.title}</td>
                                    <td>${job.description}</td>
                                    <%--<td><a class="btn btn-default" href="${pageContext.request.contextPath}/jobs/update?id=${job.id}">Editar</a></td>--%>
                                    <%--<td><a class="btn btn-danger" href="${pageContext.request.contextPath}/jobs/remove?id=${job.id}">Remover</a></td>--%>
                                    <%--<td><a class="btn btn-default" href="${pageContext.request.contextPath}/protected/candidate/jobs/add?jobId=${job.id}&candidateId=${candidate.id}">Candidatar</a></td>--%>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${!empty messageError}">
        <div class=".error" role="errors" hidden>${messageError}</div>
    </c:if>

    <c:if test="${!empty message}">
        <div class=".success" role="success" hidden>${message}</div>
    </c:if>
</h:template>
