<#import "spring.ftl" as spring />
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<#include "common.ftl">
</head>

<body>

<h1>Search page </h1>
	
	<form action="${rc.getContextPath()}/search" class="form-horizontal" modelAttribute="searchRequest" method="POST" enctype="multipart/form-data" data-toggle="validator">

		<#if strategies??>
			<div class="row form-group">
			<label class="col-sm-4 control-label" class="control-label"
						for="selectedStrategy">Choose search strategy : </label>
				<select  class="col-sm-4 name="selectedStrategy" value="${selectedStrategy!}"  required>
					<option  selected="true"></option>
					<#list strategies as strategy>
		  				<option value="${strategy}">${strategy}</option>
		  			</#list>
				</select>
				<div class="col-sm-4" >
				</div>
			</div>
		</#if> 

		<div class="row form-group">
			<label class="col-sm-4 control-label" class="control-label"
						for="imageDesc">Select image description to upload : </label>

			<input class="col-sm-4 btn btn-file" type="file" name="imageDesc" accept=".xml" >
			<div class="col-sm-4" >
			</div>
		</div>

		<div class="row form-group">
			<label class="col-sm-4 control-label" class="control-label"
						for="imageDesc">Select image source to upload : </label>
			<input class="col-sm-4 btn btn-file" type="file" name="imageSrc" accept=".jpg,.png" required>
			<div class="col-sm-4" >
			</div>
		</div>
		
		<div class="row form-group">
			<div class="col-sm-4" >
			</div>
			<div class="col-sm-4" >
				<button type="submit" class="btn btn-primary btn-lg">search</button>
			</div>
			<div class="col-sm-4" >
			</div>
		</div>
	</form>
</body>
</html>