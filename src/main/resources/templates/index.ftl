<#-- @ftlvariable name="compliment" type="String" -->
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/static/css/styles.css">
    <title>Compliment generator</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<header>
    <h1>Compliment generator</h1>
</header>
<div id="content">
    <p id="compliment">${compliment}</p>
    <input id="getComplimentButton" type="button" value="Get a new compliment"/>
    <script type="text/javascript" src="/static/js/handleButtonClick.js"></script>
</div>
</body>
</html>
