node {


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
        withSonarQubeEnv('jenkins-latest') {
            sh "${mvnHome}/bin/mvn sonar:sonar"
        }
     }
    stage('docker build image'){
        sh 'docker build -t swe699cart .'
    }

    stage('docker push image to docker hub'){
            sh 'docker build -t swe699cart .'
        }
    
}
