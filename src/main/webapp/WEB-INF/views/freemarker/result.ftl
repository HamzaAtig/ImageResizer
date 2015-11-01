<#import "spring.ftl" as spring />
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<#include "common.ftl">
</head>

<body>

<h1>Result page </h1>

	<#if fileNames??>
		<#list fileNames as file>

			<label>${file}</label>
		</#list>
	</#if>

	<#if results??>
		<#list results as result>

			<label>${result}</label>
		</#list>

	<#else>
		<label>No result found.</label>
	</#if>
</body>
</html>