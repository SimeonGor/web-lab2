<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Checker</title>

    <link href="style/css/main.css" rel="stylesheet" type="text/css" />
    <link href="style/css/graph.css" rel="stylesheet" type="text/css" />
    <link href="style/css/form.css" rel="stylesheet" type="text/css" />


</head>
<body>

<jsp:include page="header.jsp" />

<main>
    <div class="graph-data">
        <div class="graph-container">
            <svg id="graph" height="300" width="300" xmlns="http://www.w3.org/2000/svg">
                <!-- figure -->
                <path class="area" stroke-width="3"
                      d="M100 150 l 0 100 l 50 0 l 0 -100 l 100 0 a 100 100 0 0 0 -100 -100 l -50 100 Z"></path>

                <!-- lines -->
                <line stroke="black" x1="0" x2="300" y1="150" y2="150"></line>
                <line stroke="black" x1="150" x2="150" y1="0" y2="300"></line>
                <polygon fill="black" points="150,0 144,15 156,15" stroke="black"></polygon>
                <polygon fill="black" points="300,150 285,156 285,144" stroke="black"></polygon>

                <!-- lines on lines -->
                <line stroke="black" x1="200" x2="200" y1="155" y2="145"></line>
                <line stroke="black" x1="250" x2="250" y1="155" y2="145"></line>

                <line stroke="black" x1="50" x2="50" y1="155" y2="145"></line>
                <line stroke="black" x1="100" x2="100" y1="155" y2="145"></line>

                <line stroke="black" x1="145" x2="155" y1="100" y2="100"></line>
                <line stroke="black" x1="145" x2="155" y1="50" y2="50"></line>

                <line stroke="black" x1="145" x2="155" y1="200" y2="200"></line>
                <line stroke="black" x1="145" x2="155" y1="250" y2="250"></line>

                <text fill="black" x="285" y="140">X</text>
                <text fill="black" x="160" y="15">Y</text>

                <!-- Rs and X, Y -->
                <text fill="black" x="195" y="140">R/2</text>
                <text fill="black" x="250" y="140">R</text>

                <text fill="black" x="40" y="140">-R</text>
                <text fill="black" x="85" y="140">-R/2</text>

                <text fill="black" x="160" y="55">R</text>
                <text fill="black" x="160" y="105">R/2</text>

                <text fill="black" x="160" y="204">-R/2</text>
                <text fill="black" x="160" y="255">-R</text>
            </svg>
        </div>

        <form id="coordinates-form" method="GET" action='<c:url value="/controller" />'>
            <div id="x-field" class="value-input">
                <div>
                    <label>X:</label>
                    <label>
                        <select name="x" required>
                            <option value="" disabled>--select x--</option>
                            <c:forEach var="x" items=" -5, -4, -3, -2, -1, 0, 1, 2, 3 ">
                                <option value="${x}">${x}</option>
                            </c:forEach>
                        </select>
                    </label>
                </div>
            </div>
            <div id="y-field" class="value-input">
                <label>
                    Y:
                    <input id="y-input" type="text" name="y" placeholder="(-3; 5)" maxlength="30" autocomplete="off" required>
                </label>
            </div>
            <div id="r-field" class="value-input">
                <div>
                    <label>R:</label>
                    <c:forEach var="r" items=" 1, 1.5, 2, 2.5, 3 ">
                        <label class="radio-label">
                            <input type="radio" name="r" value="${r}" required>${r}
                        </label>
                    </c:forEach>
                </div>
            </div>
            <button class="submit-button" type="submit">Отправить</button>
        </form>
    </div>

    <jsp:include page="table.jsp" />
</main>

<footer>
</footer>

<script type="text/javascript" src="script/validator.js"></script>
<script type="text/javascript" src="script/area.js"></script>
</body>
</html>