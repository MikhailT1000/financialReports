<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add allData</title>
    <link rel="stylesheet" type="text/css" href="/static/styles/main.css">
</head>
<body>

<form:form method="post"
           action="/add-allData"
           enctype="application/x-www-form-urlencoded"
           modelAttribute="allData"
>
    <p>
        <label>
            Дата покупки:
            <form:input path="purchaseDate" type="date" />
        </label>
    </p>
    <p>
        <label>
            Дата продажи:
            <form:input path="saleDate" type="date" />
        </label>
    </p>

    <p>
        <label>
            Марка:
            <select>
                <option value="JAGUAR">Jaguar</option>
                <option value="Land Rover">Land Rover</option>
                <option value="Porsche">Porsche</option>
            </select>
        </label>
    </p>

    <p>
        <label>
            Модель:
            <select>
                <option value="XE">XE</option>
                <option value="F-Pace">F-Pace</option>
                <option value="F-Type">F-Type</option>
                <option value="XF">XF</option>
                <option value="E-Pace">E-Pace</option>
                <option value="Discovery">Discovery</option>
                <option value="Range Rover">Range Rover</option>
                <option value="Range Rover Evoque">Range Rover Evoque</option>
                <option value="Freelander 2">Freelander 2</option>
                <option value="Velar">Velar</option>
                <option value="718 Cayman">718 Cayman</option>
                <option value="Cayenne">Cayenne</option>
                <option value="Macan">Macan</option>
                <option value="Panamera">Panamera</option>
                <option value="911 GT3">911 GT3</option>
            </select>
        </label>
    </p>

    <p>
        <label>
            Цена покупки:
            <form:input path="purchasePrice" type="number" min="0.00" />
        </label>
    </p>

    <p>
        <label>
            Цена продажи:
            <form:input path="salePrice" type="number" />
        </label>
    </p>

    <p>
        <label>
            Скидка:
            <select>
                <option value="300.00">300000.00</option>
                <option value="400.00">400000.00</option>
                <option value="500.00">500000.00</option>
            </select>
        </label>
    </p>

    <p>
        <label>
            Себестоимость:
            <form:input path="costPrice" type="number" min="0.00" />
        </label>
    </p>

    <p>
        <label>
            Тип машины:
            <select>
                <option value="New">New</option>
                <option value="Used">Used</option>
            </select>
        </label>
    </p>


    <p>
        <label>
            Количество:
            <form:input path="quantity" type="number" min="1" />
        </label>
    </p>

    <p>
        <input type="submit">
    </p>

    <form:errors cssClass="error" />
</form:form>
</body>
</html>