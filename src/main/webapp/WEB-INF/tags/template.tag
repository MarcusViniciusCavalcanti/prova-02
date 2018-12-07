<%@ tag description="Template" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>

<%@ attribute name="title" type="java.lang.String" %>

<h:head title="${title}">
    <jsp:body>
        <body class="nav-md" style="height: 100%">
            <div class="container body">
                <div class="main_container">
                    <div class="col-md-3 left_col">
                        <div class="left_col scroll-view">
                            <div class="navbar nav_title" style="border: 0;">
                                <a href="${pageContext.request.contextPath}/candidato/dashboard" class="site_title">
                                    <i class="fa fa-paw"></i>
                                    <span>Candidate Dev</span>
                                </a>
                            </div>

                            <div class="clearfix"></div>

                            <!-- menu profile quick info -->
                            <div class="profile clearfix">
                                <div class="profile_pic">
                                    <img src="/resources/images/members/images.jpeg"
                                         alt="..." class="img-circle profile_img">
                                </div>
                                <div class="profile_info">
                                    <span>Welcome,</span>
                                    <h2>${sessionScope.candidate.name}</h2>
                                </div>
                            </div>

                            <div class="clearfix"></div>

                            <br/>

                            <h:sidebar/>

                        </div>
                </div>

                <h:topbar/>

                <jsp:doBody/>

                <footer>
                    <div class="pull-right">
                        Candidate Dev - Projeto construido na UTFPR
                    </div>

                    <div class="clearfix"></div>
                </footer>
            </div>
        </div>

            <c:if test="${!empty error}">
                <div class=".error" role="errors">${error}</div>
            </c:if>

            <script src="/resources/vendor/jquery/dist/jquery.js"></script>
            <script src="/resources/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
            <script src="/resources/vendor/bootstrap-progressbar/bootstrap-progressbar.js"></script>
            <script src="/resources/vendor/jquery-sparkline/dist/jquery.sparkline.js"></script>
            <script src="/resources/vendor/ion.rangeSlider/js/ion.rangeSlider.js"></script>
            <script src="/resources/vendor/nprogress/nprogress.js"></script>
            <script src="/resources/vendor/pnotify/dist/pnotify.js"></script>
                <%--<script src="/resources/vendor/validator/validator.js"></script>--%>
            <script src="/resources/js/notify_message.js"></script>

            <script src="/resources/vendor/datatables.net/js/jquery.dataTables.min.js"></script>
            <script src="/resources/vendor/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
            <script src="/resources/vendor/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
            <script src="/resources/vendor/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
            <script src="/resources/vendor/datatables.net-buttons/js/buttons.flash.min.js"></script>
            <script src="/resources/vendor/datatables.net-buttons/js/buttons.html5.min.js"></script>
            <script src="/resources/vendor/datatables.net-buttons/js/buttons.print.min.js"></script>
            <script src="/resources/vendor/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
            <script src="/resources/vendor/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
            <script src="/resources/vendor/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
            <script src="/resources/vendor/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
            <script src="/resources/vendor/datatables.net-scroller/js/dataTables.scroller.min.js"></script>

            <script src="/resources/js/custom.js"></script>
        </body>
    </jsp:body>
</h:head>

