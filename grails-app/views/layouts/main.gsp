<!DOCTYPE HTML>
<html>
<head>
<r:require modules="bootstrap" />
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<r:layoutResources />
<g:layoutHead />
</head>
<body>
	<!-- navigation, what else? -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="/goty/">Spendings</a>
				<div class="nav-collapse"></div>
			</div>
		</div>
	</div>

	<!-- body -->
	<g:layoutBody />
	<r:layoutResources />

	<!-- footer -->
	<footer> </footer>
</body>
</html>