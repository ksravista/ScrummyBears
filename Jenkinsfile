node {
    stage('SCM Checkout'){
        git credentialsId: 'jenkins', url: 'https://ksravista@bitbucket.org/scrummybearsgroup/cart.git'
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
    stage('docker build image'){
        
        sh 'docker build -t swe699cart .'
    }
    
}
