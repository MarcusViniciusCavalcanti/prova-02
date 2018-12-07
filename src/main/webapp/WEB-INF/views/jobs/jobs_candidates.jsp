<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Vagas">
    <div class="right_col" role="main" style="height: 100%">
    <div class="">
    <div class="page-title">
        <div class="title_left">
            <h3>Devenvoldores interessados na vaga</h3>
        </div>
    </div>

    <div class="clearfix"></div>

    <div class="row">
        <div class="col-md-12">
            <div class="x_panel">
                <div class="x_content">
                    <c:choose>
                        <c:when test="${candidates.isEmpty()}">
                            <div class="row">
                                <h3>Nem cadidate está interessado nesta vaga!</h3>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${candidates}" var="candidate">
                                <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                <div class="well profile_view">
                                <div class="col-sm-12">
                                    <h4 class="brief"><i>Digital Strategist</i></h4>
                                    <div class="left col-xs-7">
                                        <h2>Nicole Pearson</h2>
                                        <ul class="list-unstyled">
                                            <li><i class="fa fa-building"></i> Endereço: ${candidate.fullAddress()}</li>
                                        </ul>
                                        <ul class="list-unstyled user_data">
                                            <li>
                                                <p>Web Applications</p>
                                                <div class="progress progress_sm">
                                                    <div class="progress-bar bg-green" role="progressbar"
                                                         data-transitiongoal="${candidate.webApplicationAccuracy}"></div>
                                                </div>
                                            </li>
                                            <li>
                                                <p>Website Design</p>
                                                <div class="progress progress_sm">
                                                    <div class="progress-bar bg-green" role="progressbar"
                                                         data-transitiongoal="${candidate.websiteDesignAccuracy}"></div>
                                                </div>
                                            </li>
                                            <li>
                                                <p>Automation & Testing</p>
                                                <div class="progress progress_sm">
                                                    <div class="progress-bar bg-green" role="progressbar"
                                                         data-transitiongoal="${candidate.testAccuracy}"></div>
                                                </div>
                                            </li>
                                            <li>
                                                <p>UI / UX</p>
                                                <div class="progress progress_sm">
                                                    <div class="progress-bar bg-green" role="progressbar"
                                                         data-transitiongoal="${candidate.uiUixAccuracy}"></div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="right col-xs-5 text-center">
                                        <img src="/resources/images/members/images.jpeg" alt="" class="img-circle img-responsive">
                                    </div>
                                </div>
                            </c:forEach>
                            </div>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </div>

</t:template>
