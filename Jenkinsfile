pipeline {
	
	agent any

	environment {
		//all variables defined here will be available inside Jenkinsfile
		NEW_VERSION = '1.3.0'
//		SERVER_CREDENTAILS = credentials('ID from Jenkins'), also required "credentials binding" plugin
	}

	triggers {
		 cron('H */8 * * *') //regular builds
	}

	tools {
		gradle 'Gradle' 
		jdk 'JDK'
	}

	parameters {
		choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'safari', 'edge'], description:'Please select a browser you would like the tests to be run on')
		string(name: 'NUMBER_OF_RUNS', defaultValue: '1', description:'Please select how many time you would likt to re-run the tests')
		booleanParam(name: 'executeTests', defaultValue: true, description:'')
	}

	stages {

		stage("build") {
			when {
				expression {
					//the part in steps will be executed only if this condition will be met
				}
			}
			steps {
				echo 'building the application...'
			}
		}

		stage("test") {
			when {
				expression {
					//the part in steps will be executed only if this condition will be met
					params.executeTests == true
				}
			}
			steps {
				echo 'testing the application...'
				script {
                    try {
                        sh './gradlew runTests --no-daemon' //run a gradle task
                    } finally {
                        junit '**/build/test-results/test/*.xml' //make the junit test results available in any case (success & failure)
                    }
                }
			}
		}

		stage("deploy") {
			steps {
				echo 'deploying the application...'
				echo "tested on ${params.BROWSER} browser"
//				withCredentials([
//					usernamePassword('ID from Jenkins', usernameVaviable: USER, passwordVariable: PWD)
//					]) {
//					sh "some shell script ${USER} ${PWD}"
//				}
			}
		}
	}
	post {
		always {
			//this will happen after each run
		}
		success {
			//this will happen only in case of success
		}
		failure {
			//this will happen on run failure
		}
	}
}