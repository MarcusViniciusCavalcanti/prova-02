<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>

<h:template title="Dashboard">
    <jsp:body>
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Dashboard</h3>
                    </div>

                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_content">
                                    <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
                                        <div class="profile_img">
                                            <div id="crop-avatar">
                                                <!-- Current avatar -->
                                                <img class="img-responsive avatar-view"
                                                     src="/resources/images/members/images.jpeg"
                                                     alt="Avatar" title="Change the avatar">
                                            </div>
                                        </div>

                                        <h3>${sessionScope.candidate.name}</h3>

                                        <ul class="list-unstyled user_data">
                                            <li><i class="fa fa-map-marker user-profile-icon"></i> ${sessionScope.candidate.fullAddress()}
                                            </li>

                                            <li>
                                                <i class="fa fa-briefcase user-profile-icon"></i> ${sessionScope.candidate.office}
                                            </li>

                                            <li class="m-top-xs">
                                                <i class="fa fa-external-link user-profile-icon"></i>
                                                <a href="http://www.kimlabs.com/profile/" target="_blank">www.kimlabs.com</a>
                                            </li>
                                        </ul>

                                        <a class="btn btn-success" href="/candidato/atualizar"><i class="fa fa-edit m-right-xs"></i>Editar</a>
                                        <br />

                                        <h4>Skills</h4>
                                        <ul class="list-unstyled user_data">
                                            <li>
                                                <p>Web Applications</p>
                                                <div class="progress progress_sm">
                                                    <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="${sessionScope.candidate.webApplicationAccuracy}"></div>
                                                </div>
                                            </li>
                                            <li>
                                                <p>Website Design</p>
                                                <div class="progress progress_sm">
                                                    <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="${sessionScope.candidate.websiteDesignAccuracy}"></div>
                                                </div>
                                            </li>
                                            <li>
                                                <p>Automation & Testing</p>
                                                <div class="progress progress_sm">
                                                    <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="${sessionScope.candidate.testAccuracy}"></div>
                                                </div>
                                            </li>
                                            <li>
                                                <p>UI / UX</p>
                                                <div class="progress progress_sm">
                                                    <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="${sessionScope.candidate.uiUixAccuracy}"></div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="col-md-9 col-sm-9 col-xs-9">
                                        <table id="datatable-buttons" class="table table-striped table-bordered">
                                            <thead>
                                            <td>Titulo</td>
                                            <td>Descrição</td>
                                            <td>Candidatar</td>
                                            </thead>
                                            <c:forEach items="${jobs}" var="job">
                                                <tr>
                                                    <td>${job.title}</td>
                                                    <td>${job.description}</td>
                                                    <td>
                                                        <a class="btn btn-danger" href="/vagas/candidatar/${job.id}">Candidatar</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
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
    </jsp:body>
</h:template>