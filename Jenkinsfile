node {
    def mvnHome
    mvnHome = tool 'Maven_3_6_0'
    stage('Fetch sources and build sources') {

        git 'https://github.com/steevessaillant/TDDJavaValueInverterKata'
        //maven compile

        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' compile "
        } else {
            bat(/"${mvnHome}\bin\mvn" compile/)
        }

    }

    stage('Test') {
        //maven compile
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' test "
        } else {
            bat(/"${mvnHome}\bin\mvn" test/)
        }

    }
    stage('Deploy') {

        //maven compile
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' package "
        } else {
            bat(/"${mvnHome}\bin\mvn" package/)
        }
        echo "Artifact deployed!"
    }
}

