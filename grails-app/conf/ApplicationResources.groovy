modules = {
    application {
        resource url:'js/application.js'
    }
	
	bootstrap {
        resource url:'less/bootstrap/custom-bootstrap.less',attrs:[rel: "stylesheet/less", type:'css']
		resource url:'js/bootstrap/bootstrap-modal.js' 
        dependsOn 'jquery'
    }
}