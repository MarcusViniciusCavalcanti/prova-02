
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:head title="Dashboard">
    <jsp:body>
        <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <!-- page content -->
                <div class="col-md-12">
                    <div class="col-middle">
                        <div class="text-center text-center">
                            <h1 class="error-number">404</h1>
                            <h2>Sorry but we couldn't find this page</h2>
                            <p>This page you are looking for does not exist <a href="#">Report this?</a>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- /page content -->
            </div>
        </div>


        <c:if test="${!empty error}">
            <div class=".error" role="errors">${error}</div>
        </c:if>

        <script src="${pageContext.request.contextPath}/assets/vendor/jquery/dist/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/jquery-sparkline/dist/jquery.sparkline.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/nprogress/nprogress.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/pnotify/dist/pnotify.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/notify_message"></script>
        <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
        </body>
    </jsp:body>
</t:head>
