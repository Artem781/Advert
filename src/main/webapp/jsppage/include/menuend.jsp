
</div>
</div>
<c:if test="${nameUser!=null}">
    <form class="form-inline my-2 my-lg-0" action="controller?command=Logout" method="POST">
        <button id="logout" name="logout" class="btn btn-dark">
            <fmt:message key="label.logout" bundle="${rb}"/>
        </button>
    </form>
</c:if>
</div>
</nav>