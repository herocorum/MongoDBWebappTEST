<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="captcha" uri="/WEB-INF/tlds/captcha.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<title>Home</title>
</head>
<body>


<%-- 	<captcha:captcha themeName="clean" publickey="6LfNDAgTAAAAAHNWpjniSdeenSgNW309s8BfFIRD" privatekey="6LfNDAgTAAAAAFg2WcqpMNJfAUi_S-W4cxz31tPT"/> --%>
	
<form action="" method="post">
 
      <label for="name">Name:</label>
      <input name="name" required><br />
 
      <label for="email">Email:</label>
      <input name="email" type="email" required><br />
 
    <div class="g-recaptcha" data-sitekey="6LfNDAgTAAAAAHNWpjniSdeenSgNW309s8BfFIRD"></div>
 
      <input type="submit" value="Submit" />
 
    </form>
<script src='https://www.google.com/recaptcha/api.js'></script>
</body>
</html>

