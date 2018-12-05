<%@tag description="Header" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@attribute name="title"%>

<html lang="pt-br">
    <head>
        <title>${title}</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="stylesheet" href="/resources/vendor/bootstrap/dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="/resources/css/font-awesome.css"/>

        <link rel="stylesheet" href="/resources/vendor/nprogress/nprogress.css">
        <link rel="stylesheet" href="/resources/vendor/pnotify/dist/pnotify.css">

        <link rel="stylesheet" href="/resources/vendor/animate.css/animate.min.css">

        <link rel="stylesheet" href="/resources/css/custom.min.css"/>

        <link rel="stylesheet" href="/resources/vendor/ion.rangeSlider/css/ion.rangeSlider.css">
        <link rel="stylesheet" href="/resources/vendor/ion.rangeSlider/css/ion.rangeSlider.skinFlat.css">
    </head>

    <jsp:doBody />
</html>