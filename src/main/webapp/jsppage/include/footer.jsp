<div style=" position: unset; /* Фиксированное положение */
            left: 0;
            bottom: 0; /* Левый нижний угол */
            /*    padding: 10px; !* Поля вокруг текста *!*/
            /*  background: #e9e5ff; !* Цвет фона *!*/
            color: black; /* Цвет текста */
            /*width: 100%; !* Ширина слоя *!*/
            font-size: 11pt;" align=center id="footer">
    <fmt:message key="label.today" bundle="${rb}"/><fmt:formatDate value="${now}"/>
    / <ctg:footer-info/>
</div>
