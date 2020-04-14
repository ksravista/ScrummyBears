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
    stage ('sonarcube code analysis (acceptance testing)'){



    }
    stage('docker build image'){
        sh 'docker build -t swe699cart .'
    }
    
}
