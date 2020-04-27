node{
    stage('SCM Checkout'){
        git credentialsId: 'git', url: 'https://ksravista@bitbucket.org/scrummybearsgroup/cart.git'
    }

    stage('mvn package'){

        def mvnHome = tool name: 'maven-3', type: 'maven'
        def mvnCMD = "${mvnHome}/bin/mvn"
        sh  "${mvnCMD} clean package"
    }

    stage('unit tests'){
        def mvnHome = tool name: 'maven-3', type: 'maven'
        def mvnCMD = "${mvnHome}/bin/mvn"
        sh  "${mvnCMD} test"
    }
    stage('SonarQube Analysis') {
        def mvnHome =  tool name: 'maven-3', type: 'maven'
        withSonarQubeEnv('sonar') {
            sh "${mvnHome}/bin/mvn sonar:sonar"
        }
    }
    stage("Quality Gate"){

    }
    stage('docker build image'){
        sh 'docker build -t swe699cart .'
    }
    stage('push image to docker hub'){
		withDockerRegistry([credentialsId: "docker", url: "" ]) {
		    sh 'docker push ksravista/swe699cart:latest'
		}
    }

}