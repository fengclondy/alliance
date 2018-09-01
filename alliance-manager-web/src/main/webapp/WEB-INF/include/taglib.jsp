<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- <%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %> --%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/resources"/>
<script type="text/javascript">
  var ctx="${ctx}";
  var ctxStatic="${ctxStatic}";
</script>