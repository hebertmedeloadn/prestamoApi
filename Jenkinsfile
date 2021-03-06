pipeline {

  agent {
    label 'Slave_Induccion'
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
 	 disableConcurrentBuilds()
  }
  
  tools {
    jdk 'JDK8_Centos'
  }

  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
			$class: 'GitSCM',
			branches: [[name: '*/main']],
			doGenerateSubmoduleConfigurations: false,
			extensions: [],
			gitTool: 'Default',
			submoduleCfg: [],
			userRemoteConfigs: [[
				credentialsId: 'GitHub_hebertmedelo',
				url:'https://github.com/hebertmedeloadn/prestamoApi'
			]]
		])
      }
    }
	
	

    stage('Clean And Build') {
      steps{
        echo "------------>Clean<------------"
		sh ("(chmod +x prestamo/gradlew)")
        sh ("(cd prestamo && ./gradlew clean)") 
		sh ("(cd prestamo && ./gradlew build)") 
      }
    }

    stage('Unit Tests') {
      steps{        
		echo "------------>Compile project<------------"
        sh ("(cd prestamo && ./gradlew compileJava)")
        
		echo "------------>Unit Tests<------------"
		sh ("(cd prestamo && ./gradlew test)")
        sh ("(cd prestamo && ./gradlew jacocoTestReport)")
      }
    }

    stage('Static Code Analysis') {
      steps{
          echo '------------>An�lisis de c�digo est�tico<------------'

		withSonarQubeEnv('Sonar') {
                  sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties" 
                }
	    }     
       
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
		sh ("(cd prestamo && ./gradlew build -x test)")
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'hebert.medelo@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
	unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}